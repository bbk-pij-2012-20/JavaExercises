// cd /Users/Shahin/Desktop/all_pooled/computing/CODING/JavaExercises/12_CONCURRENCY/volatile

/*
This is based on example given in Oracle's language specification (chapter 8).

Two threads are created, one calls synch_method1 and the other calls synch_method2.
This class uses methods and variables in LearningAboutVolatile.java that are thread-safe.

Compare to LearningAboutVolatile_PSVM_RaceConditions and LearningAboutSynchronized_PSVM_Volatile
*/

public class PSVM_Synchronized {

  protected int counter = 0;

  public static void main(String[] args) {

    PSVM_Synchronized syn = new PSVM_Synchronized();

    Runnable r = new RepeatedlyCallsSynchMethod1(syn);
    Runnable r2 = new RepeatedlyCallsSynchMethod2(syn);
    Thread t = new Thread(r);
    Thread t2 = new Thread(r2);

    t.start();
    t2.start();

  }

}

class RepeatedlyCallsSynchMethod1 implements Runnable {

  private PSVM_Synchronized syn = null;

  public RepeatedlyCallsSynchMethod1(PSVM_Synchronized syn) {

    this.syn = syn;

  }

  @Override
  public void run() {

    final long start = System.currentTimeMillis();

    while (syn.counter < 1000) {

      LearningAboutVolatile.synch_method1();

      try {

        Thread.sleep(1);

      } catch (InterruptedException e) {

        System.out.println("thread interrupted");

      }

      syn.counter++;

    }

    final long end = System.currentTimeMillis();
    long duration = end - start;
    System.out.println("Duration with synchronized: " + duration + " ms");

  }

}

class RepeatedlyCallsSynchMethod2 implements Runnable {

  private PSVM_Synchronized syn = null;

  public RepeatedlyCallsSynchMethod2(PSVM_Synchronized syn) {

    this.syn = syn;

  }

  @Override
  public void run() {

    while (syn.counter < 1000) {

      LearningAboutVolatile.synch_method2();

      try {

        Thread.sleep(1);

      } catch (InterruptedException e) {

        System.out.println("thread interrupted");

      }

    }

  }

}
