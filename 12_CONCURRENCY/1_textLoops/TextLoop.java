// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/12_CONCURRENCY/1_textLoops
// Exercise 17.1: Introduction to concurrency

/*
Look at the following code. What will the output be for each of the “thread”
and the “no threads” modes?
Compile and execute this code several times. Do you get the result you expected?
Run it several times. Do you always get the same result in ’mode 0’? And in mode 1?

OUTPUT
------
MODE 0: Each iteration of run()'s for-loop is printed in order (from 0 to
COUNT) and this occurs for each iteration of the for-loop in PSVM(), also
in order. MODE 1: Each iteration of run()'s (though not sure how run()
gets called at all) for-loop is printed in random order, and this occurs
for each iteration of the for-loop in PSVM() which is also randomly ordered.
*/
public class TextLoop implements Runnable {

  public static final int COUNT = 5;
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

      for (int i = 0; i < COUNT; i++) {

        Runnable runnable = new TextLoop("Thread " + i);
        runnable.run();

      }

    } else if (args[0].equals("1")) {

      for (int i = 0; i < COUNT; i++) {

        Runnable runnable = new TextLoop("Thread " + i);
        Thread thread = new Thread(runnable);
        thread.start();

      }

    }

  }

}
