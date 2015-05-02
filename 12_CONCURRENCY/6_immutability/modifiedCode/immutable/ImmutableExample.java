// cd ~/Desktop/all_pooled/computing/CODING/JavaExercises/12_CONCURRENCY/6_immutability/modifiedCode/immutable
// Exercise 17.6: Introduction to concurrency
/*
Look at the example program of 5 classes (ImmutableExamplePSVM, Officer, Citizen,
DataGenerator, MutableIDClass). Read it carefully.
- Do you see any flaws?
- If yes, what whould you change to make the program work without problems?
- What would you change to make the IDCard class immutable?
*/
import java.util.Date;
import java.util.StringTokenizer;
import java.util.Random;
import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
* This has many changes to the teacherCode to make the mutable objects
* as immutable as possible, by applying Bloch's five rules (see Readme file
* in 6_immutability).
*
* It compiles. It runs without exceptions.
* It does the same as the modified code with defensive & deep copies, so only
* John is output and the DOB never changes from 1971.
*
* As with the original code, running the program 20 times in a row did not
* yield an incorrect name-DOB association so replacing mutable objects that
* are kept safe with synhcronized and defensive copies with immutables does not
* does not appear to alter the outcome nor the performance (~150-200 microsecs).
*/
public class ImmutableExample {

  public static void main(String[] args) {

    String name = DataGenerator.getNextName();
    Date dateOfBirth = DataGenerator.getNextDate();
    BufferedImage photo = DataGenerator.getNextPhoto();
    MutableIDCard id = new MutableIDCard(name, dateOfBirth, photo);
    Runnable officer = new Officer(id);
    Runnable citizen = new Citizen(id);
//  just to see what happens without multiple threads, i.e. sequential..
/*
    citizen.run();//gives: john
    officer.run();//causes the change
    citizen.run();//gives: mary
    officer.run();//causes the change
    citizen.run();//gives: lisa
    officer.run();//causes the change
    citizen.run();//gives: not a name
*/
    Thread t1 = new Thread(officer);
    Thread t2 = new Thread(citizen);

    long start, end;
    start = System.nanoTime();
    t1.start();
    t2.start();
    end = System.nanoTime();
    System.out.println("duration of teacherCode: " + (end-start) + " ns");

  }

}

class DataGenerator {

  private static StringTokenizer names = new StringTokenizer("John,Mary,Lisa",",");
  private static StringTokenizer dates = new StringTokenizer("23/6/1971,12/3/1985,9/8/2002",",");

  /*
  * data from this accessor is passed into the constructor of MutableIDCard
  */
  public static String getNextName() { //synchronized removed

    if (names.hasMoreElements()) {

      return (String)names.nextElement();

    }

    return "Not a name";

  }

  /*
  * data from this accessor is passed into the constructor of MutableIDCard
  */
  public static Date getNextDate() {//synchronized removed

    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    String txtDate = "1/1/1970";

    if (dates.hasMoreElements()) {

      txtDate = (String)dates.nextElement();

    }

    try {

      return dateFormat.parse(txtDate);

    } catch (ParseException e) {

      return new Date();

    }

  }

  /*
  * data from this accessor is passed into the constructor of MutableIDCard
  */
  public static BufferedImage getNextPhoto() {//synchronized removed

    return new BufferedImage(30, 30, BufferedImage.TYPE_INT_RGB);

  }

}

final class MutableIDCard { // modified to be completely immutable

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

/*rule 1. don’t provide any mutators!

  public void set(String name, Date dateOfBirth, BufferedImage photo) {

    check(name, dateOfBirth, photo);

    synchronized(this) {

      this.name = name;
      this.dateOfBirth = dateOfBirth;
      this.photo = photo;

    }

  }
*/

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

class Citizen implements Runnable {

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

class Officer implements Runnable {

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
    MutableIDCard id = new MutableIDCard(name, dateOfBirth, photo);
//  id.set(name, dateOfBirth, photo); // rule 1. don’t provide any mutators!

  }

}
