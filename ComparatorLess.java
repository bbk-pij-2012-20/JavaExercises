/* 
Day 11 exercise: Task is to improve the following code (Comparator
class), by reducing code repetition. Hint: via casting between 
types. (Casting is mentioned in Day 5 notes. Reducing code 
repetition is mentioned in Day 11,no.3 notes.)

NOTE: Casting from int to double is fine but from double to
int can result in loss of data. e.g. Casting the double 10.5 
to an int gives 10. Casting that int back to a double gives 10.0. 
Therefore, I partially address this here by multiplying any 
double-to-int casting by 100, then dividing the returned value 
by 100. 

Comparator class has three methods, but each performs the same
function. They have the same name but different signatures 
(i.e. different return types and parameters). This is an example
of 'method overloading'. 
One method takes 2 integers, returns 1 integer. A second method 
takes 2 doubles, returns 1 double. The third method takes 2 
Strings, returns 1 String.

This is rewritten in the class ComparatorLess directly beneath 
Comparator so that the comparison "algorithm" is now only in 
getMax(int,int) and no longer repeated in the other two methods. 
 
public class Comparator 
{
	public int getMax(int n,int m) 
	{
		if(n>m)
		{
			return n;
		}
		else
		{
			return m;
		}
	}
	public double getMax(double d1,double d2)
	{ 
		if(d1>d2)
		{
			return d1;
		}
		else
		{
			return d2;
		}
	}
	public String getMax(String number1,String number2)
	{
		int n1=Integer.parseInt(number1);
		int n2=Integer.parseInt(number2);
		if(n1>n2)
		{
			return number1;
		} 
		else 
		{
			return number2;
		}
	}
}
*/
public class ComparatorLess
{
	public static void main(String[] args)
	{
		ComparatorLess cl=new ComparatorLess();
		double dRes=cl.getMax(10.5,11.5);
		System.out.println("\ndouble result should be 11.5. \nactual result is: "+dRes);
		int iRes=cl.getMax(10,20);
		System.out.println("\ninteger result should be 20. \nactual result is: "+iRes);
		String sRes=cl.getMax("10","10000");
		System.out.println("\nString result should be 10000. \nactual result is: "+sRes+"\n");
	}
	/** This method takes 2 integers and returns the larger one.
	*  @param 2 integers n and m 
	*  @return integer
	*/
	public int getMax(int n,int m) 
	{
		if(n>m)
		{
			return n;
		}
		else
		{
			return m;
		}
	}
	/** This method takes 2 doubles and returns the larger one.
	*  @param 2 doubles d1 and d2 
	*  @return double
	*/	
	public double getMax(double d1,double d2)
	{ 
		int n=(int)(d1*100);
		int m=(int)(d2*100);
		double result=((double) getMax(n,m))/100;
		return result; 
	}
	/** This method takes 2 numbers as Strings and returns the larger one.
	*   @param 2 Strings number1 and number2 
	*   @return String
	*/
	public String getMax(String number1,String number2)
	{
		int n=Integer.parseInt(number1);
		int m=Integer.parseInt(number2);
		String result=""+getMax(n,m);
		return result;
	}
}
