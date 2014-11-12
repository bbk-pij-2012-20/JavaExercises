// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/BasicScripts#2
// Exercise 3.11 (Learning the basics). 
/*
	Write a program that reads a number with commas and decimal 
	dots (such as “23,419.34”) and then prints a number that is 
	half of it. Do not use Double.parseDouble().
	If you were writing a simple spreadsheet, you could use this 
	code to parse the input in the cells.
*/

public class Text2Number {

	public static void main(String[] args) {
		
		String num = "23,419.34";
		System.out.println("number to divide by two: " + num);
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < num.length(); i++) {
		
			if (Character.isDigit(num.charAt(i))) {
						
				sb.append("" + num.charAt(i));
				
			}
		
		}
		
		num = sb.toString();
		int numb = Integer.parseInt(num);
		num = "" + (numb / 2);
		int length = num.length();
		String integerPart = num.substring(0, length - 2);
		String decimalPart = num.substring(length - 2);
		int i = 1; // iterating from right 		
		int integerLength = integerPart.length();
		
		while (integerLength - i > 0) {
			
			System.out.println("i: " + i);
			if (i % 3 == 0) {
			
				integerPart = integerPart.substring(0, integerLength - i) + "," + integerPart.substring(integerLength - i);	
			
			}
			
			i++;

		}
			
		System.out.println("result output: " + integerPart + "." + decimalPart);
		
	}

}