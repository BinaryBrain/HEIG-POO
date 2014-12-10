package operator;

import main.State;

public class PlusOperator extends TwoOperandCalculOperator {
	void exec() {
		State.getInstance().operandPlus();
	}
}
