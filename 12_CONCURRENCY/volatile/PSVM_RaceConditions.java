// cd /Users/Shahin/Desktop/all_pooled/computing/CODING/JavaExercises/12_CONCURRENCY/volatile

/*
This is based on example given in Oracle's language specification (chapter 8).

Two threads are created, one calls method1 and the other calls method2.
This class uses methods and variables in LearningAboutVolatile.java that are not thread-safe - race conditions are observed.

Compare to LearningAboutVolatile_PSVM_Synchronized and LearningAboutVolatile_PSVM_Volatile
*/

public class PSVM_RaceConditions {

  protected int counter = 0;

  public static void main(String[] args) {

    PSVM_RaceConditions rc = new PSVM_RaceConditions();

    Runnable r = new RepeatedlyCallsMethod1(rc);
    Runnable r2 = new RepeatedlyCallsMethod2(rc);
    Thread t = new Thread(r);
    Thread t2 = new Thread(r2);

    t.start();
    t2.start();

  }

}

class RepeatedlyCallsMethod1 implements Runnable {

  private PSVM_RaceConditions rc = null;

  public RepeatedlyCallsMethod1(PSVM_RaceConditions rc) {

    this.rc = rc;

  }

  @Override
  public void run() {

    final long start = System.currentTimeMillis();

    while (rc.counter < 1000) {

      LearningAboutVolatile.method1();

      try {

        Thread.sleep(1);

      } catch (InterruptedException e) {

        System.out.println("thread interrupted");

      }

      rc.counter++;

    }

    final long end = System.currentTimeMillis();
    long duration = end - start;
    System.out.println("Duration with race conditions: " + duration + " ms");

  }

}

class RepeatedlyCallsMethod2 implements Runnable {

  private PSVM_RaceConditions rc = null;

  public RepeatedlyCallsMethod2(PSVM_RaceConditions rc) {

    this.rc = rc;

  }

  @Override
  public void run() {

    while (rc.counter < 1000) {

      LearningAboutVolatile.method2();

      try {

        Thread.sleep(1);

      } catch (InterruptedException e) {

        System.out.println("thread interrupted");

      }

    }

  }

}
