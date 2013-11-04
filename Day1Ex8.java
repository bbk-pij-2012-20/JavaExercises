public class Day1Ex8
{
	public static void main(String args[])
	{
		int highest=0, number;
		do
		{
			System.out.println("enter positive number, end with -1 ");
			number=Integer.parseInt(System.console().readLine());
			if(number>highest)
			{
				highest=number;
			}	
		}
		while(number!=-1);
		System.out.printf("The highest number was %d\n",highest);
	}
}