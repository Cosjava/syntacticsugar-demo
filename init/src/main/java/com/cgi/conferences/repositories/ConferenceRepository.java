package com.cgi.conferences.repositories;

import com.cgi.conferences.models.entities.ConferenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository extends JpaRepository<ConferenceEntity, Long> {
}
