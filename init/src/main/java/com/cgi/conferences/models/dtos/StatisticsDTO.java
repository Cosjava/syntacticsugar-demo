package com.cgi.conferences.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatisticsDTO {
    private long nbConference;
    private long nbPersonne;
}
