// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/07_INHERITANCE_ADHOCPOLYMORPHISM/Phones
// Exercise 10.4: Introducing ad hoc polymorphism (aka inheritance).
/*
10.4:
10.4.2 Reducing visibility
Create a class RestrictedSmartPhone that overrides playGame(String) to make it
private and thus non-visible to external classes and scripts.
Is this possible? Why?

ANSWER:
Not possible to restrict access to the method in this way because
the visbility of the base class can not be greater than that in the derived class.
I have however restricted access to mobile/smartPhone's playGame() method in
this class simply by not calling the super class's method. Hence, overriding the
method already effectively blocks the base class's method, so that for the base
class's method to be called requires the super call.
*/

public class RestrictedSmartPhone extends SmartPhone {

  /**
  * Contructor.
  * @param brand brandname string of the phone.
  */
  public RestrictedSmartPhone(String brand) {

    super(brand);

  }

  @Override
  public void playGame(String game) {

    System.out.println("access to playing games is restricted! You may not play " + game + " today.");

  }

}
