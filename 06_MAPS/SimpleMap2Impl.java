// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/06_MAPS
// Exercise 8.5.2 (Introduction to Maps)
 
/* 
Create a class that implements the following interface (see bottom of page) of a 
simple map from integers to strings: it is a one-to-many mapping. 
A similar map is used in some countries to classify the citizens into groups for tax 
purposes (so that each department has a limited number of citizens to examine and process).
*/
/*
*	The Map interface code provided (see bottom of page). 
*	The exercise is to implement the interface.
*	This is a single-key-to-many-value map, aka 'hashtable'.
*	Below I've implemented it using a singly-linked list. 
*/
public class SimpleMap2Impl implements SimpleMap2 {

	private KeyValueNode head = null;
	
	public static void main(String[] args) {
	
		SimpleMap2 sm = new SimpleMap2Impl	();
		System.out.println("Before putting into list, isEmpty() should be true =>> " + sm.isEmpty());
		System.out.println("putting in... " + sm.put(2, "Bob"));
		System.out.println("now isEmpty() should be false =>> " + sm.isEmpty());
		System.out.println("putting in... " + sm.put(2, "Jane"));
		System.out.println("putting in... " + sm.put(2, "Mike"));
		System.out.println("putting in... " + sm.put(234, "Mandy"));
		System.out.println("putting in... " + sm.put(65, "Sandy"));
		System.out.println("putting in... " + sm.put(76, "James"));
		System.out.println("putting in... " + sm.put(76, "Jan"));
		System.out.println("LIST: " + sm.toString());
		System.out.print("get(76) should give James and Jan =>> ");
		String[] result = sm.get(76);
		
		for (int i = 0; i < result.length; i++) {
		
			System.out.print(result[i] + " ");
		
		} 

		System.out.println();
		System.out.print("get(2) should give Bob Jane and Mike =>> ");
		result = sm.get(2);

		for (int i = 0; i < result.length; i++) {
		
			System.out.print(result[i] + " ");
		
		} 
		
		System.out.println();	
	
		System.out.print("..removing 2:Jane");
		sm.remove(2, "Jane");
		System.out.print("..removing 2:Mike");
		sm.remove(2, "Mike");
		System.out.print("..removing 2:Bob");
		sm.remove(2, "Bob");
		sm.remove(234, "Mandy");
		System.out.print("..removing 234:Mandy");
		System.out.println("\nisEmpty() should still be false =>> " + sm.isEmpty());
		System.out.println("LIST: " + sm.toString());	
		System.out.print("..removing 65:Sandy");
		sm.remove(65, "Sandy");
		System.out.print("..removing 76:Jane - which doesn't exist: ");
		sm.remove(76, "Jane");
		System.out.println("\nLIST: " + sm.toString());	
		System.out.print("..removing 76:James");
		sm.remove(76, "James");
		System.out.print("..removing 76:Jan");
		sm.remove(76, "Jan");
		System.out.println("\nLIST: " + sm.toString());	
		System.out.println("isEmpty() should now be true =>> " + sm.isEmpty());
				
	}	
	
	@Override
	public String toString() {
	
		if (head == null) {
		
			return "list is empty";
		
		} else {
		
			return head.toString();
		
		}
	
	}
	
	/*
	* (Not sure why put returns a string. I have written it to 
	* return the key-value pair as a string.
	*/
	@Override
	public String put(int key, String name) {
	
		if (head == null) {
		
			head = new KeyValueNode(key, name);
			return "" + key + ":" + name;
		
		} else {
		
			return head.put(key, name);
		
		}
	
	}
	
	@Override
	public String[] get(int key) {
	
//		String[] namesAry = null;
		String names = "";
		
		if (head.key == key) {

			names = head.name + "," + head.get(key);  

		} else {
		
			names = head.get(key);
		
		}
		
		return names.split(",");
	
	}
	
	@Override
	public void remove(int key, String name) {
	
		try {
	
			if (head == null) {
		
				throw new NullPointerException();		
		
			} else {
			
				if (head.key == key && head.name == name) {
		
					head = head.next;
			
				}
				
				head.remove(key, name);
		
			}
			
		} catch (NullPointerException e) {
		
			System.out.println();
		
		}
	
	}
	
	@Override
	public boolean isEmpty() {
	
		if (head == null) {
		
			return true;
		
		} else {
		
			return false;
		
		}
	
	}
	
	private class KeyValueNode {
	
		private String name;
		private int key;
		private KeyValueNode next;
		
		private KeyValueNode(int key, String name) {
		
			this.key = key;
			this.name = name;
			next = null;
		
		}
		
		@Override
		public String toString() {
		
			String list = key + ":" + name + " "; 
			
			if (next == null) {
			
				return list;
				
			} else {
			
				return list + next.toString();				
			
			}
		
		}
		
		private String put(int key, String name) {
		
			if (next == null) {
			
				next = new KeyValueNode(key, name);
				return "" + key + ":" + name; 
			
			} else {
			
				return next.put(key, name);
			
			}
			
		}
		
		private String get(int key) {
		
			if (next == null) {
			
				return "";
			
			} else {
			
				if (next.key == key) {
				
					return next.name + "," + next.get(key);
				
				} else {
				
					return next.get(key);
				
				}
			
			}
		
		}
		
		private void remove(int key, String name) {
		
			if (next == null) {
			
				return;
			
			} else if (next.key != key) {
			
				next.remove(key, name);
			
			} else if (next.key == key) {
				
				if (next.name != name) {
				
					next.remove(key, name);
				
				} else {
				
					next = next.next;
					next.remove(key, name);
					
				}
				
			}
		
		}	
	
	}
	
}

/**
* Map from integer to Strings: one to many
*/
interface SimpleMap2 {

	/**
	* Puts a new String in the map. 
	*/
	String put(int key, String name);

	/**
	* Returns all the names associated with that key,
	* or null if there is none.	
	*/
	String[] get(int key);

	/**
	* Removes a name from the map.
	*/
	void remove(int key, String name);

	/**
	* Returns true if there are no workers in the map,
	* false otherwise
	*/
	boolean isEmpty();

}