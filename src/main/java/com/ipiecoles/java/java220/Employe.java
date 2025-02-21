package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

/**
 * Created by pjvilloud on 21/09/17.
 */
public abstract class Employe {
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
	
	public Integer getNbConges() {
		return Entreprise.NB_CONGES_BASE;
	}
	
	@Override
	public String toString() {
		return "Employe {nom=" + nom + ", prenom=" + prenom + ", matricule=" + matricule + ", dateEmbauche="
				+ dateEmbauche + ", salaire=" + salaire + "}";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nom, prenom, matricule, dateEmbauche, salaire);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Employe)) return false;

		Employe employe = (Employe) o;

		if (Double.compare(employe.salaire, salaire) != 0) return false;
		if (nom != null ? !nom.equals(employe.nom) : employe.nom != null) return false;
		if (prenom != null ? !prenom.equals(employe.prenom) : employe.prenom != null) return false;
		if (matricule != null ? !matricule.equals(employe.matricule) : employe.matricule != null) return false;
		return dateEmbauche != null ? dateEmbauche.equals(employe.dateEmbauche) : employe.dateEmbauche == null;
	}

	public abstract Double getPrimeAnnuelle();

	public void augmenterSalaire(Double pourcentage) {
		this.salaire += this.salaire*pourcentage;
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

