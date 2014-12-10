package main;

import java.util.Arrays;
import java.util.Scanner;

import operator.*;

/**
 * This class represent the usage of the Calculator from a terminal/console. It
 * allows the user to enter values and operators with the keyboard, and the
 * state of the current value and stack is printed after each operations.
 * 
 * @author Sacha Bron
 * @author Valentin Minder
 */
public class Calculator {

	public static void main(String[] args) {

		State state = State.getInstance();
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the REVERSE POLISH TERMINAL CALCULATOR");

		String line = "";
		boolean flag = true;

		while (flag) {
			System.out.print("> ");
			line = scan.nextLine().trim().toLowerCase();
			if (line.equals("exit")) {
				flag = false;
				break;
			} else if (line.equals("+")) {
				new PlusOperator().execute();
			} else if (line.equals("-")) {
				new MinusOperator().execute();
			} else if (line.equals("/")) {
				new DivOperator().execute();
			} else if (line.equals("*")) {
				new TimesOperator().execute();
			} else if (line.equals("sqrt")) {
				new SqrtOperator().execute();
			} else if (line.equals("1/x")) {
				new OneOverXOperator().execute();
			} else if (line.equals("x^2")) {
				new SquareOperator().execute();
			} else if (line.equals("mr")) {
				new MROperator().execute();
			} else if (line.equals("ms")) {
				new MSOperator().execute();
			} else if (line.equals("c")) {
				new COperator().execute();
			} else if (line.equals("ce")) {
				new CEOperator().execute();
			} else if (line.equals("enter")) {
				new EnterOperator().execute();
			} else {
				if (line.length() > 0) {
					boolean changeSign = false;
					if (line.charAt(0) == '-') {
						changeSign = true;
						line = line.substring(1, line.length());
					}
					if (line.charAt(0) == '+') {
						line = line.substring(1, line.length());
					}
					for (int i = 0; i < line.length(); i++) {
						char a = line.charAt(i);
						if (a == '.') {
							new DotOperator().execute();
						} else if (a != ' ') {
							try {
								new DigitOperator(Integer.parseInt(a + ""))
										.execute();
								;
							} catch (NumberFormatException e) {
								System.err
										.println("Not a valid number. Try again");
								break;
							}
						}
					}
					if (changeSign) {
						new SignOperator().execute();
					}
				}
				// in order to make it immutable, so that the next
				// call doesnt modify the value but push it on the stack.
				new MSOperator().execute();
				new MROperator().execute();
			}

			System.out.print(state.getValueString() + " ");
			System.out.println(Arrays.toString(state.getStackState()));
		}
		scan.close();
	}
}
