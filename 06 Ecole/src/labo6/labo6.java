/*
 * File: labo6.java
 * Authors: Simon Baehler, Sacha Bron
 * Date: 29.10.2014
 * Goal: Launch and test the program.
 */

package labo6;

class labo6 {
    public static void main(String... args) {
    	Professeur cez = new Professeur("Evequoz", "Evequoz", "CEZ");
    	Professeur pdo = new Professeur("Donini", "Pier", "PDO");

    	Lecon poo1 = new Lecon("POO", pdo, 2, 4, 2, "H06");
    	Lecon poo2 = new Lecon("POO", pdo, 3, 2, 2, "H06");
    	Lecon poo3 = new Lecon("POO", pdo, 3, 4, 2, "H06");
    	
    	Lecon plp = new Lecon("PLP", cez, 0, 4, 5, "C23");
    	Lecon tic = new Lecon("TIC", 1, 9, 1, "F06");
    	
    	Etudiant john = new Etudiant("Lennon", "John");
    	Etudiant paul = new Etudiant("McCartney", "Paul");
    	Etudiant ringo = new Etudiant("Starr", "Ringo");
    	Etudiant george = new Etudiant("Harisson", "George");
    	Etudiant roger = new Etudiant("Waters", "Roger");
    	Etudiant david = new Etudiant("Gilmour", "David");

    	Groupe il61 = new Groupe(1, orientation???, trimiestre???, "IL6", john, paul, ringo, george);
    	Groupe ts61 = new Groupe(1, orientation???, trimiestre???, "TS6", roger, david);
    	
    	il61.definirLecons(poo1, poo2, poo3, plp, tic);
    	ts61.definirLecons(poo1, poo2, poo3);
    	
    	System.out.println("-- Membres de l'ecole");
    	// TODO toString sur un max de classe.
    } 
}
