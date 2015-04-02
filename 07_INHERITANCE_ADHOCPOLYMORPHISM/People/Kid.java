//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/07_INHERITANCE_ADHOCPOLYMORPHISM/People
// Exercise 10: Introducing ad hoc polymorphism (aka inheritance) and casting.

public class Kid implements Person {

	private int position;
	private String brain;

	/**
	*	Move a distance in a straight line, given in meters
	*/
	public void move(int distance) {

		crawl(distance);

	}

    /**
     *	Say something
     */
	public void say(String message) {

		String finalMsg = getUnderstoodWords(message);
		System.out.println(finalMsg);

	}

	private void crawl(int distance) {

		for (int i = 0; i < distance; i++) {

                position++;
                waitALittle();

		}

	}

	private String getUnderstoodWords(String text) {

		String result = "";
		String[] words = brain.substring(0,2);

		for (int i = 0; i < words.length; i++) {

			if (brain.equals(words[i])) {

				result = result + words[i];
				// if not, ignore it

			}

		}

		return result;

	}
	// ... other methods, including constructors, come here...

}
