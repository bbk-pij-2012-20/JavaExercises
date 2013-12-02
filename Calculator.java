//cd Desktop/JavaCoding/JavaExercises

public class Calculator // Day6 Ex 1
{
	public static void main(String args[])
	{
		int result=0;
		System.out.println("Enter 2 numbers");
		String input=System.console().readLine();
		int n1=Integer.parseInt(input);
		input=System.console().readLine();
		int n2=Integer.parseInt(input);
		System.out.println("(A)dd,(S)ubtract,(D)ivide,(M)ultiply,(Mo)dulo");
		input=System.console().readLine();

		switch(input)
		{
			case "A":System.out.println(add(n1,n2));break; 
			case "S":System.out.println(subtract(n1,n2));break; 		
			case "M":System.out.println(multiply(n1,n2));break;
			case "Mo":System.out.println(modulus(n1,n2));break;			
			case "D":System.out.println(divide(n1,n2));break;
			default: System.out.println("invalid");break;			
		}
	}
	public static int add(int num1,int num2)
	{
		return num1+num2;
	}
	public static int subtract(int num1,int num2)
	{
		return num1-num2;
	}
	public static int multiply(int num1,int num2)
	{
		return num1*num2;
	}
	public static int modulus(int num1,int num2)
	{
		return num1%num2;
	}
	public static double divide(int num1,int num2)
	{
		double d1=(double) num1; 
		double d2=(double) num2;
		return d1/d2;
	}
}