package operator;

import main.State;

public class OneOverXOperator extends OneOperandCalculOperator {
	public void execute() {
		State.getInstance().operandOver();
	}
}
