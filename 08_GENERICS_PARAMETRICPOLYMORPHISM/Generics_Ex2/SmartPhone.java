// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/08_GENERICS_PARAMETRICPOLYMORPHISM/Generics_Ex2
// Exercise 11.2: Casting types and introducing parametric polymorphism (aka generics).
/*
11.2.1.
Create a script that builds a new SmartPhone with the line:
Smartphone myPhone = new Smartphone();
and then uses all its methods.
*/

public class SmartPhone extends MobilePhone {

  /**
  * Contructor.
  * @param brand brandname string of the phone.
  */
  public SmartPhone(String brand) {}

  /**
  * Zero-arg constructor.
  */
  public SmartPhone() {}

  /**
   * Pretends to browse the web
   */
  public void browseWebFor(String searchString) {

    System.out.println("browsing the web for.... " + searchString);

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
   * Produces a (fictitious) GPS-found position.
   */
  public String findPosition() {

    return "Latitude: xyz, Longitude: abc (aka Costa, Northwood)";

  }

  /**
   * @return phone's brandname string.
   */
   @Override
  public String getBrand() {//for Ex 10.3

    return super.getBrand();

  }

  /**
   * Called by call(String).
   * Returns true specified string is a number with the following pattern:
   * 1 or more digits, followed by nothing or, 1 or more digits that may or may
   * not be preceded by a single white space.
   */
   private boolean isNumeric(String number) {

     return number.matches("\\d+((\\s)?\\d+)*");

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
  public void printLastNumbers() {

    super.printLastNumbers();

  }

  @Override
  public void ringAlarm(String noise) {

    super.ringAlarm(noise);

  }

}
