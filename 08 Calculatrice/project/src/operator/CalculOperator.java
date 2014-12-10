package operator;

public abstract class CalculOperator extends Operator {
	abstract void exec();

	abstract boolean checkShouldExecute();
}
