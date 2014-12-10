package operator;
import main.State;

public class MROperator extends ControlOperator {
	public void execute() {
		State.getInstance().controlMemoryRecall();
	}
}
