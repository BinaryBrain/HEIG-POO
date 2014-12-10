package operator;

import main.State;

public class OneOverXOperator extends OneOperandCalculOperator {
	void exec() {
		State.getInstance().operandOver();
	}
}
