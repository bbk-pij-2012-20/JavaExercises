// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/startingToEncapsulate
// Exercise 4.3 (Learning the basics. Starting to encapsulate in classes and methods).
// This particular exercise is also for practicing use of doubles.

/*

Write a program that asks the user for 3 user inputs:

1. the total amount borrowed for a mortgage, 
2. the number of years to pay it back, and 
3. the interest rate (in this exercise, we assume it is a fixed rate). 

The program can then calculate how much must be paid at the end using: 
  
   t = c x (1 + r / 100)

where t is the total, c is the cost, and r is the rate as a percentage. 


The program should print 3 outputs:

1. The total amount to be paid
2. The money to be paid every year
3. The number of years before the interest is paid and only the initial capital remains

Write a method to calculate each piece of data.

*/

public class Mortgage {
	
	private double propertyCost, yearsToRepay, fixedInterestRate;
	private double totalRepayment, repaymentPerYear, yearsToRepayInterest;
	
	public static void main(String[] args) {
	
		Mortgage mortgage = new Mortgage();
		
		mortgage.promptUserInput();				
		mortgage.calcOutputs();
		mortgage.printOutputs();
		
	}
	
	
	public void promptUserInput() {
	
		System.out.println("What is total amount borrowed for a mortgage ?");
		System.out.print("(£) : ");
		propertyCost = Double.parseDouble(System.console().readLine());
		System.out.println("How many years to pay back ?");
		System.out.print("years : ");
		yearsToRepay = Double.parseDouble(System.console().readLine());
		System.out.println("What is the fixed interest rate ?");
		System.out.print("(%) : ");
		fixedInterestRate = Double.parseDouble(System.console().readLine());
	
	}
	
	public void calcOutputs() {
	
		calcTotalRepayment();
		calcRepayPerYear();
		calcYrsToRepayInterest();
	
	}
	
	public void printOutputs() {
	
		roundOffOutputs();
		System.out.println("total amount to be paid : £ " + totalRepayment);
		System.out.println("money to be paid each year: £ " + repaymentPerYear);
		System.out.println("number of years for interest only to be repaid: " + yearsToRepayInterest + " years");
	
	}
	
	private void roundOffOutputs() {
	
		totalRepayment = Math.round(100 * totalRepayment) / 100.;
		repaymentPerYear = Math.round(100 * repaymentPerYear) / 100.;
		yearsToRepayInterest = Math.round(100 * yearsToRepayInterest) / 100.;
	
	}
	
	/**
	* c x (1 + r / 100) is broken up into (c x 1) + (c x r /100). 
	* The latter is encapsulated in the method calcTotalInterest(), which is 
	* reused in calculating the number of years to repay the interest.
	*/
	private void calcTotalRepayment() {

		totalRepayment = propertyCost + calcTotalInterest();

	}
	
	private void calcRepayPerYear() {
	
		repaymentPerYear = totalRepayment / yearsToRepay;

	}
	
	private double calcTotalInterest() {
	
		return propertyCost * (fixedInterestRate / 100);
	
	}
	
	private void calcYrsToRepayInterest() {
	
		yearsToRepayInterest = calcTotalInterest() / repaymentPerYear;
	
	}
	
}