
public class Int {
	private int value;

	public Int() {
		
	}
	
	public Int(int val) {
		setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public String toString() {
		return String.valueOf(getValue());
	}
}
