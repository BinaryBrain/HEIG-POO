/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labo6;

/**
 *
 * @author Simon
 */
class Personne{
    private String nom;
    private String prenom;
    public Personne(String nom, String prenom)
    {
        this.nom = nom;
        this.prenom = prenom;
    }
    public String toString()
    {
       return nom + " " + prenom;
    }
}
class Professeur extends Personne{
    private String abreviation;
    public Professeur(String nom, String prenom, String abreviation)
    {
        super(nom, prenom);
        this.abreviation = abreviation;
    }
    public String abreviation()
    {
        return abreviation;
    }
    public String toString()
    {
        return abreviation + super.toString();
    }
}

class Etudiant extends Personne{
    private int matricule;
    public Etudiant(String nom, String prenom, int matricule)
    {
        super(nom, prenom);
        this.matricule = matricule;
    }
    public String toString()
    {
        return matricule + super.toString();
    }   
}

