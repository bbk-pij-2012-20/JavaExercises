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

public class Citizen implements Runnable {

  private MutableIDCard id;

  public Citizen(MutableIDCard id) {

    this.id = new MutableIDCard(id);// making a defensive copy

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
