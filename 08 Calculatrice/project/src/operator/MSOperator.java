package operator;
import main.State;

public class MSOperator extends ControlOperator {
	void exec() {
		State.getInstance().controlMemoryStore();
	}
}
