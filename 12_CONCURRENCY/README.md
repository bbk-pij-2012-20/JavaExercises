<h1>Concurrency</h1>

In Java, light-weight processes (aka threads) are able to enhance program performance by executing discrete tasks within a program - in different order within a processor (superscalar) and on different processors ('multicore'). My Macbook Pro, for example, has four CPUs.

Where Java objects are shared between different threads of execution, memory space can be shared. Although any particular process is unaware of other processes (i.e. it 'thinks' it has the entire memory space for itself!), memory space is still shared out between them by the JVM and operating system. Threads, on the other hand can actually share the same space. While each distinct thread has its own memory stack (just like distinct processes), it can share the heap with other threads such that objects within the heap can be read and written to by different threads. The latter is not the case for normal processes.

To make this multi-threading memory model thread-safe, Java offers the programmer a number of mechanisms. Three of these mechanisms are briefly explored in this set of exercises:

1. Monitors (synchronized)
2. Wait sets (wait( ), notify( ))
3. the Java.util.concurrency package (here we look at Executors)

Monitors

Each object in Java is associated with a monitor which can be locked and
unlocked by a thread. The monitor is an implementation of synchronization in
Java. Synchronization is one of the mechanisms for inter-thread communication in
Java. If a resource already has a lock on it, the thread trying to place a lock
on it must wait until the other thread unlocks, thereby facilitating exclusive
access to that resource.

Wait sets

Each object also has an associated 'wait set', which are a set of threads. This
is empty when thread is first created. Methods that act on the wait set are
wait(), notify() and notifyAll().

Java.util.concurrency - Executors

...

14 exercises (17.1-17.8 and 18.1-18.6)

Exercise 17.1:

Exercise 17.2:

Exercise 17.3:

Exercise 17.4:

Exercise 17.5:

Exercise 17.6:

Exercise 17.7:

Exercise 17.8:

Exercise 18.1:

Exercise 18.2:

Exercise 18.3:

Exercise 18.4:

Exercise 18.5:

Exercise 18.6:
