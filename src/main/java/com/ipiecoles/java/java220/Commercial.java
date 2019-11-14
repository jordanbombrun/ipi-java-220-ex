package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

public class Commercial extends Employe {

    public static final double PRIME_ANNUELLE_MINI = 500d;
    private Double caAnnuel;

    public Commercial() {}

    public Commercial(String nom, String prenom, String matricule,
                      LocalDate dateEmbauche, Double salaire, Double caAnnuel) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
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

    public Double getCaAnnuel() {
        return caAnnuel;
    }

    public void setCaAnnuel(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }

}

/*
Modifier la méthode getPrimeAnnuelle précédemment générée par
l'IDE pour que la prime soit égale à 5% du caAnnuel, avec un minimum
de 500 € même en cas de chiffre d'affaire nul.
 */
