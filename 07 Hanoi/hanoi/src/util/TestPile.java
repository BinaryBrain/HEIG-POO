package util;

import java.util.Iterator;

/**
 * Permet de tester les fonctions de Pile et ObjectContainer...
 * 
 * @author Sacha Bron
 * @author Valentin Minder
 * @date 13.11.2014
 */
public class TestPile {

	public static void main(String[] args) {

		Pile p = new Pile();
		String s1 = "hello";
		String s2 = "world";
		p.empile(s1);
		p.empile(s2);
		System.out.println(p.depile());
		System.out.println(p.depile());
		System.out.println(p.depile());

		p.empile(s1);
		p.empile(s2);
		p.empile(s2);
		System.out.println(p.toString());
		Object[] o = p.toArray();
		for (Object object : o) {
			System.out.println(object);
		}

		Iterator<Object> i = p.iterator();
		while (i.hasNext()) {
			Object a = i.next();
			System.out.println(a);
		}
	}
}
