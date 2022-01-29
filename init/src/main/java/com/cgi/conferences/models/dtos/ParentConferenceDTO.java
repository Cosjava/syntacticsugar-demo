package com.cgi.conferences.models.dtos;

import com.cgi.conferences.models.enums.CategorieEnum;
import com.cgi.conferences.models.enums.TrackEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class ParentConferenceDTO extends RepresentationModel<ParentConferenceDTO> {
    private int identifiant;
    private List<PersonneDTO> personne;
    private String titre;
    private LocalDateTime debut;
    private LocalDateTime fin;
    private CategorieEnum categorie;
    private TrackEnum track;
    private String salle;
}
