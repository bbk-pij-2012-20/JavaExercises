// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/05_DATA_STRUCTURES/TREES
// Exercise 9.1 (Introduction to Trees)
/*
Complete the class IntegerTreeNode.
9.1.1.
From the notes, you already know what the member fields are and you have seen a possible implementation of
methods add(int) and contains(int). Implement as well two methods getMax() and getMin() that returns the
maximum and the minimum values stored in the tree.
Compile the class and use it inside a script1 adding numbers in different orderings.

Implement as well two methods getMax() and getMin() that returns the
maximum and the minimum values stored in the tree.
Compile the class and use it inside a script1 adding numbers in different orderings

9.1.2.
Add a method toString() to the class. This methods must return a representation of your tree in String form,where every node is represented as a list in square brackets containing its value, the left branch, and the rightbranch; the left branch should be prefixed by “L” and the right branch by R, and an empty branch should be shownas an empty pair of square brackets. Some examples of outputs in Figure 1.After you have commited this version of toString(), make another version that returns a simplified representation,where every node is represented as a list in square brackets containing its value and its branches, but onlyif they are not empty; without using the “L” and “R” prefixes. Some examples of outputs in Figure 1.Check that both versions of the method work by adding several elements and printing the String representationof the tree.

9.1.3.
Add a method depth() that returns the number of levels in a tree. By convention, a tree with only one node(i.e. the root) has a depth of zero. Hint: the depths of the trees in Figure 1 are 0, 1, 2, and 3.Hint: the depth of a tree is one more than the deepest of its subtreees

9.1.4.
Add a method remove(int) to the class. This method must look for the node that contains the given value and
remove it from the tree.
Hint: removing leafs is trivial; to remove nodes, you can replace the removed node with its highest element on
its left or the lowest on its right.

9.1.5.
Trees work very well with unsorted data because they automatically sort it as they are filled up with data. There is
a problem with already sorted data, though: all elements are placed on the same branches and the “natural sorting”
effect is lost, the tree becomes just a list with an additional null pointer at every level.
Add a method rebalance() to your tree that re-arranges the tree to make it balanced, i.e. having approximately
the same number of nodes on both branches.

*/

public class IntegerTree {

  private IntegerTreeNode root;

  public static void main(String[] args) {

    IntegerTree tree = new IntegerTree();
    System.out.println("root should be null at start: " + tree.root);
    tree.add(5);
    System.out.println("root should now be 5: " + tree.root);
    tree.add(42);
    tree.add(6);
    tree.add(8);
    tree.add(57);
    tree.add(58);
    tree.add(69);
    tree.add(99);
    tree.add(68);
    tree.add(67);
    tree.add(66);
    tree.add(1);
    System.out.println("contains(57) should return true: " + tree.contains(57));
    System.out.println("contains(56) should return false: " + tree.contains(56));
    System.out.println("getMax() should give 99: " + tree.getMax());
    System.out.println("getMin() should give 1: " + tree.getMin());
    System.out.println("toString(): " + tree.toString());
    System.out.println("depth(): " + tree.depth());
  //  tree.remove(5);
  //  System.out.println("toString(): " + tree.toString());
    tree.remove(58);
    System.out.println("toString(): " + tree.toString());

  }

  public IntegerTree() {

    root = null;

  }

  /**
  *  adds a new integer node with the integer passed
  */
  public void add(int n) {

    if (root == null) {

      root = new IntegerTreeNode(n);

    } else {

      root.add(n);

    }

  }

  /**
  *  returns true if tree contains the integer passed
  */
  public boolean contains(int n) {

    if (root == null) {

      return false;

    } else if (root.n == n) {

      return true;

    } else {

      return root.contains(n);

    }

  }

  /**
  *  calculates the depth of the tree
  */
  public int depth() {

    int depth = 0;

    if (root != null) {

      depth = root.depth(0);

    }

    return depth;

  }

  /**
  *  finds the maximum integer in the tree
  */
  public int getMax() {

    int max = 0;

    try {

      if (root == null) {

        throw new NullPointerException("no tree, therefore getMax() cannot return anything");

      } else if (root.right == null && root.left == null) {

        return root.n;

      }

    } catch (NullPointerException e) {

      System.out.println(e.getMessage());

    }

    return root.getMax();

  }

  /**
  *  finds the minimum integer in the tree
  */
  public int getMin() {

    int min = 0;

    try {

      if (root == null) {

        throw new NullPointerException("no tree, therefore getMin() cannot return anything");

      } else if (root.right == null && root.left == null) {

        return root.n;

      }

    } catch (NullPointerException e) {

      System.out.println(e.getMessage());

    }

    return root.getMin();

  }

