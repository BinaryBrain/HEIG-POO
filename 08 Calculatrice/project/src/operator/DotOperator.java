package operator;

import main.State;

public class DotOperator extends NumberOperator {

	public void exec() {
		State.getInstance().addDot();
	}
}
