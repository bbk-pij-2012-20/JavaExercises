public class Day1Ex4 // Prime numbers
{
	public static void main(String[] args)
	{
		System.out.println("enter number > 0");
		String input=System.console().readLine();
		int n=Integer.parseInt(input);
		int i;
		i=n-1;

		boolean prime=true;

		while(i>1&&prime)
		{
			if(n%i==0)
			{
				prime=false;
			}
			else
			{
				i--;
			}
		}
		System.out.printf("You number's %sa prime number\n",prime?"":"not ");
	}
}	