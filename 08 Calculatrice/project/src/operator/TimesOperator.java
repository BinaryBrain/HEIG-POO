package operator;

import main.State;

public class TimesOperator extends TwoOperandCalculOperator {
	void exec() {
		State.getInstance().operandTimes();
	}
}
