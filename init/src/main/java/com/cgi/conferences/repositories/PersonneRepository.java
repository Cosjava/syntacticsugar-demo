package com.cgi.conferences.repositories;

import com.cgi.conferences.models.entities.PersonneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<PersonneEntity, Long> {
}
