/* 
This exercise is to write a small program that 
calculates the nth element of the Fibonacci sequence.
Fibonacci is sum of any number -1 and -2. So, Fib(4)=(4-1)+(4-2)=5.
However the Fib for 1 or less is always just 1. 
The sequence of Fibonacci numbers starts off like this: 
1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, and so on..
This is how the code looks when implemented by recursion:
*/

/*
public class Day5ex2b
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
*/

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
/* 
Memoization is a technique whereby we keep track of the values already
calculated in an array.

// arrays are 0-based, so F(1) is stored at position 0, etc
public class Day5ex2b
{
	public static void main(String[] args)
	{
		private int[] precalculated=null;
		
		public int fib(int n) 
		{
			if(precalculated==null) 
			{
				precalculated=new int[n];
				for(int i=0;i<precalculated.length;i++)
				{
					precalculated[i]=-1; 
					// to indicate "not calculated yet" 
				}
			}
			if((n==1)||(n==2))
			{
          		return 1;
        	} 
        	else 
        	{
				if(precalculated[n-1]!=-1)
				{
					return precalculated[n-1];
				}
				else
				{
					int result=fib(n-1)+fib(n-2); 
					precalculated[n-1]=result; 
					return result;
				} 
			}
		}
	}
}
		// ...additional code would go here...

