// cd ~/Desktop/all_pooled/computing/CODING/JavaExercises/12_CONCURRENCY/6_immutability/modifiedCode/immutable
// Exercise 17.6: Introduction to concurrency

/*Applying Bloch's five rules (see readme) to make the mutable object immutable*/
import java.util.Random;

public class Citizen implements Runnable {

  private final MutableIDCard id;// made immutable with 'final' keyword

  public Citizen(MutableIDCard id) {

    this.id = id;//no need for defensive copy here because MutableIDCard's fields are immutable now

  }

  public void run() {

    Random r = new Random();

    try {

      Thread.sleep(r.nextInt(2000));

    } catch (InterruptedException e) {

      e.printStackTrace();

    }

    String message = "";
    message += "the name on this id is " + id.getName() + "\n";
    message += "and the date of birth is " + id.getDateOfBirth();
    System.out.println(message);

  }

}
