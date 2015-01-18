// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/06_MAPS
// Exercise 8.5.2 (Introduction to Maps)
 
/* 
Create a class that implements the following interface (see bottom of page 
for interface) of a simple map from integers to strings. 

Hint: You can implement it with arrays or with linked lists. 
You do not know in advance how many strings you will receive for every key.

*/
/*
// implemented with an array 
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
*/

/*
*	The Map interface code provided (see bottom of page). 
*	The exercise is to implement the interface.
*	This is a single-key-to-single-value map, aka 'dictionary'.
*	Below I've implemented it using a linked list. Above, as an array.
*/
public class SimpleMapImpl implements SimpleMap {

	private KeyValueNode head;
	
	public static void main(String[] args) {
	
		SimpleMap sm = new SimpleMapImpl();
		System.out.println("Not put anything in list, so \'isEmpty()\' should be true: " + sm.isEmpty() + "\n");
		sm.put(2, "Bob");
		sm.put(324, "Mic");
		sm.put(453, "Jac");
		sm.put(194, "Dean");
		sm.put(606, "Terri");
		System.out.println("5 KVNodes added to list, so \'isEmpty()\' should be false =>> " + sm.isEmpty());
		System.out.println("\nLIST - HEAD =>>   " + sm.toString() + "\n");
		System.out.print("Get 194 ");
		System.out.println("..should be Dean =>> " + sm.get(194));
		System.out.println("\nLIST - HEAD =>>   " + sm.toString() + "\n");
		System.out.print("...removing KVNode 194...");
		sm.remove(194);
		System.out.print("Get(194) ..should give null =>> ");
		System.out.println(sm.get(194));
		System.out.print("...removing KVNode 606...");
		sm.remove(606);
		System.out.println("\nLIST - HEAD =>   " + sm.toString() + "\n");
		System.out.print("...removing KVNode 2...");
		sm.remove(2);
		System.out.println("\nLIST - HEAD =>   " + sm.toString() + "\n");
				
	}
	
	@Override
	public String toString() {

		if (head == null) {
		
			return "nothing to print - empty list";
	
		} else {
		
			return head.toString();
		
		}
	
	}

	@Override
	public void put(int key, String name) {
	
		if (head == null) {
		
			head = new KeyValueNode(key, name);
		
		} else {
		
			head.put(key, name);
		
		}	
	
	}
	
	@Override
	public String get(int key) {
		
		if (head.key == key) {
			
			return head.name;
			
		} else {
			
			return head.get(key);
			
		}
	
	}
	
	@Override
	public void remove(int key) {
	
		if (head.key == key) {
		
			head = head.next; 
		
		} else {
		
			head.remove(key);
		
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

	/**
	*	inner key-value elements
	*/
	protected class KeyValueNode {
	
		private int key;
		private String name;
		private KeyValueNode next;
	
		protected KeyValueNode(int key, String name) {
		
			this.key= key;
			this.name = name;
		
		}
		
		@Override
		public String toString() {
		
			String list = key + ":" + name;
			
			if (next == null) {
			
				return list;  
			
			} else {
			
				return list +  " | " + next.toString();
		
			}
			
		}
		
		protected void put(int key, String name) {
		
			if (next == null) {
			
				next = new KeyValueNode(key, name);
			
			} else {
			
				next.put(key, name);
			
			}
			
		}
		
		protected String get(int key) {
		
			String name = "";
			
			try {
			
				if (next.key != key) {
			
					if (next == null) {
	
						throw new NullPointerException();
					
					} else {
			
						return next.get(key);
			
					}
					
				} else {
									
					name = next.name;
				
				}
		
			} catch (NullPointerException e) {
			
				System.out.println(e.getMessage());
			
			}
			
			return name;
		
		}
		
		protected void remove(int key) {
		
//			KeyValueNode current = this;
			
			if (next != null) {
			
				if (next.key == key) {
				
					next = next.next;
				
				} else {
				
					next.remove(key);
				
				}
			
			}
		
		}
		
	}

}

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