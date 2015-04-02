//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/07_INHERITANCE_ADHOCPOLYMORPHISM/People
// Exercise 10: Introducing ad hoc polymorphism (aka inheritance) and casting.
import interfacePerson.Person;

public class PeoplePSVM {

	public static void main(String args[]) {

		Person son = new Adult();

		// move in front of mother
		// son.move(10);

		// give the message
		son.say("I need some money for a new iPhone Mum.");

		Person son2 = new Kid();
		son2.say("hate yaooo");

	}

}
