// cd /Users/Shahin/Desktop/all_pooled/computing/CODING/JavaExercises/12_CONCURRENCY/volatile

/**
* How to write an anonymous thread and start it in one go.
*/
public class AnonThreadCreation_PSVM {

  public static void main(String[] args) {

    // first thread
    new Thread(new Runnable() {

      @Override
      public void run() {

        for (int i = 0; i < 10; i++) {

          //doSmthg();

        }

      }

    }).start();

  }

}
