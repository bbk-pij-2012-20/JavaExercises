// cd ~/Desktop/all_pooled/computing/CODING/JavaExercises/04_RECURSION/Memoization
// Ex 14.1: Memoization for performance gain with larger recursive computations.

/*
There is a major, but solvable, problem with the original form of Fibonacci
recursive code (in RECURSION Exercise 5.2b), also included below in NoMemo class.

The problem is that the greater the value of n, the more repetitions of the same
calculations occur. This is wasteful and the performance of the algorithm
exponentially deteriorates.

The solution to avoid repeating the code is to use a technique in which each
Fibonacci number that is calculated is stored, such as in an array.
This technique is called "memoization".
*/

/**
* The code below performs two different recursive Fibonacci computations.
* One is the original form with no memoization (in the class 'NoMemo').
* The other uses memoization and the main method compares the time taken between
* the two approaches for recursive methods to compute the 5th, 10th, 20th, 30th,
* 40th, 45th and 50th Fibonacci numbers.
*
* Result:
* While the 5th Fibonacci number computation is actually marginally
* slower with memoization, the rest from 10th upwards becoming increasing more
* efficient with memoization, with 10th being computated in about 4 times less
* time. The difference then increases exponentially with the 45th Fibonacci
* number being calculated about 120,000 times faster with memoization than
* without.
*/
public class NoMemoVsMemoPSVM {

	public static void main(String args[]) {

		NoMemo nonMemo = new NoMemo();
		Memoization memoize = new Memoization();
		long start, end, nonMemoTime, memoTime = 0;
		int result = 0;

		start = System.nanoTime();
		result = nonMemo.fib(5);
		end = System.nanoTime();
		nonMemoTime = end - start;
		System.out.println("calling fib(5), (Not using memoization). The result is: " + result + ". Time taken: " + nonMemoTime + " nanosecs");
		start = System.nanoTime();
		result = memoize.fib(5);
		end = System.nanoTime();
		memoTime = end - start;
		System.out.println("calling fib(5), (Using memoization). The result is: " + result + ". Time taken: " + memoTime + " nanosecs");
		System.out.println("using memoization for fib(5) was " + (nonMemoTime / memoTime) + " times faster than recusion without memoization \n");

		start = System.nanoTime();
		result = nonMemo.fib(10);
		end = System.nanoTime();
		nonMemoTime = end - start;
		System.out.println("calling fib(10), (Not using memoization). The result is: " + result + ". Time taken: " + nonMemoTime + " nanosecs");
		memoize = new Memoization();
		start = System.nanoTime();
		result = memoize.fib(10);
		end = System.nanoTime();
		memoTime = end - start;
		System.out.println("calling fib(10), (Using memoization). The result is: " + result + ". Time taken: " + memoTime + " nanosecs");
		System.out.println("using memoization for fib(10) was " + (nonMemoTime / memoTime) + " times faster than recusion without memoization \n");

		start = System.nanoTime();
		result = nonMemo.fib(20);
		end = System.nanoTime();
		nonMemoTime = end - start;
		System.out.println("calling fib(20), (Not using memoization). The result is: " + result + ". Time taken: " + nonMemoTime + " nanosecs");
		memoize = new Memoization();
		start = System.nanoTime();
		result = memoize.fib(20);
		end = System.nanoTime();
		memoTime = end - start;
		System.out.println("calling fib(20), (Using memoization). The result is: " + result + ". Time taken: " + memoTime + " nanosecs");
		System.out.println("using memoization for fib(20) was " + (nonMemoTime / memoTime) + " times faster than recusion without memoization \n");

		start = System.nanoTime();
		result = nonMemo.fib(30);
		end = System.nanoTime();
		nonMemoTime = end - start;
		System.out.println("calling fib(30), (Not using memoization). The result is: " + result + ". Time taken: " + nonMemoTime + " nanosecs");
		memoize = new Memoization();
		start = System.nanoTime();
		result = memoize.fib(30);
		end = System.nanoTime();
		memoTime = end - start;
		System.out.println("calling fib(30), (Using memoization). The result is: " + result + ". Time taken: " + memoTime + " nanosecs");
		System.out.println("using memoization for fib(30) was " + (nonMemoTime / memoTime) + " times faster than recusion without memoization \n");

		start = System.nanoTime();
		result = nonMemo.fib(40);
		end = System.nanoTime();
		nonMemoTime = end - start;
		System.out.println("calling fib(40), (Not using memoization). The result is: " + result + ". Time taken: " + nonMemoTime + " nanosecs");
		memoize = new Memoization();
		start = System.nanoTime();
		result = memoize.fib(40);
		end = System.nanoTime();
		memoTime = end - start;
		System.out.println("calling fib(40), (Using memoization). The result is: " + result + ". Time taken: " + memoTime + " nanosecs");
		System.out.println("using memoization for fib(40) was " + (nonMemoTime / memoTime) + " times faster than recusion without memoization \n");

		start = System.nanoTime();
		result = nonMemo.fib(45);
		end = System.nanoTime();
		nonMemoTime = end - start;
		System.out.println("calling fib(45), (Not using memoization). The result is: " + result + ". Time taken: " + nonMemoTime + " nanosecs");
		memoize = new Memoization();
		start = System.nanoTime();
		result = memoize.fib(45);
		end = System.nanoTime();
		memoTime = end - start;
		System.out.println("calling fib(45), (Using memoization). The result is: " + result + ". Time taken: " + memoTime + " nanosecs");
		System.out.println("using memoization for fib(45) was " + (nonMemoTime / memoTime) + " times faster than recusion without memoization \n");

	}

}

class NoMemo {

	/**
	*	returns the nth Fibonacci number
	*/
	public static int fib(int n) {

		if ((n == 1) || (n == 2)) {

			return 1;

		} else {

			int result = fib(n - 1) + fib(n - 2);
			return result;

    }

	}

}

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

	/**
	* Initialisation involves setting the length of the array, first two elements, then the remainder
	*/
	public void initPrecalculatedArray(int n) {

		precalculated = new int[n];
		precalculated[0] = 1;
		precalculated[1] = 1;

		for (int i = 2; i < precalculated.length; i++) {

			precalculated[i] =- 1;

		}

	}

}
