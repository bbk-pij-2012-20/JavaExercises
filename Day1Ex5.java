public class Day1Ex5 //Multiplication
{
	public static void main(String[] args)
	{
		System.out.println("enter two positive numbers");
		int n1=Integer.parseInt(System.console().readLine());
		int n2=Integer.parseInt(System.console().readLine());
		int result=0;
		if(n1>n2)
		{
			for(int i=0;i<n2;i++)
			{
				result+=n1;
			}
		}
		else
		{
			for(int i=0;i<n1;i++)
			{
				result+=n2;
			}
		}
		System.out.println(n1+" x "+n2+" = "+result);
	}
}