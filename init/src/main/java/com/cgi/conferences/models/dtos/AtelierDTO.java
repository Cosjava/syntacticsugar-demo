package com.cgi.conferences.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public final class AtelierDTO extends ConferenceDTO {
    private String materiel;

    public String demanderMateriel() {
        return String.format("Préciser aux participants qu'il faut installer: %s", materiel);
    }

    public String prepareSalle() {
        return "Allez dans la salle et positionner les chaises."
                + "Vérifier la connectique."
                + "Annoncer : \"Tout est prêt.\"";
    }
}
