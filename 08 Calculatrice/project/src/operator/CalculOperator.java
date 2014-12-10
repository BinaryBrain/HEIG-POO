package operator;

public abstract class CalculOperator extends Operator {
	abstract public void exec();

	abstract public boolean checkShouldExecute();
}
