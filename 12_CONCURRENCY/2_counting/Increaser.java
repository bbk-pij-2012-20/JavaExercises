// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/12_CONCURRENCY/2_counting
// Exercise 17.2: Introduction to concurrency

/*
Have a look at the following code.
What will be the value of the counter at the end of its execution?
Compile and execute this code several times. Do you get the result you expected?
Do you get always the same result?
What would you change to make sure the last value of the counter is what it should be?

reminder to myself:
start() creates a new thread, that executes the run() method.
run() just executes in the current thread, without starting a new thread.

I'm not entirely sure what the 'last value of the counter should be', but if I wrap run()'s
for-loop in a synchronized(this) block, it doesn't seem to be all that useful. If, in
addition I make the run() itself synchronized, still can't see that it achieves what I
think the exercise task is, i.e. that the stopping count should always be exactly 1000
greater than the starting count, but I can't tell which starting corresponds to which
stopping. It's all still a bit random in order.

I then also wrapped the for-loop in PSVM() in a static synchronized block. There's still
no guarantee of stopping being exactly 1000 more than starting.
The only way I think it may be possible is to not use concurrency at all. Hence, by
removing the instantiation of Thread and the thread.start(), and just replacing it with
increaserTask.run(), generating and running only a single thread.
*/

public class Increaser implements Runnable {

  private Counter counter;

  public Increaser(Counter counter) {

    this.counter = counter;

  }

  public static void main(String args[]) {

    Counter counter = new Counter();

    synchronized(Increaser.class) {

      for (int i = 0; i < 100; i++) {

        Increaser increaserTask = new Increaser(counter);
        Thread threadOfIncreaser = new Thread(increaserTask);
        threadOfIncreaser.start();

      }

    }

  }

  // note, Runnable's run() is not being overridden (The instantiation of Increaser is not
  // written as 'Runnanble increaserTask = new Increaser(counter)';
  public synchronized void run() {

    System.out.println("Starting at " + counter.getCount());

    synchronized(this) {

      for (int i = 0; i < 1000; i++) {

        counter.increase();

      }

    }

    System.out.println("Stopping at " + counter.getCount());

  }

}

class Counter {

  private int count = 0;

  public synchronized void increase() {

    count++;

  }

  public int getCount() {

    return count;

  }

}
