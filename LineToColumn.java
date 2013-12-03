//cd desktop/JavaCoding/JavaExercises

/* Day 3, ex 4 - Line to column
Write a program that reads some text from the user and then 
writes the same text on screen, but each letter on a 
different line.
Now modify your program to write each word (as defined by 
spaces) rather than letter on a different line.*/

public class LineToColumn
{
	public static void main(String args[])
	{
		System.out.println("enter some text");
		String input=System.console().readLine();
/*		for(int i=0;i<input.length();i++)
		{
			System.out.println("character at: "+(i+1)+" is "+input.charAt(i));
		} */
		int startPos=0;
		int j=1;
		System.out.println("String is: "+input);
		for(int i=0;i<input.length();i++)
		{
			if(input.charAt(i)==' ')
			{
				System.out.println("word no: "+(j)+" is "+input.substring(startPos,i));			
				startPos=i+1;
				j++;
			}
			else if(i==input.length()-1)
			{
				System.out.println("word no: "+(j)+" is "+input.substring(startPos,i));							
			}
		}
	}
}