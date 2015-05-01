// cd ~/Desktop/all_pooled/computing/CODING/JavaExercises/12_CONCURRENCY/6_immutability/modifiedCode/immutable
// Exercise 17.6: Introduction to concurrency

/*Applying Bloch's five rules (see readme) to make the mutable object immutable*/
import java.util.StringTokenizer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.awt.image.BufferedImage;

public class DataGenerator {

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
