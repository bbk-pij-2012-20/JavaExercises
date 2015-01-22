// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/05_DATA_STRUCTURES/TREES
// Exercise 9.1 (Introduction to Trees)
/*
Complete the class IntegerTreeNode.
9.1.1. From the notes, you already know what the member fields are and you have seen a possible implementation of
methods add(int) and contains(int). Implement as well two methods getMax() and getMin() that returns the
maximum and the minimum values stored in the tree.
Compile the class and use it inside a script1 adding numbers in different orderings.

Implement as well two methods getMax() and getMin() that returns the
maximum and the minimum values stored in the tree.
Compile the class and use it inside a script1 adding numbers in different orderings

9.1.2.
Add a method toString() to the class. This methods must return a representation of your tree in String form,where every node is represented as a list in square brackets containing its value, the left branch, and the rightbranch; the left branch should be prefixed by “L” and the right branch by R, and an empty branch should be shownas an empty pair of square brackets. Some examples of outputs in Figure 1.After you have commited this version of toString(), make another version that returns a simplified representation,where every node is represented as a list in square brackets containing its value and its branches, but onlyif they are not empty; without using the “L” and “R” prefixes. Some examples of outputs in Figure 1.Check that both versions of the method work by adding several elements and printing the String representationof the tree.
*/

public class IntegerTree {

	private IntegerTreeNode root;
	
	public static void main(String[] args) {
	
		IntegerTree tree = new IntegerTree();
		tree.add(5);
		tree.add(42);
		tree.add(6);
		tree.add(8);
		tree.add(57);
		tree.add(1);
		System.out.println("contains(57) should return true: " + tree.contains(57));
		System.out.println("contains(56) should return false: " + tree.contains(56));
		System.out.println("getMax() should give 57: " + tree.getMax());
		System.out.println("getMin() should give 1: " + tree.getMin());
		System.out.println("toString(): " + tree.toString());
		
	}
	
	public void add(int n) {
	
		if (root == null) {
		
			root = new IntegerTreeNode(n);
		
		} else {
		
			root.add(n);
		
		}
	
	}
	
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

	public boolean contains(int n) {
	
		if (root == null) {
		
			return false;
		
		} else if (root.n == n) {
		
			return true;	
			
		} else {
		
			return root.contains(n);
			
		}
		
	}

/*	
	//“complete version”
	@Override
	public String toString() {
	
		if (root == null) {
		
			return "empty tree";
		
		} else {
			
			return "root[" + root.n + root.toString() + "]";
			
		}
		
	}
*/
	@Override
	public String toString() {
	
		if (root == null) {
		
			return "empty tree";
		
		} else {
			
			return "[" + root.n + root.toString() + "]";
			
		}
		
	}

	private class IntegerTreeNode {
	
		private int n;
		private IntegerTreeNode left;
		private IntegerTreeNode right;
			
		private IntegerTreeNode(int n) {
		
			this.n = n;
			left = right = null;
		
		}

/*		
		// “complete” version
		@Override
		public String toString() {
			
			if (left == null) {
			
				if (right == null) {

					return " L[] R[]";
				
				} else {

					return " L[]" + " R[" + right.n + right.toString() + "]";
				
				}
		
			} else {

				if (right != null) {

					return " L[" + left.n + left.toString() + "]" + " R[" + right.n + right.toString()+ "]";
			
				} else {

					return " L[" + left.n + left.toString() + "]"  + " R[]";

				}

			}

		}
*/
		// “simplified” version
		@Override
		public String toString() {
			
			if (left == null) {
			
				if (right == null) {

					return " [] []";
				
				} else {

					return " []" + " [" + right.n + right.toString() + "]";
				
				}
		
			} else {

				if (right != null) {

					return " [" + left.n + left.toString() + "]" + " [" + right.n + right.toString()+ "]";
			
				} else {

					return " [" + left.n + left.toString() + "]"  + " []";

				}

			}

		}

		private int getMax() {
		
			if (right == null) {
	
				return n;
					
			} else {
			
				return right.getMax();
			
			}		
		
		}
		
		private int getMin() {
		
			if (left == null) {
	
				return n;
					
			} else {
			
				return left.getMin();
			
			}		
		
		}
		
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
	
	}

}