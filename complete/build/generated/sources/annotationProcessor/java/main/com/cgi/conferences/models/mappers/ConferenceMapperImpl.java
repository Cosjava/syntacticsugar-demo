package com.cgi.conferences.models.mappers;

import com.cgi.conferences.models.dtos.AtelierDTO;
import com.cgi.conferences.models.dtos.ConferenceDTO;
import com.cgi.conferences.models.dtos.KeyNoteDTO;
import com.cgi.conferences.models.dtos.PersonneDTO;
import com.cgi.conferences.models.dtos.PostConferenceDTO;
import com.cgi.conferences.models.entities.ConferenceEntity;
import com.cgi.conferences.models.entities.PersonneEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-16T09:12:42+0100",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.3.3.jar, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class ConferenceMapperImpl implements ConferenceMapper {

    @Override
    public KeyNoteDTO entityToKeyNoteDTO(ConferenceEntity conference) {
        if ( conference == null ) {
            return null;
        }

        KeyNoteDTO keyNoteDTO = new KeyNoteDTO();

        keyNoteDTO.setIdentifiant( (int) conference.getIdentifiant() );
        keyNoteDTO.setPersonne( entityToDTO( conference.getPersonne() ) );
        keyNoteDTO.setTitre( conference.getTitre() );
        keyNoteDTO.setDescription( conference.getDescription() );
        keyNoteDTO.setDebut( conference.getDebut() );
        keyNoteDTO.setFin( conference.getFin() );
        keyNoteDTO.setCategorie( conference.getCategorie() );

        return keyNoteDTO;
    }

    @Override
    public ConferenceDTO entityToConferenceDTO(ConferenceEntity conference) {
        if ( conference == null ) {
            return null;
        }

        ConferenceDTO conferenceDTO = new ConferenceDTO();

        conferenceDTO.setIdentifiant( (int) conference.getIdentifiant() );
        conferenceDTO.setPersonne( entityToDTO( conference.getPersonne() ) );
        conferenceDTO.setTitre( conference.getTitre() );
        conferenceDTO.setDescription( conference.getDescription() );
        conferenceDTO.setDebut( conference.getDebut() );
        conferenceDTO.setFin( conference.getFin() );
        conferenceDTO.setCategorie( conference.getCategorie() );
        conferenceDTO.setType( conference.getType() );

        return conferenceDTO;
    }

    @Override
    public AtelierDTO entityToAtelierDTO(ConferenceEntity conference) {
        if ( conference == null ) {
            return null;
        }

        AtelierDTO atelierDTO = new AtelierDTO();

        atelierDTO.setIdentifiant( (int) conference.getIdentifiant() );
        atelierDTO.setPersonne( entityToDTO( conference.getPersonne() ) );
        atelierDTO.setTitre( conference.getTitre() );
        atelierDTO.setDescription( conference.getDescription() );
        atelierDTO.setDebut( conference.getDebut() );
        atelierDTO.setFin( conference.getFin() );
        atelierDTO.setCategorie( conference.getCategorie() );
        atelierDTO.setType( conference.getType() );
        atelierDTO.setMateriel( conference.getMateriel() );

        return atelierDTO;
    }

    @Override
    public PersonneDTO entityToDTO(PersonneEntity personne) {
        if ( personne == null ) {
            return null;
        }

        PersonneDTO personneDTO = new PersonneDTO();

        personneDTO.setIdentifiant( personne.getIdentifiant() );
        personneDTO.setNom( personne.getNom() );
        personneDTO.setPrenom( personne.getPrenom() );
        personneDTO.setPresentation( personne.getPresentation() );

        return personneDTO;
    }

    @Override
    public ConferenceEntity dtoToEntity(PostConferenceDTO postConferenceDTO) {
        if ( postConferenceDTO == null ) {
            return null;
        }

        ConferenceEntity conferenceEntity = new ConferenceEntity();

        conferenceEntity.setTitre( postConferenceDTO.getTitre() );
        conferenceEntity.setDescription( postConferenceDTO.getDescription() );
        conferenceEntity.setMateriel( postConferenceDTO.getMateriel() );
        conferenceEntity.setType( postConferenceDTO.getType() );
        conferenceEntity.setCategorie( postConferenceDTO.getCategorie() );
        conferenceEntity.setDebut( postConferenceDTO.getDebut() );
        conferenceEntity.setFin( postConferenceDTO.getFin() );
        conferenceEntity.setIdPersonne( postConferenceDTO.getIdPersonne() );

        return conferenceEntity;
    }
}
