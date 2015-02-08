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
  private int deepest;
  private int nodeCount;
  private IntegerTreeNode[] allNodesStore;

  public static void main(String[] args) {

    IntegerTree tree = new IntegerTree();
    System.out.println("root should be empty at start: " + tree.toString());
    System.out.println("nodeCount should be 0 at start: " + tree.nodeCount);
    tree.add(5);
    System.out.println("root should now be 5: " + tree.toString());
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
//  System.out.println("...contains(58) should return true: " + tree.contains(58));
//  tree.remove(58);
//  System.out.println("...after removing 58 " + tree.toString());
//  System.out.println("...contains(58) should return false: " + tree.contains(58));
//  tree.rebalance();
//  System.out.println("After rebalancing: " + tree.toString());
    tree.countAllNodes();
    System.out.println("nodeCount should be 12: " + tree.nodeCount);
    tree.nodeCount = 0;
    System.out.println("nodeCount reset to 0. root.countNodesInSubtree() should be 12: " + tree.root.countNodesInSubtree());
    tree.nodeCount = 0;
    System.out.println("nodeCount reset to 0. nodeCount root.left should be 1: " + tree.root.leftChild.countNodesInSubtree());
    tree.nodeCount = 0;
    System.out.println("nodeCount reset to 0. nodeCount root.left should be 10: " + tree.root.rightChild.countNodesInSubtree());
    tree.rebalance();
    System.out.println("rebalanced tree: " + tree.toString());

  }

  public IntegerTree() {

    root = null;
    deepest = nodeCount = 0;

  }

  /**
  * Adds a new integer node with the integer passed
  */
  public void add(int n) {

    if (root == null) {

      root = new IntegerTreeNode(n);

    } else {

      root.add(n);

    }

  }

  public void buildBalancedTree() {

    int indexOfLeftMargin = 0;
    int indexOfRightMargin = allNodesStore.length - 1;
    int indexOfNewRoot = (allNodesStore.length / 2) - 1;
    root = allNodesStore[indexOfNewRoot];
    root.buildBalancedSubtree(indexOfNewRoot, indexOfLeftMargin, indexOfRightMargin);

  }

  /**
  * Returns true if tree contains the integer passed
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
  * Returns the number of nodes in whole tree, starting with the root.
  */
  public int countAllNodes() {

    nodeCount = 0;

    if (root == null) {

      return 0;

    } else {

      return root.countNodesInSubtree();

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

        throw new NullPointerException("NullPointerException: no tree, therefore getMax() cannot return anything");

      } else if (root.rightChild == null && root.leftChild == null) {

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

        throw new NullPointerException("NullPointerException: no tree, therefore getMin() cannot return anything");

      } else if (root.rightChild == null && root.leftChild == null) {

        return root.n;

      }

    } catch (NullPointerException e) {

      System.out.println(e.getMessage());

    }

    return root.getMin();

  }

  public void rebalance() {

    try {

      if (root == null) {

        throw new IllegalArgumentException("empty tree - hence, nothing to rebalance");

      } else if (root.countNodesInSubtree() < 2) {

        throw new IllegalArgumentException("only a root and one child node - hence, nothing to rebalance");

      }

      allNodesStore = new IntegerTreeNode[countAllNodes()];
      storeNodesInOrder();
      buildBalancedTree();

    } catch (IllegalArgumentException e) {

      System.out.println(e.getMessage());

    }

  }

  /**
  * Removes node containing int n. Calls other functions to reorder the tree after removing the node.
  */
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

    if (root.leftChild != null) {

      replacementParent = retrieveParentOfReplacementFrom("left", root.leftChild, root);

      if (replacementParent == root) {

        replacement = replacementParent.leftChild;
        replacement.rightChild = root.rightChild;

      } else {

        replacement = replacementParent.rightChild;
        replacement.rightChild = root.rightChild;
        replacementParent.rightChild = replacement.leftChild;
        replacement.leftChild = root.leftChild;

      }

    } else if (root.rightChild != null) {

      replacementParent = retrieveParentOfReplacementFrom("right", root.rightChild, root);

      if (replacementParent == root) {

        replacement = replacementParent.rightChild;
        replacement.leftChild = root.leftChild;

      } else {

        replacement = replacementParent.leftChild;
        replacement.leftChild = root.leftChild;
        replacementParent.leftChild = replacement.rightChild;
        replacement.rightChild = root.rightChild;

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

      if (child.rightChild == null) {

        return parent;

      } else {

        return retrieveParentOfReplacementFrom("left", child.rightChild, child);

      }

    } else {

      if (child.leftChild == null) {

        return parent;

      } else {

        return retrieveParentOfReplacementFrom("right", child.leftChild, child);

      }

    }

  }

  /**
  * Stores the root at correct index in allNodesStore.
  * Stores the remaining nodes via IntegerTreeNode's storeNodesInOrderFrom(int,String).
  */
  public void storeNodesInOrder() {

    int positionOfRoot = 0;

    try {

      if (root == null) {

        throw new IllegalArgumentException("no tree - therefore can't store nodes");

      }

      if (root.leftChild != null) {

        nodeCount = 0;
        positionOfRoot = root.leftChild.countNodesInSubtree();
        allNodesStore[positionOfRoot] = root;
        root.leftChild.storeNodesInOrderFrom(positionOfRoot, "this is left");

      } else {

        allNodesStore[positionOfRoot] = root;

      }

      if (root.rightChild != null) {

        root.rightChild.storeNodesInOrderFrom(positionOfRoot, "this is right");

      }

    } catch (IllegalArgumentException e) {

      System.out.println(e.getMessage());

    }

  }

  //“complete version”
  @Override
  public String toString() {

    if (root == null) {

      return "empty tree";

    } else {

      return "ROOT [" + root.n + root.toString() + "]";

    }

  }
