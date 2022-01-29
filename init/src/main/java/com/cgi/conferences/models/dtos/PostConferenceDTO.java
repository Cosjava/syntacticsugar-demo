package com.cgi.conferences.models.dtos;

import com.cgi.conferences.models.enums.CategorieEnum;
import com.cgi.conferences.models.enums.TypeEnum;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class PostConferenceDTO {
    private TypeEnum type;
    private String materiel;
    private String salle;
    private long idPersonne;
    @NotNull
    @NotEmpty
    private String titre;
    @NotNull
    @NotEmpty
    private String description;
    @NotNull
    private LocalDateTime debut;
    @NotNull
    private LocalDateTime fin;
    @NotNull
    private CategorieEnum categorie;
}
