//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/07_INHERITANCE_ADHOCPOLYMORPHISM/People
//Exercise 10: Introduction to inheritance (aka ad hoc polymorphism).

/**
 *	A person is defined by movement (as opposed to plants)
 *	and by speech (as opposed to animals).
 */

public interface Person {

   /**
	*	Move a distance in a straight line, given in meters.
	*/
	public void move(int distance);

   /**
	*	Say something, printing it on screen.
	*	It may or may not be a perfect transcription.
	*/
	public void say(String message);

}
