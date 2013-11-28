//cd Desktop/JavaCoding/JavaExercises

public class MultipleInheritance//Day10Ex5
{
	public static void main(String args[])
	{
		Guitar g=new Guitar();
		g.play();
		g.burn();
	}
}

interface MusicalInstrument //Day10 Ex5
{
	/**	@param no parameters
	*	@return void return type, just prints message.
	*/	 
	public void play();
}
interface WoodenObject
{
	/**	@param no parameters
	*	@return void return type, just prints a message.
	*/
	public void burn();
}
class Guitar implements WoodenObject, MusicalInstrument
{
	public void burn()
	{
		System.out.println("My Fender's on fire");
	}

	public void play()
	{
		System.out.println("Playing All Along the Watchtower");
	}	
}

/* Implementing one and extending the other also works,
though this is not multiple INHERITANCE 

interface MusicalInstrument //Day10 Ex5
{
	public void play();
}
class WoodenObject
{
	public void burn()
	{
		System.out.println("My Fender's on fire");
	}
}
class Guitar extends WoodenObject implements MusicalInstrument
{
	public void play()
	{
		System.out.println("Playing All Along the Watchtower");
	}
}
*/