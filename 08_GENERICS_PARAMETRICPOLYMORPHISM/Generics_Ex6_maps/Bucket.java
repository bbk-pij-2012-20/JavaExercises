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
 * The data structure held in an array of 1000 elements in GenericHashTable
 * This data structure is smaller with 100 elements.
 * Bucket's array is an array of linked lists.
 * Thus the hashtable I've made in this exercise is an array within an array.
 * It deals with collisions with a linked list in the 2nd array in this class.
 * @param <K>
 * @param <V>
 */
public class Bucket<K, V> {

	private Node<K,V>[] nodes;

	@SuppressWarnings("unchecked")
	public Bucket() {

		nodes = new Node[100];

	}

	/**
	 *
	 */
	public void put(K key, V value) {

		Node<K,V> node = new Node<>(key, value);
		int index = getNewHash(key);

		if (nodes[index] == null) {

			nodes[index] = node;//i.e. the root node.

		} else {

			nodes[index].add(node); // will add to end of linked list of nodes

		}

	}

	/**
	 * Returns the node in the bucket array.
	 * This will always be the root node, as any other nodes located at the same index will be
	 * pointed to from the first node (as part of a linked list of nodes).
	 */
	public Node<K,V> getRootNode(K key) {

		return nodes[getNewHash(key)];

	}

	private int getNewHash(K key) {

		return Math.abs(key.hashCode()) % 99;

	}

}
