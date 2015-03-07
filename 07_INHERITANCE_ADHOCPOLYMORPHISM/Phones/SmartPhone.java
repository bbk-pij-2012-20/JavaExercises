// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/Inheritance_AdhocPolymorphism/Phones
// Exercise 10.1 continued... (Introducing ad hoc polymorphism (aka inheritance) and casting.)
/*
Then create a class SmartPhone that extends MobilePhone and adds methods for browseWeb(String) and
findPosition(), the latter returning a (fictitious) GPS-found position.

Create a small script called PhoneLauncher in which you create a SmartPhone and use all its methods, including
those inherited from its ancestor classes.

Exercise 10.2:
Modify your class SmartPhone so that it overrides the method call(String) inherited from OldPhone.
If the string parameter starts with “00”, the method should output
“Calling <number> through the internet to save money”; otherwise, the method should do the same
as the original method (hint: use super).

*/

public class SmartPhone extends MobilePhone {

  /**
  * Pretends to browse the web
  */
  public void browseWeb(String searchStr) {

    System.out.println("browsing the web for: " + searchStr);

  }

  /**
  * Produces a (fictitious) GPS-found position.
  */
  public String findPosition() {

    return "XYZ";

  }

}
