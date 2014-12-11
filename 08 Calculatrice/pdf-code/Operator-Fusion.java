package operator;

/**
 * This is the root class of the hierachy of all operators. All the hierarchy
 * contains checkShouldExecute and exec methods: checkShouldExecute checks if an
 * operator (or a group of operator) should be executed, exec execute the
 * operator (in the deepest defition in the hierarchy). The only non-abstract
 * method (execute) calls the checkShouldExecute() on the operator and then if
 * necessary the exec method().
 * <p>
 * --- Hierarchy --- (lexicographic) <br>
 * Operator <br>
 * --CalculOperator<br>
 * ----OneOperandCalculOperator<br>
 * ------SignOperator<br>
 * ------SqrtOperator<br>
 * ------SquareOperator<br>
 * ------OneOverXOperator<br>
 * ----TwoOperandCalculOperator<br>
 * ------DivOperator<br>
 * ------MinusOperator<br>
 * ------PlusOperator<br>
 * ------TimesOperator<br>
 * --ControlOperator <br>
 * ----BackSpaceOperator<br>
 * ----CEOperator<br>
 * ----COperator<br>
 * ----EnterOperator<br>
 * ----MROperator<br>
 * ----MSOperator<br>
 * --NumberOperator<br>
 * ----DigitOperator<br>
 * ----DotOperator<br>
 * <p>
 * Note: only the leaf are non-abstract, all the other are abstract.
 * 
 * @author Sacha Bron
 * @author Valentin Minder
 */

 // multi-page printing of all operators TO SAVE TREES !!!

import main.State;

public abstract class Operator {
	public void execute() {
		if (checkShouldExecute()) {
			exec();
		}
	}

	abstract void exec();

	abstract boolean checkShouldExecute();
}

public abstract class CalculOperator extends Operator {
	abstract void exec();
	abstract boolean checkShouldExecute();
}

public abstract class OneOperandCalculOperator extends CalculOperator {
	abstract void exec();
	boolean checkShouldExecute() {
		// checks that a one-operand-operator could be executed
		return State.getInstance().beforeOneOperand();
	}
}

public class SignOperator extends OneOperandCalculOperator {
	void exec() {
		State.getInstance().inverseSign();
	}
}

public class SqrtOperator extends OneOperandCalculOperator {
	void exec() {
		State.getInstance().operandSqrt();
	}
}

public class SquareOperator extends OneOperandCalculOperator {
	void exec() {
		State.getInstance().operandSquare();
	}
}

public class OneOverXOperator extends OneOperandCalculOperator {
	void exec() {
		State.getInstance().operandOver();
	}
}

public abstract class TwoOperandCalculOperator extends CalculOperator {
	abstract void exec();

	boolean checkShouldExecute() {
		// checks that a two-operands-operator could be executed
		return State.getInstance().beforeTwoOperands();
	}
}

public class DivOperator extends TwoOperandCalculOperator {
	void exec() {
		State.getInstance().operandDiv();
	}
}

public class MinusOperator extends TwoOperandCalculOperator {
	void exec() {
		State.getInstance().operandMinus();
	}
}

public class PlusOperator extends TwoOperandCalculOperator {
	void exec() {
		State.getInstance().operandPlus();
	}
}

public class TimesOperator extends TwoOperandCalculOperator {
	void exec() {
		State.getInstance().operandTimes();
	}
}

public abstract class ControlOperator extends Operator {
	abstract void exec();

	boolean checkShouldExecute() {
		// they are always allowed!
		return true;
	}
}

public class BackSpaceOperator extends ControlOperator {
	void exec() {
		State.getInstance().controlBackSpace();
	}
}

public class CEOperator extends ControlOperator {
	void exec() {
		State.getInstance().controlClearError();
	}
}

public class COperator extends ControlOperator {
	void exec() {
		State.getInstance().controlClear();
	}
}

public class EnterOperator extends ControlOperator {
	void exec() {
		State.getInstance().controlEnter();
	}
}

public class MROperator extends ControlOperator {
	void exec() {
		State.getInstance().controlMemoryRecall();
	}
}

public class MSOperator extends ControlOperator {
	void exec() {
		State.getInstance().controlMemoryStore();
	}
}

public abstract class NumberOperator extends Operator {
	abstract void exec();
	
	boolean checkShouldExecute() {
		// checks that a numerical modifier could be executed
		return State.getInstance().checkNumericalOperator();
	}
}

public class DotOperator extends NumberOperator {

	void exec() {
		State.getInstance().addDot();
	}
}

public class DigitOperator extends NumberOperator {

	private int myValue = 0;

	public DigitOperator(int value) {
		myValue = value;
	}

	void exec() {
		State.getInstance().addDigit(myValue);
	}
}
