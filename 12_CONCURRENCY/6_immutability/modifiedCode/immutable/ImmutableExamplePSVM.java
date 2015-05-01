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
import java.util.Date;
import java.util.StringTokenizer;
import java.util.Random;
import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
