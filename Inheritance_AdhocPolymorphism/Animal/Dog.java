// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/Inheritance/implements
// Introducing Interfaces, their implementation and Javadoc comments : (Exercise in the notes on 'Interfaces')

/*
Day 10 - Inheritance exercises, (but the Animal code below is 
based on the example in the Day 10 NOTES.)

Dog, Human, Horse implements Animal interface. But if we want 
Animal to partially implement itself, i.e. Breath() method into 
Animal, we can just add it, but it turns it from an 'interface' 
into an 'abstract class', which must now be 'extended', not 'implemented'. 
*/

public class Dog extends Animal {

	private int legs = 4;
	
	public void move(int meters) {
	
		System.out.println("Walkies! Go " + (meters * 2) + " meters."); 
	
	}
	
	public String makeSound() {
	
		return "SAUSAGES !";
	
	}
	
	public static void main(String[] args) {
	
//		Animal d=new Dog();  	// This also works  
//		Animal a=new Animal();	// This does not work cos Animal is abstract (can't be instantiated)
		Dog d = new Dog(); 
		d.move(10);
		System.out.println("Doggy says " + d.makeSound());
		d.breath(25);
		System.out.printf("Doggy's panting %s", d.oxygen > 5? "heavily\n" : " ..not so much\n");
		Animal h = new Human();
		h.move(10);
		System.out.println("Human says " + h.makeSound());
		h.breath(25);
		System.out.printf("Human's wheezing %s", h.oxygen > 5? "heavily\n" : " ..not so much\n");
	
	}		
	
}

class Human extends Animal {

	private int legs = 2;
	
	public void move(int meters) {
	
		System.out.println("Walking, the pub is " + (meters * 1) + " meters away."); 
	
	}
	
	public String makeSound() {
	
		return "MONEY !";
	
	}	

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