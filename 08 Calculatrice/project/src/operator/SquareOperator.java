package operator;

import main.State;

public class SquareOperator extends OneOperandCalculOperator {
	void exec() {
		State.getInstance().operandSquare();
	}
}
