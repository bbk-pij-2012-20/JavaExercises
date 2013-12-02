// cd desktop/JavaCoding/JavaExercises

public class UpcastingDowncasting//Day11 Ex2
{
	public static void main(String[] args)
	{
/* Exercises 2.2 Direct upcasting:
Change the script so that the SmartPhone is created with the line: 
MobilePhone myPhone = new SmartPhone();
Compile your code again. Are there any problems? Why do these problems happen? 
What are the possible solutions? */

		MobilePhone myPhone = new SmartPhone();
/* This does not compile because the methods which are only in SmartPhone, 
and not in MobilePhone, cannot be accessed even though we are calling the 
constructor of SmartPhone with 'new SmartPhone()' 
I'm not entirely clear on why this is the case. */

/* 		SmartPhone myPhone=new MobilePhone();
Does not compile either, it reports Incompatible types */

//		myPhone.browseWeb("How to make a cheese cake");
//		myPhone.findPosition();
		myPhone.ringAlarm("beep beep, beepidee bupp bam boom");
		myPhone.playGame("Game: Randy Penguins\n");
		
		myPhone.call("00123");
		myPhone.call("00234");

		System.out.print("\nThe last 10 numbers are: \n");
		myPhone.printLastNumbers();

/* Exercises 2.3 - Indirect upcasting when calling a method:
Pass this object to a method testPhone(Phone) that has only one parameter 
of type Phone. What methods can you call on the object inside the method? */
		SmartPhone myPhone2=new SmartPhone();
		myPhone2.testPhone(myPhone); 
/* I can't tell from the question whether it is intended that I create a new 
non-static method: 'public void testPhone(Phone xyz)' and then call it from 
this script with a new SmartPhone object.. 'myPhone2', but also to pass it 
'myPhone' as follows: 'myPhone2.testPhone(Phone myPhone)' I'm just not sure!*/
	
/* 2.5 - Casting exception:
Create a MobilePhone object and then pass it to method testPhone(Phone). 
What happens? */
		MobilePhone mp=new MobilePhone();
	//	myPhone2.testPhone(mp); // gives ClassCastException when method tries 
	//	to downcast it to a SmartPhone on line 59.
	}
}
class SmartPhone extends MobilePhone
{
	public void testPhone(Phone myFone)
	{
		myFone.call("this is all I can call due to indirect upcasting");
/* 2.4 - Downcasting:
Inside the former method, downcast the object to Smartphone so that you 
can use all the public methods of Smartphone.*/
		SmartPhone mySmartFone=(SmartPhone) myFone;//DOWNCASTING 
		mySmartFone.browseWeb("How to make a cheesey chocolatey creamy fudge cake");
		mySmartFone.findPosition();
	}
	public void browseWeb(String keyword)
	{
		System.out.println("\n(SmartPhone) Googling: "+keyword);
	}
	public void findPosition()
	{
		System.out.println("\n(SmartPhone) Location: You are in a library");
	}
	@Override
	public void call(String number)
	{
		super.call(number);//i.e call method in MobilePhone, stores last 10 numbers.
		if(number.substring(0,2).equals("00"))
		{
			System.out.println("(SmartPhone) For number: "+number+", switching to Skype.");
		}
	}	
}
class MobilePhone extends OldPhone
{	
	private String[] last10=new String[10]; 
	
	@Override
	public void call(String number)
	{	
//		super.call(number);
		for(int i=1;i<last10.length;i++)
		{
			last10[i-1]=last10[i];
		}
		int endPos=last10.length-1;
		last10[endPos]=number;
	}
	public void printLastNumbers()
	{
		for(int i=0;i<last10.length;i++)
		{
			if(last10[i]==null)
			{ 
				System.out.println("..oops..no..there are fewer than 10 numbers.\n");
				return;
			}
			System.out.println((i+1)+": "+last10[i]);
		}
	}	
	public void ringAlarm(String alarmNoise)
	{
		System.out.println("\n(MobilePhone) Alarm goes "+alarmNoise);
	}
	public void playGame(String gameName)
	{
		System.out.println("\n(MobilePhone) Game called: "+gameName);
	}
}
class OldPhone implements Phone
{
 	public void call(String number)
	{
		System.out.println("Calling.... "+number);
	}	
}
/**
* A phone makes calls 
*/
interface Phone
{ 
	/**
	* Just print on the screen: "Calling <number>...".
	*/
	public void call(String number);
}