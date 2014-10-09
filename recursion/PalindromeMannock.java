//cd desktop/JavaCoding/JavaExNoGIT/d5Ex_noGIT

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
/* check for first and last char of String, if they are 
same then do the same thing for a substring with first and 
last char removed. and carry on this until you string 
completes or condition fails*/

		return s.charAt(0)==s.charAt(s.length()-1)&&isPalindrome(s.substring(1,s.length()-1));
	}
}