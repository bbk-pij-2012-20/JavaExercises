Look at the attached program ComputationLauncher for an example of a heavy
computation being performed in sequence or in parallel using more than one
processor at the same time.

In an old machine with two processors, the output looks like:

Result: 7.999582837247596E14
Time without threads: 11110ms
Result: 7.999582837247596E14
Time with threads: 6326ms

Make sure you understand how the program works. How would you modify the program
if your machine had four processors? You can see how many processors (or cores)
your machine has by reading the value of:

Runtime.getRuntime().availableProcessors();

I've left the teacher code (ComputationLauncher and Computation) as is, and put my
modified versions below, so that both sets of code, before and after, can be seen)

Notes:
Difference between a wait() and sleep() (from StackOverFlow):
A wait() can be "woken up" by another process calling notify() on the 'monitor' which
is being waited on whereas a sleep() cannot. Also a wait() (and notify()) must happen
in a block synchronized on the monitor object whereas sleep() does not.


What I changed from ComputationLauncher:
Instead of having a fixed number of Computation objects, I made an array of Computation,
the size of which was determined by how many CPUs the computer running the code has.
(In this case, there are four). A Thread array is also made accordingly and their
initialisations are performed in a for-loop in launch().
Both the sequential and parallel computations are carried out via a for-loop.
