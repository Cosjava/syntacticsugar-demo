package com.cgi.conferences.repositories;

import com.cgi.conferences.models.entities.ConferenceEntity;
import com.cgi.conferences.models.projections.StatsByPersonneProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConferenceRepository extends JpaRepository<ConferenceEntity, Long> {

    @Query("select new com.cgi.conferences.models.projections.StatsByPersonneProjection(c.personne.nom, c.personne.prenom, count(c.identifiant) ) "
            + " from ConferenceEntity c group by c.idPersonne")
    List<StatsByPersonneProjection> calculateStatsByPerson();
}
