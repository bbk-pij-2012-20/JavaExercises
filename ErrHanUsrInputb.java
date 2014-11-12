//cd ~/Desktop/JavaCoding/JavaExercises
/* Day 15 Ex3b*/

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
			System.out.println("enter input ("+numbers+" in total)");
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