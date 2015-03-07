//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/07_INHERITANCE_ADHOCPOLYMORPHISM/TeachingStaff
// Exercise 10.6: Introducing Interfaces, their implementation, constructor-chaining

/**
* A lecturer has both teaching and research responsibilities.
*/
public class Lecturer extends Teacher {

// Or, the compilation is resolved by adding this constructor.
	public Lecturer() {

		super("Jose");

	}

	public void doResearch(String topic) {

		System.out.println("Doing research on: " + topic);

	}

}
