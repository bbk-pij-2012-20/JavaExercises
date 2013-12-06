//cd desktop/JavaCoding/JavaExercises
/* Day4, Ex7 - Integer
Create your own version of boxed int! Create a class Integer2 with 
only one field (int value) and the following methods:
getValue(): returns the value of this number as an int, a getter. 
setValue(int): a setter.
isEven(): returns true if the number is even, false otherwise. 
isOdd(): the opposite.
prettyPrint(): prints the value of the integer on the screen. 
toString(): returns a String equivalent to the number.
*/
public class Integer2Launch
{
	public static void main(String args[])
	{
		Integer2 i2=new Integer2();
		System.out.println("Enter a number: ");
		String str=System.console().readLine(); 
		int i=Integer.parseInt(str); 
		i2.setValue(i);
		System.out.print("The number you entered is ");
		if(i2.isEven()) 	
		{
			System.out.println("even.");
		}
		else if(i2.isOdd())
		{
			System.out.println("odd.");
    	}
    	else
    	{
    		System.out.println("undefined!! Your code is buggy!");
    	}
		int parsedInt=Integer.parseInt(i2.toString()); 
		if(parsedInt==i2.getValue())
		{
			System.out.println("Your toString() method seems to work fine."); 
		}
	}
}
class Integer2
{
	private int value;
	public int getValue()
	{
		return value;
	}
	public void setValue(int value)
	{
		this.value=value;
	}
	public boolean isEven()
	{
		return value%2==0;
	}
	public boolean isOdd()
	{
		return !isEven();
	}
	public void prettyPrint()
	{
		System.out.println("The integer is: "+value);
	}
	public String toString()
	{
		return (""+value);
	}
}