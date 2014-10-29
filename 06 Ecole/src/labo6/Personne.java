/*
 * File: Personne.java
 * Authors: Simon Baehler, Sacha Bron
 * Date: 29.10.2014
 * Goal: ???
 */

package labo6;

public class Personne {
	private String nom;
	private String prenom;

	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public String toString() {
		return nom + " " + prenom;
	}
}
