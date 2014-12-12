// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/recursion
// Exercise 5.2a (Recursion, recursion vs iteration).
/* 
Write a small program with a method that calculates the factorial of an integer number as 
seen in the notes. Is it easy to do this both iteratively and recursively? 
Try both ways and see which is more natural for you. 
If one takes too long, try the other way.

Factorial of a number is: for example 4!=4X3X2X1
Factorial of 0 or less is not possible.
*/

// ITERATIVELY:
/* 
public class Recursive {

	public static void main(String[] args) {
	
		System.out.println("input a whole, positive number");
		String input = System.console().readLine();
		int number = Integer.parseInt(input);	
		int result = number;
	
		for(int i = (number - 1); i > 0; i--) {
		
			result *= i; 
		
		}
		
		System.out.printf(number + "! = %s\n", result);	
	
	}
*/

// RECURSIVELY:
public class Recursive {

	public static void main(String[] args) {
	
		System.out.println("input a whole, positive number");
		String input = System.console().readLine();
		int number = Integer.parseInt(input);
					
		int result = getFactorial(number);
		System.out.printf(number + "! = %s\n", result);
	
	}

	public static int getFactorial(int n) {
	
		if(n <= 0) {
		
			System.out.println("no factorial of negative nos.");
			return 0;
		
		}
		
		if (n == 1) {
			
			return n;
		
		} else {
			
			return n * getFactorial(n - 1);
		
		}
	
	}

}