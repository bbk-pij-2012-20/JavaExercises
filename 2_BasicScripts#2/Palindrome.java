//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/BasicScripts#2
// Exercise 3.8 (Learning the basics). Using iteration. (Recursive solution also shown here).

/*
A palindrome is a word, phrase, number, or other sequence of units that may be read 
the same way in either direction. Examples of strict palindromes include “ABBA”, 
“madam”, “radar”, “kayak”, and “step on no pets”.
Write a program that reads a text and detects whether the text is a strict palindrome.
*/

public class Palindrome {

	public static void main(String[] args) {

		System.out.println("Input some text (palindromic or not): ");
		String input = System.console().readLine().toLowerCase().trim();
		
		boolean palindromic = true;
		int i = 0;
		
		while (i <= input.length() / 2 && palindromic) {

			if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {

				palindromic = false;

			} else {
			
				i++;
				
			}
					
		} 

		System.out.printf("The text '%s' is %spalindromic\n", input, palindromic? "" : "not ");
//		System.out.printf("The text '%s' is %spalindromic\n", input, isPalindromic(input)? "" : "not ");	
	
	}

/*	
//	Recursive solution:

	public static boolean isPalindromic(String input) {
	
		if (input.length() == 0 || input.length() == 1) {
		
			return true;
		
		}
		
		return input.charAt(0) == input.charAt(input.length() - 1) 
		  && isPalindromic(input.substring(1,input.length()-1));	
	
	} */
		
}