package com.cgi.conferences.models.dtos;

import lombok.Data;

@Data
public class PersonneDTO {
    private long identifiant;
    private String nom;
    private String prenom;
    private String presentation;
}
