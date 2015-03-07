//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/07_INHERITANCE_ADHOCPOLYMORPHISM/Animal
//Exercise 10: Introduction to inheritance (aka ad hoc polymorphism).

public class Dog extends Animal {

	private int legs = 4;

	public void move(int meters) {

		System.out.println("Walkies! Go " + (meters * 2) + " meters.");

	}

	public String makeSound() {

		return "SAUSAGES !";

	}

abstract class Animal {

	protected int oxygen = 0;
	public abstract void move(int meters);
	public abstract String makeSound();

	public void breath(int air) {

		this.oxygen += air / 4;

	}

}

/* Animal starts out as an interface. Some implementation is entered into breath(),
as such Animal becomes an abstract class and the Dog and Human classes that used to
implement Animal, now extend it.

public interface Animal {

	void move(int meters);
	String makeSound();
	void breath(int air);

}
*/
