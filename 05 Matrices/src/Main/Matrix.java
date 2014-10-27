/*
 * File: Matrix.java
 * Date: 16 octobre 2014
 * Goal: Represent a square Matrix.
 * Authors: Sacha Bron, Valentin Minder
 */

package Main;
/**
 * 
 * This class represent a boolean square matrix of fixed size, with mutable elements.
 * 
 * @author Valentin
 *
 */
public class Matrix {
	
	/**
	 * Inner matrix storage
	 */
	private boolean [][] matrix = null;
    
	/**
	 * Constructor
	 * @param size size of matrix;
	 */
    public Matrix (int size) {
    	// create an empty square matrix
        matrix = new boolean [size][size];
        
        // fill the matrix
        fillRandom();
    }
    
    /**
     * Fill a matrix randomly
     */
    private void fillRandom () {
    	for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = (Math.random() >= 0.5);
			}
		}
    }
    
    /**
     * Get the size of the matrix.
     * @return
     */
    public int getSize() {
    	return matrix.length;
    }
    
    /**
     * Get the value of an element.
     * @param x the x coordinate
     * @param y the y coordinate
     * @return the value of this element
     */
    public boolean getElement(int x, int y) {
    	if (x < 0 || x >= getSize() || y < 0 || y >= getSize()) {
			throw new IllegalArgumentException("x/y outside matrix bounds");
		};
    	return matrix[x][y];
    }
    
    /**
     * Set the value of an element
     * @param x the x coord
     * @param y the y coord
     * @param value the new value
     */
    public void setElement (int x, int y, boolean value) {
    	if (x < 0 || x >= getSize() || y < 0 || y >= getSize()) {
			throw new IllegalArgumentException("x/y outside matrix bounds");
		};
    	matrix[x][y] = value;
    }
    
    /**
     * Return a std representation of the matrix.
     */
    @Override
    public String toString () {
    	StringBuffer buffer = new StringBuffer();
    	if (matrix != null){
    		for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					buffer.append(matrix[i][j] ? "1 " : "0 ");
				}
				buffer.append("\n");
			}
    		return buffer.toString();
    	}
    	return null;
    }
}
