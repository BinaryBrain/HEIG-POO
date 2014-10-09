
public class Int {
	private int value;

	public Int() {
		value = 0;
	}
	
	public Int(int val) {
		value = val;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public String toString() {
		return String.valueOf(value);
	}
	
	public void swapValueWith(Int i) {
		int temp = value;
		setValue(i.getValue());
		i.setValue(temp);
	}
}
