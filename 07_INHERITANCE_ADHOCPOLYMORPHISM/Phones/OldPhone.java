//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/07_INHERITANCE_ADHOCPOLYMORPHISM/Phones
// Exercise 10. Introducing ad hoc polymorphism (aka inheritance) and casting.
/*
10.1:
Create a class OldPhone that implements the following interface.

public interface Phone {
  javadoc: Just print on the screen: "Calling <number>...".
  void call(String number);
}

Now create a class MobilePhone that extends OldPhone and adds methods for things like ringAlarm(String)
and playGame(String). This class keeps a list of the last ten numbers that have been called, which can be printed
with the method printLastNumbers().

Then create a class SmartPhone that extends MobilePhone and adds methods for browseWeb(String) and
findPosition(), the latter returning a (fictitious) GPS-found position.

Create a small script called PhoneLauncher in which you create a SmartPhone and use all its methods, including
those inherited from its ancestor classes.

public class PhoneLauncher {
  public static void main(String[] args) {
    PhoneLauncher launcher = new PhoneLauncher();
    launcher.launch();

  public void launch() {
    // your code creating and using SmartPhone here...
  }
}

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
*/

import interfacePhone.Phone;

public class OldPhone implements Phone {

  private String brand = null;

  /**
  * Constructor.
  * @param brand brandname string of the phone.
  */
  public OldPhone(String brand) {

    this.brand = brand;

  }

  /**
  * Zero-arg constructor
  */
  public OldPhone(){}

  /**
  * @returns phone's brandname string.
  */
  public String getBrand() {

    return brand;

  }

  /**
  * Calls phone numbers.
  * @param number the number string being called.
  */
  @Override
  public void call(String number) {

    System.out.println("..calling " + number);

  }

}
