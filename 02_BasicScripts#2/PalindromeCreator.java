// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/BasicScripts#2
// Exercise 3.9 (Learning the basics). 
/*Write a program that reads a text and then writes on the screen a 
palindrome by writing the same text followed by the same text in 
reversed order. For example, if the user enters the text “It was a 
dark and stormy night” the program must output “It was a dark and 
stormy nightthgin ymrots dna krad a saw tI”.*/

public class PalindromeCreator {

	public static void main(String[] args) {

		System.out.println("Input some text: ");
		String input = System.console().readLine().trim();
		StringBuilder sb = new StringBuilder();
		sb.append(input);
		int i = input.length() - 1;
		
		while (i >= 0) {

			sb.append(input.charAt(i));
			i--;

		} 

		System.out.println("Output: " + sb);

	}
		
}