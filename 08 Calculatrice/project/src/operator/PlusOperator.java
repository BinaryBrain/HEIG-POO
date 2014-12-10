package operator;

import main.State;

public class PlusOperator extends TwoOperandCalculOperator {
	public void execute() {
		State.getInstance().operandPlus();
	}
}
