package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

public class Technicien extends Employe implements Comparable<Technicien> {

    private Integer grade;

    public Technicien() {}

    public Technicien(String nom, String prenom, String matricule,
                      LocalDate dateEmbauche, Double salaire, Integer grade) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Technicien)) return false;
        if (!super.equals(o)) return false;
        Technicien that = (Technicien) o;
        return Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), grade);
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public void setSalaire(Double salaire) {
        super.setSalaire(salaire * (1 + (double) grade / 10));
    }

    @Override
    public Integer getNbConges() {
        return (super.getNbConges() + getNombreAnneeAnciennete());
    }

    /*
    Implémenter l'interface Comparable pour que l'on puisse comparer
    deux Techniciens en fonction de leur
    grade plus le grade est haut, plus le technicien est compétent
     */
    public Double getPrimeAnnuelle() {
        Double primeAnnuelle = Entreprise.primeAnnuelleBase();
        primeAnnuelle += Entreprise.PRIME_ANCIENNETE * this.getNombreAnneeAnciennete() +
                        primeAnnuelle * ((double) grade / 10);
        return primeAnnuelle;
    }

    @Override
    public int compareTo(Technicien tech) {
        return Integer.compare(tech.getGrade(), this.grade);
    }
}
