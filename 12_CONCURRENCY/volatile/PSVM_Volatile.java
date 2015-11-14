// cd /Users/Shahin/Desktop/all_pooled/computing/CODING/JavaExercises/12_CONCURRENCY/volatile

/*
This is based on example given in Oracle's language specification (chapter 8).

Two threads are created, one calls synch_method1 and the other calls synch_method2.
This class uses methods and variables in LearningAboutVolatile.java that are thread-safe.

Compare to LearningAboutVolatile_PSVM_RaceConditions and LearningAboutSynchronized_PSVM_Volatile
*/

public class PSVM_Volatile {

  protected boolean running = true;

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

  @Override
  public void run() {

    while (true) {

      LearningAboutVolatile.vol_method1();

      try {

        Thread.sleep(5);

      } catch (InterruptedException e) {

        System.out.println("thread interrupted");

      }

    }

  }

}

class RepeatedlyCallsVolMethod2 implements Runnable {

  @Override
  public void run() {

    while (true) {

      LearningAboutVolatile.vol_method2();

      try {

        Thread.sleep(5);

      } catch (InterruptedException e) {

        System.out.println("thread interrupted");

      }

    }

  }

}
