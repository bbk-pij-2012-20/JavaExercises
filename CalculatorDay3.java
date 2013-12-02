// cd Desktop/JavaCoding/JavaExercises

public class CalculatorDay3
{
	public static void main(String args[])
	{
		System.out.println("Input 2 numbers");		
		int num1=Integer.parseInt(System.console().readLine());
		int num2=Integer.parseInt(System.console().readLine());
		double dNum1=(double) num1;
		double dNum2=(double) num2;
		System.out.println("Select operator: (A)dd,(S)ubtract,(M)ultiply or (D)ivide");
		String input=System.console().readLine();
		switch(input)
		{
			case "A":System.out.println(num1+"+"+num2+"="+(num1+num2));break;
			case "a":System.out.println(num1+"+"+num2+"="+(num1+num2));break;
			case "S":System.out.println(num1+"-"+num2+"="+(num1-num2));break;
			case "s":System.out.println(num1+"-"+num2+"="+(num1-num2));break;
			case "M":System.out.println(num1+"x"+num2+"="+(num1*num2));break;
			case "m":System.out.println(num1+"x"+num2+"="+(num1*num2));break;
			case "D":System.out.println(num1+"/"+num2+"="+(dNum1/dNum2));break;
			case "d":System.out.println(num1+"/"+num2+"="+(dNum1/dNum2));break;
			default:System.out.println("Invalid");break;
		}
	}
}