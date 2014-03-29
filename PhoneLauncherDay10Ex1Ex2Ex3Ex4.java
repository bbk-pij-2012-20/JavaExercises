// cd Desktop/JAVA_CODING/JavaExercises

4.1 
Q. Change the visibility of playGame(String) to private and check whether the script you 
wrote in the former exercise still works. Why does this happen? 
A. It does not compile. This is because 'private' restricts visibility to the class it is
in only. Protected increases visibility to subclasses.

Q. What are the minimal changes that you need to make on class SmartPhone so that the 
script still works?
A. Protected works.

4.2 
Q. Create a class RestrictedSmartPhone that overrides playGame(String) to make 
it private and thus non-visible to external classes and scripts. Is this possible? Why?
A. It doesn't compile when the overriding method is private. It does override if the 
the visibility is public or protected.
But I'm not sure what's meant by external classes? Does "external" refer to outside of 
the package?
*/

public class PhoneLauncherDay10Ex1Ex2Ex3Ex4
{
	public static void main(String[] args)
	{
		SmartPhone sp=new SmartPhone();
		RestrictedSmartPhone rsp=new RestrictedSmartPhone();
		sp.browseWeb("How to make a cheese cake");
		sp.findPosition();
		sp.ringAlarm("beep beep");
		sp.playGame("Crazy Penguins\n");
//		rsp.playGame("RESTRICTED\n");
		
		sp.call("00123");
		sp.call("00234");
		sp.call("111123");
		sp.call("1111234");
		sp.call("22123");
		sp.call("22234");
		sp.call("33123");
		sp.call("33234");
		sp.call("44123");
		sp.call("44234");
		sp.call("55123");
		sp.call("55234");
/*
//		MobilePhone mp=new MobilePhone();
		mp.call("00123");
		mp.call("00234");
		mp.call("111123");
		mp.call("1111234");
		mp.call("22123");
		mp.call("22234");
		mp.call("33123");
		mp.call("33234");
		mp.call("44123");
		mp.call("44234");
		mp.call("55123");
		mp.call("55234");
*/		
		System.out.print("\nThe last 10 numbers are: \n");
		sp.printLastNumbers();
		
		SmartPhone sp2=new SmartPhone("Gucci");
		String brand=sp2.getBrand();
		System.out.println("Brand is:"+ brand);
	}
}
class RestrictedSmartPhone extends MobilePhone
{
	@Override
//	public void playGame(String gameName) - this works, as does protected 
	protected void playGame(String gameName)
//	private void playGame(String gameName) - this one doesn't compile
	{
		System.out.println("\n(MobilePhone) The game is: "+gameName);
	}
}
class SmartPhone extends MobilePhone
{
	public SmartPhone(){}
	public SmartPhone(String brand)
	{
		super(brand);
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
	
	public MobilePhone()
	{}
	public MobilePhone(String brand)
	{
		super(brand);
	}
	
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
				System.out.println("..oops..there are fewer than 10 numbers.\n");
				return;
			}
			System.out.println((i+1)+": "+last10[i]);
		}
	}	
	public void ringAlarm(String alarmNoise)
	{
		System.out.println("\n(MobilePhone) Alarm goes: "+alarmNoise);
	}
	//private void playGame(String gameName)
	//public void playGame(String gameName)
	protected void playGame(String gameName)
	{
		System.out.println("\n(MobilePhone) The game is: "+gameName);
	}
}
class OldPhone implements Phone
{
	private String brand=null;
	public OldPhone()
	{}
	public OldPhone(String brand) 
	{
		this.brand=brand;
	}
	public String getBrand()
	{
		return brand;
	}
	// ... there is no setter for brand	

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