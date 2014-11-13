/* cd Desktop/JavaCoding/JavaExercises

Exercise is to make class that extends String and has some method.
The point being that one cannot inherit from a Final class such as 
String class. You get an error at compile time:
error: cannot inherit from final String
class ExtendingString extends String 
                              ^
To remove the compilation error, all you have to do is remove the 
'extends String' 
*/

public class FinalMeansNoChange //Day10 ex7
{
	public static void main(String args[])
	{
		ExtendingString es=new ExtendingString();
		es.printEven("Abracadabra");
	}
}

//class ExtendingString extends String 
class ExtendingString
{
	public void printEven(String word)
	{
		System.out.println("Even characters in: "+word+" are: ");
		for(int i=1;i<word.length();i=i+2)
		{
			System.out.println(word.charAt(i));
		}
	}
}