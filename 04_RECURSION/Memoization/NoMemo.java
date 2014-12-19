// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/RECURSION/Memoization
// Exercise 14.1: Introduction to Memoization

/* The original form of Fibonacci recursive code (in RECURSION Exercise 5.2b)
Problem with this code is that for larger numbers (i.e. n > 30), 
the same calculations will be repeated many times.

To avoid repeating the code many time, we can store the results of 
each calculation in an array - this is called "memoization".

(Memoization is encapsulated in separate class, see bottom.)
*/
public class NoMemo {

	public static void main(String args[]) {
	
		NoMemo nm1 = new NoMemo();
		Memoization m1 = new Memoization();
		System.out.println("calling fib(40), (Not using memoization). The result is: " + nm1.fib(40));
		System.out.println("calling fib(40), (Using memoization). The result is: " + m1.fib(40));
		m1 = new Memoization();
		System.out.println("calling fib(45), (Not using memoization). The result is: " + nm1.fib(45));
		System.out.println("calling fib(45), (Using memoization). The result is: " + m1.fib(45));	
	
	}
	
	public static int fib(int n) {
	
		if ((n == 1) || (n == 2)) {
		
			return 1;
		
		} else {
		
			int result = fib(n - 1) + fib(n - 2);
			return result;
        
        }

	}

}

/*
class Memoization {

// arrays are 0-based, so F(1) is stored at position 0, etc 
	private int[] precalculated=null;

	public int fib(int n) {
		
		if (precalculated == null) {
		
			precalculated = new int[n];
			
			for (int i = 0; i < precalculated.length; i++) {
			
				// to indicate "not calculated yet"
				precalculated[i] =- 1; 
				 
			}
		
		}
		
		if ((n == 1) || (n == 2)) {
		
			return 1;
		
		} else {
			
			if (precalculated[n - 1] != -1) {
			
				return precalculated[n - 1];
			
			} else {
				
				int result = fib(n - 1) + fib(n - 2);
				precalculated[n - 1] = result;
				return result;
			
			}
		
		}
	
	}
// ...additional code would go here...	
}
*/
/*
Improving the code clarity by moving the initialization of the array into a separate 
method and removing the first 'if' by moving the base cases (1 and 2) in the array at 
initialization.
*/

class Memoization {
// arrays are 0-based, so F(1) is stored at position 0, etc 
	private int[] precalculated = null;
	
	public int fib(int n) {
	
		if (precalculated == null) {
		
			initPrecalculatedArray(n);
		
		}
		
		if (precalculated[n - 1] != -1) {
		
			return precalculated[n - 1];
		
		} else {
			
			int result = fib(n - 1) + fib(n - 2);
			precalculated[n - 1] = result;
			return result;
		
		} 
	
	}
	
	public void initPrecalculatedArray(int n) {
	
		precalculated = new int[n]; 
		precalculated[0] = 1;
		precalculated[1] = 1;
		
		for (int i = 2; i < precalculated.length; i++) {
		
			precalculated[i] =- 1;
	
		}

	}

}