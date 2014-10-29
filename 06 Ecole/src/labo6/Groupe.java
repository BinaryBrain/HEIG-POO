/*
 * File: Groupe.java
 * Authors: Simon Baehler, Sacha Bron
 * Date: 29.10.2014
 * Goal: ???
 */

package labo6;

import java.util.ArrayList;

public class Groupe {
	private int numero;
	private int orientation;
	private int trimestre;
	private ArrayList<Etudiant> etudiants;

	private String nom;
        public Groupe(int numero, int orientation, int trimiestre, String nom)
        {
            this.nom = nom;
            this.numero = numero;
            this.orientation = orientation;
            this.trimestre = trimiestre;
        }
	
	public String horaire() {
		// TODO
		return null;
	}

	public String nom() {
		return nom;

	}

	public int nombreEtudiants() {
		return etudiants.size();
	}

	public void definirLecon(/* args */) {
		// TODO
	}
}
