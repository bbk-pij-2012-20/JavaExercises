// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/startingToEncapsulate
// // Exercise 4.4 (Learning the basics. Starting to encapsulate into methods).
/*
Create a program in which you define the following methods:

binary2decimal(String): takes from the user a binary number (with digits 0 and 1) and 
returns the corresponding number in decimal (base-10, with digits between 0 and 9). 
Hint: in the same way that you know that 35 = 3 x 10^1 + 5 x 10^0, you can find that 
100011 = (1 x 2^5) + (1 x 2^1) + (1 x 2^0).

decimal2binary(int): the opposite of the previous one: takes a decimal number and returns 
the corresponding binary number. Hint: instead of multiplying by 2, you will need to 
divide by two this time. The program must offer a menu to the user with two options. 
The first one takes a binary number from the user and returns the corresponding decimal 
number. The second one does the opposite: takes a decimal number and returns a binary 
number. The program should use the methods defined.
*/

public class BinaryDecimal {

	public static void main(String[] args) {
	
		BinaryDecimal bd = new BinaryDecimal();
		String decimal = bd.binary2decimal(bd.promptUserForBinaryInput());
		bd.printResult(decimal, 'D');
		String binary = bd.decimal2binary(bd.promptUserForDecimalInput());
		bd.printResult(binary, 'B');
			
	}

	public String promptUserForBinaryInput() {
	
		System.out.println("enter an unsigned binary number: ");
		return System.console().readLine();

	}
	
	public int promptUserForDecimalInput() {
	
		System.out.println("enter a decimal number (which can be negative): ");
		return Integer.parseInt(System.console().readLine());

	}
	
	public String binary2decimal(String binary) {
		
		int counter = 0;
		int result = 0;
		
		try {
			
			while (counter < binary.length()) {

				if (binary.charAt(counter) != '1' || binary.charAt(counter) != '0') {

					throw new IllegalArgumentException("This is not a binary number");

				}
		
				if (binary.charAt(counter) == '1') {
			
					result += Math.pow(2, (binary.length() - counter - 1));
						
				}				

				counter++;
			}
		
		} catch (IllegalArgumentException iae) {
		
			System.out.println("" + iae.getMessage());
		
		}
		
		return "" + result;
	
	}
	
	public String decimal2binary(int decimal) {
	
		if (decimal == 0) {
		
			return "0";
		
		}

		String binary = "";
		int dec = Math.abs(decimal); // because I change the decimal value in while loop.
									 // and to deal with negative decimals.		
		while (dec / 2 != 0) {

			binary = "" + (dec % 2) + binary;
			dec /= 2;

			if (dec == 1) {

				binary = 1 + binary; 
				break;

			}

		}
		
		if (decimal < 0) {
		
			binary = "signed_1" + binary;
		
		}
	
		return binary;
		
	}
	
	public void printResult(String value, char decimalOrBinary) {
	
		System.out.print("Converted to "); 

		if (decimalOrBinary == 'D') {
		
			System.out.println("decimal from binary: " + value);
		
		} else if (decimalOrBinary == 'B') {
		
			System.out.println("binary from decimal: " + value);
		
		} 
	
	}
	
}