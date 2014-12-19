// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/Inheritance_AdhocPolymorphism/Phone/Casting
// Exercise 11.2 : Introducing Interfaces, ad hoc polymorphism and casting.
/* Note: This is the same set of 3 classes and 1 interface from Exercise 10.2*/

public class OldPhone implements Phone {

 	public void call(String number) {
 	
		System.out.println("Calling.... " + number);
	
	}	

}