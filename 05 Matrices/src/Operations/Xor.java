/*
 * File: Xor.java
 * Date: 16 octobre 2014
 * Goal: Xor operation between two matrices.
 * Authors: Sacha Bron, Valentin Minder
 */

package Operations;

public class Xor extends Operation {
	protected boolean execute(boolean a, boolean b) {
		return a ^ b;
	}
}
