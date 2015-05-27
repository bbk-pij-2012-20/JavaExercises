<h1>Recursion</h1>

Calculating Fibonacci numbers<br/>
Iteration vs Recursion vs Recursion with Memoization.

On the whole, it would seem that iteration comes out marginally better than
recursion-with-memoization.
Recursion-without-memoization is very slow indeed.

**Times taken to calculate the 15th Fibonacci number**<br/>

(Ex 5.2b) the iterative method computes the 15th Fibonacci number in ~10,000
nanoseconds while the recursive method computes the 15th in ~200,000 nanoseconds.

(Ex 14.1) the recursive method computes the 15th in ~200,000 nanoseconds, while
the recursive with memoization method computes the 15th in ~6,000 nanoseconds.

Thus, for the 15th Fibonacci number, the fastest to slowest computation is:

**In summary**  <br/>
Fastest:&nbsp;&nbsp;&nbsp;&nbsp;Recursive with memoization&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ~ **6,000 ns**<br/>
Mid:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Iterative&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ~ **10,000 ns**<br/>
Slowest:&nbsp;&nbsp;&nbsp;Recursive (without memoization)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;~ **200,000 ns**<br/>

---

**Times taken to calculate the 45th Fibonacci number**<br/>

(Ex 5.2b) the iterative method computes the 45th Fibonacci number in ~22,000.
nanoseconds while the recursive method computes the 45th in ~4,000,000,000 nanoseconds.

(Ex 14.1) the recursive method computes the 45th in ~200,000 nanoseconds, while
the recursive with memoization method computes the 45th in ~6,000 nanoseconds.

Thus, for the 45th Fibonacci number, the fastest to slowest computation is:

**In summary**  <br/>
Fastest........Iterative........................ ~22,000 ns<br/>
Mid............Recursive with memoization....... ~30,000 ns<br/>
Slowest........Recursive (without memoization).. ~4,000,000,000 ns (i.e. about 4 secs)<br/>
