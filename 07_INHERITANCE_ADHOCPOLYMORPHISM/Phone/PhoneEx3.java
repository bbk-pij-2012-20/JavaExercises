// cd desktop/JAVA_CODING/JavaExercises

public class PhoneEx3
{
	public static void main(String[] args)
	{
		SmartPhone sp=new SmartPhone();
		sp.browseWeb("How to make a cheese cake");
		sp.findPosition();
		sp.ringAlarm("beep beep");
		sp.playGame("Game: Crazy Penguins\n");
		
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
		System.out.println("\n(MobilePhone) Alarm goes "+alarmNoise);
	}
	public void playGame(String gameName)
	{
		System.out.println("\n(MobilePhone) Game called: "+gameName);
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