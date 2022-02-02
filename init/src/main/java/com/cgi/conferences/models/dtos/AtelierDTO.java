package com.cgi.conferences.models.dtos;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AtelierDTO extends ConferenceDTO {
    private String materiel;

    public String demanderMateriel() {
        return String.format("Préciser aux participants qu'il faut installer: %s", materiel);
    }

    public String prepareSalle() {
        return "Vérifier la connectique.";
    }
}
