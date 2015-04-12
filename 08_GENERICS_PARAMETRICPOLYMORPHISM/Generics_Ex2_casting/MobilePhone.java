// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/08_GENERICS_PARAMETRICPOLYMORPHISM/Generics_Ex2
// Exercise 11.2: Casting types and introducing parametric polymorphism (aka generics).

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

    initList();

  }

  /**
  * Zero-arg constructor.
  */
  public MobilePhone() {

    initList();

  }

  /**
  * Initialises list of numbers with preset limit.
  */
  public void initList() {

    mostRecentlyCalledNumbersList = new ArrayDeque<>(CALLS_STORE_LIMIT);

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
  * @return phone's brandname string.
  */
  public String getBrand() {// for Ex 10.3

    return super.getBrand();

  }


  /**
  * Plays game.
  * @param game name string of game to play.
  */
  protected void playGame(String game) {

    System.out.println("playing game: " + game);

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

  /**
  * Rings alarm.
  * @param noise alarm noise as a string.
  */
  public void ringAlarm(String noise) {

    System.out.println("ringing alarm: " + noise);

  }

}
