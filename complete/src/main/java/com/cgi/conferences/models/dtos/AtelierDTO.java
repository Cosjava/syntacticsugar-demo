package com.cgi.conferences.models.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public final class AtelierDTO extends ConferenceDTO {
    private String materiel;

    public String prepareSalle() {
        return "Vérifier la connectique";
    }

    public String demanderMateriel() {
        return "Préciser le matériel à installer pour les participants.\n";
    }

}
