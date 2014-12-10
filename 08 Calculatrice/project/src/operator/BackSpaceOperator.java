package operator;
import main.State;

public class BackSpaceOperator extends ControlOperator {
	void exec() {
		State.getInstance().controlBackSpace();
	}
}
