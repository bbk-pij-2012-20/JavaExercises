//cd desktop/JavaCoding/JavaExercises

/*day 3 ex5 - Counting letters
Write a program that reads some text from the user and then says 
how many letters ’e’ are there in that text. Then modify the 
program so that it reads the text from the user and then asks 
for a letter. The program should then say how many times you 
can find the letter in the text.*/

public class CountingLetters
{
	public static void main(String args[])
	{
		System.out.println("enter some text");
		String input=System.console().readLine();
		int noE=0;
		for(int i=0;i<input.length();i++)
		{
			if(input.charAt(i)=='e'||input.charAt(i)=='E')
			{
				noE++;
			}
		}
		System.out.println("Number of e letters in: "+input+" = "+noE);
	}
}