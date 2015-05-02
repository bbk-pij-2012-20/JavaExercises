// cd ~/Desktop/all_pooled/computing/CODING/JavaExercises/12_CONCURRENCY/6_immutability/modifiedCode/mutableWithDefensiveCopy
// Exercise 17.6: Introduction to concurrency

import java.util.Date;
import java.util.StringTokenizer;
import java.util.Random;
import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
* This is identical to teacherCode but with defensive copies of MutableIDCard made in Officer & Citizen
* and deep copies made in a new constructor in MutableIDCard.
*/
public class ImmutableExample {

  public static void main(String[] args) {

    String name = DataGenerator.getNextName();
    Date dateOfBirth = DataGenerator.getNextDate();
    BufferedImage photo = DataGenerator.getNextPhoto();
    MutableIDCard id = new MutableIDCard(name, dateOfBirth, photo);
    Runnable officer = new Officer(id);
    Runnable citizen = new Citizen(id);
//  just wanted to see what happens without multiple threads, i.e. sequential..
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

class DataGenerator {//same as teacherCode

  private static StringTokenizer names = new StringTokenizer("John,Mary,Lisa",",");
  private static StringTokenizer dates = new StringTokenizer("23/6/1971,12/3/1985,9/8/2002",",");


  /*
  * Data from this accessor is passed into the constructor of MutableIDCard.
  * synchronized places a lock on the DataGenerator class, so that this method
  * can only be called by one thread at a time.
  */
  public synchronized static String getNextName() {
    if (names.hasMoreElements()) {

      return (String)names.nextElement();

    }

    return "Not a name";

  }

  /*
  * Data from this accessor is passed into the constructor of MutableIDCard.
  * synchronized places a lock on the DataGenerator class, so that this method
  * can only be called by one thread at a time.
  */
  public synchronized static Date getNextDate() {

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
  * Data from this accessor is passed into the constructor of MutableIDCard.
  * synchronized places a lock on the DataGenerator class, so that this method
  * can only be called by one thread at a time.
  */
  public synchronized static BufferedImage getNextPhoto() {

    return new BufferedImage(30, 30, BufferedImage.TYPE_INT_RGB);

  }

}

class MutableIDCard { // mutable teacherCode plus defensive and deep copies of mutable objects

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

class Citizen implements Runnable {

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

class Officer implements Runnable {

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
