//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/07_INHERITANCE_ADHOCPOLYMORPHISM/noahsArk
//Exercise 10.8: Introduction to inheritance (aka ad hoc polymorphism).
package noahsArk;

import noahsArk.vertebrata.amphibia.Frogs;
import noahsArk.vertebrata.arthropoda.Beetles;
import noahsArk.vertebrata.arthropoda.Flies;
import noahsArk.vertebrata.aves.Eagles;
import noahsArk.vertebrata.aves.Pigeons;
import noahsArk.vertebrata.mammalia.Bears;
import noahsArk.vertebrata.mammalia.Dogs;
import noahsArk.vertebrata.mammalia.Dolphins;
import noahsArk.vertebrata.mammalia.Monkeys;
import noahsArk.vertebrata.mammalia.Whales;
import noahsArk.vertebrata.pisces.Salmon;
import noahsArk.vertebrata.reptilia.Crocodiles;
import noahsArk.vertebrata.reptilia.Lizards;
import noahsArk.vertebrata.reptilia.Snakes;

public class NoahsArkPSVM {

	  public static void main(String[] args) {

	    Animalia animal = new Frogs();
	    animal.call();
	    animal.reproduce();
	    animal.makeSound();

	    Animalia animal2 = new Beetles();
	    animal2.call();
	    animal2.reproduce();
	    animal2.makeSound();

	    Animalia animal3 = new Whales();
	    animal3.call();
	    animal3.reproduce();
	    animal3.makeSound();

	    Animalia animal4 = new Salmon();
	    animal4.call();
	    animal4.reproduce();
	    animal4.makeSound();

	    Animalia animal5 = new Dolphins();
	    animal5.call();
	    animal5.reproduce();
	    animal5.makeSound();

	    Animalia animal6 = new Flies();
	    animal6.call();
	    animal6.reproduce();
	    animal6.makeSound();

	    Animalia animal7 = new Pigeons();
	    animal7.call();
	    animal7.reproduce();
	    animal7.makeSound();

	    Animalia animal8 = new Eagles();
	    animal8.call();
	    animal8.reproduce();
	    animal8.makeSound();

	    Animalia animal9 = new Monkeys();
	    animal9.call();
	    animal9.reproduce();
	    animal9.makeSound();

	    Animalia animal10 = new Dogs();
	    animal10.call();
	    animal10.reproduce();
	    animal10.makeSound();

	    Animalia animal11 = new Bears();
	    animal11.call();
	    animal11.reproduce();
	    animal11.makeSound();

	    Animalia animal12 = new Snakes();
	    animal12.call();
	    animal12.reproduce();
	    animal12.makeSound();

	    Animalia animal13 = new Lizards();
	    animal13.call();
	    animal13.reproduce();
	    animal13.makeSound();

	    Animalia animal14 = new Crocodiles();
	    animal14.call();
	    animal14.reproduce();
	    animal14.makeSound();

	  }

}
