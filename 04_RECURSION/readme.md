<h1>Recursion</h1>

Calculating Fibonacci numbers<br/>
Iteration vs Recursion vs Recursion with Memoization.

On the whole, it would seem that iteration comes out marginally better than
recursion-with-memoization.
Recursion-without-memoization is very slow indeed.

(Ex 5.2b) the iterative method computes the 15th Fibonacci number in ~10,000
nanoseconds while the recursive method computes the 15th in ~200,000 nanoseconds.

(Ex 14.1) the recursive method computes the 15th in ~200,000 nanoseconds, while
the recursive with memoization method computes the 15th in ~6,000 nanoseconds.

Thus, for the 15th Fibonacci number, the fastest to slowest computation is:

**In summary**<br/>
Fastest:  Recursive with memoization      (~6,000)<br/>
Mid:      Iterative                       (~10,000)<br/>
Slowest:  Recursive (without memoization) (~200,000)<br/>

---

45th

(Ex 5.2b) the iterative method computes the 45th Fibonacci number in ~22,000.
nanoseconds while the recursive method computes the 45th in ~4,000,000,000 nanoseconds.

(Ex 14.1) the recursive method computes the 45th in ~200,000 nanoseconds, while
the recursive with memoization method computes the 45th in ~6,000 nanoseconds.

Thus, for the 45th Fibonacci number, the fastest to slowest computation is:

Fastest:      Iterative                       (~22,000)
Mid:          Recursive with memoization      (~30,000)
Slowest:      Recursive (without memoization) (~4,000,000,000) i.e. about 4 secs.