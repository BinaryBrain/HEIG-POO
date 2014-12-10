package operator;
import main.State;

public class SignOperator extends NumberOperator {

	public void execute() {
		State.getInstance().inverseSign();
	}
}
