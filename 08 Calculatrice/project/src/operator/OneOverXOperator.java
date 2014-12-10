package operator;

import main.State;

public class OneOverXOperator extends OneOperandCalculOperator {
	public void exec() {
		State.getInstance().operandOver();
	}
}
