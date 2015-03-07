//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/07_INHERITANCE_ADHOCPOLYMORPHISM/Instruments
//Exercise 10.5: Introduction to inheritance (aka ad hoc polymorphism).

public class Guitar implements WoodenObject, MusicalInstrument {

	public void burn() {

		System.out.println("My Fender's on fire");

	}

	public void play() {

		System.out.println("Playing All Along the Watchtower");

	}

}

/*

Implementing one (MusicalInstrument) and extending the other (WoodenObject changed from interface to class),
shown below. (This becomes no longer multiple inheritance).

interface MusicalInstrument {

	public void play();

}

class WoodenObject  {

	public void burn() {

		System.out.println("My Fender's on fire");

	}

}

class Guitar extends WoodenObject implements MusicalInstrument {

	public void play() {

		System.out.println("Playing All Along the Watchtower");

	}

}

*/
