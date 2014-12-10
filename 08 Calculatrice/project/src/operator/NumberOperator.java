package operator;

import main.State;

public abstract class NumberOperator extends Operator {
	abstract void exec();
	
	boolean checkShouldExecute() {
		// checks that a numerical modifier could be executed
		return State.getInstance().checkNumericalOperator();
	}
}
