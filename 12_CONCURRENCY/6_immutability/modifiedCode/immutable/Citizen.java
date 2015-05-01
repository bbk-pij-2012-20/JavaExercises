// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/12_CONCURRENCY/6_immutability/modifiedCode/immutable
// Exercise 17.6: Introduction to concurrency

/*Applying Bloch's 5 rules (see readme) to make the mutable object immutable*/
public class Citizen implements Runnable {

  private final MutableIDCard id;// made immutable with 'final' keyword

  public Citizen(MutableIDCard id) {

    this.id = id;

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
