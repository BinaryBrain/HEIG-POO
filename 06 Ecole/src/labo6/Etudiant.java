/*
 * File: Etudiant.java
 * Authors: Simon Baehler, Sacha Bron
 * Date: 29.10.2014
 * Goal: ???
 */

package labo6;

import java.util.UUID;

public class Etudiant extends Personne {
	private int matricule;

	public Etudiant(String nom, String prenom) {
		super(nom, prenom);
		this.matricule = generateUniqueMatricule();
	}

	public String toString() {
		return "Etud." + super.toString() + "(#" + matricule + ")\n";
	}
	
	public int getMatricule() {
		return matricule;
	}
	
	private static int previousMatricule = 0;
	public static int generateUniqueMatricule() {
		return previousMatricule++;
	}
}
