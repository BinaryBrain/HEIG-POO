package operator;
import main.State;

public class BackSpaceOperator extends ControlOperator {
	public void execute() {
		State.getInstance().controlBackSpace();
	}
}
