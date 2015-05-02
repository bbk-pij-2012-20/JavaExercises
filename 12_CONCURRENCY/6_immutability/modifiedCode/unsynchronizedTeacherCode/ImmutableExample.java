// cd ~/Desktop/all_pooled/computing/CODING/JavaExercises/12_CONCURRENCY/6_immutability/modifiedCode/unsynchronizedTeacherCode
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
* This is identical to the teacherCode but with all the 'synchronized' keywords
* removed just to see what happens!
*
* It compiles. It runs without exceptions.
* It does the same as the original code, i.e. John or Mary are printed out in
* a non-deterministic manner.
* So, nothing dramatic happens when you remove the locks.
* As with the original code, running the program 20 times in a row did not
* yield an incorrect name-DOB association so the absence of 'thread-safety'
* does not appear to result in data corruption (via race conditions), but this
* cannot be entirely ruled out. I remain unsure about this.
*/
public class ImmutableExample
{
  public static void main(String[] args)
  {
      String name = DataGenerator.getNextName();
      Date dateOfBirth = DataGenerator.getNextDate();
      BufferedImage photo = DataGenerator.getNextPhoto();

      MutableIDCard id = new MutableIDCard(name,dateOfBirth,photo);

      Runnable officer = new Officer(id);
      Runnable citizen = new Citizen(id);

      Thread t1 = new Thread(officer);
      Thread t2 = new Thread(citizen);
//I added the following code to check for any performance 'flaws'
      long start, end;
      start = System.nanoTime();
      t1.start();
      t2.start();
      end = System.nanoTime();
      System.out.println("duration of teacherCode: " + (end-start) + " ns");

  }

}

class DataGenerator
{
  private static StringTokenizer names = new StringTokenizer("John,Mary,Lisa",",");
  private static StringTokenizer dates = new StringTokenizer("23/6/1971,12/3/1985,9/8/2002",",");

    public static String getNextName()//removed synchronized
    {
      if (names.hasMoreElements())
      {
        return (String)names.nextElement();
      }
      return "Not a name";
    }

    public static Date getNextDate()//removed synchronized
    {
      DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      String txtDate="1/1/1970";

      if(dates.hasMoreElements())
      {
        txtDate=(String)dates.nextElement();
      }

      try
      {
        return dateFormat.parse(txtDate);
      }
      catch (ParseException e)
      {
		return new Date();
	  }
  }

    public static BufferedImage getNextPhoto()//removed synchronized
    {
        return new BufferedImage(30, 30, BufferedImage.TYPE_INT_RGB);
    }
}

class MutableIDCard
{
  private String name;
  private Date dateOfBirth;
  private BufferedImage photo;

  public MutableIDCard(String name,Date dateOfBirth,BufferedImage photo)
  {
    this.name=name;
    this.dateOfBirth=dateOfBirth;
    this.photo=photo;
  }

  public void set(String name,Date dateOfBirth,BufferedImage photo)
  {
    check(name,dateOfBirth,photo);

    //removed synchronized
    {
      this.name = name;
      this.dateOfBirth = dateOfBirth;
      this.photo = photo;
    }
  }

  public String getName()//removed synchronized
  {
    return name;
  }

  public Date getDateOfBirth()//removed synchronized
  {
    return dateOfBirth;
  }

  public BufferedImage getPhoto()//removed synchronized
  {
    return photo;
  }

  public void check(String name,Date dateOfBirth,BufferedImage photo)
  {
    if (name==null || name.equals(""))
    {
      throw new IllegalArgumentException();
    }

    if (dateOfBirth==null)
    {
      throw new IllegalArgumentException();
    }

    long age=getAge(dateOfBirth);

    if (dateOfBirth==null || age<=0)
    {
      throw new IllegalArgumentException();
    }

    if (photo==null)
    {
      throw new IllegalArgumentException();
    }
  }

  private long getAge(Date dateOfBirth)
  {
    long now = new Date().getTime();
    long age = now - dateOfBirth.getTime();
    return age;
  }
}

class Citizen implements Runnable
{
  private MutableIDCard id;

  public Citizen(MutableIDCard id)
  {
    this.id = id;
  }

  public void run()
  {
/*    Random r = new Random();

    try
    {
      Thread.sleep(r.nextInt(2000));
    }
      catch (InterruptedException e)
	  {
		e.printStackTrace();
	  }
*/
    String message = "";
    message += "the name on this id is "+id.getName()+"\n";
    message += "and the date of birth is "+id.getDateOfBirth();

    System.out.println(message);
  }
}

class Officer implements Runnable
{
  private MutableIDCard id;

  public Officer(MutableIDCard id)
  {
    this.id=id;
  }

  public void run()
  {
/*    Random r=new Random();

    try
    {
      Thread.sleep(r.nextInt(2000));
    }
      catch (InterruptedException e)
	  {
      e.printStackTrace();
	  }
*/
      String name = DataGenerator.getNextName();
      Date dateOfBirth = DataGenerator.getNextDate();
      BufferedImage photo = DataGenerator.getNextPhoto();

      id.set(name, dateOfBirth, photo);
  }
}
