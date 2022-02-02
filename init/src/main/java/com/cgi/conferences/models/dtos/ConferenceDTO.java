package com.cgi.conferences.models.dtos;

import com.cgi.conferences.models.enums.TypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ConferenceDTO extends ParentConferenceDTO {
    private TypeEnum type;

    public String prepareAtelier() {
        return "Organiser la disposition des tables + installer de l'eau pour le présentateur.";
    }
}
