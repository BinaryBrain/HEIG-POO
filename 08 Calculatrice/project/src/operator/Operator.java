package operator;

public abstract class Operator {
	public void execute() {
		if (checkShouldExecute()) {
			exec();
		}
	}

	abstract public void exec();

	abstract public boolean checkShouldExecute();
}
