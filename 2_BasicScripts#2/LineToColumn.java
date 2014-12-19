//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/BasicScripts#2
// Exercise 3.4 (Learning the basics. Beginning to encapsulate in classes & methods)

/*
Write a program that reads some text from the user and then writes the same text 
on screen, but each letter on a different line. Now modify your program to write 
each word (as defined by spaces) rather than letter on a different line.
*/

public class LineToColumn {

	public static void main(String args[]) {
	
		System.out.println("enter some text");
		String input = System.console().readLine();
		
/*
		for (int i = 0; i < input.length(); i++) {
		
			System.out.println("character at: " + (i + 1) + " is " + input.charAt(i));
		
		} 
*/
		
		String[] inputSplit = input.split(" ");
		
		for (int i = 0; i < inputSplit.length; i++) {
		
			System.out.println(inputSplit[i]);
		
		}

	}
}