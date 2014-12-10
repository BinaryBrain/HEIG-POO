package operator;
import main.State;

public class MROperator extends ControlOperator {
	void exec() {
		State.getInstance().controlMemoryRecall();
	}
}
