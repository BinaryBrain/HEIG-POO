package operator;

public abstract class ControlOperator extends Operator {
	abstract public void exec();

	public boolean checkShouldExecute() {
		// they are always allowed!
		return true;
	}
}
