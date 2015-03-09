//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/07_INHERITANCE_ADHOCPOLYMORPHISM/Phones
// Exercise 10.7: Introducing ad hoc polymorphism (aka inheritance).
/*
Create a class that extends String and adds a method printEven() that prints on screen the even-numbered
characters of the string. Try to compile it and see what happens.

ANSWER:
java.lang.String is final, so it can't be extended. The end.

*/

public class FinalMeansNoChange extends String {

  public static void main(String[] args) {

    FinalMeansNoChange fmnc = new FinalMeansNoChange("This don't even compile");
    fmnc.printEven();

  }

  public void printEven() {

    System.out.println(this);

  }

}
