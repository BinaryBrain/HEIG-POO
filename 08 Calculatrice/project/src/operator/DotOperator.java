package operator;

import main.State;

public class DotOperator extends NumberOperator {

	void exec() {
		State.getInstance().addDot();
	}
}
