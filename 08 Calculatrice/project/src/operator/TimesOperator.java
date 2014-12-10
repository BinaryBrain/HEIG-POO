package operator;

import main.State;

public class TimesOperator extends TwoOperandCalculOperator {
	public void exec() {
		State.getInstance().operandTimes();
	}
}
