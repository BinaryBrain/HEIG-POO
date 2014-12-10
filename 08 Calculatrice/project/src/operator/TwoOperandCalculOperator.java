package operator;

import main.State;

public abstract class TwoOperandCalculOperator extends CalculOperator {
	abstract void exec();

	boolean checkShouldExecute() {
		// checks that a two-operands-operator could be executed
		return State.getInstance().beforeTwoOperands();
	}
}