/*
  //"simple version"
  @Override
  public String toString() {

    if (root == null) {

      return "empty tree";

    } else {

      return "root[" + root.toString() + "]";

    }

  }*/

  /**
  * The node as an inner class
  */
  private class IntegerTreeNode {

    private int n;
    private IntegerTreeNode leftChild;
    private IntegerTreeNode rightChild;

    private IntegerTreeNode(int n) {

      this.n = n;
      leftChild = rightChild = null;

    }

    /**
    * Adds a new node with the passed integer
    */
    private void add(int n) {

      if (n >= this.n) {

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

    private void buildBalancedSubtree(int indexOfParent, int indexOfLeftMargin, int indexOfRightMargin) {

      int lengthOfMarginSpecifiedSubarray = Math.abs(indexOfLeftMargin - indexOfRightMargin) + 1;
System.out.print("\nlengthOfMarginSpecifiedSubarray: " + lengthOfMarginSpecifiedSubarray);
      if (lengthOfMarginSpecifiedSubarray == 3) {
System.out.println("     SHOULD PRINT IF 3");
        leftChild = allNodesStore[indexOfLeftMargin];
        leftChild.leftChild = null;
        leftChild.rightChild = null;
        rightChild = allNodesStore[indexOfRightMargin];
        rightChild.leftChild = null;
        rightChild.rightChild = null;

      } else if (lengthOfMarginSpecifiedSubarray == 2) {
System.out.println("SHOULD PRINT IF 2");
System.out.println("====================================indexOfParent: " + indexOfParent);
System.out.println("====================================indexOfRightMargin: " + indexOfRightMargin);
System.out.println("====================================indexOfLeftMargin: " + indexOfLeftMargin);
        if (indexOfParent == indexOfRightMargin) {
System.out.println("this.n should be 5 and 66 and 42" + this.n);
          leftChild = allNodesStore[indexOfLeftMargin];
System.out.print("this.leftChild should be 1 and 58 and null: ");
if (leftChild == null) {
System.out.print(leftChild);
} else {System.out.print(leftChild.n);}
System.out.println("this.leftChild should be 1 and 58" + leftChild.n);
          leftChild.leftChild = null;
          leftChild.rightChild = null;
          rightChild = null;

        } else if (indexOfParent == indexOfLeftMargin) {

          leftChild = null;
          rightChild = allNodesStore[indexOfRightMargin];
          rightChild.leftChild = null;
          rightChild.rightChild = null;

        }

      } else {
System.out.println("           SHOULD PRINT IF NOT 2 OR 3");
        int relativePositionOfLeftChild = -1 * ((Math.abs(indexOfParent - indexOfLeftMargin) + 1 ) / 2);
System.out.println("...indexOfParent: " + indexOfParent + " ...indexOfLeftMargin: " + indexOfLeftMargin + " ...indexOfRightMargin: " + indexOfRightMargin);
        int relativePositionOfRightChild = (Math.abs(indexOfParent - indexOfRightMargin) + 1 ) / 2;
System.out.println("relativePositionOfRightChild: " + relativePositionOfRightChild);
System.out.println("relativePositionOfLeftChild: " + relativePositionOfLeftChild);
        int indexOfLeftChild = indexOfParent + relativePositionOfLeftChild;
        int indexOfRightChild = indexOfParent + relativePositionOfRightChild;
System.out.println("indexOfRightChild: " + indexOfRightChild);
System.out.println("indexOfLeftChild: " + indexOfLeftChild);
        leftChild = allNodesStore[indexOfLeftChild];
        rightChild = allNodesStore[indexOfRightChild];
        leftChild.buildBalancedSubtree(indexOfLeftChild, indexOfLeftMargin, indexOfParent - 1);
        rightChild.buildBalancedSubtree(indexOfRightChild, indexOfParent + 1, indexOfRightMargin);

      }

    }

    /**
    * Returns true if tree contains the integer passed
    */
    private boolean contains(int n) {

      if (rightChild == null && leftChild == null) {

        return false;

      }

      if (n > this.n) {

        if (rightChild == null) {

          return false;

        } else if (rightChild.n == n) {

          return true;

        } else {

          return rightChild.contains(n);

        }

      } else {

        if (leftChild == null) {

          return false;

        } else if (leftChild.n == n) {

          return true;

        } else {

          return leftChild.contains(n);

        }

      }

    }

    /**
    * Adds number of nodes from this node on down to the present value of 'nodeCount' in Tree.
    */
    private int countNodesInSubtree() {

      if (this != null) {

        nodeCount++;

      }

      if (rightChild == null) {

        if (leftChild == null) {

          return nodeCount;

        } else {

          return leftChild.countNodesInSubtree();

        }

      } else {

        if (leftChild == null) {

          return rightChild.countNodesInSubtree();

        } else {

          leftChild.countNodesInSubtree();
          return rightChild.countNodesInSubtree();

        }

      }

    }

    /**
    * Calculates the depth of the tree that has at least a root.
    * (If only root, depth is zero).
    */
    private int depth(int depth) {

      int depth_ = depth;

      if (depth > deepest) {

        deepest = depth;

      }

      if (leftChild == null && rightChild == null) {

        return deepest;

      } else {

        depth_++;

        if (depth_ > deepest) {

          deepest = depth_;

        }

        if (leftChild != null && rightChild == null) {

          return leftChild.depth(depth_);

        }

        if (rightChild != null && leftChild == null) {

          return rightChild.depth(depth_);

        }

        leftChild.depth(depth_);
        return rightChild.depth(depth_);

      }

    }

    /**
    * Calcuates the difference between the number of nodes in the left subtree
    * and right subtree of this node.
    */
    private int differenceOfLeftRightNodeCount() {

      int difference = 0;

      if (leftChild == null) {

        if (rightChild == null) {

          difference = 0;

        } else {

          difference = 0 - rightChild.countNodesInSubtree();

        }

      } else {

        if (rightChild == null) {

          difference = leftChild.countNodesInSubtree() - 0;

        } else {

          difference = leftChild.countNodesInSubtree() - rightChild.countNodesInSubtree();

        }

      }

      return difference;

    }

    /**
    * Finds the maximum integer in the tree
    */
    private int getMax() {

      if (rightChild == null) {

        return n;

      } else {

        return rightChild.getMax();

      }

    }

    /**
    * Finds the minimum integer in the tree
    */
    private int getMin() {

      if (leftChild == null) {

        return n;

      } else {

        return leftChild.getMin();

      }

    }

    /**
    * Traverses the tree to find the node with int n, and removes it from the tree.
    * The necessary subsequent re-ordering of the tree is encapsulated in separate
    * functions.
    */
    private void remove(IntegerTreeNode node, int n) {

      if (n < node.n) {

        if (node.leftChild != null) {

          if (n == node.leftChild.n) {

            reorderTreeAfterRemoving(node.leftChild, "leftChild", node);

          } else {

            remove(node.leftChild, n);

          }

        }

      } else if (n > node.n) {

        if (node.rightChild != null) {

          if (n == node.rightChild.n) {

            reorderTreeAfterRemoving(node.rightChild, "rightChild", node);

          } else {

            remove(node.rightChild, n);

          }

        }

      }

    }

    /**
    * Receives both the node that is to be removed, as well as its parent node.
    * These two should not be confused with the node that will replace the removed node,
    * and its parent node.
    */
    private void reorderTreeAfterRemoving(IntegerTreeNode nodeToRemove, String leftOrRightChild, IntegerTreeNode parentOfNodeToRemove) {

      IntegerTreeNode replacement = null;
      IntegerTreeNode parentOfReplacement = null;
      IntegerTreeNode parentOfNodeToRemove_ = parentOfNodeToRemove;
      // Following condition determines which subtree (left or right) of nodeToRemove its replacement node will be retrieved from.
      if (nodeToRemove.leftChild != null) {

        parentOfReplacement = retrieveParentOfReplacementFrom("left", nodeToRemove.leftChild, nodeToRemove);

        if (parentOfReplacement == nodeToRemove) {

          replacement = nodeToRemove.leftChild;
          replacement.rightChild = nodeToRemove.rightChild;

        } else {

          replacement = parentOfReplacement.rightChild;
          replacement.rightChild = nodeToRemove.rightChild;
          parentOfReplacement.rightChild = replacement.leftChild;
          replacement.leftChild = nodeToRemove.leftChild;

        }

      } else if (nodeToRemove.rightChild != null) {

        parentOfReplacement = retrieveParentOfReplacementFrom("right", nodeToRemove.rightChild, nodeToRemove);

        if (parentOfReplacement == nodeToRemove) {

          replacement = nodeToRemove.rightChild;
          replacement.leftChild = nodeToRemove.leftChild;

        } else {

          replacement = parentOfReplacement.leftChild;

          replacement.leftChild = nodeToRemove.leftChild;
          parentOfReplacement.leftChild = replacement.rightChild;
          replacement.rightChild = nodeToRemove.rightChild;

        }

      }

      if (leftOrRightChild.equals("leftChild")) {

        parentOfNodeToRemove_.leftChild = replacement;

      } else if (leftOrRightChild.equals("rightChild")) {

        parentOfNodeToRemove_.rightChild = replacement;

      }

    }

    /**
    * Takes the node to be removed as the 'parent'. The first potential replacement node is
    * the 'child' node (be it in left or right subtree).
    *
    * Retrieves the parent of the node that will replace the node to be removed.
    * (The parent is required because the pointer that the parent uses to point to the replacement
    * node will have to be reset to one of the replacement node's child nodes (before the replacement
    * node own pointers can be redirected).
    * (This wouldn't be necessary if the tree was "threaded" (i.e. nodes point back upwards)).
    *
    */
    private IntegerTreeNode retrieveParentOfReplacementFrom(String subtree, IntegerTreeNode child, IntegerTreeNode parent) {

      if (subtree.equals("left")) {

        if (child.rightChild == null) {

          return parent;

        } else {

          return retrieveParentOfReplacementFrom(subtree, child.rightChild, child);

        }

      } else {

        if (child.leftChild == null) {

          return parent;

        } else {

          return retrieveParentOfReplacementFrom(subtree, child.leftChild, child);

        }

      }

    }

    /**
    * Stores child nodes of the root into an array, by their integers, n, in ascending numerical order.
    */
    private void storeNodesInOrderFrom(int positionOfParent, String thisIsLeftOrRightChild) {

      nodeCount = 0;
      int newLeftChildPosition = 0;
      int newRightChildPosition = 0;
      int indexPositionsToLeftOfParent = 1;
      int indexPositionsToRightOfParent = 1;

      if (thisIsLeftOrRightChild.equals("this is left")) {

        if (rightChild != null) {

          indexPositionsToLeftOfParent += rightChild.countNodesInSubtree();

        }

        newLeftChildPosition = positionOfParent - indexPositionsToLeftOfParent;
        allNodesStore[newLeftChildPosition] = this;

        if (leftChild != null) {

          leftChild.storeNodesInOrderFrom(newLeftChildPosition, "this is left");

        }

        if (rightChild != null) {

          rightChild.storeNodesInOrderFrom(newLeftChildPosition, "this is right");

        }

      }

      if (thisIsLeftOrRightChild.equals("this is right")) {

        if (leftChild != null) {

          indexPositionsToRightOfParent += leftChild.countNodesInSubtree();

        }

        newRightChildPosition = positionOfParent + indexPositionsToRightOfParent;
        allNodesStore[newRightChildPosition] = this;

        if (leftChild != null) {

          leftChild.storeNodesInOrderFrom(newRightChildPosition, "this is left");

        }

        if (rightChild != null) {

          rightChild.storeNodesInOrderFrom(newRightChildPosition, "this is right");

        }

      }

    }

    // “complete” version
    @Override
    public String toString() {

      if (leftChild == null) {

        if (rightChild == null) {

          return "L[]R[]";

        } else {

          return "L[]" + "R[" + rightChild.n + rightChild.toString() + "]";

        }

      } else {

        if (rightChild != null) {

          return "L[" + leftChild.n + leftChild.toString() + "]" + "R[" + rightChild.n + rightChild.toString()+ "]";

        } else {

          return "L[" + leftChild.n + leftChild.toString() + "]"  + "R[]";

        }

      }

    }

/*
    // “simplified” version
    @Override
    public String toString() {

      if (leftChild == null) {

        if (rightChild == null) {

          return "" + n + "[][]";

        } else {

          return "" + n + "[]" + "[" + rightChild.toString() + "]";

        }

      } else {

        if (rightChild != null) {

          return "" + n + "[" + leftChild.toString() + "]" + "[" + rightChild.toString() + "]";

        } else {

          return "" + n + "[" + leftChild.toString() + "]"  + "[]";

        }

      }

    }
*/
  }

}
