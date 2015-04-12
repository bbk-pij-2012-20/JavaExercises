// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/08_GENERICS_PARAMETRICPOLYMORPHISM/Generics_Ex2
// Exercise 11.2: Casting types and introducing parametric polymorphism (aka generics).

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
  * @return phone's brandname string.
  */
  public String getBrand() {

    if (brand == null) {

      brand = "no brand was given";

    }

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
