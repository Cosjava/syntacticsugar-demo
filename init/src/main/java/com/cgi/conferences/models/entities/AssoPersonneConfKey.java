package com.cgi.conferences.models.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AssoPersonneConfKey implements Serializable {

    @Column(name = "ID_PERSONNE")
    private long idPersonne;

    @Column(name = "ID_CONFERENCE")
    private long idConference;
}
