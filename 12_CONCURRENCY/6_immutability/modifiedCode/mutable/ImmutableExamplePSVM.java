// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/12_CONCURRENCY/6_immutability/modifiedCode/mutable
// Exercise 17.6: Introduction to concurrency

import java.util.Date;
import java.util.StringTokenizer;
import java.util.Random;
import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ImmutableExamplePSVM { //teacherCode but with defensive & deep copies of mutable objects

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
    t1.start();
    t2.start();

  }

}
