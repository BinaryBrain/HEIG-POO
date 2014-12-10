package operator;
import main.State;

public class CEOperator extends ControlOperator {
	public void execute() {
		State.getInstance().controlClearError();
	}
}
