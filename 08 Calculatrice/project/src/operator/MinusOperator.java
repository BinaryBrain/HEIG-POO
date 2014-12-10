package operator;

import main.State;

public class MinusOperator extends TwoOperandCalculOperator {
	public void exec() {
		State.getInstance().operandMinus();
	}
}
