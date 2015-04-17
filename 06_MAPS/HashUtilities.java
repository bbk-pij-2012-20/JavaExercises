// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/06_MAPS
// Exercise 8.5.1 (Introduction to Maps)

/*
Create a class HashUtilities that implements a simple hash function shortHash(int) that takes any integer and
returns an integer between 0 and 1000. You can use the modulo operator and the static function Math.abs(int)
for obtaining the absolute value of an integer.
Note that shortHash(int) is a pure function (it does not have any side effects), so it should be static. Then
you can call this method using the name of the class like HashUtilities.shortHash(int).
Every object in Java has the method hashCode(), that returns an int. Test your hash function by passing the
hash codes of different objects and verifying that it always returns a number between 0 and 1000, as in the following
example:
println "Give me a string and I will calculate its hash code";
String str = System.console().readLine();
int hash = str.hashCode();
int smallHash = HashUtilities.shortHash(hash);
System.out.println("0 < " + smallHash + " < 1000");
*/

public class HashUtilities {

	public static void main(String[] args) {

		HashUtilities hUtil = new HashUtilities();
		System.out.println("Input a word, to get its hashcode");
		int hash = System.console().readLine().hashCode();
		System.out.println("hashcode is: " + hash);
		System.out.println("short hashcode is: " + hUtil.shortH(hash));

	}

	private int shortH(int hash) {

		return 1 + (Math.abs(hash) % 999); //in this way the value will be BETWEEN 0 and 1000 (i.e. 1-999)

	}

}
