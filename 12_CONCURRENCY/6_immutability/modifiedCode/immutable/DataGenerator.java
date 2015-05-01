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
public class DataGenerator {

  private static StringTokenizer names = new StringTokenizer("John,Mary,Lisa",",");
  private static StringTokenizer dates = new StringTokenizer("23/6/1971,12/3/1985,9/8/2002",",");

  /*
  * data from this accessor is passed into the constructor of MutableIDCard
  */
  public synchronized static String getNextName() { //synchronised accessor

    if (names.hasMoreElements()) {

      return (String)names.nextElement();

    }

    return "Not a name";

  }

  /*
  * data from this accessor is passed into the constructor of MutableIDCard
  */
  public synchronized static Date getNextDate() {//synchronised accessor

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
  public synchronized static BufferedImage getNextPhoto() {//synchronised accessor

    return new BufferedImage(30, 30, BufferedImage.TYPE_INT_RGB);

  }

}
