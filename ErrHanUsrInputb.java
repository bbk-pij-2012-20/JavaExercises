//cd ~/Desktop/JavaCoding/JavaExercises
/* Day 15 Ex3b*/
//import java.lang.Exception;
//import java.lang.NullPointerException;

public class ErrHanUsrInputb {
	public static void main(String[] args) {
		int numbers = 0;
		int input = 0;
		int counter = 0;
		
		System.out.println("how many numbers you gonna input?");
		
		do {
			numbers = parser_ExHandler(System.console().readLine());
		} while (numbers == 0);

		do {
			System.out.println("enter number ("+numbers+" in total)");
			input = parser_ExHandler(System.console().readLine());
			counter++;
		} while (counter<numbers);
	}
	
	public static int parser_ExHandler(String input) {
		int n = 0;
		try {
			n = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("number format exception");
			e.printStackTrace();
//			continue;
		}	catch (Exception e) {
			System.out.println("some exception other than NullPointerException");
			e.printStackTrace();
		}
		return n;
	}
}