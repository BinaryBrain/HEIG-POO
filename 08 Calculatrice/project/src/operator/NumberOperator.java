package operator;

import main.State;

public abstract class NumberOperator extends Operator {
	abstract void exec();
	
	boolean checkShouldExecute() {
		return State.getInstance().checkNumericalOperator();
	}
}
