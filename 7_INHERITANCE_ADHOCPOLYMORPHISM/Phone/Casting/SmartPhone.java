// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/Inheritance_AdhocPolymorphism/Phone/Casting
// Exercise 11.2 : Introducing Interfaces, ad hoc polymorphism and casting.
/* Note: This is the same set of 3 classes and 1 interface from Exercise 10.2*/

public class SmartPhone extends MobilePhone {

	public void testPhone(Phone myFone) {

		myFone.call("this is all I can call due to indirect upcasting");
/* 11.2.4 - Downcasting:
Inside the former method, downcast the object to Smartphone so that you 
can use all the public methods of Smartphone.*/
		SmartPhone mySmartFone = (SmartPhone) myFone;//DOWNCASTING 
		mySmartFone.browseWeb("How to make a cheesey chocolatey creamy fudge cake");
		mySmartFone.findPosition();
	
	}
	
	public void browseWeb(String keyword) {
	
		System.out.println("\n(SmartPhone) Googling: " + keyword);
	
	}
	
	public void findPosition() {
	
		System.out.println("\n(SmartPhone) Location: You are in a library");
	
	}
	
	@Override
	public void call(String number) {
	
		super.call(number);//i.e call method in MobilePhone, stores last 10 numbers.
		
		if (number.substring(0, 2).equals("00")) {

			System.out.println("(SmartPhone) For number: " + number + ", switching to Skype.");

		}

	}	

}