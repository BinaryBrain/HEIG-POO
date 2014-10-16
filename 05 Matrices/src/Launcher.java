
public class Launcher {

	public static void main(String[] args) {
		System.out.println("Welcome to the Matrix Generator!");
		
		int size = 4;
		Matrix m1 = new Matrix(size);
		Matrix m2 = new Matrix(size);
		
		System.out.println("Matrix one\n" + m1);
		System.out.println("Matrix two\n" + m2);
		System.out.println("oneOrTwo = one or two");
		System.out.println(new Or().executeOperation(m1, m2));
		System.out.println("oneAndTwo = one and two");
		System.out.println(new And().executeOperation(m1, m2));
		System.out.println("oneXOrTwo = one xor two");
		System.out.println(new Xor().executeOperation(m1, m2));
	}

}
