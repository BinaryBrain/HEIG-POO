package operator;

import main.State;

public abstract class OneOperandCalculOperator extends CalculOperator {
	abstract void exec();

	boolean checkShouldExecute() {
		// checks that a one-operand-operator could be executed
		return State.getInstance().beforeOneOperand();
	}
}
