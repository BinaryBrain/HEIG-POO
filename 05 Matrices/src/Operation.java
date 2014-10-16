
public abstract class Operation {
	public Matrix executeOperation(Matrix a, Matrix b) {
		int size = a.getSize();
		Matrix result = new Matrix(size);
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				result.setElement(i, j, execute(a.getElement(i, j), b.getElement(i, j)));
			}
		}
		
		return result;
	}
	
	public abstract boolean execute(boolean a, boolean b);
}
