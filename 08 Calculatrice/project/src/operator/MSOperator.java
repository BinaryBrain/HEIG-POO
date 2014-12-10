package operator;
import main.State;

public class MSOperator extends ControlOperator {
	public void execute() {
		State.getInstance().controlMemoryStore();
	}
}
