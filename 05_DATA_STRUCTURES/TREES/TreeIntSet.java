// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/05_DATA_STRUCTURES/TREES
// Exercise 9.2 (Introduction to Trees)
/*
Complete the class IntegerTreeNode.

9.2.1.
Create an interface IntSet with the following methods, including the comments:
add(int) adds a new int to the set; if it is there already, nothing happens.
contains(int) returns true if the number is in the set, false otherwise.
containsVerbose(int) returns the same values as the former method, but for
every element that is checked prints its value on screen.
toString() returns a string with the values of the elements in the set separated by commas.

9.2.2.
Create a class TreeIntSet that implements this interface based on a tree structure.

9.2.3.
Create a class ListIntSet that implements this interface based on a linked list structure.

*/

public class TreeIntSet implements TreesAsSets {

  private IntegerTreeNode root;

  public static void main(String[] args) {

    TreesAsSets tree = new TreeIntSet();
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
    System.out.println("tree contains(635), should return true: " + tree.contains(635));
    System.out.println("tree containsVerbose(635), should return true: " + tree.containsVerbose(635));
    System.out.println("tree.toString(): " + tree.toString());

  }

  @Override
  public void add(int n) {

    if (root == null) {

      System.out.println("..adding a root to empty tree. int: " + n);
      root = new IntegerTreeNode(n);

    } else {

      if (contains(n)) {

        System.out.println("Tree already has this int (" + n + "). Thus, duplicate not added.");

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

      System.out.println("checking root: " + root.n);

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

      result = "empty tree, toString returns nothing";

    } else {

      result = "root: " + root.toString();

    }

    return result;

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

      if (n > this.n) {

        if (rightChild == null) {

          System.out.println("...adding int " + n + " to rightChild.");
          rightChild = new IntegerTreeNode(n);

        } else {

          rightChild.add(n);

        }

      } else {

        if (leftChild == null) {

          System.out.println("...adding int " + n + " to leftChild.");
          leftChild = new IntegerTreeNode(n);

        } else {

          leftChild.add(n);

        }

      }

    }

    private boolean contains(int n) {

      if (n > root.n) {

        if (rightChild == null) {

          return false;

        } else {

          if (rightChild.n == n) {

            return true;

          } else {

            return rightChild.contains(n);

          }

        }

      } else {

        if (leftChild == null) {

          return false;

        } else {

          if (leftChild.n == n) {

            return true;

          } else {

            return leftChild.contains(n);

          }

        }

      }

    }

    private boolean containsVerbose(int n) {

      if (n > root.n) {

        if (rightChild != null) {

          System.out.println("\'containsVerbose(" + n + ")\' method checking rightChild: " + rightChild.n);

          if (rightChild.n == n) {

            return true;

          } else {

            return rightChild.containsVerbose(n);

          }

        } else {

          return false;

        }

      } else if (n < root.n) {

        if (leftChild != null) {

          System.out.println("\'containsVerbose(" + n + ")\' method checking leftChild: " + leftChild.n);

          if (leftChild.n == n) {

            return true;

          } else {

            return leftChild.containsVerbose(n);

          }

        } else {

          return false;

        }

      } else {
        // This is just for compiler. The containsVerbose(n) method in
        // the outerClass already returns true if the root has the specified int.
        return false;

      }

    }

    @Override
    public String toString() {

      String result = "" + n;

      if (leftChild != null) {

        result += ", " + leftChild.toString();

      }

      if (rightChild != null) {

        result += ", " + rightChild.toString();

      }

      return result;

    }

  }

}

interface TreesAsSets {

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
