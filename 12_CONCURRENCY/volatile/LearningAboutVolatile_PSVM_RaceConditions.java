// cd /Users/Shahin/Desktop/all_pooled/computing/CODING/JavaExercises/12_CONCURRENCY/volatile

/*
This is based on example given in Oracle's language specification (chapter 8).

Two threads are created, one calls method1 and the other calls method2.
This class uses methods and variables in LearningAboutVolatile.java that are not thread-safe - race conditions are observed.

Compare to LearningAboutVolatile_PSVM_Synchronized and LearningAboutVolatile_PSVM_Volatile
*/

public class LearningAboutVolatile_PSVM_RaceConditions {

  boolean running = true;

  public static void main(String[] args) {

    final long start = System.currentTimeMillis();
    LearningAboutVolatile_PSVM l = new LearningAboutVolatile_PSVM();
    Runnable r = new RepeatedlyCallsMethod1(l);
    Runnable r2 = new RepeatedlyCallsMethod2(l);
    Thread t = new Thread(r);
    Thread t2 = new Thread(r2);

    t.start();
    t2.start();

  }

}

class RepeatedlyCallsMethod1 implements Runnable {

  LearningAboutVolatile_PSVM l = null;

  public RepeatedlyCallsMethod1(LearningAboutVolatile_PSVM l) {

    this.l = l;

  }

  @Override
  public void run() {

    while (l.running) {

      LearningAboutVolatile.method1();

      try {

        Thread.sleep(10);

      } catch (InterruptedException e) {

        System.out.println("thread interrupted");

      }

    }

  }

}

class RepeatedlyCallsMethod2 implements Runnable {

  LearningAboutVolatile_PSVM l = null;

  public RepeatedlyCallsMethod2(LearningAboutVolatile_PSVM l) {

    this.l = l;

  }

  @Override
  public void run() {

    while (l.running) {

      LearningAboutVolatile.method2();

      try {

        Thread.sleep(10);

      } catch (InterruptedException e) {

        System.out.println("thread interrupted");

      }

    }

  }

}
