package operator;

import main.State;

public class SignOperator extends NumberOperator {

	public void exec() {
		State.getInstance().inverseSign();
	}
}
