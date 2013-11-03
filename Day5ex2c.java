/* This exercise is to calculate the number of moves necessary to move 
a set of n Hanoi disks from the initial post to the last post. 
Hint: if you want to play monk yourself in order to better understand 
the problem, ask the lecturer for a “Hanoi envelope”.:
*/
public class Day5ex2c
{
	public static void main(String[] args)
	{
		System.out.println("Which nth Fibonacci number do you want?");
		String input=System.console().readLine();
		int number=Integer.parseInt(input);
					
		int result=getNthFibonacci(number);
		System.out.printf(number+"th Fibonacci= %s\n",result);
	}

	public static int getNthFibonacci(int n)
	{
		if(n<1)
		{
			System.out.println("no Fibonacci of negative nos.");
			return 0;
		}
		if(n==1||n==2)
		{
			return 1;
		}
		else 
		{
			return getNthFibonacci(n-1)+getNthFibonacci(n-2);
		}
	}
}
/*

Try to write Iteratively and/or recursively.


// ITERATIVELY:
/* 
public class Day5ex2b
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
}
*/


