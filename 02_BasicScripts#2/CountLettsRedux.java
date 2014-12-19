//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/BasicScripts#2
// Exercise 3.7 (Learning the basics. Beginning to encapsulate in classes & methods)

/*
Write a program that reads a text from the user and then enter a loop of requesting 
letters and counting them. 
The program stops if the user asks for the same letter twice.
*/

import java.util.List;
import java.util.ArrayList;

public class CountLettsRedux {

	public static void main(String[] args) {

		System.out.println("Please write some text: ");
		String inputText = System.console().readLine();
		List<String> alreadyEnteredLetters = new ArrayList<>();
		boolean repeatInput = false;
		
		while (!repeatInput) {
		
			System.out.println("Which letter would you like to count now?");
			String inputLetter = System.console().readLine().toLowerCase();
			inputLetter = inputLetter.trim();
			
			if (alreadyEnteredLetters.contains(inputLetter)) {
			
				repeatInput = true;
			
			} else if (inputLetter.length() != 1) {
			
				System.out.println("try again, enter 1 letter only");
			
			} else {
			
				alreadyEnteredLetters.add(inputLetter);
				char inputChar = inputLetter.charAt(0);
				int count = 0;
				
				for (int i = 0; i < inputText.length(); i++) {
			
					if (inputChar == inputText.toLowerCase().charAt(i)) {
				
						count++;
				
					}
				
				}
		
				System.out.printf("There are %d '%s' characters in %s\n", count, inputChar, inputText);
			
			} 

		}
		
		System.out.println("Repeated character. Exiting the program...");
		System.out.println("Thank you for your cooperation. Good bye!");

	}

}