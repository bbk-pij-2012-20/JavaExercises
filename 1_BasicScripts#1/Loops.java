// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/BasicScripts

// Exercise 1.3 (learning the basics)
// What does the following piece of code do?

public class Loops {
	
	public static void main(String[] args) {

		System.out.println("enter number");	
		String str = System.console().readLine();
		int i = Integer.parseInt(str);
	
		while (i < 10) {
		
			i++;
			System.out.println("enter another number");
			str = System.console().readLine();
			int j = Integer.parseInt(str);
			
			if (j == 0) {
			
				break; // break exits the if block, but also the while loop

			} else if (j != 1) {

				System.out.println(j);
		
			}
		
		}

		System.out.println("finished");
	}
	
}