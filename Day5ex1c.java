/* This gives 'Exception in thread "main" java.lang.StackOverflowError' at runtime.

public class Day5ex1c
{
	public static void main(String[] args)
	{
		Day5ex1c d5=new Day5ex1c();
		d5.doggyMethod(4);
	}
	
	public String doggyMethod(int n)
	{
		String result=doggyMethod(n-3)+n+doggyMethod(n-2); 
		if(n<=0) 
		{
			return ""; 
		}
        return result;
    }
}
*/
public class Day5ex1c
{
	public static void main(String[] args)
	{
		Day5ex1c d5=new Day5ex1c();
		String stringToPrint=d5.doggyMethod(4);
		System.out.println(stringToPrint);
	}
	
	public String doggyMethod(int n)
	{
		if(n<=0) 
		{
			return ""; 
		}
		//SOFError solved by placing the bottom limit before 		
		//the recursive call instead of after it.
        String result=doggyMethod(n-3)+n+doggyMethod(n-2); 
        return result;
    }
}
