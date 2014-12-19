// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/ErrorHandling
// Exercise 15.5: Introduction to Error handling
/*
Create a class PrimeDivisorList. Integers (as in class Integer) can be added to/removed 
from the list. If a null number is passed to the add(Integer) method, a 
NullPointerException must be thrown. 
If a non-prime number is added, an IllegalArgumentException must be thrown.
Override the method toString() so that it returns something like: [ 2 * 3^2 * 7 = 126 ]
for a list containing one 2, two 3, and one 7.
Use the TDD methodology to create the class (interface,tests,implementation). 
You can base your class on classes and interfaces from the Java Collections Library.
*/
// Only done the exception part, not done the interface,TDD, or the toString override!
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