package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

/**
 * Created by pjvilloud on 21/09/17.
 */
public class Employe {
	private String nom;
	private String prenom;
	private String matricule;
	private LocalDate dateEmbauche;
	private Double salaire;

	Employe() {}
	
	Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire) {
		this.nom = nom;
		this.prenom = prenom;
		this.matricule = matricule;
		this.dateEmbauche = dateEmbauche;
		this.salaire = salaire;
	}

	public final Integer getNombreAnneeAnciennete() {
		if (dateEmbauche != null) {
			return LocalDate.now().getYear() - dateEmbauche.getYear();
		}
		return 0;
	}
	
	public static Integer getNbConges() {
		return Entreprise.NB_CONGES_BASE;
	}
	
	@Override
	public String toString() {
		return "Employe {nom=" + nom + ", prenom=" + prenom + ", matricule=" + matricule + ", dateEmbauche="
				+ dateEmbauche + ", salaire=" + salaire + "}";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((matricule == null) ? 0 : matricule.hashCode());
		result = prime * result + ((dateEmbauche == null) ? 0 : dateEmbauche.hashCode());		
		result = prime * result + ((salaire == null) ? 0 : salaire.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return hashCode() == obj.hashCode();
	}
	
	/*
	 * Coder la méthode augmenterSalaire prenant en paramètre un pourcentage 
	 * d'augmentation de type Double et augmentant l'attribut salaire du pourcentage 
	 * passé en paramètre :
		Ex : un salaire de 500.0, avec une augmentation de 0.50, 
		cela donne un salaire de 750.0
	 */

	public void augmenterSalaire(Double pourcentage) {
		this.salaire += this.salaire*(pourcentage/100);
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public LocalDate getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(LocalDate dateEmbauche) {
		if (dateEmbauche != null && dateEmbauche.isAfter(LocalDate.now())) {
			System.out.println("La date d'embauche ne peut être postérieure à la date courante");
		} else {
			this.dateEmbauche = dateEmbauche;
		}
	}
	public Double getSalaire() {
		return salaire;
	}
	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}
}

