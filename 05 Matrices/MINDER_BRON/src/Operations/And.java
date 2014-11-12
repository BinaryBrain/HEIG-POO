/*
 * File: And.java
 * Date: 16 octobre 2014
 * Goal: And operation between two matrices.
 * Authors: Sacha Bron, Valentin Minder
 */

package Operations;

public class And extends Operation {
	protected boolean execute(boolean a, boolean b) {
		return a & b;
	}
}
