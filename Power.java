//cd desktop/JavaCoding/JavaExercises
/*Day5 Ex5 - Power
Create a class with a static method pow that takes two integers 
(base and exponent) and calculates the power, e.g. pow(2,3) calculates 8. 
Is it easy to do this both iteratively and recursively?*/

public class Power
{
	public static void main(String args[])
	{
		System.out.println("enter base then exponent");
		String input=System.console().readLine();
		int base=Integer.parseInt(input);
		input=System.console().readLine();
		int exponent=Integer.parseInt(input);
		System.out.println("Result = "+pow(base,exponent));
	}
	//recursively
	public static int pow(int base,int exponent)
	{
		if(exponent==1)
		{
			return base;
		}
		return base*pow(base,exponent-1);	
	}
	/*iteratively
	public static int pow(int base,int exponent)
	{
		int result=1;
		for(int i=0;i<exponent;i++)
		{
			result*=base;
		}
		return result;
	}*/
	
}