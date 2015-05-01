// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/12_CONCURRENCY/6_immutability/modifiedCode/immutable
// Exercise 17.6: Introduction to concurrency
/*
The teacherCode version currently has a mutable object (called MutableIDCard)
being passed between two threads (Officer and Citizen). But it has synchronised
the mutable object's mutator (called set(String, Date, BufferedImage). Furthermore,
its getters of its mutable fields (name, dateOfBirth and Photo) are synchronised.

So, in this solution, I am making MutableIDCard thoroughly immutable by following
J.Bloch's five rules which essentially amount to:
1. don’t provide any mutators.
2. make the class final.
3. make all fields final.
4. make all fields private.
5. ensure exclusive access to any mutable components. If your class has any
fields that refer to mutable objects, ensure that clients of the class cannot
obtain references to these objects. Never initialise such a field to a
client-provided object reference or return the object reference from an accessor.
Make defensive copies in constructors, accessors, and readObject methods.
*/
public class Officer implements Runnable {

  private MutableIDCard id;

  public Officer(MutableIDCard id) {

    this.id = id;

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
    id.set(name, dateOfBirth, photo); // rule 1: Don’t provide any methods that modify the object’s state

  }

}
