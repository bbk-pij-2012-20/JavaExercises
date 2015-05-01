// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/12_CONCURRENCY/6_immutability/modifiedCode/mutable
// Exercise 17.6: Introduction to concurrency

public class DataGenerator {//same as teacherCode

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
