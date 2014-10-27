/*
 * File: Launcher.java
 * Date: 16 octobre 2014
 * Goal: Uses Matrices and Operations to achive the lab goal. Contains the main.
 * Authors: Sacha Bron, Valentin Minder
 */

package Main;
import Operations.And;
import Operations.Operation;
import Operations.Or;
import Operations.Xor;


public class Launcher {
	public static void main(String[] args) {
		String banner = 
		".  .   .                 ,      , .       .  .    ,        |\n"+
		"|  | _ | _. _ ._ _  _   -+-_   -+-|_  _   |\\/| _ -+-._.*\\./|\n"+ 
		"|/\\|(/,|(_.(_)[ | )(/,   |(_)   | [ )(/,  |  |(_] | |  |/'\\*\n"+
		"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
		
		int size = 4;
		Matrix m1 = new Matrix(size);
		Matrix m2 = new Matrix(size);
		
		System.out.println(banner);
		System.out.println("Matrix one");
		System.out.println(m1);
		System.out.println("Matrix two");
		System.out.println(m2);
		System.out.println("oneOrTwo = one or two");
		Operation op = new Or();
		System.out.println(op.executeOperation(m1, m2));
		System.out.println("oneAndTwo = one and two");
		op = new And();
		System.out.println(op.executeOperation(m1, m2));
		System.out.println("oneXOrTwo = one xor two");
		op = new Xor();
		System.out.println(op.executeOperation(m1, m2));
	}
}
