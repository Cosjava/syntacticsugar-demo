package com.cgi.conferences.models.dtos;

import com.cgi.conferences.models.enums.CategorieEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
public abstract sealed class ParentConferenceDTO extends RepresentationModel<ParentConferenceDTO> permits ConferenceDTO, KeyNoteDTO {
    private int identifiant;
    private PersonneDTO personne;
    private String titre;
    private LocalDateTime debut;
    private LocalDateTime fin;
    private CategorieEnum categorie;
}
