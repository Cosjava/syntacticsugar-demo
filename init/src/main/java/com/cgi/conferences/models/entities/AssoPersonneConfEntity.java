package com.cgi.conferences.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ASSOCIATION_PERSONNE_CONF")
public class AssoPersonneConfEntity implements Serializable {

    @EmbeddedId
    private AssoPersonneConfKey assoPersonneConfKey;

    @ManyToOne
    @JoinColumn(name = "ID_PERSONNE", insertable = false, updatable = false)
    private PersonneEntity personne;
}
