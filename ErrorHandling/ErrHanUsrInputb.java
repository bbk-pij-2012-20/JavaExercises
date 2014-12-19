// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/ErrorHandling
// Exercise 15.3b: Introduction to Error handling
/* 
Modify the program so that it first asks how many numbers the user wants to enter, and 
then asks for the numbers. The computer should complain if the user enters something 
that is not a number in both cases. Use methods to prevent code repetitions.
*/
public class ErrHanUsrInputb {

	private static int counter = -1; //added static member counter

	public static void main(String[] args) {

		int numbers = 0;
		int input = 0;
//		int counter = 0; //removed local counter
		
		do {
			
			System.out.println("how many numbers you gonna input?");
			numbers = parser_ExHandler(System.console().readLine());
		
		} while (numbers == 0);

		do {
	
			System.out.println("enter input (" + numbers + " in total)");
			input = parser_ExHandler(System.console().readLine());		
//			counter++; // removed counter increment
	
		} while (counter < numbers);

	}
	
	public static int parser_ExHandler(String input) {
	
		int n = 0;
		
		try {
		
			n = Integer.parseInt(input);
		
		} catch (NumberFormatException e) {
		
			System.out.println("number format exception");
			e.printStackTrace();
			counter--; // added decrement counter
//			continue;  // removed continue
	
		}	catch (Exception e) {
			
			System.out.println("some exception other than NullPointerException");
			e.printStackTrace();
	
		}
	
		counter++; //added increment counter
		return n;
	
	}

}