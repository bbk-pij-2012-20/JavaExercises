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
public class MutableIDCard { // modified to be completely immutable

  private String name;
  private Date dateOfBirth;//Date is mutable
  private BufferedImage photo;

  public MutableIDCard(String name, Date dateOfBirth, BufferedImage photo) {

    this.name = name;
    this.dateOfBirth = dateOfBirth;
    this.photo = photo;

  }

  // rule 1: Don’t provide any methods that modify the object’s state
  public void set(String name, Date dateOfBirth, BufferedImage photo) {

    check(name, dateOfBirth, photo);

    synchronized(this) {//synchronized block within a mutator

      this.name = name;
      this.dateOfBirth = dateOfBirth;
      this.photo = photo;

    }

  }

  public synchronized String getName() {//synchronized accessor

    return name;

  }

  public synchronized Date getDateOfBirth() {//synchronized accessor

    return dateOfBirth;

  }

  public synchronized BufferedImage getPhoto() {//synchronized accessor

    return photo;

  }

  public void check(String name, Date dateOfBirth, BufferedImage photo) {

    if (name == null || name.equals("")){

      throw new IllegalArgumentException();

    }

    if (dateOfBirth == null) {

      throw new IllegalArgumentException();

    }

    long age = getAge(dateOfBirth);

    if (dateOfBirth == null || age <= 0) {

      throw new IllegalArgumentException();

    }

    if (photo == null) {

      throw new IllegalArgumentException();

    }

  }

  private long getAge(Date dateOfBirth) {

    long now = new Date().getTime();
    long age = now - dateOfBirth.getTime();
    return age;

  }

}
