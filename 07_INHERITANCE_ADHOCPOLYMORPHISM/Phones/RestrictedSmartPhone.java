// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/07_INHERITANCE_ADHOCPOLYMORPHISM/Phones
// Exercise 10.4: Introducing ad hoc polymorphism (aka inheritance).
/*
10.4:
10.4.2 Reducing visibility
Create a class RestrictedSmartPhone that overrides playGame(String) to make it
private and thus non-visible to external classes and scripts.
Is this possible? Why?
*/

public class RestrictedSmartPhone extends SmartPhone {

  /**
  * Contructor.
  * @param brand brandname string of the phone.
  */
  public RestrictedSmartPhone(String brand) {

    super(brand);

  }



}
