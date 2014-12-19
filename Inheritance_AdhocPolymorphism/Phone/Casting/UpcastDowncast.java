// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/Inheritance_AdhocPolymorphism/Phone/Casting
// Exercise 11.2 : Introducing Interfaces, their implementation, constructor chaining  
/*For this exercise, you will need to use again some classes and interfaces you created 
last day: Phone, OldPhone, MobilePhone, SmartPhone.
11.2.1. Create a script that builds a new SmartPhone with the line:
Smartphone myPhone = new Smartphone(); and then uses all its methods
*/
public class UpcastDowncast {

	public static void main(String[] args) {
	
/* 11.2.2. Direct upcasting
Change the script so that the SmartPhone is created with the line: 
MobilePhone myPhone = new SmartPhone();
Compile your code again. Are there any problems? Why do these problems happen? 
What are the possible solutions? */
		
		MobilePhone myPhone = new SmartPhone();
/* This does not compile because the methods which are only in SmartPhone, and not in 
MobilePhone, cannot be accessed even though we are calling the constructor of SmartPhone 
with 'new SmartPhone()'. I'm not entirely clear on why this is the case. */

//		myPhone.browseWeb("How to brew a cup of cheese");
//		myPhone.findPosition();
		myPhone.ringAlarm("beep beep, beepidee bupp bam boom");
		myPhone.playGame("Game: Penguin Sushi \n");
		
		myPhone.call("00123");
		myPhone.call("00234");

		System.out.print("\nThe last 10 numbers are: \n");
		myPhone.printLastNumbers();

/* 11.2.3. - Indirect upcasting when calling a method:
Pass this object to a method testPhone(Phone) that has only one parameter 
of type Phone. What methods can you call on the object inside the method? */
		SmartPhone myPhone2 = new SmartPhone();
		myPhone2.testPhone(myPhone); 
/* I can't tell from the question whether it is intended that I create a new 
non-static method: 'public void testPhone(Phone xyz)' and then call it from 
this script with a new SmartPhone object.. 'myPhone2', but also to pass it 
'myPhone' as follows: 'myPhone2.testPhone(Phone myPhone)' I'm just not sure!*/
	
/* 11.2.5 - Casting exception:
Create a MobilePhone object and then pass it to method testPhone(Phone). 
What happens? */
		MobilePhone mp = new MobilePhone();
	//	myPhone2.testPhone(mp); // gives ClassCastException when method tries 
	//	to downcast it to a SmartPhone on line 59.
	}

}