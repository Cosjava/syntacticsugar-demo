package com.cgi.conferences.models.projections;

public class StatsByPersonneProjection {
    private String nom;
    private long nbConferences;

    public StatsByPersonneProjection(String nom, long nbConferences){
        this.nom = nom;
        this.nbConferences = nbConferences;
    }

    public long getNbConferences() {
        return nbConferences;
    }

    public void setNbConferences(long nbConferences) {
        this.nbConferences = nbConferences;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
