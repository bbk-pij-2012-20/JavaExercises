//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/07_INHERITANCE_ADHOCPOLYMORPHISM/Phones
// Exercise 10.8: Introducing ad hoc polymorphism (aka inheritance).
/*
Design and implement an application that represents the day that Noah’s Ark was
open, just before the rain started.

In your script, create an animal of each species and then call them all in.
Every animal must implement a method call() that prints on screen the appropriate
message. You should keep in mind the following requirements:

• The application should contain at least: bears, beetles, cats, crocodiles,
dogs, dolphins, eagles, flies, frogs, lizards, monkeys, pigeons, salmon, sharks,
snakes, whales.

• All animals have at least a method call() and a method reproduce().

• Insects, fish, amphibians, reptiles, and birds lay eggs (layEggs()).
Mammals cannot lay eggs but give birth (giveBirth()).
The method reproduce() should call the appropriate method in each case.

• When called, all animals answer (i.e. print on screen)
“<name of the animal> coming...”. The exceptions are aquatic animals,
which are not affected by the rain and answer
“<name of the animal> will not come...”; and flying animals, that answer
“<name of the animal> now flying, will come later when tired...”.
Method call() must not be implemented in every class:
use inheritance to reuse methods and constructors to pass information to
parent classes.

• All animals make a sound. If Animal is an interface in your design,
makeSound() must be a method in there;
if Animal is an abstract class, it must be an abstract method.
The method can then be implemented by descendant classes.
*/

public class NoahsArkPSVM {

  public static void main(String[] args) {

    Animal animal = new

  }

}
