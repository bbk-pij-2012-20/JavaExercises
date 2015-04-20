// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/12_CONCURRENCY
// Exercise 17.2: Introduction to concurrency

/*
Have a look at the following code.
What will be the value of the counter at the end of its execution?
Compile and execute this code several times. Do you get the result you expected?
Do you get always the same result?
What would you change to make sure the last value of the counter is what it should be?
*/

public class Increaser implements Runnable {

  private Counter c;

  public Increaser(Counter counter) {

      this.c = counter;

  }

  public static void main(String args[]) {

    Counter counter = new Counter();

    for (int i = 0; i < 100; i++) {

      Increaser increaserTask = new Increaser(counter);
      Thread t = new Thread(increaserTask);
      t.start();
    }

  }

  public void run() {

    System.out.println("Starting at " + c.getCount());

    for (int i = 0; i < 1000; i++) {

      c.increase();

    }

    System.out.println("Stopping at " + c.getCount());

  }

}

class Counter {

  private int n = 0;

  public void increase() {

    n++;

  }

  public int getCount() {

    return n;

  }

}
