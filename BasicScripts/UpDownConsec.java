//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/BasicScripts
// Exercise 1.9 (learning the basics)

/*
Modify your former program so that it outputs ”Yes” when the numbers are
consecutive, regardless of whether they go up or down. For example, both
”2,3,4,5,6,-1” and ”10,9,8,7,-1” should now result in ”Yes”.
*/

public class UpDownConsec {

	public static void main(String[] args) {
	
		boolean first = true, second = true, consecutive = true;
		int stepSize = 0, previous = 0, input = 0;
	
		do {

			System.out.println("enter numbers, press enter after each, end with -1: ");
			input = Integer.parseInt(System.console().readLine());
			
			if (first) {
			
				previous = input;
				first = false;
			
			} else if (second) {
			
				stepSize = input - previous;
				previous = input;
				second = false;
			
			} else if (input != -1) {
				
				consecutive = consecutive && (input == previous + stepSize) 
				               && Math.abs(stepSize) == 1;
				previous = input;
				
			}
			
		} while (input != -1);
		
		System.out.printf("your numbers were %sconsecutive \n",consecutive? "" : "not ");
	
	}


}