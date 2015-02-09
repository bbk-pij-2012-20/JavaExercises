// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/05_DATA_STRUCTURES/TREES
// Exercise 9.2. (Introduction to Trees, Sets and interfaces)
/*
9.2.1.
Create an interface IntSet with the following methods, including the comments:
add(int) adds a new int to the set; if it is there already, nothing happens.
contains(int) returns true if the number is in the set, false otherwise.
containsVerbose(int) returns the same values as the former method, but for
every element that is checked prints its value on screen.
toString() returns a string with the values of the elements in the set separated by commas.

9.2.2.
Create a class TreeIntSet that implements this interface based on a tree structure.
(This is saved in a separate file called 'TreeIntSet').

9.2.3.
Create a class ListIntSet that implements this interface based on a linked list structure.

*/

public class ListIntSet implements IntSet {

  private IntegerNode root;

  public static void main(String[] args) {

    IntSet list = new ListIntSet();
    list.add(6);
    list.add(56);
    list.add(2);
    list.add(95);
    list.add(635);
    list.add(8);
    list.add(2);
    list.add(6);
    list.add(46);
    list.add(16);
  //  System.out.println("linked list contains(635), should return true: " + list.contains(635));
    System.out.println("linked list containsVerbose(635), should return true: ");
    System.out.printf("Result is %s\n", list.containsVerbose(635)? "true" : "false");
    System.out.println("list.toString(): " + list.toString());

  }

  @Override
  public void add(int n) {

    if (root == null) {

      System.out.println("..adding a root to empty linked list. int: " + n);
      root = new IntegerNode(n);

    } else {

      if (contains(n)) {

        System.out.println("List already has this int (" + n + "). Thus, duplicate not added.");

      } else {

        root.add(n);

      }

    }

  }

  @Override
  public boolean contains(int n) {

    if (root == null) {

      return false;

    } else {

      if (root.n == n) {

        return true;

      } else {

        return root.contains(n);

      }

    }

  }

  @Override
  public boolean containsVerbose(int n) {

    if (root == null) {

      System.out.println("empty list");
      return false;

    } else {

      System.out.println("...checking root: " + root.n);

      if (root.n == n) {

        return true;

      } else {

        return root.containsVerbose(n);

      }

    }

  }

  @Override
  public String toString() {

    String result = "";

    if (root == null) {

      result = "empty list, toString returns nothing";

    } else {

      result = "root: " + root.toString();

    }

    return result;

  }

  private class IntegerNode {

    private IntegerNode next, previous;
    private int n;

    private IntegerNode(int n) {

      next = previous = null;
      this.n = n;

    }

    /**
    * Adds a unique int. (Only called if the tree does not already have this int).
    */
    private void add(int n) {

      if (next == null) {

        System.out.println("...adding int " + n);
        next = new IntegerNode(n);
        next.previous = this;

      } else {

        next.add(n);

      }

    }

    private boolean contains(int n) {

      if (next == null) {

        return false;

      } else {

        if (next.n == n) {

          return true;

        } else {

          return next.contains(n);

        }

      }

    }

    private boolean containsVerbose(int n) {

      if (next == null) {

        return false;

      } else {

        System.out.println("\'containsVerbose(" + n + ")\' method ...checking 'next': " + next.n);

        if (next.n == n) {

          return true;

        } else {

          return next.containsVerbose(n);

        }

      }

    }

    @Override
    public String toString() {

      String result = "" + n;

      if (next != null) {

        result += ", " + next.toString();

      }

      return result;

    }

  }

}

interface IntSet {

  /**
  * Adds a new int to the set; if it is there already, nothing happens.
  */
  void add(int n);

  /**
  * Returns true if the number is in the set, false otherwise.
  */
  boolean contains(int n);

  /**
  * ContainsVerbose(int) returns the same values as the former method, but for
  */
  boolean containsVerbose(int n);

  /**
  * Returns a string with the values of the elements in the set separated by commas.
  */
  String toString();

}
