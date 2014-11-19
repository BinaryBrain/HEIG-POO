package util;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * Permet de tester toutes les fonctions publiques de Pile...
 * 
 * @author Sacha Bron
 * @author Valentin Minder
 * @date 13.11.2014
 */
public class TestPile {

	public static void main(String[] args) {

		Pile pileTest = new Pile();
		System.out.println("TEST: taille pile vide:" + pileTest.getSize());
		String s1 = "hello(1)";
		String s2 = "world(2)";
		String s3 = "my name is Bond (3)";
		String s4 = "James Bond (4)";

		try {
			// crashe volontairement, catch!
			System.out.println("Depile:" + pileTest.depile());
			System.err.println("ERREUR : Pile devrait etre vide !!");
		} catch (EmptyStackException e) {
			System.out.println("TEST : vide au demarrage");
		}

		System.out.println("TEST: empile/depile.");
		System.out.println("Empile:" + pileTest.empile(s1));
		System.out.println("Empile:" + pileTest.empile(s2));
		System.out.println("Empile:" + pileTest.empile(s3));
		System.out.println("Empile:" + pileTest.empile(s4));
		System.out.println("TEST: taille pile plein:" + pileTest.getSize());
		System.out.println("Depile:" + pileTest.depile());
		System.out.println("Depile:" + pileTest.depile());
		System.out.println("Depile:" + pileTest.depile());
		System.out.println("Depile:" + pileTest.depile());

		try {
			// crashe volontairement, catch!
			System.out.println("Depile:" + pileTest.depile());
			System.out.flush();
			System.err.println("ERREUR : Pile devrait etre vide !!");
			System.err.flush();
		} catch (EmptyStackException e) {
			System.out.println("TEST: Depile: previsible : Pile vide!");
		}

		System.out.println("Empile:" + pileTest.empile(s1));
		System.out.println("Empile:" + pileTest.empile(s2));
		System.out.println("Empile:" + pileTest.empile(s3));
		System.out.println("Empile:" + pileTest.empile(s4));

		System.out.println("TEST: ToString():" + pileTest.toString());

		System.out.println("TEST: foreach on ToArray()");
		Object[] objectArray = pileTest.toArray();
		for (Object object : objectArray) {
			System.out.println(object);
		}

		System.out.println("TEST Arrays.toString() on toArray()");
		System.out.println(Arrays.toString(objectArray));

		System.out.println("TEST: Iterateur");
		Iterator<Object> iterator = pileTest.iterator();
		System.out.println("HasNext()?:" + iterator.hasNext());
		while (iterator.hasNext()) {
			System.out.println("Next:" + iterator.next());
			System.out.println("HasNext()?:" + iterator.hasNext());
		}
	}
}
