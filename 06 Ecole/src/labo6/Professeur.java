package labo6;

public class Professeur extends Personne{
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
