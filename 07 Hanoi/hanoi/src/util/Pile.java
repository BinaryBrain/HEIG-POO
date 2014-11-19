package util;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Represente une pile geree manuellement.
 * <p>
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
	 * Retourne un iterateur sur objet sur la pile.
	 * 
	 * @return un iterateur sur la pile.
	 */
	public Iterator<Object> iterator() {
		Iterator<Object> iter = new Iterator<Object>() {

			/**
			 * Reference vers l'objet en cours de manipulation dans cet
			 * iterateur.
			 */
			private ObjectContainer current = head;

			/**
			 * Permet de recuperer l'element suivant (s'il existe)
			 */
			@Override
			public Object next() {
				if (current == null) {
					throw new NoSuchElementException();
				} else {
					Object ret = current.getData();
					current = current.getPred();
					return ret;
				}
			}

			/**
			 * Permet de tester la presence d'un element suivant dans la pile
			 */
			@Override
			public boolean hasNext() {
				return current != null;
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
}
