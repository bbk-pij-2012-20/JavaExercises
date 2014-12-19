// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/Arrays
// Exercise 6.2 (Arrays)
/* 
Create a new Java class called ArrayCopier with a method called copy that takes two 
arrays of integers as parameters. 
The method should copy the elements of the 1st array (call it src) to the 
2nd one (dst, from “destination”) as much as possible.
If the second array is smaller, then only those elements that fit will be copied. 
If the second array is larger, it will be filled with zeroes.

Write a program that creates an object of this class and uses this method to copy 
some arrays in all three cases: 
• Both arrays are of the same size.
• The source array is longer.
• The source array is shorter.
*/

import java.util.Arrays;

public class ArrayCopier {

	public static void main(String args[]) {
	
		int[] a1 = {12,24,567,89,23};					// 5 ints
		int[] a2 = {2,8,3};								// 3 ints
		int[] a3 = {34,676,23,56,78,233,56,7,34,56,7};	// 11 ints
		int[] a4 = {3,4,8,2,6};							// 5 ints
		
		ArrayCopier ac = new ArrayCopier();

		ac.printArrays("a1", a1);
		ac.printArrays("a2", a2);
//		ac.printArrays("a3", a3);
//		ac.printArrays("a4", a4);
		
		ac.printResults("a1", "a2", ac.copy(a1,a2));							
		ac.printArrays("a1", a1);
		ac.printArrays("a2", a2);

//		ac.printResults("a2", "a3", ac.copy(a2,a3));
//		ac.printResults("a1", "a4", ac.copy(a1,a4));
//		ac.printResults("a3", "a1", ac.copy(a3,a1));	
//		ac.printResults("a1", "a3", ac.copy(a1,a3));	

	}
	
/*
	v.important note of caution: 
	The formal parameter dst will be pointing at the actual parameter object (e.g. a2) 
	so that any changes made to dst INSIDE the method body will also be performed on the 
	actual parameter, so will persist, which is not what I want to do here. I wanted a 
	new int array which has the result of the copy return without altering the original
	arrays. To achieve the latter, I would either have to instantiate a new array of the 
	same size and the iterate through it and the source array, copying the value at each
	index into the new array in a for loop, or use java.util.Arrays method copyOf().
*/
		public int[] copy(int[] src, int[] dst) {
	
/*	
	v.important point here too. This does not simply assign the values of the parameter array to the new ly
	created one. There remains now a pointer from the new one to the original such that any changes to the new one
	will be done to the old one too!!  
	
		int[] dst2 = new int[dst.length];
		dst2 = dst; 
*/		

/*	so I could use java.util.Arrays' copyOf() method which is basically what we're being 
	asked to implement here:

		int[] dst2 = Arrays.copyOf(dst, dst.length);

	or the following for-loop
*/
		
		int[] dst2 = new int[dst.length];
		
		for (int i = 0; i < dst2.length; i++) {
		
			dst2[i] = dst[i];
		
		}
			
		for (int i = 0; i < dst2.length; i++) {
		
			if (i >= src.length) {
	
				dst2[i] = 0;
			
			} else {
			
				dst2[i] = src[i];
			
			}
		
		}
		
		return dst2;
	
	}
	
	//print arrays before adding
	public void printArrays(String aryStr, int[] aray) {

		System.out.println("");
		System.out.print(aryStr + ": ");
		int lengthMinus1 = aray.length - 1;
		
		for (int i = 0; i < lengthMinus1; i++) { 
		
			System.out.print(aray[i] + ", "); 
		
		}
		
		System.out.print(aray[lengthMinus1] + ".");
		System.out.println("");

	}
	
	//print dst arrays after adding
	public void printResults(String srcs, String dsts, int[] dst) {
	
		System.out.println("\nCopied " + srcs + " (src) to " + dsts + "(dst)");
		System.out.println("Result array " + dsts + ": ");
		int lengthMinus1 = dst.length - 1;

		for (int i = 0; i < lengthMinus1; i++) { 
		
			System.out.print(dst[i] + ", ");	
		
		}
		
		System.out.print(dst[lengthMinus1] + ".");
		System.out.println("");
		
	}
	
}