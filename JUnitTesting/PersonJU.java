// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/RECURSION/Memoization
// Exercise 12.3: Introduction to Testing (primarily using JUnit)

/*
The method getInitials(String) has a bug! If you introduce a name with more than one 
space between words, it throws an exception. 
Create a class that contains the method getInitials(String) as described in the notes. 
Create also the test class as described in the notes. 
Then follow the “find bugs once” algorithm: reproduce the bug manually, reproduce the 
bug programmatically by adding a new test to the testing class, then fix the bug and 
check that all tests pass.
*/

public class PersonJU {
	
	public static void main(String args[]) {
	
//		String fullName = "MrSpaced Out";
//		String fullName = "MrSpaced  Out"; // <-- reproducing bug manually
		String fullName = "MrSpaced   Out"; // <-- reproducing bug manually

		PersonJU pj = new PersonJU();
		String initials = pj.getInitials(fullName);
		System.out.println("\nName: " + fullName + ". Initials: " + initials);
	
	}
	
	public String getInitials(String fullName) {
	
		String result = "";
		String[] words = fullName.split(" "); 

//This for loop is just so I can see what the buggy split does.
		for (int i = 0; i < words.length; i++) {
		
			System.out.print(words[i] + " ");
		
		}

		for (int i = 0; i < words.length; i++) {
		
			while (words[i].equals("") && i < (words.length - 1)) {
			
				i++;
			
			}
			
			words[i].trim();
			String nextInitial = "" + words[i].charAt(0);
			
			result = result + nextInitial.toUpperCase(); 
		
		}
		
		return result;
	
	}

}