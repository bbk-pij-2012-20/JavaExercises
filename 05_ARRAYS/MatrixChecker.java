// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/05_ARRAYS
// Exercise 6.5 (Arrays)
/*
Make a class MatrixChecker with three methods:

• isSymmetrical(int[]) takes an array of int and returns true if the array is symmetrical and false otherwise.
An array is symetrical if the element at [0] is the same as the element at [length-1], the element at [1] is the
same as the element at [length-2], etc.

• isSymmetrical(int[][]) takes an bidimensional array of int and returns true if the matrix is symmetrical
and false otherwise. An matrix is symmetrical if m[i][j] == m[j][i] for any value of i and j.

• isTriangular(int[][]) takes an bidimensional array of int and returns true if the matrix is triangular§
and false otherwise. An matrix is triangular if m[i][j] == 0 for any value of i that is greater than j.
Add some methods to your Matrix class from the other exercise to perform tests on the matrices you create
using the methods from MatrixChecker. 
(Hint: these methods will need to create objects of type MatrixChecker).

(§ matrix can be up-triangular or low–triangular, but just checking one of the two is fine for this exercise.)

*/

import java.util.Arrays;

public class MatrixChecker {
	
	public static void main(String[] args) {

		MatrixChecker mc = new MatrixChecker();
		int[] symmetricArray = {4,3,3,2,1,0,1,2,3,3,4};
		int[] aSymmetricArray = {4,3,3,2,1,0,1,2,3,3};
		System.out.printf("\"symmetricArray\" is %ssymmetric.\n", mc.isSymmetrical(symmetricArray)? "" : "not ");
		System.out.printf("\"aSymmetricArray\" is %ssymmetric.\n", mc.isSymmetrical(aSymmetricArray)? "" : "not ");

		MatrixPlusSetMatrix m = new MatrixPlusSetMatrix(4, 4);

		m.setMatrix("6,11,200,0; 11,8,52,1; 2,52,20,5; 0,1,5,12");
		System.out.printf("symmetric matrix is %ssymmetric.\n", mc.isSymmetrical(m.getMatrix())? "" : "not ");
		m.setMatrix("11,200,0,6;11,8,52,1;200,52,20,5;0,1,5,12");
		System.out.printf("asymmetric matrix is %ssymmetric.\n", mc.isSymmetrical(m.getMatrix())? "" : "not ");

		m.setMatrix("6,11,200,9;0,8,52,1;0,0,20,5;0,0,0,12");
		System.out.printf("triangular matrix is %striangular.\n", mc.isTriangular(m.getMatrix())? "" : "not ");
		m.setMatrix("6,11,200,9;0,8,52,1;0,0,20,5;0,0,10000,12");
		System.out.printf("non-triangular matrix is %striangular.\n", mc.isTriangular(m.getMatrix())? "" : "not ");
				
	}
		
	public MatrixChecker() {}
	
   /**
	* Determines if an array is symmetrical (i.e. palindromic). 
	*
	* @param array		the array to be checked
	* @return			true if the array given is symmetrical			
	*/
	public boolean isSymmetrical(int[] array) {

		int length = array.length;
		
		if (length < 2) {
		
			return true;
		
		}

		return array[0] == array[length - 1] && isSymmetrical(Arrays.copyOfRange(array, 1, length - 1));
		
	}

   /**
	* Determines if an array is symmetrical (i.e. if value at i,j is same as value at j,i). 
	*
	* @param matrix		the 2D array to be checked
	* @return			true if the array given is symmetrical
	*/	
	public boolean isSymmetrical(int[][] matrix) {
	
		boolean symmetric = true;
		
		int i = 0;
		int j = 0;
		
		while (i < matrix.length && symmetric) {
		
			while (j < matrix[0].length) {
				
				symmetric = symmetric && matrix[i][j] == matrix[j][i];
				j++;
				
			}
			
			j = 0;
			i++;
		
		}
		
		return symmetric;
		
	}
	
   /**
	* Determines if an array is triangular (i.e. if i > j, value at i,j is zero). 
	*
	* @param matrix		the 2D array to be checked
	* @return			true if the array given is triangular	
	*/
	public boolean isTriangular(int[][] matrix) {
	
		boolean triangular = true;
		
		int i = 0;
		int j = 0;

		while (i < matrix.length && triangular) {
		
			while (j < matrix[0].length) {
			 
			 	if (i > j) {

					triangular = triangular && matrix[i][j] == 0;
			 	
			 	}
			 	j++;
				
			}
			
			j = 0;
			i++;
			
		}
				
		return triangular;
		
	}
}