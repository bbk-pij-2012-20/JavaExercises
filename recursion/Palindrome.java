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

/*
public class PalindromeRec {

	public static void main(String args[]) {
	
		PalindromeRec pr = new PalindromeRec();
		System.out.println("Enter word");
		String input = System.console().readLine();
		System.out.printf("The word is %spalindromic\n", pr.isPalindrome(input)? "" : "not ");
	}
	
	public boolean isPalindrome(String str) {
	
		if (str.length() == 0 || str.length() == 1) {
		
			return true;
		
		} else {
		
			return str.charAt(0) == str.charAt(str.length() - 1) && isPalindrome(str.substring(1, str.length() - 1));
		
		}
	
	}
}
/* iterative 
class Palindrome {

	public static void main(String args[]) {
	
		Palindrome p = new Palindrome();
		System.out.println("Enter word");
		String input = System.console().readLine();
		p.isPalindrome(input);
		System.out.printf("The word is %spalindromic\n", palindrome? "" : "not ");
	
	}
	
	public boolean isPalindrome(String str) {
	
		int i = 0;
		boolean palindrome = true;
		
		while (palindrome && i < (str.length() / 2)) {
			
			if (str.charAt(i) == str.charAt(str.length() - (i + 1))) {
			
				i++;
			
			} else {
				
				palindrome = false;
			
			}
	
		}

	}

}
*/
/*
//@author KJ Mannock

public class PalindromeMannock
{
	public static void main(String[] args)
	{
		System.out.println(isPalindrome("noon"));
		System.out.println(isPalindrome("A Toyota"));
		System.out.println(isPalindrome("Not a Palindrome"));
		System.out.println(isPalindrome("asdfghfdsa"));
		System.out.println(isPalindrome("abba"));
		System.out.println(isPalindrome("asdfghgfdsa"));
	}
	public static boolean isPalindrome(String s)
	{
		if(s.length()==0||s.length()==1)
		{
			return true;
		}
		
		return s.charAt(0)==s.charAt(s.length()-1)&&isPalindrome(s.substring(1,s.length()-1));
	}
}
*/
