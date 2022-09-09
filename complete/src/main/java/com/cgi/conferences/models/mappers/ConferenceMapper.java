package com.cgi.conferences.models.mappers;

import com.cgi.conferences.models.dtos.*;
import com.cgi.conferences.models.entities.ConferenceEntity;
import com.cgi.conferences.models.entities.PersonneEntity;
import com.cgi.conferences.models.enums.TrackEnum;
import com.cgi.conferences.models.enums.TypeEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ConferenceMapper {
    KeyNoteDTO entityToKeyNoteDTO(ConferenceEntity conference);

    ConferenceDTO entityToConferenceDTO(ConferenceEntity conference);

    AtelierDTO entityToAtelierDTO(ConferenceEntity conference);

    PersonneDTO entityToDTO(PersonneEntity personne);

    @Mapping(target = "personne", ignore = true)
    @Mapping(target = "identifiant", ignore = true)
    ConferenceEntity dtoToEntity(PostConferenceDTO postConferenceDTO);

    default TrackEnum getTrack(TypeEnum typeEnum) {
        return switch (typeEnum) {
            case CLOUD, PERFORMANCE, ARCHITECTURE -> TrackEnum.ARCHITECTE;
            case LANGUAGES, WEB, MACHINE_LEARNING -> TrackEnum.DEVELOPPEUR;
            case null, DISCOVER -> TrackEnum.ALL;
        };
    }

    default ParentConferenceDTO convertToDTO(ConferenceEntity entity) {
        return switch (entity.getCategorie()) {
            case CONFERENCE:
                yield entityToConferenceDTO(entity);
            case KEYNOTE:
                yield entityToKeyNoteDTO(entity);
            case ATELIER:
                yield entityToAtelierDTO(entity);
        };
    }
}
