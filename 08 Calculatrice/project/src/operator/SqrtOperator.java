package operator;

import main.State;

public class SqrtOperator extends OneOperandCalculOperator {
	void exec() {
		State.getInstance().operandSqrt();
	}
}
