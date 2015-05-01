// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/12_CONCURRENCY/6_immutability/modifiedCode/immutable
// Exercise 17.6: Introduction to concurrency

/*Applying Bloch's five rules (see readme) to make the mutable object immutable*/
import java.util.Random;

public class Officer implements Runnable {

  private final MutableIDCard id;// made immutable with 'final' keyword

  public Officer(MutableIDCard id) {

    this.id = id;//no need for defensive copy here because MutableIDCard's fields are immutable now

  }

  public void run() {

    Random r = new Random();

    try {

      Thread.sleep(r.nextInt(2000));

    } catch (InterruptedException e) {

      e.printStackTrace();

    }

    String name = DataGenerator.getNextName();
    Date dateOfBirth = DataGenerator.getNextDate();
    BufferedImage photo = DataGenerator.getNextPhoto();
    id.set(name, dateOfBirth, photo); // rule 1. don’t provide any mutators!

  }

}
