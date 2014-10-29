/*
 * File: Etudiant.java
 * Authors: Simon Baehler, Sacha Bron
 * Date: 29.10.2014
 * Goal: ???
 */

package labo6;

public class Etudiant extends Personne {
	private int matricule;

	public Etudiant(String nom, String prenom, int matricule) {
		super(nom, prenom);
		this.matricule = matricule;
	}

	public String toString() {
		return matricule + super.toString();
	}
}
