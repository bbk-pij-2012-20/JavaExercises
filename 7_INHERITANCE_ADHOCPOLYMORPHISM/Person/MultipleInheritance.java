// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/Inheritance/implements
// Introducing Interfaces, their implementation and Javadoc comments : (Exercise in the notes on 'Interfaces')

/*
	Create a class MusicalInstrument with a method play(). 
	Now create another class WoodenObject with a method burn().	
	Create a class Guitar that is at the same time a musical instrument and a wooden object. 
	How would you do it in Java?
*/

public class MultipleInheritance {
	
	public static void main(String args[]) {
	
		Guitar g = new Guitar();
		g.play();
		g.burn();
	
	}

}

interface MusicalInstrument { 

   /**	@param no parameters
	*	@return void return type, just prints message.
	*/	 
	public void play();

}

interface WoodenObject {

   /**	@param no parameters
	*	@return void return type, just prints a message.
	*/
	public void burn();

}

class Guitar implements WoodenObject, MusicalInstrument {

	public void burn() {
	
		System.out.println("My Fender's on fire");
	
	}

	public void play() {
	
		System.out.println("Playing All Along the Watchtower");
	
	}	

}

/* 

Implementing one and extending the other also works, though this is not multiple INHERITANCE 

interface MusicalInstrument {

	public void play();

}

class WoodenObject {

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