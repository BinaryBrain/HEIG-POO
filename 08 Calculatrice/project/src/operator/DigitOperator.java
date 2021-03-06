package operator;

import main.State;

public class DigitOperator extends NumberOperator {

	private int myValue = 0;

	public DigitOperator(int value) {
		myValue = value;
	}

	void exec() {
		State.getInstance().addDigit(myValue);
	}
}
