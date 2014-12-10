package operator;

public abstract class Operator {
	public void execute() {
		if (checkShouldExecute()) {
			exec();
		}
	}

	abstract void exec();

	abstract boolean checkShouldExecute();
}
