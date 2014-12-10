package operator;

import main.State;

public abstract class TwoOperandCalculOperator extends CalculOperator {
	abstract public void exec();

	public boolean checkShouldExecute() {
		return State.getInstance().beforeTwoOperands();
	}
}
