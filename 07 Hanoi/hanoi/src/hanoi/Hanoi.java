package hanoi;

import hanoi.gui.JHanoi;
import util.Pile;

/**
 * Represente le classique probleme des Tours de Hanoi.
 * <p>
 * Trois piles sont utilisees pour representer l'etat courant des tours de
 * Hanoi. Fournit une methode de resolutoon du problème, avec affichage
 * graphique ou console, au choix.
 * 
 * @author Sacha Bron
 * @author Valentin Minder
 * @date 13.11.2014
 */
public class Hanoi {

	/**
	 * Represente les trois piles initialisees vides.
	 */
	private Pile[] pilesArray = { new Pile(), new Pile(), new Pile() };

	/**
	 * Represente la taille maximale de la pile (definie par le nombre de
	 * disques utilises).
	 */
	private int size = 0;

	/**
	 * Represente le nombre de coup joues jusque la (initialisation = 0).
	 */
	private int turn = 0;

	/**
	 * Constructeur (utilise pour resolution console et graphique).
	 * 
	 * @param disks
	 *            nombre de disks
	 * @throw {@link IllegalArgumentException} si le nombre de disque n'est pas
	 *        strictement positif
	 */
	public Hanoi(int disks) {
		if (disks <= 0) {
			throw new IllegalArgumentException(
					"Positive number of disks required!");
		}
		size = disks;
		// remplissage de la premiere pile.
		for (int i = 0; i < disks; i++) {
			pilesArray[0].empile(size - i);
		}
	}

	/**
	 * Resoud le probleme avec affichage de maniere "graphique".
	 * <p>
	 * Deplace tous les disques de la premiere aiguille à la troisieme en
	 * affichant les etats successifs des aiguilles dans la fenetre frame,
	 * instance de la classe hanoi.gui.JHanoi
	 * 
	 * @param frame
	 */
	public void solve(JHanoi frame) {
		frame.display();
		solveHanoi(size, 0, 2, 1, frame);
		return;
	}

	/**
	 * Resoud le probleme avec affichage de maniere "console".
	 * <p>
	 * Deplace tous les disques de la premiere aiguille à la troisieme en
	 * affichant les etats successifs des aiguilles dans la console.
	 */
	public void solveConsoleOnly() {
		System.out.println("--- turn " + turn + " ---");
		System.out.println("One:   " + pilesArray[0]);
		System.out.println("Two:   " + pilesArray[1]);
		System.out.println("Three: " + pilesArray[2]);
		solveHanoi(size, 0, 2, 1, null);
	}

	/**
	 * Methodes de resolution recursive de Hanoi (affichage console ou
	 * graphique).
	 * <p>
	 * 
	 * Explication par pseudo-code <br>
	 * (n est le nombre de disque, D, A, I sont les piles respectivement de
	 * depart, d'arrivee et intermediaire
	 * <p>
	 * procedure Hanoi(n, D, A, I) <br>
	 * __si n != 0 <br>
	 * ____Hanoi(n-1, D, I, A) // (1)<br>
	 * ____Deplacer le disque de D vers A // (2) <br>
	 * ____Hanoi(n-1, I, A, D) // (3)<br>
	 * fin-procedure
	 * <p>
	 * 
	 * Explication en francais: pour deplacer un pile de n disques de depart D a
	 * arrivee A, il faut <br>
	 * (1) deplacer la pile de n-1 disques (sans le plus grand disque) du depart
	 * D a l'intermediaire I, <br>
	 * (2) deplacer le plus grand cercle du depart D a l'arrivee A, <br>
	 * (3) finalement deplacer de n-1 disques (sans le plus grand disque) la
	 * pile de l'intermediaire I a l'arrive A.
	 * 
	 * <p>
	 * Les index des piles doivent etre entre 0 et 2, et etre complets (chacune
	 * des piles doit etre representee, donc tous differents et la somme doit
	 * etre 0 + 1 + 2 = 3).
	 *
	 * @param numberOfDisks
	 *            nombre de disques a deplacer
	 * @param indexPileDepart
	 *            index de la pile de depart
	 * @param indexPileArrivee
	 *            index de la pile d'arrivee
	 * @param indexPileInterm
	 *            index de la pile utilisee comme intermediaire
	 * @param frame
	 *            JHanoi Frame (peut etre null pour affichage console
	 *            uniquement)
	 */
	public void solveHanoi(int numberOfDisks, int indexPileDepart,
			int indexPileArrivee, int indexPileInterm, JHanoi frame) {
		// test des arguments...
		if (numberOfDisks <= 0 || numberOfDisks > size) {
			throw new IllegalArgumentException(
					"Number of disks must be: 0 < disks <= size of Hanoi towers");
		}
		if (indexPileDepart + indexPileArrivee + indexPileInterm != 3) {
			throw new IllegalArgumentException(
					"Piles idnex must represent the three piles: 0, 1, 2, and their sum must be 3.");
		}
		if (indexPileDepart == indexPileArrivee
				|| indexPileDepart == indexPileInterm
				|| indexPileArrivee == indexPileInterm) {
			throw new IllegalArgumentException(
					"Piles idnex must represent the three piles: 0, 1, 2, and must be all different");
		}
		if (0 > indexPileDepart || 0 > indexPileArrivee || 0 > indexPileInterm
				|| indexPileDepart > 2 || indexPileArrivee > 2
				|| indexPileInterm > 2) {
			throw new IllegalArgumentException(
					"Piles idnex must represent the three piles: 0, 1, 2, and must be 0 <= index < 3");
		}

		// appel fonction privee
		solveHanoiRecursive(numberOfDisks, indexPileDepart, indexPileArrivee,
				indexPileInterm, frame);
	}

