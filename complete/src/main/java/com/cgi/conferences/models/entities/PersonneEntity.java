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
@Table(name = "PERSONNES")
public class PersonneEntity implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "personne_sequence"
    )
    @SequenceGenerator(
            name = "personne_sequence",
            sequenceName = "PERSONNE_SEQUENCE",
            allocationSize = 1
    )
    @Column(name = "IDENTIFIANT")
    private long identifiant;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    @Column(name = "PRESENTATION")
    private String presentation;

}
