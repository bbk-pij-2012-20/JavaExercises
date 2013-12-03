//cd desktop/JavaCoding/JavaExercises
/* Day 3 Ex8 - Palindrome
A palindrome is a word, phrase, number, or other sequence 
of units that may be read the same way in either direction. 
Examples of strict palindromes include “ABBA”, “madam”, 
“radar”, “kayak”, and “step on no pets”. Write a program 
that reads a text and detects whether the text is a strict 
palindrome. */

public class Palindrome
{
	public static void main(String args[])
	{
		System.out.println("enter text");
		String input=System.console().readLine();
		boolean palindromic=true;
		int i=0;
//		0123 length 4  4/2=2 0,1
//		abba
		while(palindromic&&i<input.length()/2)
		{
			if(input.charAt(i)==input.charAt(input.length()-(i+1)))
			{
				i++;
			}
			else
			{
				palindromic=false;
			}
		}
		System.out.printf("The string entered is %spalindromic\n",palindromic?"":"not ");
	}
}