	/**
	 * Voir ci dessus @link{@link Hanoi#solveHanoi(int, int, int, int, JHanoi)}
	 */
	private void solveHanoiRecursive(int numberOfDisks, int indexPileDepart,
			int indexPileArrivee, int indexPileInterm, JHanoi frame) {
		// condition d'arret de la recursion
		if (numberOfDisks > 0) {

			// appel recursif
			solveHanoiRecursive(numberOfDisks - 1, indexPileDepart,
					indexPileInterm, indexPileArrivee, frame);

			// deplacement courrant: UN objet de depart a arrivee
			Pile pileDepart = pilesArray[indexPileDepart];
			Pile pileArrivee = pilesArray[indexPileArrivee];
			int k = (int) pileDepart.depile();
			pileArrivee.empile(k);
			turn++;
			if (frame != null) {
				frame.display();
			} else {
				System.out.println("--- turn " + turn + " ---");
				System.out.println("One:   " + pilesArray[0]);
				System.out.println("Two:   " + pilesArray[1]);
				System.out.println("Three: " + pilesArray[2]);
			}

			// appel recursif
			solveHanoiRecursive(numberOfDisks - 1, indexPileInterm,
					indexPileArrivee, indexPileDepart, frame);
		}
	}

	/**
	 * Rend un tableau de tableaux représentant l’etat des aiguilles. Pour un
	 * tel tableau t, l’element t[i][j] correspond a la taille du j-eme disque
	 * (en partant du haut) de la i-eme aiguille.
	 * <p>
	 * Attention, le tableau n'est pas de taille 3 x n, car seules les cases
	 * occupees sont representees! La 2e dimension n'est donc pas homogène!
	 * 
	 * @return un tableau representant l'etat des piles
	 */
	public int[][] status() {
		int[][] statusIntIntArray = new int[3][];
		Object[] statusPileIndexAsObjectArray;
		for (int indexPile = 0; indexPile < 3; indexPile++) {
			statusPileIndexAsObjectArray = pilesArray[indexPile].toArray();
			statusIntIntArray[indexPile] = new int[statusPileIndexAsObjectArray.length];
			for (int indexVertical = 0; indexVertical < statusPileIndexAsObjectArray.length; indexVertical++) {
				statusIntIntArray[indexPile][indexVertical] = (int) statusPileIndexAsObjectArray[indexVertical];
			}
		}
		return statusIntIntArray;
	}

	/**
	 * Rend true si la solution du probleme a ete atteinte, false sinon.
	 * <p>
	 * Retourne true si les pile 0 et 1 sont vides (et donc la pile 2 contient
	 * tous les disques).
	 * 
	 * @return true si termine, false sinon.
	 */
	public boolean finished() {
		return !pilesArray[0].iterator().hasNext()
				&& !pilesArray[1].iterator().hasNext();
	}

	/**
	 * Rend le nombre de disques deja deplaces.
	 * 
	 * @return nombre de disque deplaces
	 */
	public int turn() {
		return turn;
	}

}
