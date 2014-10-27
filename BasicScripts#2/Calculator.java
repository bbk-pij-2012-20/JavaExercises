//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/BasicScripts#2
// Exercise 3.1 (Learning the basics. Beginning to encapsulate in classes & methods)

/*
Write a program that reads two numbers from the user and then offers a menu with 
the four basic operations: addition, subtraction, multiplication, and division. 
Once the user has selected an operation from the menu, the calculator performs 
the operation.
*/

public class Calculator {

	public static void main(String args[]) {
	
		int result = 0;
		System.out.println("Enter 2 numbers");
		String input = System.console().readLine();
		int n1 = Integer.parseInt(input);
		input = System.console().readLine();
		int n2 = Integer.parseInt(input);
		System.out.println("(A)dd,(S)ubtract,(D)ivide,(M)ultiply");
		input = (System.console().readLine()).toUpperCase();

		switch (input) {
		
			case "A" : System.out.println(add(n1, n2)); break; 
			case "S" : System.out.println(subtract(n1, n2)); break; 		
			case "M" : System.out.println(multiply(n1, n2)); break;
			case "D" : System.out.println(divide(n1, n2)); break;
			default : System.out.println("invalid"); break;			
		
		}
	}
	
	public static int add(int num1, int num2) {
	
		return num1 + num2;
	
	}
	
	public static int subtract(int num1, int num2) {
	
		return num1 - num2;
	
	}
	
	public static int multiply(int num1,int num2) {
	
		return num1 * num2;
	
	}
	
	public static double divide(int num1, int num2) {
	
		double d1 = (double) num1; 
		double d2 = (double) num2;
		return d1 / d2;
	
	}

}