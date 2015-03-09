//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/07_INHERITANCE_ADHOCPOLYMORPHISM/Phones
// Exercise 10.1 - 10.4 continued... Introducing ad hoc polymorphism (aka inheritance) and casting.

/*
10.1:
'..Now create a class MobilePhone that extends OldPhone and adds methods for things like ringAlarm(String)
and playGame(String). This class keeps a list of the last ten numbers that have been called, which can be printed
with the method printLastNumbers()...''

10.3:
Add the following field, constructor, and method to OldPhone:
private String brand = null;
public OldPhone(String brand) {
  this.brand = brand;
}
public String getBrand() {
  return brand;
}
// ... there is no setter for brand
Add the appropriate constructors to MobilePhone and SmartPhone in order
to be able to call the method getBrand() from an object of class SmartPhone
and obtain the right answer, i.e. the brand provided in the constructor.

10.4:
10.4.1 Increasing visibility
Change the visibility of playGame(String) to private and check whether the
script you wrote in the former exercise still works. Why does this happen?
What are the minimal changes that you need to make on class SmartPhone so
that the script still works?
10.4.2 Reducing visibility
Some parents are concerned that their children spend too much time playing
with their smartphones. Create a class RestrictedSmartPhone that overrides
playGame(String) to make it private and thus non-visible to external classes
and scripts. Is this possible? Why?
*/
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class MobilePhone extends OldPhone {

  private Deque<String> mostRecentlyCalledNumbersList;
  private final int CALLS_STORE_LIMIT = 10;

  /**
  * Constructor.
  * @param brand brandname string of the phone.
  */
  public MobilePhone(String brand) {// for Ex 10.3

    super(brand);
    mostRecentlyCalledNumbersList = new ArrayDeque<>(CALLS_STORE_LIMIT);

  }

  /**
  * Zero-arg constructor.
  */
  public MobilePhone() {}

  /**
  * @returns phone's brandname string.
  */
  public String getBrand() {// for Ex 10.3

    return super.getBrand();

  }

  /**
  * Rings alarm.
  * @param noise alarm noise as a string.
  */
  public void ringAlarm(String noise) {

    System.out.println("ringing alarm: " + noise);

  }

  /**
  * Plays game.
  * @param game name string of game to play.
  */
  protected void playGame(String game) {

    System.out.println("playing game: " + game);

  }

  /**
  * Calls number, places number in list of last 10 numbers called.
  * @param number the number string being called.
  */
  @Override
  public void call(String number) {

    super.call(number);

    if (mostRecentlyCalledNumbersList.size() >= CALLS_STORE_LIMIT) {

      mostRecentlyCalledNumbersList.removeFirst();

    }

    mostRecentlyCalledNumbersList.addLast(number);

  }

  /**
  * Prints out the most recently numbers, upto the last 10.
  */
  public void printLastNumbers() {

    if (mostRecentlyCalledNumbersList.isEmpty()) {

      System.out.println("nothing to print - you've not made a single phone call with this phone");

    } else {

      System.out.println("most recently called numbers (..most recent first ..no more than last 10)");

      for (Iterator it = mostRecentlyCalledNumbersList.descendingIterator(); it.hasNext();) {

        System.out.println(it.next());

      }

    }

  }

}
