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

	private class IntegerTreeNode {
	
		private int n;
		private IntegerTreeNode left;
		private IntegerTreeNode right;
			
		private IntegerTreeNode(int n) {
		
			this.n = n;
			left = right = null;
		
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