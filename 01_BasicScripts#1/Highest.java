// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/BasicScripts
// Exercise 1.8 (learning the basics)

/*
Write a program that read a (arbitrarily long) sequence of positive numbers.
The sequence is ended when the users enters “-1”. At that point, the program
must output the highest number in the sequence.
*/

public class Highest {

	public static void main(String args[]) {
	
		int highest = 0, number = 0;
		
		do {
		
			System.out.println("enter positive number, end with -1 ");
			number = Integer.parseInt(System.console().readLine());
			
			if (number > highest) {
				
				highest = number;
			
			}	
	
		} while (number != -1);
		
		System.out.printf("The highest number was %d\n", highest);
	
	}

}