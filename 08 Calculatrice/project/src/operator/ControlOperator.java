package operator;

public abstract class ControlOperator extends Operator {
	abstract void exec();

	boolean checkShouldExecute() {
		// they are always allowed!
		return true;
	}
}
