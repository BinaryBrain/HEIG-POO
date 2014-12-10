package operator;
import main.State;

public class CEOperator extends ControlOperator {
	void exec() {
		State.getInstance().controlClearError();
	}
}
