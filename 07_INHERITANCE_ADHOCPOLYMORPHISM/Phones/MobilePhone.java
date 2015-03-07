// cd
// Exercise 10.1 continued... (Introducing ad hoc polymorphism (aka inheritance) and casting.)

/*
'..Now create a class MobilePhone that extends OldPhone and adds methods for things like ringAlarm(String)
and playGame(String). This class keeps a list of the last ten numbers that have been called, which can be printed
with the method printLastNumbers()...''
*/

public class MobilePhone extends OldPhone {

  private String[] numList;
  private int nextEmptyPosition = 0;
  private boolean phoneBookFull = false;

  public MobilePhone() {

    numList = new String[10];

  }

  public void ringAlarm(String alarm) {

    System.out.println("ringing alarm: " + alarm);

  }

  public void playGame(String game) {

    System.out.println("playing game: " + game);

  }

  @Override
  public void call(String number) {

    if (!phoneBookFull) {

      numList[nextEmptyPosition++] = number;

      if (nextEmptyPosition == numList.length) {

        phoneBookFull = true;
        nextEmptyPosition--;

      }

    } else {

      numList[nextEmptyPosition] = number;

    }

  }

  public void printLastNumbers() {

    if (numList == null) {

      System.out.println("phone numbers list is empty");

    }

    int i = 0;
    boolean end = false;

    while (!end && numList[i] != null && i < numList.length) {

      int num = i + 1;
      System.out.println("number " + num + ": " + numList[i]);
      i++;

      if (i == numList.length) {

        end = true;

      }

    }

  }

}
