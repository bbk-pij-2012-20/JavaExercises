// cd desktop/JavaCoding/JavaExercises
/* Day3 Ex11 - Text2number
Write a program that reads a number with commas and decimal 
dots (such as “23,419.34”) and then prints a number that is 
half of it. Do not use Double.parseDouble().
If you were writing a simple spreadsheet, you could use this 
code to parse the input in the cells.
*/
public class Text2Number
{
	public static void main(String args[])
	{
		System.out.println("enter big number, e.g. 23,419.34");
		String input=System.console().readLine();
		String inputLess="";
		boolean stop=false;
		int n=0;
		System.out.println("input is: "+input);
		System.out.println("input char at 0: "+input.charAt(n));
		
		while(n<input.length())
		{
			if(input.charAt(n)==','||input.charAt(n)=='.')
			{
				n++;
				continue;
			}
			else
			{
				inputLess+=input.charAt(n);
				n++;
			}
		}
		System.out.println("inputLess is: "+inputLess);
		
		int inputLessInt=Integer.parseInt(inputLess);
		int halfInt=inputLessInt/2;
		String halfString=""+halfInt;
		System.out.println("halfString "+ halfString);
		String output="";
		int counter=0;		

		for(int i=halfString.length()-3;i>=0;i--)
		{
			output=halfString.charAt(i)+output;
			counter++;
			if(counter%3==0&&i>0)
			{
				output=','+output;
			}
		}
		output=output+'.'+halfString.substring(halfString.length()-2,halfString.length());
		System.out.println("half of "+input+" = "+output);
	}
}