package operator;

import main.State;

public class TimesOperator extends TwoOperandCalculOperator {
	public void execute() {
		State.getInstance().operandTimes();
	}
}
