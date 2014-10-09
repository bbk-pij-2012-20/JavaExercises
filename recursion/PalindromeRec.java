//cd desktop/JavaCoding/JavaExNoGIT/d5Ex_noGIT

public class PalindromeRec
{
	public static void main(String args[])
	{
		PalindromeRec pr=new PalindromeRec();
		System.out.println("Enter word");
		String input=System.console().readLine();
		System.out.printf("The word is %spalindromic\n",pr.isPalindrome(input)?"":"not ");
	}
	public boolean isPalindrome(String str)
	{
		if(str.length()==0||str.length()==1)
		{
			return true;
		}
		else
		{
			return str.charAt(0)==str.charAt(str.length()-1)&&isPalindrome(str.substring(1,str.length()-1));
		}
	}
}
/* iterative 
class Palindrome
{
	public static void main(String args[])
	{
		Palindrome p=new Palindrome();
		System.out.println("Enter word");
		String input=System.console().readLine();
		p.isPalindrome(input);
		System.out.printf("The word is %spalindromic\n",palindrome?"":"not ");
	}
	public boolean isPalindrome(String str)
	{
		int i=0;
		boolean palindrome=true;
		while(palindrome&&i<(str.length()/2))
		{
			if(str.charAt(i)==str.charAt(str.length()-(i+1)))
			{
				i++;
			}
			else
			{
				palindrome=false;
			}
		}
	}
}
*/