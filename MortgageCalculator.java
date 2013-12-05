//cd desktop/JavaCoding/JavaExercises
/* Day 4, Ex3 - A bit more practice with doubles
Write a program that asks the user for the total amount borrowed for a mortgage, 
the number of years to pay it back, and the interest rate (in this exercise, we 
assume it is a fixed rate). The program can then calculate how much must be paid 
at the end t=c.(1+(r/100)) 
where t is the total, c is the cost, and r is the rate as a percentage. 
The program should print: the total amount to be paid, the money to be paid every 
year and the number of years before the interest is paid and only the initial 
capital remains. Write a method to calculate each piece of data.
*/

//How do I limit the double output to only 2 decimal places?
public class MortgageCalculator
{
	public static void main(String args[])
	{
		System.out.println("Enter total £ borrowed, e.g. 175000.25");
		String input=System.console().readLine();
		double borrowed=Double.parseDouble(input);
		System.out.println("Enter no of years to repay, e.g. 30");
		input=System.console().readLine();
		double years=Double.parseDouble(input);
		System.out.println("Enter fixed rate %, e.g. 4.5");
		input=System.console().readLine();
		double rate=Double.parseDouble(input);

		MortgageCalculator mc=new MortgageCalculator();
		double mortgage=mc.getMortgageTotal(borrowed,rate);
		double yearlyPay=mc.getYearlyPay(years,mortgage);
		double yearsIntOnly=mc.getYrsIntOnly(mortgage,borrowed,yearlyPay);	
	}

	public double getMortgageTotal(double borrowed,double rate)
	{
		double mortgage=borrowed*(1+(rate/100));
		System.out.println("mortgage = "+mortgage);
		return mortgage;
	}
	public double getYearlyPay(double years,double mortgage)
	{
		System.out.println("yearly payment = "+mortgage/years);
		return mortgage/years;
	}
	public double getYrsIntOnly(double mortgage,double borrowed,double yearlyPay)
	{
		double interest=mortgage-borrowed;
		System.out.println("years to pay off interest only = "+interest/yearlyPay);
		return interest/yearlyPay;		
	}
}