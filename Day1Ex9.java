public class Day1Ex9 // "Going up!"
{
	public static void main(String args[])
	{
		boolean up=true;
		System.out.println("Enter positive number");
		int next=Integer.parseInt(System.console().readLine());
		int current=0;
		boolean first=true;
		
		if(first)
		{
			current=next-1;
			first=false;
		}
		while(next!=-1)
		{
			if(next-current!=1)
			{
				up=false;
			}
			else
			{
				current=next;
			}
			System.out.println("Enter positive numbers, end with -1: ");
			next=Integer.parseInt(System.console().readLine());	
		}	
		System.out.printf("The numbers are %sincreasing by 1\n",up?"":"not ");
	}
}