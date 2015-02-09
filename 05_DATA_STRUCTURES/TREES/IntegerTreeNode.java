// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/DataStructures/Trees
// Exercise 9.1: Intro to Tree data structures 

public class IntegerTreeNode {

	private int value; // as a member field, this will be initialised to 0 automatically.
	private IntegerTreeNode2 left;
	private IntegerTreeNode2 right;
	
	/** 
	* constructor to allow add() method to pass the new value with the new node.
	*/	
	public IntegerTreeNode2(int value) {
	
		this.value = value;
		left = right = null;		

	}

	/*
	* a second constructor, empty this time. This is to enable me to create an itn  
	* object without having to pass an integer to it (line 26).
	* (Obviously an empty constructor would be generated
	*/
//	public IntegerTreeNode2(){}
	public static void main(String[] args) {
				
		IntegerTreeNode2 itn = new IntegerTreeNode2(1); 
/* 
		IntegerTreeNode2 itn = new IntegerTreeNode2(); 

If IntegerTreeNode is instantiated without any value sent to the 
constructor, the node this creates, which is the first node 
(i.e. root), will be whatever int 'value' was initialised to on 
line 3, i.e. 0 (because it is a member field, not explicitly 
initialised to any integer, hence getMin() returns 0. 
*/		
		itn.add(10);
		itn.add(3);
		itn.add(30);
		itn.add(14);
		itn.add(345);
		itn.add(2);
		itn.add(134);
		itn.add(39);
		
		boolean find345 = itn.contains(345);
		System.out.printf("\nThe integer 345 is %spresent\n", find345? "" : "not ");
	
		boolean find30000 = itn.contains(30000);
		System.out.printf("\nThe integer 30000 is %spresent\n", find30000? "" : "not ");

		int minimum = itn.getMin(); 
		System.out.println("\nmin is " + minimum);

		int maximum = itn.getMax(); 
		System.out.println("\nmax is " + maximum + "\n");
	
	}
	
	/** Copied from Day9 notes.
	* method to add elements (i.e. int value, inside a new node) to the tree.
	* @return returns void. Either creates new node or points to another node and repeats.  
	*/	
	public void add(int newNumber) {
	
		if (newNumber > this.value) {
		
			if (right == null) {
			
				right = new IntegerTreeNode2(newNumber);
			
			}  else {
			 
				right.add(newNumber);
			
			}
		
		} else {
			
			if (left == null) {
			
				left = new IntegerTreeNode2(newNumber);
			
			} else {
				
				left.add(newNumber);
			
			}
		
		}
	
	}
	
	/** Copied from Day9 notes.
	* method to find elements (i.e. int value) stored in the tree.
	* @return returns true if found, false otherwise.
	*/	
	public boolean contains(int n) {
	
		if (n == this.value) {
		
			return true;
		
		} else if (n > this.value) {
		
			if (right == null) {
			
				return false;
    		
    		} else {
				
				return right.contains(n);// debugged by Ryan/Dave!
			
			}
		
		} else {
			
			if (left == null) {

				return false;

			} else {
				
				return left.contains(n); // debugged by Ryan/Dave!
			
			}
		
		}
	
	}

	/**
	* method to return the maximum values stored in the tree.
	* @return returns the value integer
	*/	
	public int getMax() {
	
		if (this.right == null) {
		
			return this.value;
		
		} else {
			
			return this.right.getMax(); 	
		
		}
	
	}

	/**
	* method to return the minimum values stored in the tree.
	* @return returns the value integer
	*/	
	public int getMin() {
	
		if (this.left == null) {
		
			return this.value;
		
		} else {
			
			return this.left.getMin();
		
		}
	
	}

}