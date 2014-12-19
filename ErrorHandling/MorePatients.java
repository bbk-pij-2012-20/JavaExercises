// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/ErrorHandling
// Exercise 15.4: Introduction to Error handling
/* 
Write a class that asks for data (name and year of birth) about new patients in a 
hospital and keeps them in a list of Patient. The constructor of Patient must throw 
an IllegalArgumentException if the age of the patient is negative or greater than 130.
*/

public class MorePatients {

	public static void main(String[] args) {

		String name = "";
		String dob = "";

		do {

			System.out.println("input name and DOB of new patients,-1 to end");
			System.out.println("name: ");
			name = System.console().readLine();
			System.out.println("DOB (yyyy): ");
			dob = System.console().readLine();
			new PatientList.Patient(name, dob);

		} while (!name.equals("-1")); 
	
	}

}

class PatientList {
	
	//other code for a list of some form

	static class Patient {
	
		String name = "";
		String dob = "";
		int age = 0;
		
		public Patient(String name, String dob) {
		
			setName(name);
			setAge(dob);
	
		}
	
		public void setName(String name) {
	
			this.name = name;
	
		}
	
		public void setAge(String dob) {
	
			int age = 2014 - Integer.parseInt(dob);

			try {
				
				if (age < 0 || age > 130) {
				
					throw new IllegalArgumentException();
			
				}
				
				this.age = age;
			
			} catch (IllegalArgumentException e) {
		
				System.out.println("cant be less than 0 or more than 130 years old");
				e.printStackTrace();
	
			}

		}
		
	}
}