  public boolean remove(int n) {

    boolean nodeRemove = true;

    if (root == null) {

      nodeRemove = false;

    } else if (contains(n)) {

      nodeRemove = true;

      if (root.n == n) {

        reorderTreeAfterRemovingRoot();

      } else {

        root.remove(root, n);

      }

    }

    return nodeRemove;

  }

  /**
  * Reorders the tree when the node to remove is the root.
  */
  public void reorderTreeAfterRemovingRoot() {

    IntegerTreeNode replacement = null;
    IntegerTreeNode replacementParent = null;

    if (root.left != null) {

      replacementParent = retrieveParentOfReplacementFrom("left", root.left, root);

      if (replacementParent == root) {

        replacement = replacementParent.left;
        replacement.right = root.right;

      } else {

        replacement = replacementParent.right;
        replacement.right = root.right;
        replacementParent.right = replacement.left;
        replacement.left = root.left;

      }

    } else if (root.right != null) {

      replacementParent = retrieveParentOfReplacementFrom("right", root.right, root);

      if (replacementParent == root) {

        replacement = replacementParent.right;
        replacement.left = root.left;

      } else {

        replacement = replacementParent.left;
        replacement.left = root.left;
        replacementParent.left = replacement.right;
        replacement.right = root.right;

      }

    }

    root = replacement;

  }

  /**
  * Retrieves the parent of the appropriate node according to the subtree specified.
  * (The parent is required because the pointer to the child that will be relocated must itself be redirected).
  * Hence, if the left subtree is specifed, node retrieved should be that with the highest int n.
  * If the right subtree is specified, node retrieved should be that with the lowerst int n.
  */
  public IntegerTreeNode retrieveParentOfReplacementFrom(String subtree, IntegerTreeNode child, IntegerTreeNode parent) {

    if (subtree.equals("left")) {

      if (child.right == null) {

        return parent;

      } else {

        return retrieveParentOfReplacementFrom("left", child.right, child);

      }

    } else {

      if (child.left == null) {

        return parent;

      } else {

        return retrieveParentOfReplacementFrom("right", child.left, child);

      }

    }

  }

/*
  //“complete version”
  @Override
  public String toString() {

    if (root == null) {

      return "empty tree";

    } else {

      return "root[" + root.n + root.toString(root) + "]";

    }

  }
*/
  @Override
  public String toString() {

    if (root == null) {

      return "empty tree";

    } else {

      return "root[" + root.toString() + "]";

    }

  }

  /**
  *  the node as an inner class
  */
  private class IntegerTreeNode {

    private int n;
    private IntegerTreeNode left;
    private IntegerTreeNode right;
    private int deepest;

    private IntegerTreeNode(int n) {

      this.n = n;
      left = right = null;
      deepest = 0;

    }

    /**
    *  adds a new node with the passed integer
    */
    private void add(int n) {

      if (n >= this.n) {

        if (right == null) {

          right = new IntegerTreeNode(n);

        } else {

          right.add(n);

        }

      } else {

        if (left == null) {

          left = new IntegerTreeNode(n);

        } else {

          left.add(n);

        }

      }

    }

  /**
  *  returns true if tree contains the integer passed
  */
  private boolean contains(int n) {

    if (right == null && left == null) {

      return false;

    }

    if (n > this.n) {

      if (right == null) {

        return false;

      } else if (right.n == n) {

        return true;

      } else {

        return right.contains(n);

      }

    } else {

      if (left == null) {

        return false;

      } else if (left.n == n) {

        return true;

      } else {

        return left.contains(n);

      }

    }

  }

    /**
    *   Calculates the depth of the tree that has at least a root.
    *   (If only root, depth is zero).
    */
    private int depth(int depth) {

      int depth_ = depth;

      if (depth > root.deepest) {

        root.deepest = depth;

      }

      if (left == null && right == null) {

        return root.deepest;

      } else {

        depth_++;

        if (depth_ > root.deepest) {

          root.deepest = depth_;

        }

        if (left != null && right == null) {

          return left.depth(depth_);

        }

        if (right != null && left == null) {

          return right.depth(depth_);

        }

        left.depth(depth_);
        return right.depth(depth_);

      }

    }

    /**
    *  finds the maximum integer in the tree
    */
    private int getMax() {

      if (right == null) {

        return n;

      } else {

        return right.getMax();

      }

    }

