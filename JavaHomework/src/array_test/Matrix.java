package array_test;

public class Matrix {
	private double[][] values;
	private int nrows, ncols;
 
	public Matrix(int nrows, int ncols) {
		this.nrows = nrows;
		this.ncols = ncols;
		this.values = new double[nrows][ncols];
	}
 
	public Matrix(double[][] values) {
		this.nrows = values.length;
		this.ncols = values[0].length;
		this.values = values;
	}
 
	public Matrix add(Matrix mat) {
		if (nrows != mat.nrows || ncols != mat.ncols) {
			return null;
		}
 
		double[][] newValues = new double[nrows][ncols];
		for (int i = 0; i < nrows; i++) {
			for (int j = 0; j < ncols; j++) {
				newValues[i][j] = values[i][j] + mat.values[i][j];
			}
		}
 
		return (new Matrix(newValues));
	}
 
        public Matrix substract(Matrix mat) {
		if (nrows != mat.nrows || ncols != mat.ncols) {
			return null;
		}
 
		double[][] newValues = new double[nrows][ncols];
		for (int i = 0; i < nrows; i++) {
			for (int j = 0; j < ncols; j++) {
				newValues[i][j] = values[i][j] - mat.values[i][j];
			}
		}
 
		return (new Matrix(newValues));
	}
 
	public Matrix multiplicate(Matrix mat) {
		if (ncols != mat.nrows) {
			return null;
		}
 
		double[][] newValues = new double[nrows][mat.ncols];
		for (int i = 0; i < nrows; i++) {
			for (int j = 0; j < mat.ncols; j++) {
				double sum = 0;
				for (int k = 0; k < ncols; k++) {
					sum += values[i][k] * mat.values[k][j];
				}
				newValues[i][j] = sum;
			}
		}
 
		return (new Matrix(newValues));
	}
 
	public Matrix transpose() {
		double[][] newValues = new double[ncols][nrows];
 
		for (int i = 0; i < nrows; i++) {
			for (int j = 0; j < ncols; j++) {
				newValues[j][i] = values[i][j]; 
			}
		}
 
		return (new Matrix(newValues)); 
	}
	public Matrix getrows(int rows) {
		double[][] arrays= new double[1][ncols];
		for (int i = 0;i<ncols;i++) {
			arrays[0][i] = values[rows][i];
		}
		return (new Matrix(arrays));
	}
	public Matrix getcols(int cols) {
		double[][] arrays= new double[nrows][1];
		for (int i = 0;i<nrows;i++) {
			arrays[i][0] = values[i][cols];
		}
		return (new Matrix(arrays));
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for ( int i=0;i<nrows;i++) {
			for(int j = 0; j<ncols;j++) {
				sb.append("\t"+values[i][j]);
			}
			sb.append("\n");
		}
		return sb.toString();
		
	}

	
	
}
	