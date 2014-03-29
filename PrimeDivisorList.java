//cd ~/Desktop/JavaCoding/JavaExercises
/*Day15 Ex5
Only done the exception part, not done the interface,TDD, or the 
toString override ! */
import java.lang.NullPointerException;
import java.lang.IllegalArgumentException;

public class PrimeDivisorList {
	private Integer firstInt = null;
	public static void add(Integer integer) {
		if (integer == null) {
			throw new NullPointerException();
		}
		if (!isPrime(integer)) {
			throw new IllegalArgumentException();
		}
//		new PrimeDivisorList(integer);
	}
	private static boolean isPrime(int integer) { 
		boolean prime = true;
		int n = integer - 1;
		while (n > 1 && prime) {
			if (integer % n == 0) {
				prime = false;
			} else {
				n--;
			}
		}
		return prime;
	}
	
	public static String toString() {
		
		return 
	}

	public static void main(String[] args) {
/*		try { 
			Integer n4 = null;
			add(3);
			add(7);
			add(16);
			add(n4);
			add(null);
*/		try { 		
			add(3);
			add(7);
			add(16);
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("that is SO null");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("caught you trying to pass a non-prime");
		}
		try { 
			Integer n4 = null;
			add(n4);
			add(null);
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("that is SO null");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("caught you trying to pass a non-prime");
		}
		
//		System.out.println("calculation using the integers: "+new PrimeDivisorList().toString());
	}	
}