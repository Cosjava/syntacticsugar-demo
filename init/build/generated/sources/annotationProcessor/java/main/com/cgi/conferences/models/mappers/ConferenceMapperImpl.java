package com.cgi.conferences.models.mappers;

import com.cgi.conferences.models.dtos.AtelierDTO;
import com.cgi.conferences.models.dtos.ConferenceDTO;
import com.cgi.conferences.models.dtos.KeyNoteDTO;
import com.cgi.conferences.models.dtos.PersonneDTO;
import com.cgi.conferences.models.dtos.PostConferenceDTO;
import com.cgi.conferences.models.entities.AssoPersonneConfEntity;
import com.cgi.conferences.models.entities.ConferenceEntity;
import com.cgi.conferences.models.entities.PersonneEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-23T19:34:49+0100",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.3.3.jar, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class ConferenceMapperImpl implements ConferenceMapper {

    @Override
    public KeyNoteDTO entityToKeyNoteDTO(ConferenceEntity conference) {
        if ( conference == null ) {
            return null;
        }

        KeyNoteDTO keyNoteDTO = new KeyNoteDTO();

        keyNoteDTO.setPersonne( assoPersonneConfEntityListToPersonneDTOList( conference.getAssoPersonneConf() ) );
        keyNoteDTO.setTrack( getTrack( conference.getType() ) );
        keyNoteDTO.setIdentifiant( (int) conference.getIdentifiant() );
        keyNoteDTO.setTitre( conference.getTitre() );
        keyNoteDTO.setDebut( conference.getDebut() );
        keyNoteDTO.setFin( conference.getFin() );
        keyNoteDTO.setCategorie( conference.getCategorie() );
        keyNoteDTO.setSalle( conference.getSalle() );

        return keyNoteDTO;
    }

    @Override
    public ConferenceDTO entityToConferenceDTO(ConferenceEntity conference) {
        if ( conference == null ) {
            return null;
        }

        ConferenceDTO conferenceDTO = new ConferenceDTO();

        conferenceDTO.setPersonne( assoPersonneConfEntityListToPersonneDTOList( conference.getAssoPersonneConf() ) );
        conferenceDTO.setTrack( getTrack( conference.getType() ) );
        conferenceDTO.setIdentifiant( (int) conference.getIdentifiant() );
        conferenceDTO.setTitre( conference.getTitre() );
        conferenceDTO.setDebut( conference.getDebut() );
        conferenceDTO.setFin( conference.getFin() );
        conferenceDTO.setCategorie( conference.getCategorie() );
        conferenceDTO.setSalle( conference.getSalle() );
        conferenceDTO.setType( conference.getType() );

        return conferenceDTO;
    }

    @Override
    public AtelierDTO entityToAtelierDTO(ConferenceEntity conference) {
        if ( conference == null ) {
            return null;
        }

        AtelierDTO atelierDTO = new AtelierDTO();

        atelierDTO.setPersonne( assoPersonneConfEntityListToPersonneDTOList( conference.getAssoPersonneConf() ) );
        atelierDTO.setTrack( getTrack( conference.getType() ) );
        atelierDTO.setIdentifiant( (int) conference.getIdentifiant() );
        atelierDTO.setTitre( conference.getTitre() );
        atelierDTO.setDebut( conference.getDebut() );
        atelierDTO.setFin( conference.getFin() );
        atelierDTO.setCategorie( conference.getCategorie() );
        atelierDTO.setSalle( conference.getSalle() );
        atelierDTO.setType( conference.getType() );
        atelierDTO.setMateriel( conference.getMateriel() );

        return atelierDTO;
    }

    @Override
    public PersonneDTO entityToDTO(AssoPersonneConfEntity assoPersonneConf) {
        if ( assoPersonneConf == null ) {
            return null;
        }

        PersonneDTO personneDTO = new PersonneDTO();

        personneDTO.setIdentifiant( assoPersonneConfPersonneIdentifiant( assoPersonneConf ) );
        personneDTO.setNom( assoPersonneConfPersonneNom( assoPersonneConf ) );

        return personneDTO;
    }

    @Override
    public ConferenceEntity dtoToEntity(PostConferenceDTO postConferenceDTO) {
        if ( postConferenceDTO == null ) {
            return null;
        }

        ConferenceEntity conferenceEntity = new ConferenceEntity();

        conferenceEntity.setTitre( postConferenceDTO.getTitre() );
        conferenceEntity.setMateriel( postConferenceDTO.getMateriel() );
        conferenceEntity.setSalle( postConferenceDTO.getSalle() );
        conferenceEntity.setType( postConferenceDTO.getType() );
        conferenceEntity.setCategorie( postConferenceDTO.getCategorie() );
        conferenceEntity.setDebut( postConferenceDTO.getDebut() );
        conferenceEntity.setFin( postConferenceDTO.getFin() );

        return conferenceEntity;
    }

    protected List<PersonneDTO> assoPersonneConfEntityListToPersonneDTOList(List<AssoPersonneConfEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<PersonneDTO> list1 = new ArrayList<PersonneDTO>( list.size() );
        for ( AssoPersonneConfEntity assoPersonneConfEntity : list ) {
            list1.add( entityToDTO( assoPersonneConfEntity ) );
        }

        return list1;
    }

    private long assoPersonneConfPersonneIdentifiant(AssoPersonneConfEntity assoPersonneConfEntity) {
        if ( assoPersonneConfEntity == null ) {
            return 0L;
        }
        PersonneEntity personne = assoPersonneConfEntity.getPersonne();
        if ( personne == null ) {
            return 0L;
        }
        long identifiant = personne.getIdentifiant();
        return identifiant;
    }

    private String assoPersonneConfPersonneNom(AssoPersonneConfEntity assoPersonneConfEntity) {
        if ( assoPersonneConfEntity == null ) {
            return null;
        }
        PersonneEntity personne = assoPersonneConfEntity.getPersonne();
        if ( personne == null ) {
            return null;
        }
        String nom = personne.getNom();
        if ( nom == null ) {
            return null;
        }
        return nom;
    }
}
