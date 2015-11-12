// cd /Users/Shahin/Desktop/all_pooled/computing/CODING/JavaExercises/12_CONCURRENCY/volatile

/*
Trying the example given in Oracle's language specification (chapter 8)

i and j have no locks nor volatile modifiers - race conditions ensue !
synch_i and synch_j are accessed by synchronized methods - avoids race conditions by securing mutual exclusion to the shared variables.
vol_i and vol_j are not accessed by synchronized methods but have volatile modifiers - also avoid race conditions by making sure access to updated values is consistent across separate threads.
*/

public class LearningAboutVolatile {

  private static int i = 0;
  private static int j = 0;
  private static int synch_i = 0;
  private static int synch_j = 0;
  private static volatile int vol_i = 0;
  private static volatile int vol_j = 0;

  /**
  * non-synchronized method number 1
  */
  public static void method1() {

    i++;
    j++;

  }

  /**
  * non-synchronized method number 2
  */
  public static void method2() {

    System.out.println("i - j " + (i - j));

  }

  /**
  * synchronized method number 1
  */
  public static synchronized void synch_method1() {

    synch_i++;
    synch_j++;

  }

  /**
  * synchronized method number 2
  */
  public static synchronized void synch_method2() {

    System.out.println("synch_i - synch_j " + (synch_i - synch_j));

  }

  /**
  * non-synchronized method number 1 accessing volatile shared variables
  */
  public static void method1() {

    vol_i++;
    vol_j++;

  }

  /**
  * non-synchronized method number 2 accessing volatile shared variables
  */
  public static void method2() {

    System.out.println("vol_i - vol_j " + (vol_i - vol_j));

  }

}
