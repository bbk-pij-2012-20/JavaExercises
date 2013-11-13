/* cd desktop/JAVA_CODING/JavaEx_noGIT/d12Ex_noGIT

Ex#3 is to practice "find bugs once" algorithm: 
Hence: reproduce bug manually (by adding a 2nd space between 
the "" on line 15), programmatically by adding new test 
to testing class (done in PersonTest), then fix it and check it. 

*/
public class PersonJU // JUnit day12 exercises
{	
	public static void main(String args[])
	{
//		String fullName="MrSpaced Out";
//		String fullName="MrSpaced  Out"; // <-- reproducing bug manually
		String fullName="MrSpaced   Out"; // <-- reproducing bug manually

		PersonJU pj=new PersonJU();
		String initials=pj.getInitials(fullName);
		System.out.println("\nName: "+fullName+". Initials: "+initials);
	}
	
	public String getInitials(String fullName)
	{
		String result="";
		String[] words=fullName.split(" "); 

//This for loop is just so I can see what the buggy split does.
		for(int i=0;i<words.length;i++)
		{
			System.out.print(words[i]+" ");
		}

		for(int i=0;i<words.length;i++)
		{
			while(words[i].equals("")&&i<(words.length-1))
			{
				i++;
			}
			words[i].trim();
			String nextInitial=""+words[i].charAt(0);
			
			result=result+nextInitial.toUpperCase(); 
		}
		return result;
	}
}