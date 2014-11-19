package hanoi;

import hanoi.gui.JHanoi;

/**
 * Permet de tester les fonctions de resolution de Hanoi. Gere le mode graphique
 * et le mode console.
 * 
 * @author Sacha Bron
 * @author Valentin Minder
 * @date 13.11.2014
 */
public class TestHanoi {

	public static void main(String[] args) {
		int size = 4;
		if (args.length > 0 && args[0] != null) {
			String arg = args[0];
			try {
				Integer i = new Integer(arg);
				if (i.intValue() <= 0) {
					throw new IllegalArgumentException();
				}
				size = i;
			} catch (NumberFormatException e) {
				System.err.println("Invalid number format: " + arg);
				return;
			} catch (IllegalArgumentException e) {
				System.err.println("Illegal argument: under 0" + arg);
				return;
			}
		}

		Hanoi h = new Hanoi(size);
		h.solveConsoleOnly();

		JHanoi j = new JHanoi();

	}

}
