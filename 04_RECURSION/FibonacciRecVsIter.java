// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/recursion
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

public class FibonacciRecVsIter {

	public static void main(String[] args) {

		int nth, result = 0;
		long start, end = 0;

		System.out.println("Which nth Fibonacci number do you want?");
		nth = Integer.parseInt(System.console().readLine());
		FibonacciRecursive fibRec = new FibonacciRecursive();

		start = System.currentNanoTime();
		result = fibRec.fib(nth);
		end = System.currentNanoTime();
		System.out.printf(nth + "th Fibonacci with recursive method = %s\n", result);

		System.out.println("input a whole, positive number");
		String inputStr = System.console().readLine();
		int n = Integer.parseInt(inputStr);
//	System.out.printf("fibo at %s = \n %d", inputNum, fibAt(inputNum));
		System.out.println("fibo at " + n + " = " + fibAt(n));

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

			return fibonacciAt(n - 1) + fibonacciAt(n - 2);

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
