package operator;
import main.State;

public class COperator extends ControlOperator {
	void exec() {
		State.getInstance().controlClear();
	}
}
