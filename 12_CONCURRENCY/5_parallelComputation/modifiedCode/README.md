<h3>Multithreading with blocking and non-blocking</h3>

sharedVariable

Modifying the original teacher's code to increase the number of threads to 4,
resulted in the computation completing about 3-4 times as fast.
Notably, there was no increase in speed when the threads and Computation objects
were created in arrays.


noSharedVariable

However, the latter problem seemed to be addressed by unlocking the code in
Computation (called ComputationVersion4). The blocking that was enforced and
released by wait() and notifyAll() to protect the shared variable result,
by synchronized blocks was removed.
Instead, I made a result array in which every result is held in every thread,
but each thread only performs its computation on the result value that
corresponds to that thread, while not touching the others.

Using this approach, the increase in speed of processing was atleast 7000 times!
