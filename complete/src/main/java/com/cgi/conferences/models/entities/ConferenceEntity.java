package com.cgi.conferences.models.entities;

import com.cgi.conferences.models.enums.CategorieEnum;
import com.cgi.conferences.models.enums.TypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CONFERENCES")
public class ConferenceEntity implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "conference_sequence"
    )
    @SequenceGenerator(
            name = "conference_sequence",
            sequenceName = "CONFERENCE_SEQUENCE",
            allocationSize = 1
    )
    @Column(name = "IDENTIFIANT")
    private long identifiant;

    @Column(name = "TITRE")
    private String titre;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "MATERIEL")
    private String materiel;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private TypeEnum type;

    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORIE")
    private CategorieEnum categorie;

    @Column(name = "HORODATE_DEBUT")
    private LocalDateTime debut;

    @Column(name = "HORODATE_FIN")
    private LocalDateTime fin;

    @Column(name = "FK_PERSONNE")
    private long idPersonne;

    @ManyToOne
    @JoinColumn(name = "FK_PERSONNE", insertable = false, updatable = false)
    private PersonneEntity personne;
}
