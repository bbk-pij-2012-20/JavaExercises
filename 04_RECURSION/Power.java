// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/recursion
// Exercise 5.5 (Recursion, recursion vs iteration).  Difficulty level: medium

/*
Create a class with a static method pow that takes to integers (base and exponent) and 
calculates the power, e.g. pow(2,3) calculates 8.
Is it easy to do this both iteratively and recursively?
*/

//noticed that when the output is higher than some value around 1 billion, the output becomes negative (?)
public class Power {

	public static void main(String[] args) {
	
		Power p = new Power();
		System.out.println("enter base (whole number)");
		int base = Integer.parseInt(System.console().readLine());
		System.out.println("enter exponent (whole positive number)");
		int exponent = Integer.parseInt(System.console().readLine());
		System.out.println("result using iteration: " + p.pow(base, exponent));
		System.out.println("result using recursion: " + p.powRec(base, exponent));
		
	}	

// using iteration
	public int pow(int base, int exponent) {
	
		int result = 1;

		while (exponent > 0) {

			result *= base;
			exponent--;
		
		}
	
		return result;
		
	}
	
	public int powRec(int base, int exponent) {
				
		if (exponent == 1) {
		
			return base;
		
		}
		
		return base * powRec(base, exponent - 1); 
									
	}

}