<h1>Recursion</h1>

(Ex 5.2b & 14.1)<h3>Fibonacci numbers</h3><br/>
Recursion can be used to calculate the nth number in a famous sequence of numbers called the "Fibonacci numbers". It is named for 12th century mathematician Leonardi Bonacci who was instrumental in bringing awareness of Eastern mathematics to Europe. (The numbers series dates as far back as 200 BC in Sanskrit prosody). It is widely observed in nature.

The Fibonacci number-related exercises (5.2b and 14.1) cover three different approaches to coding a computation that returns the nth Fibonacci number. They are:<br/>

<h4>Iteration vs Recursion vs Recursion-with-Memoization.</h4>


<h4>Times taken to calculate the 15th Fibonacci number</h4>


(Ex 5.2b) the iterative method computes the 15th Fibonacci number in ~10,000
nanoseconds while the recursive method computes the 15th in ~200,000 nanoseconds.

(Ex 14.1) the recursive method computes the 15th in ~200,000 nanoseconds, while
the recursive with memoization method computes the 15th in ~6,000 nanoseconds.

Thus, for the 15th Fibonacci number, the fastest to slowest computation is:

<h4>In summary</h4>

Fastest:&nbsp;&nbsp;&nbsp;&nbsp;Recursive with memoization&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ~ **6,000 ns**<br/>
Mid:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Iterative&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ~ **10,000 ns**<br/>
Slowest:&nbsp;&nbsp;&nbsp;Recursive (without memoization)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;~ **200,000 ns**<br/>

---

<h4>Times taken to calculate the 45th Fibonacci number</h4>


(Ex 5.2b) the iterative method computes the 45th Fibonacci number in ~22,000.
nanoseconds while the recursive method computes the 45th in ~4,000,000,000 nanoseconds.

(Ex 14.1) the recursive method computes the 45th in ~200,000 nanoseconds, while
the recursive with memoization method computes the 45th in ~6,000 nanoseconds.

Thus, for the 45th Fibonacci number, the fastest to slowest computation is:

<h4>In summary</h4>

Fastest:&nbsp;&nbsp;&nbsp;&nbsp;Iterative&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;~ **22,000 ns**<br/>
Mid:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Recursive with memoization&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;~ **30,000 ns**<br/>
Slowest:&nbsp;&nbsp;&nbsp;Recursive (without memoization)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;~ **4,000,000,000 ns** (i.e. about 4 secs)<br/>

---

<h3>Conclusion</h3>

On the whole, it would seem that iteration comes out marginally better than
recursion-with-memoization for the larger calculation of 45th.<br/> Iteration is
marginally slower than recursion-with-memoization for the 15th.<br/>
Recursion-without-memoization is more than 20-fold slower for 15th and as
much as 200,000 times slower for the 45th.

Thus, despite these exercises (5.1-5.8 & 14.1-14.7) being about recursion, it would seem that for the Fibonacci series, the
