package util;

/**
 * Interface representant un iterateur, notamment les methode possedeSuivant()
 * et suivant().
 * <p>
 * FROM LAB7 (HANOI) WITHOUT MODIFICATIONS!
 * 
 * @author Sacha Bron
 * @author Valentin Minder
 * @date 13.11.2014
 */
public interface Iterateur {

	/**
	 * Permet de tester la presence d'un element suivant dans la pile
	 */
	public boolean possedeSuivant();

	/**
	 * Permet de recuperer l'element suivant (s'il existe)
	 */
	public Object suivant();
}
