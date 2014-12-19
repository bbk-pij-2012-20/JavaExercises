// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/DataStructures/Maps
// Exercise 8.5.2: Intro to Map data structures 
 
/* Create a class that implements the following interface (see bottom) of a simple map from 
integers to strings. */

public class SimpleMapImpl implements SimpleMap {
	
	private String[] nameArray = new String[200];
	
	public static void main(String args[]) {
	
		SimpleMapImpl smi = new SimpleMapImpl();
		System.out.println("...inserting a green bottle at key# 1");
		smi.put(1, "green bottle");
		System.out.println("...at key# 1 is ..." + smi.get(1));
		System.out.printf("...the map is currently %sempty\n", smi.isEmpty()? "" : "not ");
		System.out.println("...removing string at at key# 1");
		smi.remove(1);
		System.out.printf("...the map is %sempty\n", smi.isEmpty()? "" : "not ");
	
	}

	public void put(int key, String name) {
	
		int keyHash = key % 200;
		
		if (nameArray[keyHash] == null) {
		
			nameArray[keyHash] = name;
		
		}
	
	}

	public String get(int key) {
	
		int keyHash = key % 200;
		return nameArray[keyHash];

	}

	public void remove(int key) {

		int keyHash = key % 200;
		nameArray[keyHash] = null;

	}

	public boolean isEmpty() {

		int i = 0;
		boolean empty = true;

		while (empty && i < 200) {

			if (nameArray[i] != null) {

				empty = false;

			} else {

				i++;
			} 
	
		}
	
		return empty;
	}
	
}

/*
*  The Map interface code provided. The exercise is to implement this (see above).
*/
interface SimpleMap { 
	/**
	 * Puts a new String in the map. 
	 *
	 * If the key is already in the map, nothing is done. 
	 */
	 void put(int key, String name);
	
	/**
	 * Returns the name associated with that key, 
	 * or null if there is none.
	 */
	 String get(int key);

	/**
	 * Removes a name from the map. Future calls to get(key) 
	 * will return null for this key unless another
	 * name is added with the same key.
	 */
	 void remove(int key);

	/**
	 * Returns true if there are no workers in the map, 
	 * false otherwise
	 */
	 boolean isEmpty(); 
	 
}	