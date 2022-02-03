package com.cgi.conferences.services;

import com.cgi.conferences.models.dtos.StatisticsDTO;
import com.cgi.conferences.models.projections.StatsByPersonneProjection;
import com.cgi.conferences.repositories.AssoPersonneConfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Service
public class StatistiquesService {

    @Autowired
    private AssoPersonneConfRepository assoPersonneConfRepository;

    public List<StatisticsDTO> calculateStats() {
        var statistics = assoPersonneConfRepository.calculateStatsByPerson().stream().collect(
                groupingBy(StatsByPersonneProjection::getNbConferences,
                        TreeMap::new,
                        collectingAndThen(toList(), List::size)));
        return statistics.entrySet().stream().map(entry -> new StatisticsDTO(entry.getKey(), entry.getValue())).collect(Collectors.toList());
    }

}
