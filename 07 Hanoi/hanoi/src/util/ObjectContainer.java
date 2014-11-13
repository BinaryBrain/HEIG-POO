package util;

/**
 * Represente un conteneur compose d'une donnee (data) et d'une reference vers
 * son predecesseur.
 * 
 * @author Sacha Bron
 * @author Valentin Minder
 * @date 13.11.2014
 */
public class ObjectContainer {

	/**
	 * Donnee contenue par le conteneur.
	 */
	private Object data;
	/**
	 * Reference vers le conteneur predecesseur.
	 */
	private ObjectContainer pred;

	/**
	 * Constructeur d'un conteneur
	 * 
	 * @param data
	 *            la donnee a contenir
	 * @param pred
	 *            la reference vers le predecesseur
	 */
	public ObjectContainer(Object data, ObjectContainer pred) {
		this.data = data;
		this.pred = pred;
	}

	/**
	 * Retourne la donnee representee par le conteneur.
	 * 
	 * @return la donne
	 */
	public Object getData() {
		return data;
	}

	/**
	 * Retourne le conteneur predecesseur.
	 * 
	 * @return le predecesseur
	 */
	public ObjectContainer getPred() {
		return pred;
	}

	/**
	 * Retourne la reprensation sous forme de String de ce conteneur.
	 * 
	 * Il s'agit de l'appel toString() sur les donnees contenues.
	 */
	@Override
	public String toString() {
		return data.toString();
	}
}
