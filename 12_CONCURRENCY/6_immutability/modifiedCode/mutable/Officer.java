// cd ~/Desktop/all_pooled/computing/CODING/JavaExercises/12_CONCURRENCY/6_immutability/modifiedCode/mutable
// Exercise 17.6: Introduction to concurrency
/*
I think Citizen & Officer can be refered to as 'clients' of the mutable class
(MutableIDCard), so according to rule#5 (see readme), I should make sure that
neither can obtain references to the mutable fields of MutableIDCard (which
include Date and BufferedImage). Hence I am creating a 'defensive copy' of
MutableIDCard in the constructor. (Is this correct?)
*/
import java.util.Random;

public class Officer implements Runnable {

  private MutableIDCard id;

  public Officer(MutableIDCard id) {

    this.id = new MutableIDCard(id);// making a defensive copy

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
    id.set(name, dateOfBirth, photo);

  }

}
