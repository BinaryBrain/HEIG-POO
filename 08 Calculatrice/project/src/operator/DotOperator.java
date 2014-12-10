package operator;
import main.State;

public class DotOperator extends NumberOperator {

	public void execute() {
		State.getInstance().addDot();
	}
}
