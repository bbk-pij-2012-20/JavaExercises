// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/recursion
// Exercise 5.4 (Recursion, recursion vs iteration). Difficulty level: medium

/*
Create a program with a (recursive) method that takes a String paremeter and returns 
true if the String is a palindrome and false otherwise. Compare this recursive version 
with the iterative version you wrote in past weeks.
Which one seems clearer to you?
*/

public class Palindrome {

	public static void main(String[] args) {
	
		Palindrome p = new Palindrome();
		System.out.println("Enter a string");
		System.out.printf("The input is %spalindromic.\n", p.isPalindromic(System.console().readLine())? "" : "not ");
	
	}
	
	public boolean isPalindromic(String input) {
	
		if (input.length() < 2) {
		
			return true;
			
		}
		
		if (input.length() == 2) {
		
			return input.charAt(0) == input.charAt(1);
		
		}
		
		return input.charAt(0) == input.charAt(input.length() - 1) && isPalindromic(input.substring(1, input.length() - 1));
		
	}

}