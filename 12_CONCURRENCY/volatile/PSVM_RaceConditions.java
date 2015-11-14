// cd /Users/Shahin/Desktop/all_pooled/computing/CODING/JavaExercises/12_CONCURRENCY/volatile

/*
This is based on example given in Oracle's language specification (chapter 8).

Two threads are created, one calls method1 and the other calls method2.
This class uses methods and variables in LearningAboutVolatile.java that are not thread-safe - race conditions are observed.

Compare to LearningAboutVolatile_PSVM_Synchronized and LearningAboutVolatile_PSVM_Volatile
*/

public class PSVM_RaceConditions {

  protected boolean running = true;

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

    int counter = 0;

    while (obj.running && counter < 100) {

      LearningAboutVolatile.method1();

      try {

        Thread.sleep(5);

      } catch (InterruptedException e) {

        System.out.println("thread interrupted");

      }

      counter++;

    }

  }

}

class RepeatedlyCallsMethod2 implements Runnable {

  private PSVM_RaceConditions rc = null;

  public RepeatedlyCallsMethod2(PSVM_RaceConditions rc) {

    this.rc = rc;

  }

  @Override
  public void run() {

    int counter = 0;

    while (rc.running && counter < 100) {

      LearningAboutVolatile.method2();

      try {

        Thread.sleep(5);

      } catch (InterruptedException e) {

        System.out.println("thread interrupted");

      }

      counter++;

    }

  }

}
