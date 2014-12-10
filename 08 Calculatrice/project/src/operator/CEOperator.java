package operator;
import main.State;

public class CEOperator extends ControlOperator {
	public void exec() {
		State.getInstance().controlClearError();
	}
}
