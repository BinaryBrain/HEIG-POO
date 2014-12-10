package operator;

import main.State;

public class DivOperator extends TwoOperandCalculOperator {
	public void exec() {
		State.getInstance().operandDiv();
	}
}
