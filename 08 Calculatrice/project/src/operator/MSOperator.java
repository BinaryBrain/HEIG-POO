package operator;
import main.State;

public class MSOperator extends ControlOperator {
	public void exec() {
		State.getInstance().controlMemoryStore();
	}
}
