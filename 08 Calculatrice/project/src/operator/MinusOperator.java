package operator;

import main.State;

public class MinusOperator extends TwoOperandCalculOperator {
	public void execute() {
		State.getInstance().operandMinus();
	}
}
