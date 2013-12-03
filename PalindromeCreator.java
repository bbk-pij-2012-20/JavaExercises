// cd desktop/JavaCoding/JavaExercises

/* Day 3 Ex9 - Palindrome creator
Write a program that reads a text and then writes on the 
screen a palindrome by writing the same text followed by 
the same text in reversed order. For example, if the user 
enters the text “It was a dark and stormy night” the 
program must output 
“It was a dark and stormy nightthgin ymrots dna krad a saw tI”.
*/

public class PalindromeCreator
{
	public static void main(String args[])
	{
		System.out.println("enter text");
		String input=System.console().readLine();
		String output=input;
		for(int i=0;i<input.length();i++)
		{
			output+=input.charAt(input.length()-(i+1));
		}
		System.out.println(output);
	}
}