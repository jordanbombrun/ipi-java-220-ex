package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;
import java.util.Objects;

public class Commercial extends Employe {

    private static final double PRIME_ANNUELLE_MINI = 500d;
    private Double caAnnuel;
    private Integer performance;
    private Note note;

    public Commercial() {
        super();
    }

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche,
                      Double salaire, Double caAnnuel, Integer performance) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
        this.performance = performance;
    }

    public Double getPrimeAnnuelle() {
        if (this.caAnnuel == null) {
            return PRIME_ANNUELLE_MINI;
        }
        Double primeAnnuelle = Math.ceil(0.05*this.caAnnuel);
        if (primeAnnuelle <= PRIME_ANNUELLE_MINI) {
            return PRIME_ANNUELLE_MINI;
        }
        return primeAnnuelle;
    }

    public Boolean performanceEgale(Integer perf) {
        return Objects.equals(this.performance, perf);
    }

    public Note equivalenceNote() {
        switch (this.performance) {
            case 50 :
                return Note.INSUFFISANT;
            case 100 :
                return Note.PASSABLE;
            case 150 :
                return Note.BIEN;
            case 200 :
                return Note.TRES_BIEN;
            default :
                return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Commercial that = (Commercial) o;
        return (caAnnuel.equals(that.caAnnuel) && performance.equals(that.performance));
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), caAnnuel, performance);
    }

    public Double getCaAnnuel() {
        return caAnnuel;
    }

    public void setCaAnnuel(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }

    public Integer getPerformance() {
        return performance;
    }

    public void setPerformance(Integer performance) {
        this.performance = performance;
    }

}

/*
une méthode performanceEgale prenant un Integer en paramètre qui renvoie true
si la performance du commercial est égale à celle passée en paramètre, false sinon
 */
