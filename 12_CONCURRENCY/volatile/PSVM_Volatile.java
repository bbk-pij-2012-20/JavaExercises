// cd /Users/Shahin/Desktop/all_pooled/computing/CODING/JavaExercises/12_CONCURRENCY/volatile

/*
This is based on example given in Oracle's language specification (chapter 8).

Two threads are created, one calls synch_method1 and the other calls synch_method2.
This class uses methods and variables in LearningAboutVolatile.java that are thread-safe.

Compare to LearningAboutVolatile_PSVM_RaceConditions and LearningAboutSynchronized_PSVM_Volatile
*/

public class PSVM_Volatile {

  protected int counter = 0;

  public static void main(String[] args) {

    PSVM_Volatile vol = new PSVM_Volatile();

    Runnable r = new RepeatedlyCallsVolMethod1(vol);
    Runnable r2 = new RepeatedlyCallsVolMethod2(vol);
    Thread t = new Thread(r);
    Thread t2 = new Thread(r2);

    t.start();
    t2.start();

  }

}

class RepeatedlyCallsVolMethod1 implements Runnable {

  private PSVM_Volatile vol = null;

  public RepeatedlyCallsVolMethod1(PSVM_Volatile vol) {

    this.vol = vol;

  }

  @Override
  public void run() {

    final long start = System.currentTimeMillis();

    while (vol.counter < 1000) {

      LearningAboutVolatile.vol_method1();

      try {

        Thread.sleep(1);

      } catch (InterruptedException e) {

        System.out.println("thread interrupted");

      }

      vol.counter++;

    }

    final long end = System.currentTimeMillis();
    long duration = end - start;
    System.out.println("Duration with race conditions: " + duration + " ms");

  }

}

class RepeatedlyCallsVolMethod2 implements Runnable {

  private PSVM_Volatile vol = null;

  public RepeatedlyCallsVolMethod2(PSVM_Volatile vol) {

    this.vol = vol;

  }

  @Override
  public void run() {

    while (vol.counter < 1000) {

      LearningAboutVolatile.vol_method2();

      try {

        Thread.sleep(1);

      } catch (InterruptedException e) {

        System.out.println("thread interrupted");

      }

    }

  }

}
