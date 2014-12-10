package operator;

import main.State;

public abstract class TwoOperandCalculOperator extends CalculOperator {
	abstract void exec();

	boolean checkShouldExecute() {
		return State.getInstance().beforeTwoOperands();
	}
}
