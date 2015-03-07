//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/07_INHERITANCE_ADHOCPOLYMORPHISM/Animals
//Exercise 10: Introduction to inheritance (aka ad hoc polymorphism).

public class Human extends Animal {

	private int legs = 2;

	public void move(int meters) {

		System.out.println("Walking, the pub is " + (meters * 1) + " meters away.");

	}

	public String makeSound() {

		return "MONEY !";

	}

}
