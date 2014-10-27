//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/BasicScripts#2
// Exercise 3.3 (Learning the basics). 

/* 
Write a program that reads the total cost of a purchase and an amount of money 
that is paid to buy it. Your program should output the correct change specifying 
the amount of notes (50, 20, 10, 5) and coins (2, 1, 0.50, 0.20, 0.10, 0.05, 
0.02, 0.01) needed.
*/
public class YrChange {

	public static void main(String[] args) {
	
//		System.out.println("Enter cost(£), e.g. 200.43");	
//		double cost = Double.parseDouble(System.console().readLine());
		double cost = 200.34; // test value
//		System.out.println("Enter amount paid, e.g. 300.00");	
//		double paid = Double.parseDouble(System.console().readLine());
		double paid = 300; //test value

		while (paid < cost) {
		
			System.out.println("No! you must pay more!");
			paid = Double.parseDouble(System.console().readLine());
		
		}		
		
		double change = paid - cost; // 99.66
//		double change = 114.45234; // testing the Math.round
		change = Math.round(change * 100) / 100.0; // to round off to 2 decimal places (e.g. 100 - 99.99 does not give 0.01)
		System.out.println("your change is: " + change); // 300-200.34 --> 99.66

		if (change == 0.0) {
		
			System.out.println("Goodbye");
			System.exit(0);
		
		}
		
		change *= 100; // 99.66 x 100 --> 9966.0
		int bigChange = (int) change / 100; // 9966.0 / 100 --> 99
		int smallChange = (int) change % 100; // remainder of 9966.0/100 --> 66

// BIG CHANGE (£50, £20, £10, £5, £2, £1)

		if (bigChange >= 50) {
		
			System.out.println("£50 notes X " + bigChange / 50); // 99 / 50 --> 1
			bigChange %= 50; // 99 % 50 -->> 49
				
		}
		
		if (bigChange >= 20) { 
		
			System.out.println("£20 notes X " + bigChange / 20); // 49 / 20 --> 2
			bigChange %= 20; // 49 % 20 --> 9
				
		}
			
		if (bigChange >= 10) {
		
			System.out.println("£10 notes X " + bigChange / 10); 
			bigChange %= 10;
				
		}

		if (bigChange >= 5) {
		
			System.out.println("£5 notes X " + bigChange / 5); 
			bigChange %= 5;
				
		}

		if (bigChange >= 2) {
		
			System.out.println("£2 notes X " + bigChange / 2); 
			bigChange %= 2;
				
		}

		if (bigChange >= 1) {
		
			System.out.println("£1 notes X " + bigChange / 1); 
			bigChange %= 1;
				
		}

//SMALL CHANGE (50p, 20p, 10p, 5p, 2p, 1p)
		
		if (smallChange >= 50) { 
		
			System.out.println("50p coins X " + smallChange / 50); // 66 / 50 --> 1 
			smallChange %= 50; // 66 % 50 --> 16
				
		}

		if (smallChange >= 20) {
		
			System.out.println("20p coins X " + smallChange / 20); 
			smallChange %= 20;
				
		}

		if (smallChange >= 10) {
		
			System.out.println("10p coins X " + smallChange / 10); // 16 / 10 --> 1 
			smallChange %= 10; // 16 % 10 --> 6
				
		}

		if (smallChange >= 5) {
		
			System.out.println("5p coins X " + smallChange / 5); // 6 / 5 --> 1
			smallChange %= 5; // 6 % 5 --> 1
				
		}

		if (smallChange >= 2) {
		
			System.out.println("2p coins X " + smallChange / 2); 
			smallChange %= 2;
				
		}

		if (smallChange >= 1) {
		
			System.out.println("1p coins X " + smallChange / 1); // 1 / 1 --> 1
			smallChange %= 1; // 1 % 1 --> 0
				
		}

	}

}