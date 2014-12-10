package operator;

/**
 * This is the root class of the hierachy of all operators. All the hierarchy
 * contains checkShouldExecute and exec methods: checkShouldExecute checks if an
 * operator (or a group of operator) should be executed, exec execute the
 * operator (in the deepest defition in the hierarchy). The only non-abstract
 * method (execute) calls the checkShouldExecute() on the operator and then if
 * necessary the exec method().
 * <p>
 * --- Hierarchy --- <br>
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
public abstract class Operator {
	public void execute() {
		if (checkShouldExecute()) {
			exec();
		}
	}

	abstract void exec();

	abstract boolean checkShouldExecute();
}
