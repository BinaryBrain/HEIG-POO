package hanoi;

import hanoi.gui.JHanoi;
import util.Pile;

/**
 * Represente le classique probleme des Tours de Hanoi.
 * 
 * @author Sacha Bron
 * @author Valentin Minder
 * @date 13.11.2014
 */
public class Hanoi {

	/**
	 * Represente les trois piles initialisees.
	 */
	private Pile[] piles = { new Pile(), new Pile(), new Pile() };
	/**
	 * Represente la taille maximale de la pile (definie par le nombre de
	 * disques utilises)
	 */
	private int size = 0;
	/**
	 * Represente le nombre de coup joues jusque là.
	 */
	private int turn = 0;

	/**
	 * Constructeur.
	 * 
	 * @param disks
	 *            nombre de disks
	 */
	public Hanoi(int disks) {
		if (disks <= 0) {
			throw new IllegalArgumentException(
					"Positive number of disks required!");
		}
		System.out.println("calling hanoi" + disks);
		size = disks;
		// remplissage de la premiere pile.
		for (int i = 0; i < disks; i++) {
			piles[0].empile(size - i);
		}
	}

	/**
	 * Deplace tous les disques de la premiere aiguille à la troisieme en
	 * affichant les etats successifs des aiguilles dans la fenetre frame,
	 * instance de la classe hanoi.gui.JHanoi
	 * 
	 * @param frame
	 */
	public void solve(JHanoi frame) {
		System.out.println("solving hanoi");
		// TODO: not working.
		// frame.display();
		solve(size, 0, 2, 1, frame);
		return;
	}

	/**
	 * Resoud le probleme de maniere "console" avec affichage.
	 */
	public void solve() {
		System.out.println("--- turn " + turn + " ---");
		System.out.println("One:   " + piles[0]);
		System.out.println("Two:   " + piles[1]);
		System.out.println("Three: " + piles[2]);
		solve(size, 0, 2, 1, null);
	}

	/**
	 * Methode privee de resolution (affichage console ou graphique).
	 * 
	 * procedure Hanoi(n, D, A, I)
	 * 
	 * si n != 0
	 * 
	 * Hanoi(n-1, D, I, A)
	 * 
	 * Deplacer le disque de D vers A
	 * 
	 * Hanoi(n-1, I, A, D)
	 * 
	 * fin-procedure
	 *
	 * @param numberOfDisks
	 * @param nPileDepart
	 * @param nPileArrivee
	 * @param nPileInterm
	 * @param frame
	 *            JHanoi Frame (peut etre null pour affichage console)
	 */
	private void solve(int numberOfDisks, int nPileDepart, int nPileArrivee,
			int nPileInterm, JHanoi frame) {
		if (numberOfDisks > 0) {
			solve(numberOfDisks - 1, nPileDepart, nPileInterm, nPileArrivee,
					frame);
			Pile pileDepart = piles[nPileDepart];
			Pile pileArrivee = piles[nPileArrivee];
			int k = (int) pileDepart.depile();
			pileArrivee.empile(k);
			turn++;
			if (frame != null) {
				// TODO: not working
				// frame.display();
			} else {
				System.out.println("--- turn " + turn + " ---");
				System.out.println("One:   " + piles[0]);
				System.out.println("Two:   " + piles[1]);
				System.out.println("Three: " + piles[2]);
			}
			solve(numberOfDisks - 1, nPileInterm, nPileArrivee, nPileDepart,
					frame);
		}
	}

	/**
	 * Rend un tableau de tableaux représentant l’etat des aiguilles. Pour un
	 * tel tableau t, l’element t[i][j] correspond a la taille du j-eme disque
	 * (en partant du haut) de la i-eme aiguille.
	 * 
	 * @return
	 */
	public int[][] status() {
		System.out.println("get status");
		int[][] ret = new int[3][size];
		try {

			Object[] ar = piles[0].toArray();
			for (int i = 0, k = size - ar.length; k < size; i++, k++) {
				ret[0][k] = (int) ar[i];
			}
			ar = piles[1].toArray();
			for (int i = 0, k = size - ar.length; k < size; i++, k++) {
				ret[1][k] = (int) ar[i];
			}
			ar = piles[2].toArray();
			for (int i = 0, k = size - ar.length; k < size; i++, k++) {
				ret[2][k] = (int) ar[i];
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		return ret;
	}

	/**
	 * Rend true si la solution du probleme a ete atteinte, false sinon.
	 * 
	 * @return true si termine, false sinon.
	 */
	public boolean finished() {
		return !piles[0].iterator().hasNext() && !piles[1].iterator().hasNext();
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
