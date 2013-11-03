public class Day8Ex5Hash
{
	public static void main(String[] args)
	{
		System.out.println("Give me a string, I'll calculate its hash code"); 
		String str=System.console().readLine();
		int hash=str.hashCode();
		int smallHash=HashUtilities.shortHash(hash); 
		System.out.println("0 < "+smallHash+" < 1000");
	}
}