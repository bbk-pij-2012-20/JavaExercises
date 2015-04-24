<h3>2 different versions</h3>

Version 2

I noticed that subtley modifying the teacher code to set up and run 4 threads has the expected outcome of speeding up the parallel processing 4 times, as compared to twice for the original code which uses only 2 threads.


Version 3

However, attempting to build an array of Computations and Threads that are initialised at runtime according to how many CPUs the computer has (which is determined by Runtime.getRuntime().availableProcessors()) appears to produce the same speed as the sequential processing. I'm not yet sure why this is.
