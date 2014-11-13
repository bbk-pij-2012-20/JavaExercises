// cd desktop/JAVA_CODING/JavaEx_noGIT/d10Ex_noGIT

/* Inheritance day 10 exercises. Final class below is to demonstrate
this cannot be subclassed. Gives compilation error: cannot inherit from 
final FinalClass public class FinalClassSub extends FinalClass
*/

public class FinalClassSub extends FinalClass
{
	public static void main(String[] args)
	{	
		System.out.println("This will print out if a final class can be subclassed");
	}
}
final class FinalClass
{
	protected void something()
	{
		System.out.println("something in the final class");	
	}
}