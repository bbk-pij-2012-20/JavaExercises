// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/05_ARRAYS
// Exercise 6.4 (Arrays)
/*
Extend your Matrix class with a method setMatrix(String) that takes a String representing the numbers to be
put in the elements of the array separated by commas, separating rows by semicolons, e.g. 1,2,3;4,5,6;7,8,9.
*/
//btw: as we hadn't yet begun on Inheritance, 'extend' here is used simply to mean add another method to the same class. 

public class MatrixPlusSetMatrix {

	private int[][] matrix = null;
	
	public static void main(String[] args) {
	
		//4 rows by 3 columns:
		MatrixPlusSetMatrix m = new MatrixPlusSetMatrix(3, 4);
			
		System.out.println("matrix with default values: " + m);
		System.out.println("matrix with default values (prettyPrint): ");
		m.prettyPrint();
		
		//4 columns:
		m.setElement(0,0,10); 	
		m.setElement(0,1,11);	
		m.setElement(0,2,12);
		m.setElement(0,3,13);
				
		m.setElement(1,0,14);	
		m.setElement(1,1,15);	
		m.setElement(1,2,16);
		m.setElement(1,3,17);		
		
		//3 rows:
		m.setElement(2,0,18);	
		m.setElement(2,1,19);	
		m.setElement(2,2,20);
		m.setElement(2,3,21);		
		
		System.out.println("matrix after initial values inserted: " + m);
		System.out.println("matrix after initial values inserted (prettyPrint): ");
		m.prettyPrint();
		
		m.setRow(0, "1, 2,3,4");
		System.out.println("matrix after setRow(0,\"1,2,3,4\") (prettyPrint): ");
		m.prettyPrint();
		m.setColumn(0, "100, 200,300");
		System.out.println("matrix after setColumn(0,\"100,200,300\") (prettyPrint): ");
		m.prettyPrint();
			
		m.setMatrix("1000,2000,3000,4000;5000,6000,7000,8000;9000,10000,11000,12000");
		System.out.println("matrix after setMatrix(\"1000,2000,3000,4000;5000,6000,7000,8000;9000,10000,11000,12000\") (prettyPrint): ");
		m.prettyPrint();

	}
	
	/**
	*	constructor sets size of default constructor (all values set to 1)
	*
	*	@param i			row length
	*	@param j			column length
	*/
	public MatrixPlusSetMatrix(int i, int j) {
		
		setDefaultMatrix(i, j);
			
	}
	
		
   /**
    *	resets the integers of the matrix to value passed
    *	
	*	@param matrix	the array to be passed in
	*/
	public void setMatrix(String matrix) {
	
		String[] rowPerElement = matrix.split(";");

		for (int i = 0; i < rowPerElement.length; i++) {
		
			setRow(i, rowPerElement[i]);
		
		}
	
	}
	
   /**
    *	sets the integer at matrix[i][j] to value passed
    *	
	*	@param i		row index
	*	@param j		column index
	*	@param n
	*	@throws 		IndexOutOfBoundException if isValid(i, j) is false
	*/
	public void setElement(int i, int j, int n) {
	
		try {
		
			if (!isValid(i, j)) {
			
				throw new IndexOutOfBoundsException();
			
			}
			
			matrix[i][j] = n;
		
		
		} catch (IndexOutOfBoundsException e) {
		
			e.printStackTrace();
			
		}
	
	}
	
   /**
   	*	checks the integers are within valid range
   	*	
	*	@param i		row index
	*	@param j 		column index
	*	@return			true if indices are within the dimensions of the matrix
	*/
	private boolean isValid(int i, int j) {
	
		return  i < matrix.length && j < matrix[0].length && i >= 0 && j >= 0;
	
	}
	
