package main;

import java.util.EmptyStackException;

import util.Pile;

/**
 * SINGLETON!
 */
public class State {

	private static State myInstance;

	private String strValue = "";
	// TODO: gerer erreur, plus message ?!?
	private boolean error = false;
	private String memory;

	private Pile pile;

	private void clear() {
		clearError();
		pile = new Pile();
	}

	private void clearError() {
		error = false;
		strValue = "";
	}

	/**
	 * Private constructor.
	 */
	private State() {
		clear();
	}

	public static State getInstance() {
		if (myInstance == null) {
			myInstance = new State();
		}
		return myInstance;
	}

	// always valid
	public void addDigit(int digit) {
		strValue += digit;
	}

	// always valid
	public void inverseSign() {
		if (value() < 0) {
			// TODO: marche pas ?!?
			strValue.substring(1, strValue.length());
		} else {
			strValue = "-" + strValue;
		}
	}

	// TODO may not be valid!
	public void addDot() {
		strValue += ".";
	}

	// TODO: checks
	private boolean checkTwoOperands() {
		return true;
	}

	private boolean checkOneOperand() {
		return true;
	}

	public void operandDiv() {
		setValue(head() / value());
	}

	public void operandTimes() {
		setValue(head() * value());
	}

	public void operandPlus() {
		setValue(head() + value());
	}

	public void operandMinus() {
		setValue(head() - value());
	}

	public void operandOver() {
		if (value() == 0) {
			// TODO error!!
		}
		setValue(1 / value());
	}

	public void operandSquare() {
		setValue(Math.pow(value(), 2));
	}

	public void operandSqrt() {
		setValue(Math.sqrt(value()));
	}

	public void controlEnter() {
		// TODO: verifier erreur
		push(value());
		clearError();
	}

	public void controlBackSpace() {
		if (strValue.length() > 0) {
			// !! 0.0 verifier TODO
			strValue = strValue.substring(0, strValue.length() - 1);
		}
	}

	public void controlMemoryStore() {
		// TODO: uniquement si pas d'erreur
		memory = strValue;
		clearError();
	}

	public void controlMemoryRecall() {
		strValue = memory;
	}

	public void controlClear() {
		clear();
	}

	public void controlClearError() {
		clearError();
	}

	private void push(double val) {
		// TODO: verifier erreur
		pile.empile(val);
	}

	private double head() {
		// TODO: mieux gerer la fin de pile!!
		try {
			return (double) pile.depile();
		} catch (EmptyStackException e) {
			return 0; // TODO: non
		}
	}

	private double value() {
		try {
			if (strValue.length() == 0) {
				return 0;
			}
			return Double.valueOf(strValue);
		} catch (NumberFormatException e) {
			error = true;
			return -1; // TODO: "ERROR: " + strValue;
		}

	}

	private void setValue(double d) {
		strValue = Double.toString(d);
	}

	public String valueStr() {
		// TODO: message d'erreur ?
		return Double.toString(value());
	}

	public Object[] stack() {
		return pile.toArray();
	}

}
