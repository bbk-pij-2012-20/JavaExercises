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

public class GenericHashTable<K,V> {

  private Mapping<K,V>[] mappings;

  public GenericHashTable() {

    mappings = new Mapping[1000];

  }

  /**
  * puts specified key with specified value.
  * in contrast to GenericSimpleMap, if mappings already contain a key-value pair,
  * the new value does not overwrite the current value but is instead added as another
  * value for that key, using an hashing function and an array - hence hashtable.
  */
  public void put(K key, V value) {

    int index = getNewHash(key);
    Mapping mapping = mappings[index];

    try {

      if (key == null) {

        throw new Exception("key is null, cannot put key-value with null key");

      }

      if (mapping == null) {

        mappings[index] = new Mapping();

      }

      mapping.put(key, value);

    } catch (Exception e) {

      System.out.println(e.getMessage());

    }

  }

  public V[] get(K key) {

    int index = getNewHash(key);
    V[] values = null;

    try {

      if (key == null) {

        throw new Exception("key is null, cannot get value with null key");

      }

      if (mappings[index] != null) {

    ///    values = toArray(mappings[index].getRootNode(key), key).getValue();

      }

    } catch (Exception e) {

      System.out.println(e.getMessage());

    }

    return values;

  }

  private Node<K,V>[] toArray(Node<K,V> rootNode, K key) {

    Node<K,V> currentNode = rootNode;
    int arraySize = 0;
    Node<K,V>[] nodesWithSameKey = null;

    if (rootNode != null && rootNode.getKey().hashCode() == key.hashCode()) {

      arraySize = 1;

    }

    while (arraySize > 0 && currentNode.getNext() != null) {

      if (currentNode.getKey().hashCode() == key.hashCode()) {

        arraySize++;
        currentNode = currentNode.getNext();

      }

      nodesWithSameKey = new Node<K,V>[arraySize];
      currentNode = rootNode;

      for (int i = 0; i < nodesWithSameKey.length; i++) {

        if (currentNode.getKey().hashCode() == key.hashCode()) {

          nodesWithSameKey[i] = currentNode;

        }

        if (currentNode.getNext() != null) {

          currentNode = currentNode.getNext();

        }

      }

    }

    return nodesWithSameKey;

  }

  public V remove(K key) {



  }

  /**
  * converts the key into its hashcode, then to an integer within 0 and 999 (inclusive)
  */
  private int getNewHash(K key) {

    return Math.abs(key.hashCode()) % 999;

  }

}

class Mapping<K,V> {

  private Node<K,V>[] bucket;

  public Mapping() {

    bucket = new Node[100];

  }

  /**
  *
  */
  public void put(K key, V value) {

    Node<K,V> node = new Node<>(key, value);
    int index = getNewHash(key);

    if (bucket[index] == null) {

      bucket[index] = node;//i.e. the root node.

    } else {

      bucket[index].add(node); // will add to end of linked list of nodes

    }

  }

  /**
  *
  */
  public Node<K,V> getRootNode(K key) {

    int index = getNewHash(key);
    Node<K,V> valuesRootNode = null;

    try {

      if (key == null) {

        throw new Exception("key is null in Mapping - something's gone wrong");

      }

      if (bucket[index] == null) {

        throw new Exception("bucket for this key is null in Mapping - something's gone wrong");

      } else {

        valuesRootNode = bucket[index];

      }

    } catch (Exception e) {

      System.out.println(e.getMessage());

    }

    return valuesRootNode;

  }

  private int getNewHash(K key) {

    return Math.abs(key.hashCode()) % 99;

  }

}

/**
* class that acts as the bucket in a hashtable. Deals with collisions by using
* the separate chaining model (as opposed to linear probing).
* Here I've implemented a separate chaining model with linked lists.
*/
class Node<K,V> {

  private K key;
  private V value;
  private Node<K,V> next;

  public Node(K key, V value) {

    this.key = key;
    this.value = value;

  }

  public void add(Node<K,V> node) {

    if (next == null) {

      next = node;

    } else {

      next.add(node);

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
