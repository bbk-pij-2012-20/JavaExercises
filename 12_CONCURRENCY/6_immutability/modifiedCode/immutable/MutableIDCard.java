// cd ~/Desktop/all_pooled/computing/CODING/JavaExercises/12_CONCURRENCY/6_immutability/modifiedCode/immutable
// Exercise 17.6: Introduction to concurrency

/*Applying Bloch's five rules (see readme) to make the mutable object immutable*/
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.image.BufferedImage;

public class MutableIDCard { // modified to be completely immutable

  private String name;
  private final Date dateOfBirth;//Date is mutable, so I added final to make it immutable
  private final BufferedImage photo;//Date is mutable, so I added final to make it immutable

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

    public MutableIDCard(MutableIDCard id) {

      set(id.getName(),
        (Date) id.getDateOfBirth().clone(),
          id.getPhoto().getSubimage(0,0,id.getPhoto.getWidth(),id.getPhoto().getHeight()));

    }

*/

  public void set(String name, Date dateOfBirth, BufferedImage photo) {

    check(name, dateOfBirth, photo);

//    synchronized(this) { //I removed synchronized block as fields are now immutable

      this.name = name;
      this.dateOfBirth = dateOfBirth;
      this.photo = photo;

//    }

  }

  public String getName() {//synchronized removed because name is immutable

    return name;

  }

  public Date getDateOfBirth() {//synchronized removed because the mutable field is now final

    return dateOfBirth;

  }

  public BufferedImage getPhoto() {//synchronized removed because the mutable field is now final

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
