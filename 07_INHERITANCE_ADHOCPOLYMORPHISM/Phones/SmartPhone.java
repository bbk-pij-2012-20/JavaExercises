// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/07_INHERITANCE_ADHOCPOLYMORPHISM/Phones
// Exercise 10.1 - 10.4 continued... (Introducing ad hoc polymorphism (aka inheritance) and casting.)
/*
10.1:
Then create a class SmartPhone that extends MobilePhone and adds methods for browseWeb(String) and
findPosition(), the latter returning a (fictitious) GPS-found position.

Create a small script called PhoneLauncher in which you create a SmartPhone and use all its methods, including
those inherited from its ancestor classes.

10.2:
Modify your class SmartPhone so that it overrides the method call(String) inherited from OldPhone.
If the string parameter starts with “00”, the method should output
“Calling <number> through the internet to save money”; otherwise, the method should do the same
as the original method (hint: use super).

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
Create a class RestrictedSmartPhone that overrides playGame(String) to make it
private and thus non-visible to external classes and scripts.
Is this possible? Why?
*/

public class SmartPhone extends MobilePhone {

  /**
  * Contructor.
  * @param brand brandname string of the phone.
  */
  public SmartPhone(String brand) {

//    super(brand); I commented this out cos this constructor chain is done automatically!!

  }

  /**
  * Zero-arg constructor.
  */
  public SmartPhone() {}

  /**
  * @return phone's brandname string.
  */
  public String getBrand() {//for Ex 10.3

    return super.getBrand();

  }

  /**
  * Pretends to browse the web
  */
  public void browseWebFor(String searchString) {

    System.out.println("browsing the web for.... " + searchString);

  }

  /**
  * Produces a (fictitious) GPS-found position.
  */
  public String findPosition() {

    return "Latitude: xyz, Longitude: abc (aka Costa, Northwood)";

  }

  /**
  * Plays game.
  * @param game name string of game to play.
  */
  @Override
  protected void playGame(String game) {

    super.playGame(game);

  }

  @Override
  public void ringAlarm(String noise) {

    super.ringAlarm(noise);

  }

  @Override
  public void printLastNumbers() {

    super.printLastNumbers();

  }

  /**
  * Prints statement if number starts with 00 (international), otherwise
  * upcasts to call(number) in OldPhone.
  * @param number the number string being called.
  */
  @Override //for Ex 10.2
  public void call(String number) {

    if (number == null) {

      System.out.println("no number was given");

    } else {

      if (number.trim().charAt(0) == '+') {

        number = number.substring(1);

      }

      if (isNumeric(number) == false) {

        System.out.println(number + " is not numeric.. Please enter a numberic value.");

      } else {

        if (number.substring(0,2).equals("00")) {

          System.out.println("Calling " + number + " through the internet to save money");

        } else {

          super.call(number);

        }

      }

    }

  }

 /**
  * Returns true specified string is a number with the following pattern:
  * 1 or more digits, followed by nothing or, 1 or more digits that may or may
  * not be preceded by a single white space.
  */
  private boolean isNumeric(String number) {

    return number.matches("\\d+((\\s)?\\d+)*");

  }

}
