package operator;

import main.State;

public abstract class NumberOperator extends Operator {
	abstract public void exec();
	
	public boolean checkShouldExecute() {
		return State.getInstance().checkNumericalOperator();
	}
}
