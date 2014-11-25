/*
 * File: Groupe.java
 * Authors: Simon Baehler, Sacha Bron
 * Date: 29.10.2014
 * Goal: ???
 */

package labo6;

import java.util.Arrays;
import java.util.LinkedList;

public class Groupe {
	private int numero;
	private int orientation;
	private int trimestre;
	private LinkedList<Etudiant> etudiants;
	private LinkedList<Lecon> lecons;
	
	private String nom;

	public Groupe(int numero, int orientation, int trimiestre, String nom, Etudiant... etudiants) {
		this.nom = nom;
		this.numero = numero;
		this.orientation = orientation;
		this.trimestre = trimiestre;
		this.etudiants = (LinkedList<Etudiant>) Arrays.asList(etudiants);
		
		if(this.etudiants.size() < 1) {
			System.err.println("Etudiants list is empty.");
			throw new IllegalArgumentException();
		}
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

	public void definirLecons(Lecon... lecons) {
		this.lecons.addAll(Arrays.asList(lecons));
	}
}
