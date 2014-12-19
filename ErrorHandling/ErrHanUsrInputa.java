// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/ErrorHandling
// Exercise 15.3a: Introduction to Error handling
/*
Write a program that reads 10 numbers from the user and then prints the mean average. 
If the user inputs something that is not a number, the program should complain and ask 
for a number again until 10 numbers have been introduced.
*/
public class ErrHanUsrInputa {

	public static void main(String[] args) {

		String str = "";
		int counter = 0;
		int[] numbers = new int[10];
		
		do {
			
			System.out.println("enter number (10 in total)");
			str = System.console().readLine();
		
			try {
		
				int n = Integer.parseInt(str);//"line 16"
		
			} catch (NumberFormatException e) {
		
				System.out.println("number format exception at line 16");
				e.printStackTrace();
				continue;
		
			}	catch (Exception e) {
		
				System.out.println("some exception other than NullPointerException");
				e.printStackTrace();
		
			}
		
			counter++;
	
		} while (counter < 10);
	
	}
}