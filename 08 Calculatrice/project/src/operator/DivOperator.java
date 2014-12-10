package operator;

import main.State;

public class DivOperator extends TwoOperandCalculOperator {
	public void execute() {
		State.getInstance().operandDiv();
	}
}
