//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/BasicScripts#2
// Exercise 2.6 (Learning the basics). 

/*
Write a program that reads a short string and then some longer text. 
The program must say how many times you can find the short string in the text. 
You cannot use any method of String apart from charAt() and length().
*/

public class CountLettsPairs {

	public static void main(String[] args) {

		System.out.println("Please write some text: ");
		String input = System.console().readLine().toLowerCase().trim();
		System.out.println("Please write some longer text: ");
		String inputLong = System.console().readLine().toLowerCase();
		int iLong = 0;
		int i = 0;
		
		while (iLong <= (inputLong.length() - input.length()) && i < input.length()) {

			if (input.charAt(i) != inputLong.charAt(iLong)) {
			
				iLong++; 
			
			} else if (input.charAt(i) == inputLong.charAt(iLong)) {

				i++;
				iLong++;
			
			}
		
		} 

		System.out.printf("'%s' does %scontain the text '%s'\n", inputLong, (i == input.length())? "" : "not ", input);

	}
		
}