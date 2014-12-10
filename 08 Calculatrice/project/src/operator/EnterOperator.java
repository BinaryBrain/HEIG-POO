package operator;
import main.State;

public class EnterOperator extends ControlOperator {
	void exec() {
		State.getInstance().controlEnter();
	}
}
