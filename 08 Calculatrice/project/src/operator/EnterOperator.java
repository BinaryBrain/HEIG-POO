package operator;
import main.State;

public class EnterOperator extends ControlOperator {
	public void exec() {
		State.getInstance().controlEnter();
	}
}
