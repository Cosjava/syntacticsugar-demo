package com.cgi.conferences.models.projections;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatsByPersonneProjection {
    private String nom;
    private long nbConferences;
}
