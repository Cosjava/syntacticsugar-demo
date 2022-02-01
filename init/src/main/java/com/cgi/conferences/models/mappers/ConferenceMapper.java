package com.cgi.conferences.models.mappers;

import com.cgi.conferences.models.dtos.*;
import com.cgi.conferences.models.entities.AssoPersonneConfEntity;
import com.cgi.conferences.models.entities.ConferenceEntity;
import com.cgi.conferences.models.enums.TrackEnum;
import com.cgi.conferences.models.enums.TypeEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ConferenceMapper {

    @Mapping(target = "personne", source = "assoPersonneConf")
    @Mapping(target = "track", source = "type")
    KeyNoteDTO entityToKeyNoteDTO(ConferenceEntity conference);

    @Mapping(target = "personne", source = "assoPersonneConf")
    @Mapping(target = "track", source = "type")
    ConferenceDTO entityToConferenceDTO(ConferenceEntity conference);

    @Mapping(target = "personne", source = "assoPersonneConf")
    @Mapping(target = "track", source = "type")
    AtelierDTO entityToAtelierDTO(ConferenceEntity conference);

    @Mapping(target = "identifiant", source = "personne.identifiant")
    @Mapping(target = "nom", source = "personne.nom")
    PersonneDTO entityToDTO(AssoPersonneConfEntity assoPersonneConf);

    @Mapping(target = "assoPersonneConf", ignore = true)
    @Mapping(target = "identifiant", ignore = true)
    ConferenceEntity dtoToEntity(PostConferenceDTO postConferenceDTO);

    default TrackEnum getTrack(TypeEnum typeEnum) {
        if (typeEnum == null) {
            return TrackEnum.ALL;
        }
        TrackEnum track = null;
        switch (typeEnum) {
            case CLOUD:
            case PERFORMANCE:
            case ARCHITECTURE:
                track = TrackEnum.ARCHITECTE;
                break;
            case LANGUAGE:
            case WEB:
            case MACHINE_LEARNING:
                track = TrackEnum.DEVELOPPEUR;
                break;
            default:
                return TrackEnum.ALL;
        }
        return track;
    }

    default ParentConferenceDTO convertToDTO(ConferenceEntity entity) {
        ParentConferenceDTO conferenceDTO = null;
        switch (entity.getCategorie()) {
            case ATELIER:
                conferenceDTO = entityToAtelierDTO(entity);
                break;
            case KEYNOTE:
                conferenceDTO = entityToKeyNoteDTO(entity);
                break;
            case CONFERENCE:
                conferenceDTO = entityToConferenceDTO(entity);
                break;
        }
        return conferenceDTO;
    }
}
