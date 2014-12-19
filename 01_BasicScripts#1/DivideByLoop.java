// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/BasicScripts
// Exercise 1.6 (learning the basics)

/*
Write a program that requests two numbers from the user and then outputs the
quotient and the remainder, e.g. if the user enters 7 and 3, your program should
output something like “7 divided by 3 is 2, remainder 1”. You cannot use the
“/” or “%” operators.
*/

public class DivideByLoop { //dividing a "dividend" by a "divisor" to give a "quotient" and "remainder"

	public static void main(String[] args) {
	
		System.out.println("input 2 numbers, the dividend followed by the divisor:");
		int dvdnd = Integer.parseInt(System.console().readLine());	
		int dvsr = Integer.parseInt(System.console().readLine());
		boolean frctn = false;
		
		if (dvdnd < dvsr) {

			System.out.println(dvdnd + " divided by " + dvsr + " is the fraction: " + dvdnd + "/" + dvsr);
			frctn = true;

		}
		
		int qtnt = 0;
		int rmndr = dvdnd;

		while (!frctn) {
			
			if (rmndr > dvsr) {
			
				qtnt++;
				rmndr -= dvsr;
			
			} else {
				
				System.out.println(dvdnd + " divided by " + dvsr + " is " + qtnt + ", remainder " + rmndr);		
				break;
			
			}

		}

	}

}