//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/07_INHERITANCE_ADHOCPOLYMORPHISM/Instruments
//Exercise 10.5: Introduction to inheritance (aka ad hoc polymorphism).

/*
	Create a class MusicalInstrument with a method play().
	Now create another class WoodenObject with a method burn().
	Create a class Guitar that is at the same time a musical instrument and a wooden object.
	How would you do it in Java?
*/

public class InstrumentsPSVM {

	public static void main(String args[]) {

		Guitar g = new Guitar();
		g.play();
		g.burn();

	}

}

/*
Code in Guitar implements two interfaces.
(Commented out code in Guitar file also shows Guitar extending
WoodenObject (changed from interface to class), and
implementing MusicalInstrument hence no longer multiple inheritance).
*/
