// cd ~/Desktop/JavaCoding/JavaExercises
/* Day8 Ex 5.1*/

public class HashUtilities {

	public static void main(String args[]) {
		System.out.println("Give me a string and I will calculate its hash code"); 
		String str = System.console().readLine();
		int hash = str.hashCode();
		int smallHash = HashUtilities.shortHash(hash); 
		System.out.println("0 < " + smallHash + " < 1000");
	}
	public static int shortHash(int n) {
		return 1+(Math.abs(n)%1000);
	}
}