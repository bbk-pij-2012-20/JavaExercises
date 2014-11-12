//cd desktop/JavaCoding/JavaExercises
/*Day6 Ex2*/
public class DoWhileUnder
{
	public static void main(String args[])
	{
		int fail=0;
		int pass=0;
		int merit=0;
		int distinction=0; 
		boolean invalid=false;
		int mark;
		int student=0;
		do
		{
			System.out.println("Input a mark: ");
			String s=System.console().readLine();
			mark=Integer.parseInt(s);
			student++;
			if(mark<0||mark>100)
			{
				System.out.println("invalid");
				student--;
				continue;
			}
			else 
			{
				if(mark>69)
				{
					distinction++;
				}
				else if(mark>59)
				{
					merit++;
				}
				else if(mark>49)
				{
					pass++;
				}		
				else if(mark<50)
				{
					fail++;
				}
			}
		}
		while(mark!=-1&&!invalid);
		System.out.println(student+" students: "+distinction+" distinctions, "+merit+" merits, "+pass+" passes, "+fail+" fails.");
	}
}