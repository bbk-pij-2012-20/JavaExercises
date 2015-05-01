// cd ~/Desktop/all_pooled/computing/CODING/JavaExercises/12_CONCURRENCY/6_immutability/modifiedCode/immutable
// Exercise 17.6: Introduction to concurrency

/*Applying Bloch's five rules (see readme) to make the mutable object immutable*/
import java.util.Date;
import java.awt.image.BufferedImage;

public class ImmutableExamplePSVM { //modifiedCode (MutableIDCard made immutable)

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
    t1.start();
    t2.start();

  }

}
