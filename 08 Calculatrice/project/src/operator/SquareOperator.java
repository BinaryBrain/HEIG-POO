package operator;

import main.State;

public class SquareOperator extends OneOperandCalculOperator {
	public void execute() {
		State.getInstance().operandSquare();;
	}
}
