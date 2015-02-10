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

9.3.3. Implementation as list
Create a class ListIntSortedList that implements this interface based on a linked list structure.
(This part is in a separate java file ListIntSortedList)
*/

public class TreeIntSortedList implements IntSortedList {

  private IntegerTreeNode root;

  public static void main(String[] args) {

    IntSortedList tree = new TreeIntSortedList();
    tree.add(6);
    tree.add(56);
    tree.add(2);
    tree.add(95);
    tree.add(635);
    tree.add(8);
    tree.add(2);
    tree.add(6);
    tree.add(46);
    tree.add(16);
    System.out.println("list contains(635), should return true: " + tree.contains(635));
    System.out.println("list.toString(): " + tree.toString());

  }

  @Override
  public void add(int n) {

    if (root == null) {

      root = new IntegerTreeNode(n);

    } else {

      root.add(n);

    }

  }

  @Override
  public boolean contains(int n) {

    boolean contains = false;

    try {

      if (root == null) {

        throw new IllegalArgumentException("Tree is empty. Thus, contains(int) is false");

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

    String treeToString = "";

    try {

      if (root == null) {

        throw new IllegalArgumentException("Tree is empty. Thus, toString() is blank");

      }

      treeToString = root.toString();

    } catch (IllegalArgumentException e) {

      System.out.println(e.getMessage());

    }

    return treeToString;

  }

  private class IntegerTreeNode {

    private IntegerTreeNode leftChild, rightChild;
    private int n;

    private IntegerTreeNode(int n) {

      leftChild = rightChild = null;
      this.n = n;

    }

    /**
    * Adds a unique int. (Only called if the tree does not already have this int).
    */
    private void add(int n) {

      if (n >= root.n) {

        if (rightChild == null) {

          rightChild = new IntegerTreeNode(n);

        } else {

          rightChild.add(n);

        }

      } else {

        if (leftChild == null) {

          leftChild = new IntegerTreeNode(n);

        } else {

          leftChild.add(n);

        }

      }

    }

    private boolean contains(int n) {

      if (n > this.n) {

        if (n == rightChild.n) {

          return true;

        } else {

          return rightChild.contains(n);

        }

      } else {

        if (n == leftChild.n) {

          return true;

        } else {

          return leftChild.contains(n);

        }

      }

    }

    @Override
    public String toString() {

      String treeToString = "" + n;

      if (leftChild != null) {

        treeToString += ", " + leftChild.toString();

      }

      if (rightChild != null) {

        treeToString += ", " + rightChild.toString();

      }

      return treeToString;

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
