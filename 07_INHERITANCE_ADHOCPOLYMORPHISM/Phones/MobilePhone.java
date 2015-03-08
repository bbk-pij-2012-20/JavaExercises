//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/07_INHERITANCE_ADHOCPOLYMORPHISM/Phones
// Exercise 10.1 continued... Introducing ad hoc polymorphism (aka inheritance) and casting.

/*
'..Now create a class MobilePhone that extends OldPhone and adds methods for things like ringAlarm(String)
and playGame(String). This class keeps a list of the last ten numbers that have been called, which can be printed
with the method printLastNumbers()...''
*/
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class MobilePhone extends OldPhone {

  private Deque<String> mostRecentlyCalledNumbersList;
  private final int CALLS_STORE_LIMIT = 10;

  public MobilePhone() {

    mostRecentlyCalledNumbersList = new ArrayDeque<>(CALLS_STORE_LIMIT);

  }

  public void ringAlarm(String alarm) {

    System.out.println("ringing alarm: " + alarm);

  }

  public void playGame(String game) {

    System.out.println("playing game: " + game);

  }

  @Override
  public void call(String number) {

    super.call(number);

    if (mostRecentlyCalledNumbersList.size() >= CALLS_STORE_LIMIT) {

      mostRecentlyCalledNumbersList.removeFirst();

    }

    mostRecentlyCalledNumbersList.addLast(number);

  }

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
