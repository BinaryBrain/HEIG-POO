package operator;
import main.State;

public class EnterOperator extends ControlOperator {
	public void execute() {
		State.getInstance().controlEnter();
	}
}
