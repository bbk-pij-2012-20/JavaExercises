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
 * This is the class that actually holds the key-value pairs.
 * It also deals with collisions by linking at a doubly-linked list.
 * Dealing with collisions in this manner is referred to as the 'separate
 * chaining model' (as opposed to 'linear probing' which can involve just moving
 * along an array until the next available slot is found).
 */
public class Node<K, V> {

	private K key;
	private V value;
	private Node<K,V> next;
	private Node<K,V> previous;

	public Node(K key, V value) {

		this.key = key;
		this.value = value;
		next = previous = null;

	}

	/**
	 * adds nodes to a doubly-linked list
	 * @param node
	 */
	public void add(Node<K,V> node) {

		if (next == null) {

			node.previous = this;
			next = node;

		} else {

			next.add(node);

		}

	}

	/**
	 * called from GenericHashTable, by the node to be removed, i.e. this node.
	 */
	public void remove() {

		next.previous = previous;

		if (previous != null) {

			previous.next = next;

		}

	}

	public V getValue() {

		return value;

	}

	public Node<K,V> getNext() {

		return next;

	}

	public K getKey() {

		return key;

	}

}
