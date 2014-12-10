package operator;

import main.State;

public class SignOperator extends OneOperandCalculOperator {

	void exec() {
		State.getInstance().inverseSign();
	}
}
