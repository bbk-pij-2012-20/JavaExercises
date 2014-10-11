// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/BasicScripts
// Exercise 1.9 (learning the basics)

/*
Read an arbitrarily long sequence of positive numbers from the user, until -1
is entered. At that point, print ”Yes” if the numbers were consecutive and
increasing and ”No” otherwise. Sequences ”1,2,3,4,-1” and ”5,6,7,8,9,10,11,-
1” should output ”Yes”, but ”2,3,5,6,7,-1”, ”10,9,8,7,-1”, and ”1,1,2,3,4,5,-1”
should output ”No”.
*/

public class UpByOne {

	public static void main(String args[]) {
	
		boolean goingUp = true;
		System.out.println("Enter positive number");
		int next = Integer.parseInt(System.console().readLine());
		int current = 0;
		boolean first = true;
		
		if (first) {
		
			current = next - 1;
			first = false;
		
		}
		
		while (next! =- 1) {
		
			if (next - current != 1) {
			
				up = false;
			
			} else {
				
				current = next;
			
			}
		
			System.out.println("Enter positive numbers, end with -1: ");
			next=Integer.parseInt(System.console().readLine());	
		
		}	
		
		System.out.printf("The numbers are %sincreasing by 1\n", up? "" : "not ");

	}
}