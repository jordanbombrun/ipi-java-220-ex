package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.HashSet;

public class Manager extends Employe {

    private HashSet<Technicien> equipe = new HashSet<Technicien>();

    public Manager() {
        super();
    }

    public Manager(String nom, String prenom, String matricule, LocalDate dateEmbauche,
                   Double salaire, HashSet<Technicien> equipe) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.equipe = equipe;
    }

    @Override
    public Double getPrimeAnnuelle() {
        Double primeAnnuelleBase = Entreprise.primeAnnuelleBase();
        Double primeManager = Entreprise.PRIME_MANAGER_PAR_TECHNICIEN * this.equipe.size();
        return primeAnnuelleBase + primeManager;
    }

    private void augmenterSalaireEquipe(Double pourcentage) {
        for (Technicien tech : equipe) {
            tech.augmenterSalaire(pourcentage);
        }
    }

    @Override
    public void augmenterSalaire(Double pourcentage) {
        this.augmenterSalaireEquipe(pourcentage);
        super.augmenterSalaire(pourcentage);
    }

    @Override
    public void setSalaire(Double salaire) {
        Double salaireIndice = salaire * Entreprise.INDICE_MANAGER;
        super.setSalaire(salaireIndice + 0.1 * salaire * this.equipe.size());
    }

    public void ajoutTechnicienEquipe(Technicien tech) {
        if (equipe == null) {
            equipe = new HashSet<Technicien>();
        }
        this.equipe.add(tech);
    }

    /*
    Surcharger ajoutTechnicienEquipe pour permettre l'ajout d'un technicien en passant directement
    les paramètres nom, prenom, matricule, date, salaire et grade
     */
    public void ajoutTechnicienEquipe(String nom, String prenom, String matricule,
                                      LocalDate dateEmbauche, Double salaire, Integer grade) {
        if (equipe == null) {
            equipe = new HashSet<Technicien>();
        }
        Technicien tech = new Technicien(nom, prenom, matricule, dateEmbauche, salaire, grade);
        this.equipe.add(tech);
    }

    public HashSet<Technicien> getEquipe() {
        return equipe;
    }

    public void setEquipe(HashSet<Technicien> equipe) {
        this.equipe = equipe;
    }
}
