package operator;

import main.State;

public abstract class OneOperandCalculOperator extends CalculOperator {
	abstract public void exec();

	public boolean checkShouldExecute() {
		return State.getInstance().beforeOneOperand();
	}
}
