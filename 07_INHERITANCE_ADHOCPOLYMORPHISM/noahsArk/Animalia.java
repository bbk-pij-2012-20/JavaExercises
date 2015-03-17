//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/07_INHERITANCE_ADHOCPOLYMORPHISM/noahsArk
//Exercise 10.8: Introduction to inheritance (aka ad hoc polymorphism).
package noahsArk;

public interface Animalia {

  /**
  * Generates a description of the animal being called to board the ark.
  */
  void call();

  /**
  * Prompts the animal to reproduce.
  */
  void reproduce();

  /**
  * Prompts animal to make a noise.
  */
  void makeSound();

}
