package util;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Represente une pile geree manuellement.
 * @author Sacha Bron
 * @author Valentin Minder
 * @date 13.11.2014
 */
public class Pile {

	/**
	 * Reference vers le sommet de la pile.
	 * 
	 * Valeur par defaut: null (si la pile est vide).
	 */
	private ObjectContainer head = null;
	/**
	 * Taille courante de la pile.
	 * 
	 * Valeur par defaut: 0 (la pile est vide).
	 */
	private int size = 0;

	/**
	 * Ajoute un element au sommet de la pile.
	 * @param data l'element a ajouter.
	 */
	public void empile(Object data) {
		head = new ObjectContainer(data, head);
		size++;
	}

	/**
	 * Retourne et supprimer l'element au sommet de la pile.
	 * @return le premier element de la pile.
	 */
	public Object depile() {
		ObjectContainer pop = head;
		Object ret = null;
		if (pop != null) {
			ret = pop.getData();
			head = head.getPred();
			size--;
		}
		return ret;
	}

	/**
	 * Retourne une reprentation sous forme de String de l'etat de la pile.
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
	 * @return
	 */
	public Object[] toArray() {
		Object[] array = new Object[size];
		ObjectContainer current = head;
		int ptr = 0;
		while (current != null) {
			array[ptr] = current.getData();
			current = current.getPred();
			ptr++;
		}
		return array;
	}

	/**
	 * Retourne un iterateur sur objet sur la pile.
	 * @return
	 */
	public Iterator<Object> iterator() {
		Iterator<Object> iter = new Iterator<Object>() {

			/**
			 * Reference vers l'objet en cours de manipulation dans cet iterateur.
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

}
