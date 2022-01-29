package com.cgi.conferences.repositories;

import com.cgi.conferences.models.entities.AssoPersonneConfEntity;
import com.cgi.conferences.models.entities.AssoPersonneConfKey;
import com.cgi.conferences.models.projections.StatsByPersonneProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssoPersonneConfRepository extends JpaRepository<AssoPersonneConfEntity, AssoPersonneConfKey> {
    @Query("select new com.cgi.conferences.models.projections.StatsByPersonneProjection(c.personne.nom, count(c.assoPersonneConfKey.idConference) ) "
            + " from AssoPersonneConfEntity c group by c.assoPersonneConfKey.idPersonne")
    List<StatsByPersonneProjection> calculateStatsByPerson();
}
