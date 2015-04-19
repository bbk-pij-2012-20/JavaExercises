// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/08_GENERICS_PARAMETRICPOLYMORPHISM/Generics_Ex6_Maps
// Exercise 11.6: Intro to parametric polymorphism (aka Generics).
/*
6.2 Hash table (*)
Create a generic map (with methods for putting a key–value pair, getting the value for a key,
and removing a key).
The key and the value may be any type, and they may be different.
Under each key, the hash table can store any number of values associated to that key.
For simplicity, assume that your map can hold a maximum of 1000 pairs.
This way, you can use the hashing method you developed in past weeks and base your map on an array.
*/

/**
 * The Generic hashtable made here has an array of 1000 elements to hold key-value pairs.
 * However, unlike GenericSimpleMap (exercise 11.6.1), the bucket objects that take up this array
 * have themselves another array (bucket), this time of 100 elements, as opposed to the actual key
 * and value. Each element in this 2nd array holds the key-value buckets within a Node, each of
 * which holds a pointer to another Node that has been placed there by
 * the same two hash functions. A list of nodes in one slot of the bucket could potentially have different
 * keys, and therefore the get(Key) method needs to perform a check of the key for each Node in a list of
 * Nodes returned.
 * Thus, the idea was that this hashtable could store very numbers of generic key-value pairs via an array
 * of arrays, and the condition that it be unlimited in size is satisfied by linked lists in the second
 * of the two arrays.
 * It is possibly more common that the linked lists method of avoiding collisions is applied directly in the
 * first array, rather than there being an array of arrays.
 * The purpose of using an array is for the advantage of random access which makes retrieving a value
 * much faster than from a linked list, and does not change with size of array (hence lookup time is always
 * O(1)). The linked list serves to deal the problem of having to resize the array as and when needed, albeit
 * it at the potential cost of retrieving a value from a linked list that has worst-case lookup time of O(n).
 *
 * @param <K>
 * @param <V>
 */
public class GenericHashTable<K,V> {

	private Bucket<K,V>[] buckets;
	private int arraySize = 0;

	@SuppressWarnings("unchecked")
	public GenericHashTable() {

		buckets = new Bucket[1000];

	}

	public static void main(String[] args) {

		GenericHashTable<String, String> ghtStrStr = new GenericHashTable<>();
		ghtStrStr.put("First", "press on");
		ghtStrStr.put("First", "and wait");
		ghtStrStr.put("First", "enter password");
		ghtStrStr.put("Second", "open window");
		ghtStrStr.put("Third", "click button");
		String[] firstGot = ghtStrStr.get("First");// at runtime, this lines causes java.lang.ClassCastException to be thrown

		for (int i = 0; i < firstGot.length; i++) {

			System.out.println("first should be \'press on\', \'and wait\', \'enter password\': "+firstGot[i] + ", ");

		}

		ghtStrStr.remove("First");
		String[] firstGot2 = ghtStrStr.get("First");

		for (int i = 0; i < firstGot2.length; i++) {

			System.out.println("first should be null, null, null: "+ firstGot2[i] + ", ");

		}

	}

	/**
	 * puts specified key with specified value.
	 * in contrast to GenericSimpleMap, if the index in the array already contain a key-value pair,
	 * the new value does not overwrite the current value but is instead added as another
	 * value for that key, using an hashing function and an array - hence hashtable.
	 * @param key
	 * @param value
	 */
	public void put(K key, V value) {

		int index = getNewHash(key);
		Bucket<K, V> newBucket = new Bucket<>();

		if (buckets[index] != null) {

			buckets[index].put(key, value);

		} else {

			buckets[index] = newBucket;

		}

	}

	/**
	 * returns the value or values corresponding to the key.
	 * As specified for this exercise, duplicate keys do not result in over-writing the
	 * current value with a new value (as done for ex 11.6.1), but these 'collisions'
	 * are simply added to, in this case, indefinitely long lists. This is a defining
	 * characteristic of hashtables.
	 * Thus, the value or values that is/are paired to a specified key is/are returned in
	 * one array, of generic type V.
	 *
	 * @param key
	 * @return
	 */
	public V[] get(K key) {

		int index = getNewHash(key);
		Node<K,V>[] nodesWithSameKey = null;

		if (buckets[index] != null) {

			nodesWithSameKey = nodesWithSameKeyToArray(buckets[index].getRootNode(key), key);
			calculateArraySize(buckets[index].getRootNode(key), key);

		}

		@SuppressWarnings("unchecked")
		V[] values = (V[])new Object[arraySize];

		for (int i = 0; i < nodesWithSameKey.length; i++) {

			values[i] = nodesWithSameKey[i].getValue();

		}

		return values;

	}

	@SuppressWarnings("unchecked")
	private Node<K,V>[] nodesWithSameKeyToArray(Node<K,V> rootNode, K key) {

		Node<K,V> currentNode = rootNode;
		Node<K,V>[] nodesWithSameKey = null;
		nodesWithSameKey = new Node[arraySize];

		for (int i = 0; i < nodesWithSameKey.length; i++) {

			if (currentNode.getKey().hashCode() == key.hashCode()) {

				nodesWithSameKey[i] = currentNode;

			}

			if (currentNode.getNext() != null) {

				currentNode = currentNode.getNext();

			}

		}

		return nodesWithSameKey;

	}

	private void calculateArraySize(Node<K,V> rootNode, K key) {

		Node<K,V> currentNode = rootNode;

		if (rootNode != null && rootNode.getKey().hashCode() == key.hashCode()) {

			arraySize = 1;

		}

		while (arraySize > 0 && currentNode.getNext() != null) {

			if (currentNode.getKey().hashCode() == key.hashCode()) {

				arraySize++;
				currentNode = currentNode.getNext();

			}

		}

	}

	/**
	 * Returns value(s) corresponding to specified key.
	 * Removes key-value pair(s) corresponding to specified key.
	 *
	 * @param key
	 * @return
	 */
	public V[] remove(K key) {

		int index = getNewHash(key);
		Node<K,V>[] nodesWithSameKey = null;

		if (buckets[index] != null) {

			nodesWithSameKey = getAndRemoveNodesWithSameKey(buckets[index].getRootNode(key), key);
			calculateArraySize(buckets[index].getRootNode(key), key);

		}

		@SuppressWarnings("unchecked")
		V[] values = (V[])new Object[arraySize];

		for (int i = 0; i < nodesWithSameKey.length; i++) {

			values[i] = nodesWithSameKey[i].getValue();

		}

		return values;

	}

	@SuppressWarnings("unchecked")
	private Node<K,V>[] getAndRemoveNodesWithSameKey(Node<K,V> rootNode, K key) {

		Node<K,V> currentNode = rootNode;
		Node<K,V> nodeToRemove = null;
		Node<K,V>[] nodesWithSameKey = new Node[arraySize];

		for (int i = 0; i < nodesWithSameKey.length; i++) {

			if (currentNode.getKey().hashCode() == key.hashCode()) {

				nodeToRemove = nodesWithSameKey[i] = currentNode;

			}

			if (currentNode.getNext() != null) {

				currentNode = currentNode.getNext();

			}

			nodeToRemove.remove();

		}

		return nodesWithSameKey;

	}

	/**
	 * converts the key into its hashcode, then to an integer within 0 and 999 (inclusive)
	 */
	private int getNewHash(K key) {

		return Math.abs(key.hashCode()) % 999;

	}

}
