/*
 * File: Lecon.java
 * Authors: Simon Baehler, Sacha Bron
 * Date: 29.10.2014
 * Goal: ???
 */

package labo6;

public class Lecon {
	private String matiere;
	private int jourSemaine;
	private int periodeDebut;
	private int duree;
	private String salle;

	private Professeur prof;

	public Lecon(String matiere, Professeur prof, int jourSemaine,
			int periodeDebut, int duree, String salle) {
		this.matiere = matiere;
		this.prof = prof;
		this.jourSemaine = jourSemaine;
		this.periodeDebut = periodeDebut;
		this.duree = duree;
		this.salle = salle;
	}
	
	public Lecon(String matiere, int jourSemaine,
			int periodeDebut, int duree, String salle) {
		this(matiere, null, jourSemaine, periodeDebut, duree, salle);
	}

	public static String horaire(/* args */) {
		// TODO
		return null;
	}
}
