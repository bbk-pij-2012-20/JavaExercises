//cd ~/Desktop/JavaCoding/JavaExercises
/* Day 15 Ex3a */
//import java.lang.Exception;
//import java.lang.NullPointerException;

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
				System.out.println("number format exception at line 13");
				e.printStackTrace();
				continue;
			}	catch (Exception e) {
				System.out.println("some exception other than NullPointerException");
				e.printStackTrace();
			}
			counter++;
		} while (counter<10);
	}
}