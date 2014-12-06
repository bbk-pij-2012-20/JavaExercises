// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/recursion
// Exercise 5.2b (Recursion, recursion vs iteration).
/* 
Write a small program with a method that calculates the nth element of the Fibonacci sequence as seen in the notes.
Is it easy to do this both iteratively and recursively? Try both ways and see which is more natural for you. If
one takes too long, try the other way.
When doing it recursively, do it with and without memoization. Compare the time that is needed in each case
to find F(40) or F(45).

The sequence of Fibonacci numbers starts off like this: 
1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, and so on..
*/

/*
public class FibonacciRec {

	public static void main(String[] args) {
	
		System.out.println("Which nth Fibonacci number do you want?");
		String input = System.console().readLine();
		int number = Integer.parseInt(input);
					
		int result = fibonacciAt(number);
		System.out.printf(number + "th Fibonacci = %s\n", result);
		
	}

	public static int fibonacciAt(int n) {
	
		if (n < 1) {
		
			System.out.println("no Fibonacci of negative nos.");
			return 0;
		
		}
		
		if (n == 1 || n == 2) {
		
			return 1;
		
		} else {
		
			return fibonacciAt(n - 1) + fibonacciAt(n - 2);
		
		}
	}
}
*/

/* ITERATIVELY:     1  		2 		3		4	  5	  6	  7  	8
					1  		1  		2		3	  5	  8	  13	21
				  fibN_2  fibN_1   fib_N
						  fibN_2   fibN_1  fib_N
*/
public class FibonacciRec {

	public static void main(String[] args) {
	
		System.out.println("input a whole, positive number");
		String inputStr = System.console().readLine();
		int n = Integer.parseInt(inputStr);
//		System.out.printf("fibo at %s = \n %d", inputNum, fibAt(inputNum));	
		System.out.println("fibo at " + n + " = " + fibAt(n));	

	}
			
	public static int fibAt(int n) {
	
		int fib_N = 0; 
		int fibN_1 = 1;
		int fibN_2 = 1;
		
		if (n == 1 || n == 2) {
		
			fib_N = 1;
		
		} else if (n > 2) {
		
			for (int i = 3; i <= n; i++) {    

				fib_N = fibN_1 + fibN_2; 
				fibN_2 = fibN_1;
				fibN_1 = fib_N;

			}

		}
		
		return fib_N;
	
	}

}


 
// Memoization is a technique whereby we keep track of the values already calculated in an array.
// arrays are 0-based, so F(1) is stored at position 0, etc
/*
public class FibonacciRec {

	public static void main(String[] args) {
	
		private int[] precalculated = null;
		
		public int fib(int n) {
		
			if (precalculated == null) {
				
				precalculated = new int[n];
				
				for (int i = 0; i < precalculated.length; i++) {
				
					precalculated[i] =- 1; 
					// to indicate "not calculated yet" 
				
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
	
	}

}
// ...additional code would go here...
*/
