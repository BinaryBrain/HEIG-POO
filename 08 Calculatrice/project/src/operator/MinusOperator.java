package operator;

import main.State;

public class MinusOperator extends TwoOperandCalculOperator {
	void exec() {
		State.getInstance().operandMinus();
	}
}
