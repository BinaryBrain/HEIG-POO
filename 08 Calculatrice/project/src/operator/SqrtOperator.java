package operator;

import main.State;

public class SqrtOperator extends OneOperandCalculOperator {
	public void execute() {
		State.getInstance().operandSqrt();
	}
}
