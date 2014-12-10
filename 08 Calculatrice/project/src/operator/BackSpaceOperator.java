package operator;
import main.State;

public class BackSpaceOperator extends ControlOperator {
	public void exec() {
		State.getInstance().controlBackSpace();
	}
}
