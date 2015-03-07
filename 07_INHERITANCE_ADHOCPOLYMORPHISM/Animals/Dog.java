//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/07_INHERITANCE_ADHOCPOLYMORPHISM/Animals
//Exercise 10: Introduction to inheritance (aka ad hoc polymorphism).

public class Dog extends Animal {

	private int legs = 4;

	public void move(int meters) {

		System.out.println("Walkies! Go " + (meters * 2) + " meters.");

	}

	public String makeSound() {

		return "SAUSAGES !";

	}
