// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/Inheritance_AdhocPolymorphism
// Exercise 10.6 : Introducing Interfaces, their implementation, constructor chaining  
/*
Exercise was to determine why not compiling and also to use the methods of both classes.
Compilation error: Constructor Teacher in class Teacher cannot be 
applied to given types;
class Lecturer extends Teacher
^
  required: String
  found: no arguments
  reason: actual and formal argument lists differ in length

This is because upon instantiation of a subclass, a constructor of the subclass will 
automatically call a constructor of the superclass. In this case the constructor of the 
subclass, Lecturer, has no constructor which passes a String argument to the superclass's 
constructor. And vice versa, the superclass has no zero argument constructors which can 
match up with the default empty constructor of the subclass.    
*/
public class ResearcherCantTeach {

	public static void main(String args[]) {
	
		Lecturer l = new Lecturer();
		l.getName();
		l.teach("walking");
		l.doResearch("The theory of being great");
	
	}

}

class Teacher {

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
/**
* A lecturer has both teaching and research responsibilities.
*/
class Lecturer extends Teacher {

// Or, the compilation is resolved by adding this constructor.
	public Lecturer() {
	
		super("Jose");
	
	}
	
	public void doResearch(String topic) {
	
		System.out.println("Doing research on: " + topic);
	
	}

}