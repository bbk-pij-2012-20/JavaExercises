//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/07_INHERITANCE_ADHOCPOLYMORPHISM/TeachingStaff
// Exercise 10.6 : Introducing Interfaces, their implementation, constructor-chaining

public class Teacher {

	private String name;

	public Teacher(String name) {

		this.name = name;

	}

// compilation is resolved either by adding a zero-arg constructor here:
	public Teacher(){}
// Or by explicitly calling Teacher's constructor with a string from Lecturer's
// constructor (see line 67)

	public String getName() {

		return name;

	}

	public void teach(String lessonName) {

		System.out.println("Teaching lesson: " + lessonName);

	}

}