    /**
    *  finds the minimum integer in the tree
    */
    private int getMin() {

      if (left == null) {

        return n;

      } else {

        return left.getMin();

      }

    }

    /**
    * Traverses the tree to find the node with int n, and removes it from the tree.
    * The necessary subsequent re-ordering of the tree is encapsulated in separate
    * functions.
    */
    private void remove(IntegerTreeNode node, int n) {

      if (node.left != null) {

        if (n < node.n) {

          if (n == node.left.n) {

            reorderTreeAfterRemoving(node.left, "left", node);

          } else {

            remove(node.left, n);

          }

        }

      } else if (node.right != null) {

        if (n > node.n) {

          if (n == node.right.n) {

            reorderTreeAfterRemoving(node.right, "right", node);

          } else {

            remove(node.right, n);

          }

        }

      }

    }

    /**
    * Receives both the node that is to be removed, as well as its parent node.
    * These two should not be confused with the node that will replace the removed node,
    * and its parent node.
    */
    private void reorderTreeAfterRemoving(IntegerTreeNode nodeToRemove, String childOf, IntegerTreeNode removeParent) {

      IntegerTreeNode replacement = null;
      IntegerTreeNode replacementParent = null;
      IntegerTreeNode removeParent_ = removeParent;

      if (nodeToRemove.left != null) {

        replacementParent = retrieveParentOfReplacementFrom("left subtree of", nodeToRemove, removeParent);

        if (replacementParent == nodeToRemove) {

          replacement = nodeToRemove.left;
          replacement.right = nodeToRemove.right;

        } else {

          replacement = replacementParent.right;
          replacement.right = nodeToRemove.right;
          replacementParent.right = replacement.left;
          replacement.left = nodeToRemove.left;

        }

      } else if (nodeToRemove.right != null) {

        replacementParent = retrieveParentOfReplacementFrom("right subtree of", nodeToRemove, removeParent);

        if (replacementParent == nodeToRemove) {

          replacement = nodeToRemove.right;
          replacement.left = nodeToRemove.left;

        } else {

          replacement = replacementParent.left;
          replacement.left = nodeToRemove.left;
          replacementParent.left = replacement.right;
          replacement.right = nodeToRemove.right;

        }

      }

      if (childOf.equals("left")) {

        removeParent_.left = replacement;

      } else if (childOf.equals("right")) {

        removeParent_.right = replacement;

      }

    }

    /**
    * Takes the node to be removed as the 'parent'. The first potential replacement node is
    * the 'child' node (be it on left of right).
    *
    * Retrieves the parent of the node that will replace the node to be removed.
    * (The parent is required because the pointer that the parent uses to point to the replacement
    * node will have to be reset to one of the replacement node's child nodes (before the replacement
    * node can be relocated).
    *
    * This would not be necessary if the tree was a threaded tree structures (i.e. where nodes can point back up the tree)).
    * Hence, if the left subtree is specifed, node retrieved should be that with the highest int n.
    * If the right subtree is specified, node retrieved should be that with the lowerst int n.
    */
    private IntegerTreeNode retrieveParentOfReplacementFrom(String subtree, IntegerTreeNode child, IntegerTreeNode parent) {

      if (subtree.equals("left subtree of")) {

        if (child.right == null) {

          return parent;

        } else {

          return retrieveParentOfReplacementFrom("left subtree of", child.right, child);

        }

      } else {

        if (child.left == null) {

          return parent;

        } else {

          return retrieveParentOfReplacementFrom("right subtree of", child.left, child);

        }

      }

    }

/*
    // “complete” version
    @Override
    public String toString() {

      if (left == null) {

        if (right == null) {

          return "L[]R[] ";

        } else {

          return "L[]" + "R[" + right.n + right.toString() + "] ";

        }

      } else {

        if (right != null) {

          return "L[" + left.n + left.toString() + "] " + " R[" + right.n + right.toString()+ "] ";

        } else {

          return "L[" + left.n + left.toString() + "] "  + " R[] ";

        }

      }

    }
*/

    // “simplified” version
    @Override
    public String toString() {

      if (left == null) {

        if (right == null) {

          return "" + n + "[][]";

        } else {

          return "" + n + "[]" + "[" + right.toString() + "]";

        }

      } else {

        if (right != null) {

          return "" + n + "[" + left.toString() + "]" + "[" + right.toString() + "]";

        } else {

          return "" + n + "[" + left.toString() + "]"  + "[]";

        }

      }

    }

  }

}
