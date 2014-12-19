// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/startingToEncapsulate
// Exercise 4.5 (Learning the basics. Starting to encapsulate into methods).
/*
Binary numbers can be quite long. A 32-bit memory address looks like 
1001 0101 0110 1010 1011 0010 1001 1010, 
which is difficult to handle. That is why memory addresses and other binary numbers are 
usually written as hexadecimal numbers. 
A hexadecimal number is a base-16 number, with digits between 0 and f (f is equivalent to
decimal 15, e is equivalent to decimal 14, and so on). 
A hexadecimal number is equivalent to a four-digit binary number, which makes them quite 
compact. The former address reads 956ab29a, which is easier to read and write.
To prevent confusion with decimal numbers, hexadecimal numbers are usually prefixed by 
“0x”, as in 0x95 (which is 149) or 0xff (which is 255).

Write a program that takes a String. The string can be a decimal or a hexadecimal number 
(starting by “0x”). Your program must recognise the number as what it is and convert it 
to the other base. Use two methods for conversion as in the former exercise.
*/

public class BinaryHexadecimal {

	public static void main(String[] args) {
	
		BinaryHexadecimal bh = new BinaryHexadecimal();
		String answer = bh.convert(bh.promptUserInput());
		bh.print(answer);
	
	}
	
	public String promptUserInput() {
	
		boolean validInput = false;
		String input = "";
		
		do {
		
			System.out.println("enter a positive hexadecimal or decimal number: ");
			input = System.console().readLine();		

			if (input.charAt(0) == '-') {
			
				System.out.println("No. Input must be unsigned: ");
				
			} else {

				validInput = true;

			}
			
		} while (!validInput);
		
		return input;
	
	}

	// NB: method name used 3 times, different signatures (i.e. argument type)
	public String convert(String userInput) {
	
		String result = "";
		
		if (userInput.substring(0,2).equals("0x") || userInput.substring(0,2).equals("0X")) {
					
			result = hex2Dec(userInput.substring(2));

		} else {
			
			result = dec2Hex(Integer.parseInt(userInput));
				
		}
		
		return result;
	
	}
	
	public void validate(String userInput) throws Exception {
	
		for (int i = 0; i < userInput.length(); i++) {
			
			if (Character.isLetter(userInput.charAt(i))) {
				
				throw new Exception("needs either 0x prefix or number only");
				
			}
			
		}
		
	}
	
	public String hex2Dec(String hex) {

		int decimal = 0;

		for (int i = 0; i < hex.length(); i++) {

			if (Character.isLetter(hex.charAt(i))) {

				decimal += convert(hex.charAt(i)) * Math.pow(16, hex.length() - 1 - i);

			} else {

				int power = hex.length() - 1 - i;
				int number = Integer.parseInt(""+hex.charAt(i));
				int mathPow = (int) Math.pow(16, power);
				decimal += number * mathPow;

			}

		}


		return "" + decimal;
		
	}
	
	public String dec2Hex(int decimal) {
	
		if (decimal == 0) {
		
			return "0";
			
		}
		
		String hex = "";
		int dec = decimal;

		while (dec / 16 != 0) {
		
			hex = convert(dec % 16) + hex;
			dec /= 16;
			
		} 
		
		return "0x" + hex;
	
	}
	
	public void print(String answer) {
	
		System.out.print("Converted to ");
		
		if (answer.length() < 2 || !answer.substring(0,2).equals("0x")) {
		
			System.out.print("decimal: ");
			
		} else {
		
			System.out.print("hexadecimal: ");
			
		}
				
		System.out.print(answer + "\n");
	
	}
	
	// NB: method name used 3 times, different signatures (i.e. argument type)
	private int convert(char c) {
	
		int num10_15 = 0;
		c = Character.toLowerCase(c);
		
		try {
		
			switch (c) {
		
				case 'a' : num10_15 = 10; break; 
				case 'b' : num10_15 = 11; break;
				case 'c' : num10_15 = 12; break; 
				case 'd' : num10_15 = 13; break;
				case 'e' : num10_15 = 14; break; 
				case 'f' : num10_15 = 15; break; 
				default : throw new IllegalArgumentException("not within A to F"); 
			
			}			
	
		} catch (IllegalArgumentException iae) {
		
			System.out.println(iae.getMessage());
		
		}
		
		return num10_15;
	
	}
	
	// NB: method name used 3 times, different signatures (i.e. argument type)
	private char convert(int remainder){
	
		char result = 0;
		
		if (remainder < 9) {
		
			return (char) remainder;
		
		} 
		
		switch (remainder) {
			
			case 10 : result = 'A'; break;
			case 11 : result = 'B'; break;
			case 12 : result = 'C'; break;		
			case 13 : result = 'D'; break;
			case 14 : result = 'E'; break;				
			default : result = 'F'; break;	
		
		}
		
		return result;
				
	}
	
}