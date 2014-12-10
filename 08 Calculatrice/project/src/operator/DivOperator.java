package operator;

import main.State;

public class DivOperator extends TwoOperandCalculOperator {
	void exec() {
		State.getInstance().operandDiv();
	}
}
