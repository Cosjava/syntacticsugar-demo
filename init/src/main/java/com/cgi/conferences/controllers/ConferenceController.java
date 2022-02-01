package com.cgi.conferences.controllers;

import com.cgi.conferences.models.dtos.ParentConferenceDTO;
import com.cgi.conferences.models.dtos.PostConferenceDTO;
import com.cgi.conferences.models.dtos.StatisticsDTO;
import com.cgi.conferences.models.entities.ConferenceEntity;
import com.cgi.conferences.models.mappers.ConferenceMapper;
import com.cgi.conferences.models.projections.StatsByPersonneProjection;
import com.cgi.conferences.repositories.AssoPersonneConfRepository;
import com.cgi.conferences.repositories.ConferenceRepository;
import com.cgi.conferences.services.PrepareConferenceService;
import com.cgi.conferences.services.StatistiquesService;
import lombok.NonNull;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Log4j
@RestController
//@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL_FORMS)
public class ConferenceController {

    private static final String REL_CONFERENCES = "conferences";
    private static final String REL_STATISTICS = "statistiques";
    private static final String REL_PREPARATION = "preparation";

    @Autowired
    private ConferenceRepository conferenceRepository;

    @Autowired
    private AssoPersonneConfRepository assoPersonneConfRepository;

    @Autowired
    private ConferenceMapper conferenceMapper;

    @Autowired
    private StatistiquesService statistiquesService;

    @Autowired
    private PrepareConferenceService prepareConferenceService;

    @GetMapping("{id}")
    public ResponseEntity<ParentConferenceDTO> getConference(@PathVariable long id) {
        return conferenceRepository.findById(id)
                .map(conferenceMapper::convertToDTO)
                .map(this::addOneConfLinks)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteConference(@PathVariable long id) {
        conferenceRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<?> postConference(@RequestBody @NonNull @Valid PostConferenceDTO conference) {
        ConferenceEntity entity = conferenceMapper.dtoToEntity(conference);
        ParentConferenceDTO savedConference = conferenceMapper.convertToDTO(conferenceRepository.save(entity));
        Optional<URI> uriNewConf = savedConference.add(linkTo(methodOn(ConferenceController.class).getConference(savedConference.getIdentifiant())).withSelfRel()
                                .andAffordance(afford(methodOn(ConferenceController.class).deleteConference(savedConference.getIdentifiant())
                                )),
                        linkTo(methodOn(ConferenceController.class).getConferences()).withRel(REL_CONFERENCES))
                .getLink(IanaLinkRelations.SELF)
                .map(Link::getHref)
                .map(href -> {
                    try {
                        return new URI(href);
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }
                });
        return uriNewConf.map(uri -> ResponseEntity.noContent().location(uri).build())
                .orElse(ResponseEntity.badRequest().body("Impossible d'accéder à  " + conference));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<ParentConferenceDTO>> getConferences() {
        var conferences = conferenceRepository.findAll()
                .stream()
                .map(conferenceMapper::convertToDTO)
                .map(this::addOneConfLinks)
                .collect(Collectors.toList());
        return ResponseEntity.ok(CollectionModel.of(
                conferences,
                linkTo(methodOn(ConferenceController.class).getStatistics()).withRel(REL_STATISTICS),
                linkTo(methodOn(ConferenceController.class).getConferences()).withSelfRel()
                        .andAffordance(afford(methodOn(ConferenceController.class).postConference(new PostConferenceDTO())))));
    }

    @GetMapping("/statistiquesByPersonne")
    public ResponseEntity<CollectionModel<StatsByPersonneProjection>> getStatistics() {
        var statistics = assoPersonneConfRepository.calculateStatsByPerson();
        return ResponseEntity.ok(CollectionModel.of(
                statistics,
                linkTo(methodOn(ConferenceController.class).getStatistics()).withSelfRel(),
                linkTo(methodOn(ConferenceController.class).getConferences()).withRel(REL_CONFERENCES)
                        .andAffordance(afford(methodOn(ConferenceController.class).postConference(new PostConferenceDTO())))));
    }

    @GetMapping("/prepare/{id}")
    public ResponseEntity<String> getConferencePreparation(@PathVariable long id) {
        return conferenceRepository.findById(id)
                .map(conferenceMapper::convertToDTO)
                .map(prepareConferenceService::prepareConference)
                .map(ResponseEntity::ok
                )
                .orElse(ResponseEntity.notFound().build());
    }

/*    @GetMapping("/supervision")
    public List<StatisticsDTO> getSupervision() {
        return statistiquesService.calculateStats();
    }*/

    private ParentConferenceDTO addOneConfLinks(ParentConferenceDTO conf) {
        return conf.add(linkTo(methodOn(ConferenceController.class).getConferencePreparation(conf.getIdentifiant())).withRel(REL_PREPARATION),
                linkTo(methodOn(ConferenceController.class).getConference(conf.getIdentifiant())).withSelfRel()
                        .andAffordance(afford(methodOn(ConferenceController.class).deleteConference(conf.getIdentifiant())
                        )), linkTo(methodOn(ConferenceController.class).getConferences()).withRel(REL_CONFERENCES));
    }

}
