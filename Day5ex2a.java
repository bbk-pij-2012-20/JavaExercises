/* Exercise is to write a small program that 
calculates the factorial of an integer.
We should try this both iteratively and recursively.
Factorial of a number is: for example 4!=4X3X2X1
Factorial of 0 or less is not possible.
*/
// ITERATIVELY:
/* 
public class Day5ex2a
{
	public static void main(String[] args)
	{
		System.out.println("input a whole, positive number");
		String input=System.console().readLine();
		int number=Integer.parseInt(input);	
		int result=number;
	
		for(int i=(number-1);i>0;i--)
		{
			result*=i; 
		}
		System.out.printf(number+"! = %s\n",result);	
	}
*/

// RECURSIVELY:
public class Day5ex2a
{
	public static void main(String[] args)
	{
		System.out.println("input a whole, positive number");
		String input=System.console().readLine();
		int number=Integer.parseInt(input);
					
		int result=getFactorial(number);
		System.out.printf(number+"! = %s\n",result);
	}

	public static int getFactorial(int n)
	{
		if(n<=0)
		{
			System.out.println("no factorial of negative nos.");
			return 0;
		}
		if(n==1)
		{
			return n;
		}
		else 
		{
			return n*getFactorial(n-1);
		}
	}
}
