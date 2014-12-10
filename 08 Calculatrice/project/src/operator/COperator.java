package operator;
import main.State;

public class COperator extends ControlOperator {
	public void exec() {
		State.getInstance().controlClear();
	}
}
