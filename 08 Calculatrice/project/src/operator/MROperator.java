package operator;
import main.State;

public class MROperator extends ControlOperator {
	public void exec() {
		State.getInstance().controlMemoryRecall();
	}
}
