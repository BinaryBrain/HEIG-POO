package hanoi;

/**
 * Permet de tester les fonctions de resolution de Hanoi en mode console.
 * 
 * <p>
 * Il est possible de preciser la taille des tours par argument, par defaut 4
 * sans arguments.
 * 
 * @author Sacha Bron
 * @author Valentin Minder
 * @date 13.11.2014
 */
public class TestHanoi {

	/**
	 * Taille par defaut des tours de Hanoi (sans argument)
	 */
	private static int defaultSize = 4;

	/**
	 * Launch the Hanoi tower in console mode.
	 * <p>
	 * arg[1] is the size of the tower (optionnal, default = 4).
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int size = defaultSize;
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

		new Hanoi(size).solveConsoleOnly();
	}
}
