package operator;

import main.State;

public class PlusOperator extends TwoOperandCalculOperator {
	public void exec() {
		State.getInstance().operandPlus();
	}
}
