// cd ~/Desktop/all_pooled/computing/CODING/JavaExercises/04_RECURSION
// Exercise 5.2b (Recursion, recursion vs iteration).
/*
Write a small program with a method that calculates the nth element of the
Fibonacci sequence as seen in the notes.
Is it easy to do this both iteratively and recursively? Try both ways and see
which is more natural for you. If one takes too long, try the other way.
When doing it recursively, do it with and without memoization. Compare the time
that is needed in each case to find F(40) or F(45).

The sequence of Fibonacci numbers starts off like this:
1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, and so on..
*/

/**
* This class compares the speed of calculating the nth Fibonacci number with
* a recursive method as compared to an iterative method.
* The iterative method turns out to be faster the recursive method for all
* Fibonacci number computations. The difference increases significantly for
* nth numbers greater than about the 15th.
*
* For the 15th number, the iterative method is about 20x times faster than the
* recursive method.
* For the 45th number, the iterative method is about 20,000x times faster than
* the recursive method.
*/
public class FibonacciRecVsIter {

	public static void main(String[] args) {

		int nth, resultRec, resultIter = 0;
		long start, end, timeRec, timeIter = 0;

		System.out.println("Which nth Fibonacci number do you want?");
		nth = Integer.parseInt(System.console().readLine());
		FibonacciRecVsIter fRVI = new FibonacciRecVsIter();

		start = System.nanoTime();
		resultRec = fRVI.fibRecursive(nth);
		end = System.nanoTime();
		timeRec = end - start;
		start = System.nanoTime();
		resultIter = fRVI.fibIterative(nth);
		end = System.nanoTime();
		timeIter = end - start;
		System.out.printf(nth + "th Fibonacci with recursive method = %s. With iterative method = %s\n", resultRec, resultIter);
		System.out.printf("Recursive took %s nanosecs. Iterative took %s nanosecs\n", timeRec, timeIter);
		System.out.println("Thus, iterative method is " + (timeRec / timeIter ) + " times faster than recursive.");

	}

	/**
	*	Recursive version of Fibonacci method.
	*/
	public int fibRecursive(int n) {

		if (n < 1) {

			System.out.println("no Fibonacci of negative nos.");
			return 0;

		}

		if (n == 1 || n == 2) {

			return 1;

		} else {

			return fibRecursive(n - 1) + fibRecursive(n - 2);

		}

	}

	/**
	*	Iterative version of Fibonacci method.
	*/
	public int fibIterative(int n) {

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
