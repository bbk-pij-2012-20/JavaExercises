// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/BasicScripts

// Exercise 1.4 (learning the basics)
// Write a program that asks a number from the user, then says whether the number is prime or not.

public class PrimeNums {

	public static void main(String[] args) {
	
		System.out.println("enter number > 0");
		String input = System.console().readLine();
		int n = Integer.parseInt(input);
		int i;
		i = n - 1;

		boolean prime = true;

		while (i > 1 && prime) {
			
			if (n % i == 0) {
			
				prime = false;
			
			} else {
				
				i--;
			
			}
		}
	
		System.out.printf("You number's %sa prime number\n", prime? "" : "not ");

	}

}	