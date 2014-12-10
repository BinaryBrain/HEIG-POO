package main;

import util.Pile;

/**
 * This is singleton class.
 */
public class State {

	/**
	 * Private reference to the unique instance of State.
	 */
	private static State myInstance;

	/**
	 * Private constructor.
	 */
	private State() {
		clear();
	}

	/**
	 * Public getInstance of the State. If not exists, creates a new one.
	 * Otherwise, returns the same state.
	 * 
	 * @return the unique instance of State.
	 */
	public static State getInstance() {
		if (myInstance == null) {
			myInstance = new State();
		}
		return myInstance;
	}

	// INTERNAL STATE
	// value currently printed
	private String currentStrValue;
	// value stored in memory by MS
	private String memory;
	// if the current value has an error
	private boolean error;
	// error displayed to the user
	private String errorMessage;
	// if the value is mutable (while typing) or not (after a result)
	private boolean isMutable = true;
	// reference to the stack of computed values
	private Pile pile;

	/**
	 * Clear all the machine, including the stack and memory.
	 */
	private void clear() {
		clearError();
		pile = new Pile();
		memory = "";
	}

	/**
	 * Clear only the error on the current value.
	 */
	private void clearError() {
		currentStrValue = "";
		error = false;
		errorMessage = "";
		isMutable = true;
	}

	// NUMERICAL OPERATORS.
	/**
	 * To be called before a numerical operator. If it's not mutable, push the
	 * value to stack in order to enter a new value and keep the old one in the
	 * stack.
	 */
	public boolean checkNumericalOperator() {
		if (!isMutable) {
			push();
		}
		return !error;
	}

	/**
	 * Add a digit at the end of the current value.
	 */
	public void addDigit(int digit) {
		currentStrValue += digit;
	}

	/**
	 * Inverse the sign of the current value. WARNING: IN OUR COMPREHENSION,
	 * THIS IS A UNARY OPERATOR WHICH IS VALID ON ANY VALID VALUE (MUTABLE OR
	 * NOT), CONTRARY TO DIGIT OR DOT, WHICH ARE ONLY ALLOWED ON MUTABLE VALUES.
	 */
	public void inverseSign() {
		double val = value();
		if (!error) {
			if (val < 0) {
				currentStrValue = currentStrValue.substring(1,
						currentStrValue.length());
			} else if (val > 0) {
				currentStrValue = "-" + currentStrValue;
			}
		}
	}

	/**
	 * Add a dot at the end of the current value (plus a leading 0 if the value
	 * is currently empty)
	 */
	public void addDot() {
		if (currentStrValue.length() == 0) {
			currentStrValue += "0";
		}
		currentStrValue += ".";
	}

	// OPERATORS
	/**
	 * Checks that it's allowed to compute a two operands operator (the current
	 * value must be valid and the stack must have a least one element)
	 */
	public boolean beforeTwoOperands() {
		return beforeOneOperand() && hasNext();
	}

	/**
	 * Checks that it's allowed to compute a single operand operator (the
	 * current value must be valid)
	 */
	public boolean beforeOneOperand() {
		value();
		return !error;
	}

	public void operandDiv() {
		setValue(pop() / value());
	}

	public void operandTimes() {
		setValue(pop() * value());
	}

	public void operandPlus() {
		setValue(pop() + value());
	}

	public void operandMinus() {
		setValue(pop() - value());
	}

	public void operandOver() {
		if (value() == 0) {
			error = true;
			errorMessage = "Div. by 0 not allowed!";
		} else {
			setValue(1 / value());
		}
	}

	public void operandSquare() {
		setValue(Math.pow(value(), 2));
	}

	public void operandSqrt() {
		setValue(Math.sqrt(value()));
	}

	// CONTROLS
	/**
	 * Push the value to stack
	 */
	public void controlEnter() {
		push();
	}

	/**
	 * Only if the current value is mutable (not a computed result), removes the
	 * last digit inserted (including dot)
	 */
	public void controlBackSpace() {
		if (isMutable) {
			if (currentStrValue.length() > 0) {
				// !! 0.0 verifier TODO
				currentStrValue = currentStrValue.substring(0,
						currentStrValue.length() - 1);
			}
		}
	}

	/**
	 * Stores the current value (only if valid) in the memory, and leave it in
	 * the current value.
	 */
	public void controlMemoryStore() {
		value();
		if (!error) {
			memory = currentStrValue;
		}
	}

	/**
	 * Delete the current value (clearError) and replace it by the memory, which
	 * is non mutable;
	 */
	public void controlMemoryRecall() {
		clearError();
		currentStrValue = memory;
		isMutable = false;
	}

	/**
	 * Clear all the machine.
	 */
	public void controlClear() {
		clear();
	}

	/**
	 * Clear the error of the current value.
	 */
	public void controlClearError() {
		clearError();
	}

	// INSIDE STATE MANAGEMENT
	/**
	 * Push the value (only if valid) on the stack.
	 */
	private void push() {
		double val = value();
		if (!error) {
			pile.empile(val);
			clearError();
		}
	}

	/**
	 * Returns the last inserted value in the stack.
	 */
	private double pop() {
		if (hasNext()) {
			return (double) pile.depile();
		}
		return 0;
	}

	/**
	 * Checks if the stack has a next value, and stores an error if yes.
	 */
	private boolean hasNext() {
		if (pile.getSize() == 0) {
			error = true;
			errorMessage = "Empty stack! Operation not allowed!";
			return false;
		}
		return true;
	}

	/**
	 * Computes the numerical double value of the current value.
	 */
	private double value() {
		try {
			if (currentStrValue.length() == 0) {
				return 0;
			}
			return Double.valueOf(currentStrValue);
		} catch (NumberFormatException e) {
			error = true;
			errorMessage = "Format error:" + currentStrValue;
			return 0;
		}
	}

	/**
	 * Set the string current value
	 * 
	 * @param d
	 *            the new numerical value.
	 */
	private void setValue(double d) {
		currentStrValue = Double.toString(d);
		isMutable = false;
	}

	// INTERACTION WITH OUTSIDE
	/**
	 * Getter for the current value as string representation. Returns the error
	 * message if appropriate.
	 */
	public String getValueString() {
		if (error) {
			return errorMessage;
		}
		if (currentStrValue.length() == 0) {
			return "0";
		}
		return currentStrValue;
	}

	/**
	 * Get the stack state as an Object array.
	 */
	public Object[] getStackState() {
		return pile.toArray();
	}

}
