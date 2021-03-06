package util;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * Represente une pile geree manuellement.
 * <p>
 * FROM LAB7 (HANOI) WITHOUT MODIFICATIONS!
 * 
 * @author Sacha Bron
 * @author Valentin Minder
 * @date 13.11.2014
 */
public class Pile {

	/**
	 * Reference vers le sommet de la pile.
	 * <p>
	 * Valeur par defaut: null (si la pile est vide).
	 */
	private ObjectContainer head = null;
	/**
	 * Taille courante de la pile.
	 * <p>
	 * Valeur par defaut: 0 (la pile est vide).
	 */
	private int size = 0;

	/**
	 * Ajoute un element au sommet de la pile.
	 * 
	 * @param data
	 *            l'element a ajouter.
	 * @return l'element ajouté au sommet.
	 */
	public Object empile(Object data) {
		// la nouvelle tete est le container de data donne avec reference sur
		// l'ancienne tete
		head = new ObjectContainer(data, head);
		size++;
		return data;
	}

	/**
	 * Retourne et supprimer l'element au sommet de la pile.
	 * 
	 * @return le premier element de la pile.
	 * @throw {@link EmptyStackException} si la pile est deja vide.
	 */
	public Object depile() {
		ObjectContainer pop = head;
		Object dataHead = null;
		if (pop != null) {
			dataHead = pop.getData();
			head = head.getPred();
			size--;
		} else {
			throw new EmptyStackException();
		}
		return dataHead;
	}

	/**
	 * Retourne une reprentation sous forme de String de l'etat de la pile.
	 * <p>
	 * Ex: "[ &lt;Obj1&gt; &lt;Obj2&gt; ]" ; "[ ]"
	 * 
	 * @return string representant le contenu de la pile.
	 */
	@Override
	public String toString() {
		Object[] array = toArray();
		String s = "[ ";
		for (int i = 0; i < array.length; i++) {
			s += "<" + array[i] + "> ";
		}
		s += "]";
		return s;
	}

	/**
	 * Retourne une reprentation sous forme de tableau de l'etat de la pile.
	 * <p>
	 * Le somment de la pile est en position 0 de la pile. La taille du tableau
	 * correspond à la taille de la pile (y compris si la pile est vide).
	 * 
	 * @return un tableau representant la pile.
	 */
	public Object[] toArray() {
		Object[] arrayRepresentation = new Object[size];
		ObjectContainer current = head;
		int indexArray = 0;
		while (current != null) {
			arrayRepresentation[indexArray] = current.getData();
			current = current.getPred();
			indexArray++;
		}
		return arrayRepresentation;
	}

	/**
	 * Retourne un @link {@link Iterateur} sur objet sur la pile.
	 * 
	 * @return un iterateur sur la pile.
	 */
	public Iterateur iterateur() {
		Iterateur iter = new Iterateur() {

			/**
			 * Reference vers l'objet en cours de manipulation dans cet
			 * iterateur.
			 */
			private ObjectContainer nextContainer = head;

			public Object suivant() {
				if (nextContainer == null) {
					throw new NoSuchElementException();
				} else {
					Object nextData = nextContainer.getData();
					nextContainer = nextContainer.getPred();
					return nextData;
				}
			}

			public boolean possedeSuivant() {
				return nextContainer != null;
			}
		};
		return iter;
	}

	/**
	 * Retourne la taille de la pile.
	 * 
	 * @return taille de la pile.
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Represente un conteneur compose d'une donnee (data) et d'une reference
	 * vers son predecesseur.
	 * 
	 * @author Sacha Bron
	 * @author Valentin Minder
	 * @date 13.11.2014
	 */
	private class ObjectContainer {

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
		 * Retourne la reference vers le conteneur predecesseur.
		 * 
		 * @return le predecesseur
		 */
		public ObjectContainer getPred() {
			return pred;
		}

		/**
		 * Retourne la reprensation sous forme de String de ce conteneur.
		 * <p>
		 * Il s'agit de l'appel toString() sur les donnees contenues.
		 */
		@Override
		public String toString() {
			return data.toString();
		}
	}
}
