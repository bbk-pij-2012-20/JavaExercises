// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/Inheritance_AdhocPolymorphism/Phone/Casting
// Exercise 11.2 : Introducing Interfaces, ad hoc polymorphism and casting.
/* Note: This is the same set of 3 classes and 1 interface from Exercise 10.2*/

public class MobilePhone extends OldPhone {
	
	private String[] last10 = new String[10]; 
	
	@Override
	public void call(String number) {
		
//		super.call(number);
		for (int i = 1; i < last10.length; i++) {
		
			last10[i - 1] = last10[i];

		}
		
		int endPos = last10.length - 1;
		last10[endPos] = number;
	
	}
	
	public void printLastNumbers() {
	
		for (int i = 0; i < last10.length; i++) {
		
			if (last10[i] == null) { 
	
				System.out.println("..oops..no..there are fewer than 10 numbers.\n");
				return;
	
			}
	
			System.out.println((i + 1) + ": " + last10[i]);
	
		}
	
	}	
	
	public void ringAlarm(String alarmNoise) {
	
		System.out.println("\n(MobilePhone) Alarm goes " + alarmNoise);

	}
	
	public void playGame(String gameName) {
	
		System.out.println("\n(MobilePhone) Game called: " + gameName);

	}

}