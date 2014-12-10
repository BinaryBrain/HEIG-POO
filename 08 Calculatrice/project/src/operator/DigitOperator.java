package operator;
import main.State;

public class DigitOperator extends NumberOperator {

	private int myValue = 0;

	public DigitOperator(int value) {
		myValue = value;
	}

	public void execute() {
		State.getInstance().addDigit(myValue);
	}
}
