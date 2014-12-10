package operator;

import main.State;

public class SignOperator extends NumberOperator {

	void exec() {
		State.getInstance().inverseSign();
	}
}
