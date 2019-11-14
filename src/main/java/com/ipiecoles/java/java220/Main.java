package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		System.out.println(Entreprise.primeAnnuelleBase());
		
		Employe emp = new Employe("vbd", "jordan", "mat101", 
						new LocalDate(2018, 01, 01), (double) 2000);
		Employe emp2 = new Employe("vbd", "jordan", "mat101", 
				new LocalDate(2018, 01, 01), (double) 2000);
		if (emp.equals(emp2)) {
			System.out.println("égales");
		}
		System.out.println(emp.hashCode());
		System.out.println(emp2.toString());
		
		emp.augmenterSalaire((double) 100);
		System.out.println("Nouveau salaire : " + emp.getSalaire());

		
	}

}