   /**
   	*	replaces the integers in the specified row with new values
   	*	
	*	@param i		row index
	*	@param row 		row values e.g. “1,2,3”
	*	@throws			IllegalArgumentException if an empty string is passed as row values
	*	@throws			IndexOutOfBoundsException if isValid(i, j) is false or 
	*						if the number of row values given does not match the 
	*						number of rows in matrix
	*/
	public void setRow(int i, String row) {
	
		try {
		
			if (row.length() < 1) {
			
				throw new IllegalArgumentException();
							
			}
			
			int[] rowNums = make1DArray(row);
			
			if (!isValid(i, 0) || rowNums.length != matrix[0].length) {
		
				throw new IndexOutOfBoundsException();
			
			}
			
			for (int j = 0; j < matrix[0].length; j++) {

				setElement(i, j, rowNums[j]);
	
			}	
		
		} catch (IndexOutOfBoundsException e) {
		
			e.printStackTrace();
			
		} catch (IllegalArgumentException iae) {
		
			iae.printStackTrace();
		
		}
		
	}
	
   /**
   	*	replaces the integers in the specified row with new values given
   	*	
	*	@param i		row index
	*	@param row 		row values e.g. “1,2,3”
	*/
	private int[] make1DArray(String row_ColumnStr) {
	
		String[] row_Col = row_ColumnStr.split(",");
		int[] row_Column = new int[row_Col.length];
				
		try {
			
			for (int i = 0; i < row_Column.length; i++) {
			 
				row_Column[i] = Integer.parseInt(row_Col[i].trim());
			
			}
		
		} catch (NumberFormatException nfe) {
		
			nfe.printStackTrace();
		
		}
		
		return row_Column;
		
	}
	
   /**
   	*	replaces the integers in the specified column with new values given
   	*	
	*	@param j		column index 
	*	@param column 	column values e.g. “1,2,3”
	*	@throws			IllegalArgumentException if an empty string is passed as column values
	*	@throws			IndexOutOfBoundsException if isValid() is false or 
	*						if the number of column values given does not match the 
	*						number of columns in matrix
	*/
	public void setColumn(int j, String column) {
	
		try {
		
			if (column.length() < 1) {
			
				throw new IllegalArgumentException();
			
			}
			
			int[] columnNums = make1DArray(column);
						
			if (!isValid(0, j) || columnNums.length != matrix.length) {
		
				throw new IndexOutOfBoundsException();
			
			}
			
			for (int i = 0; i < matrix.length; i++) {

				setElement(i, j, columnNums[i]);
	
			}	
		
		} catch (IndexOutOfBoundsException e) {
		
			e.printStackTrace();
			
		} catch (IllegalArgumentException iae) {
		
			iae.printStackTrace();
		
		}
		
	}
	
	@Override
	public String toString() {
	
		return "[" + toString(";", ",") + "]";
	
	}
	
   /**
   	*	converts the matrix into a readable string format
   	*	
	*	@param rowSeparation		how rows are separated
	*	@param columnSeparation 	how columns are separated
]	*/
	public String toString(String rowSeparation, String columnSeparation) {
	
		String matrixStr = "";
		
		for (int i = 0; i < matrix.length; i++) {
		
			for (int j = 0; j < matrix[0].length; j++) {
			
				matrixStr += matrix[i][j]; 
				
				if (j < matrix[0].length - 1) {
				
					matrixStr += columnSeparation;
					
				}
				
			}
		
			if (i < matrix.length - 1) {
				
				matrixStr += rowSeparation;			
			}
			
		}
		
		return matrixStr;
	
	}

   /**
   	*	prints out the matrix as tabulated format
   	*	
	*/
	public void prettyPrint() {
	
		System.out.println("\n" + toString("\n", "\t"));
	
	}
	
   /**
   	*	returns the matrix (made for MatrixChecker)
   	*	
   	*	@return	int[][]				the matrix
	*/
	public int[][] getMatrix() {
	
		return matrix;
	
	}

   /**
   	*	sets a new matrix
   	*	
   	*	@param i					row length
   	*	@param j					column length
	*/
	public void setDefaultMatrix(int i, int j) {
	
		matrix = new int[i][j];
		
		for (int n = 0; n < i; n++) {
		
			for (int m = 0; m < j; m++) {
			
				matrix[n][m] = 1;
			
			}
		
		}
	}

}