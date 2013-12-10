//cd desktop/JavaCoding/JavaExercises

public class Spy
{
	private static int spyCount;
	private int ID;
	public Spy(int ID)
	{
		this.ID=ID;
		spyCount++;
//		System.out.print("number of spies so far: "+spyCount);
//		System.out.println(" - id# "+ID);	
		spyCount(ID);
	}	

// if this method were not static it would be able 
// to access the instance variable ID without needing.
// But it is static, therefore ID must be passed to it.
	public static void spyCount(int ID)	{
//		System.out.print("number of spies so far: "+spyCount);
//		System.out.println(" - id# "+ID);		
	}
	public static void main(String args[])
	{
		Spy s1=new Spy(123);
		Spy s2=new Spy(34);
		Spy s3=new Spy(473);
		Spy s4=new Spy(12334);
		Spy s5=new Spy(334);		
		System.out.println("there are "+spyCount+" spies");		
// ID can't be accessed like this: System.out.println(" - id# "+ID);		
		s1.die();
		s3.die();
		s5.die();
	}
	public void die()
	{
//		this=null; //'this' is a final variable, you can't assign values to it.
		spyCount--;
		System.out.println("spy "+ID+" has been deleted");
		System.out.println("there are "+spyCount+" spies");		
	}
}