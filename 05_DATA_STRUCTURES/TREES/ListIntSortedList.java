// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/05_DATA_STRUCTURES/TREES
// Exercise 9.3. (Introduction to Trees, Sets, interfaces, sorted & unsorted lists)
/*
9.3.1. Interface
Create an interface IntSortedList with the following methods, including the comments:
add(int) adds a new int to the list so that the list remains sorted; a list can contain duplicates unlike a set.
contains(int) returns true if the number is in the list, false otherwise.
toString() returns a string with the values of the elements in the list separated by commas.

9.3.2. Implementation as tree
Create a class TreeIntSortedList that implements this interface based on a tree structure.
(This part is in a separate java file TreeIntSortedList)

9.3.3. Implementation as list
Create a class ListIntSortedList that implements this interface based on a linked list structure.

*/

public class ListIntSortedList implements IntSortedList {

  private IntegerNode root;

  public static void main(String[] args) {

    IntSortedList list = new ListIntSortedList();
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
    System.out.println("list contains(635), should return true: " + list.contains(635));
    System.out.println("list.toString(): " + list.toString());

  }

  @Override
  public void add(int n) {

    if (root == null) {

      root = new IntegerNode(n);

    } else {

      if (n < root.n) {

        IntegerNode newNode = new IntegerNode(n);
        newNode.next = root;
        root.previous = newNode;
        root = newNode;

      } else {

        root.add(n);

      }

    }

  }

  @Override
  public boolean contains(int n) {

    boolean contains = false;

    try {

      if (root == null) {

        throw new IllegalArgumentException("List is empty. Thus, contains(int) is false");

      }

      if (root.n == n) {

        contains = true;

      } else {

        contains = root.contains(n);

      }

    } catch (IllegalArgumentException e) {

      System.out.println(e.getMessage());

    }

    return contains;

  }

  @Override
  public String toString() {

    String listToString = "";

    try {

      if (root == null) {

        throw new IllegalArgumentException("List is empty. Thus, toString() is blank");

      }

      listToString = root.toString();

    } catch (IllegalArgumentException e) {

      System.out.println(e.getMessage());

    }

    return listToString;

  }

  private class IntegerNode {

    private IntegerNode next, previous;
    private int n;

    private IntegerNode(int n) {

      next = previous = null;
      this.n = n;

    }

    /**
    * Adds new node with specified int, simultaneously sorting the node so that
    * the list is ordered (from lowest int node at the root to largest at the end
    * of the linked list).
    */
    private void add(int n) {

      if (next == null) {

        next = new IntegerNode(n);
        next.previous = this;

      } else {

        if (n < next.n) {

          IntegerNode newNode = new IntegerNode(n);
          newNode.next = next;
          newNode.previous = this;
          next.previous = newNode;
          next = newNode;

        } else {

          next.add(n);

        }

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

    @Override
    public String toString() {

      String listToString = "" + n;

      if (next != null) {

        listToString += ", " + next.toString();

      }

      return listToString;

    }

  }

}

interface IntSortedList {

  /**
  * Adds a new int to the list so that the list remains sorted;
  * a list can contain duplicates unlike a set.
  */
  void add(int n);

  /**
  * Returns true if the number is in the list, false otherwise.
  */
  boolean contains(int n);

  /**
  * Returns a string with the values of the elements in the list separated by commas.
  */
  String toString();

}
