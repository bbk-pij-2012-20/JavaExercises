//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/07_INHERITANCE_ADHOCPOLYMORPHISM/noahsArk
//Exercise 10.8: Introduction to inheritance (aka ad hoc polymorphism).
package noahsArk;

public abstract class Vertebrata implements Animalia {

	@Override
	public void call() {

		System.out.print(" are coming aboard");

	}

	@Override
	public abstract void makeSound();

	@Override
	public void reproduce() {

		System.out.print("..and they reproduce");

	}

}
