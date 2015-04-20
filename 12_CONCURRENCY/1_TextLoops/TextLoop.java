// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/12_CONCURRENCY
// Exercise 17.1: Introduction to concurrency

/*
Look at the following code. What will the output be for each of the “thread”
and the “no threads” modes?
Compile and execute this code several times. Do you get the result you expected?
Run it several times. Do you always get the same result in ’mode 0’? And in mode 1?

ANS:
*/
public class TextLoop implements Runnable {

  public static final int COUNT = 10;
  private final String name;

  public TextLoop(String name) {

    this.name = name;

  }

  @Override
  public void run() {

    for (int i = 0; i < COUNT; i++) {

      System.out.println("Loop:" + name + ", iteration:" + i + ".");

    }

  }

  public static void main(String args[]) {

    if (args.length < 1 || (!args[0].equals("0") && !args[0].equals("1"))) {

      System.out.println("USAGE: java TextLoop <mode>");
      System.out.println(" mode 0: without threads");
      System.out.println(" mode 1: with threads");

    } else if (args[0].equals("0")) {

      for (int i = 0; i < 10; i++) {

        Runnable r = new TextLoop("Thread " + i);
        r.run();

      }

    } else {

      for (int i = 0; i < 10; i++) {

        Runnable r = new TextLoop("Thread " + i);
        Thread t = new Thread(r);
        t.start();
      }

    }

  }

}
