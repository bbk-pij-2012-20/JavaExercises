// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/08_GENERICS_PARAMETRICPOLYMORPHISM/Generics_Ex6_Maps
// Exercise 11.6: Intro to parametric polymorphism (aka Generics).
/*
6.1 Simple map (*)
Create a generic simple map (with methods for putting a key–value pair, getting the value for
a key, and removing a key-value mapping via a specified key whilst returning the value).
The key and the value may be any type, and they may be different.
Each key can only be linked to one value.
For simplicity, assume that your map can hold a maximum of 1000 pairs.
This way, you can use the hashing method you developed in past weeks and base your map on
an array.

*/

public class GenericSimpleMap<K,V> {

  private Mapping<K,V>[] mappings;

  public GenericSimpleMap() {

    mappings = new Mapping[1000];

  }

  public static void main(String[] args) {

    GenericSimpleMap<String, String> gsmStrStr = new GenericSimpleMap<>();

    System.out.println("putting(\"First\" & \"buy land\") should not throw any exceptions...");
    gsmStrStr.put("First", "buy land");

    System.out.println("putting(\"Next\" & \"buy bricks\") should not throw any exceptions...");
    gsmStrStr.put("Next", "buy bricks");

    System.out.println("putting(\"Finally\" & \"build house\") should not throw any exceptions...");
    gsmStrStr.put("Finally", "build house");

    System.out.println("get(\"Next\") should give \"buy bricks\":..." + gsmStrStr.get("Next"));
    System.out.println("remove(\"Next\") should give \"buy bricks\":..." + gsmStrStr.remove("Next"));
    System.out.println("get(\"Next\") now should return null:..." + gsmStrStr.get("Next"));

  }

  /**
  * puts specified key with specified value
  * if key already exists, the new value overwrites the current value
  */
  public void put(K key, V value) {

    int index = getNewHash(key);
    Mapping<K,V> mapping = null;

    try {

      if (key == null) {

        throw new Exception("key is null - cannot perform put(K,V)");

      }

      if (mappings[index] == null) {

        mapping = new Mapping<K,V>(key, value);
        mappings[index] = mapping;

      } else {

        mappings[index].setValue(value);

      }

    } catch (Exception e) {

      System.out.println(e.getMessage());

    }

  }

  /**
  * removes the key-value pair of specified key, returns the value
  */
  public V remove(K key) {

    V value = null;
    int index = getNewHash(key);

    try {

      if (key == null) {

        throw new Exception("key is null - cannot locate a key-value pair to remove using a null key");

      }

      value = mappings[index].getValue();
      mappings[index] = null;

    } catch (Exception e) {

      System.out.println(e.getMessage());

    }

    return value;

  }

  /**
  * returns value paired with specified key
  * returns null if the value is null
  */
  public V get(K key) {

    V value = null;
    int index = getNewHash(key);

    try {

      if (key == null) {

        throw new Exception("key is null - cannot get a value using a null key");

      }

      value = mappings[index].getValue();

    } catch (Exception e) {

      System.out.println(e.getMessage());

    }

    return value;

  }

  /**
  * converts the key object into an integer within range 1 - 1000
  */
  private int getNewHash(K key) {

    return 1 + (Math.abs(key.hashCode()) % 1000);

  }

}

class Mapping<K,V> {

  private K key;
  private V value;

  protected Mapping(K key, V value) {

    this.key = key;
    this.value = value;

  }

  protected void setValue(V value) {

    this.value = value;

  }

  protected V getValue() {

    return value;

  }

}
