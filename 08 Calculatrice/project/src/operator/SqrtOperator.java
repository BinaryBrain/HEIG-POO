package operator;

import main.State;

public class SqrtOperator extends OneOperandCalculOperator {
	public void exec() {
		State.getInstance().operandSqrt();
	}
}
