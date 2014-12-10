package operator;
import main.State;

public class COperator extends ControlOperator {
	public void execute() {
		State.getInstance().controlClear();
	}
}
