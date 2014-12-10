package operator;

import main.State;

public class SquareOperator extends OneOperandCalculOperator {
	public void exec() {
		State.getInstance().operandSquare();
	}
}
