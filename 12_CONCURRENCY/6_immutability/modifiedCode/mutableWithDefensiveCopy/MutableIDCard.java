// cd ~/Desktop/all_pooled/computing/CODING/JavaExercises/12_CONCURRENCY/6_immutability/modifiedCode/mutable
// Exercise 17.6: Introduction to concurrency
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.image.BufferedImage;

public class MutableIDCard { // mutable teacherCode plus defensive and deep copies of mutable objects

  private String name;
  private Date dateOfBirth;
  private BufferedImage photo;

  public MutableIDCard(String name, Date dateOfBirth, BufferedImage photo) {

    this.name = name;
    this.dateOfBirth = dateOfBirth;
    this.photo = photo;

  }
/*
  rule#5. ensure exclusive access to any mutable components:
    . If your class has any fields that refer to mutable objects, ensure that
       clients of the class cannot obtain references to these objects.
    . Never initialise such a field to a client-provided object reference or
       return the object reference from an accessor.
    . Make defensive copies in constructors, accessors, and readObject methods.

    Making a deep copy to match up with the defensive copy made in Officer and Citizen.
*/
    public MutableIDCard(MutableIDCard id) {

      set(id.getName(),
        (Date) id.getDateOfBirth().clone(),
          id.getPhoto().getSubimage(0,0,id.getPhoto().getWidth(),id.getPhoto().getHeight()));

    }

  public void set(String name, Date dateOfBirth, BufferedImage photo) {

    check(name, dateOfBirth, photo);

    synchronized(this) {

      this.name = name;
      this.dateOfBirth = dateOfBirth;
      this.photo = photo;

    }

  }

  public synchronized String getName() {

    return name;

  }

  public synchronized Date getDateOfBirth() {

    return dateOfBirth;

  }

  public synchronized BufferedImage getPhoto() {

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
