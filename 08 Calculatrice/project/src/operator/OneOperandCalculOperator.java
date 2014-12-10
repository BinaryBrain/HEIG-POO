package operator;

import main.State;

public abstract class OneOperandCalculOperator extends CalculOperator {
	abstract void exec();

	boolean checkShouldExecute() {
		return State.getInstance().beforeOneOperand();
	}
}
