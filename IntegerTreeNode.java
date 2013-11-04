public class IntegerTreeNode //Day9Ex1.1
{
	private int value;
	private IntegerTreeNode left;
	private IntegerTreeNode right;

	//Empty constructor so that I can create the 
	//itn object (line 21) without having to pass any value to it.
	public IntegerTreeNode()
	{}
	
	/** 
	* constructor to allow add() method to pass the new value with the new node.
	*/	
	public IntegerTreeNode(int value)
	{
		this.value=value;
		left=null;
		right=null;		
	}
	
	public static void main(String[] args)
	{			
		IntegerTreeNode itn=new IntegerTreeNode();
		
		itn.add(10);
		itn.add(2);
		itn.add(30);
		itn.add(14);
		itn.add(345);
		itn.add(1);
		itn.add(134);
		itn.add(39);
		
		boolean find345=itn.contains(345);
		System.out.printf("The integer 345 is %spresent\n",find345?"":"not ");
	
		boolean find30000=itn.contains(30000);
		System.out.printf("The integer 30000 is %spresent\n",find30000?"":"not ");

		int maximum=itn.getMax(); 
		System.out.println("max is "+maximum);
		
		int minimum=itn.getMin(); 
		System.out.println("min is "+minimum);
	}
	
	/** Copied from Day9 notes.
	* method to add elements (i.e. int value, inside a new node) to the tree.
	* @return returns void. Either creates new node or points to another node and repeats.  
	*/	
	public void add(int newNumber) 
	{
		if(newNumber>this.value) 
		{
			if(right==null)
			{
				right=new IntegerTreeNode(newNumber);
			} 
			else 
			{ 
				right.add(newNumber);
			}
		}
		else
		{
			if(left==null)
			{
				left=new IntegerTreeNode(newNumber);
			}
			else
			{
				left.add(newNumber);
			}
		}
	}
	/** Copied from Day9 notes.
	* method to find elements (i.e. int value) stored in the tree.
	* @return returns true if found, false otherwise.
	*/	
	public boolean contains(int n) 
	{
		if(n==this.value)
		{
			return true;
		}
		else if(n>this.value)
		{
			if(right==null)
			{
				return false;
    		}
    		else
    		{
				return right.contains(n);
			}
		}
		else
		{
			if(left==null)
			{
				return false;
			}
			else
			{
				return left.contains(n); 
			}
		}
	}
	
	/**
	* method to return the maximum values stored in the tree.
	* @return returns the value integer
	*/	
	public int getMax()
	{
		if(right==null)
		{
			return right.value;
		}
		else
		{
			this.right=right.right;
			this.left=right.left;  
			return this.getMax(); 
/*
	It compiles and the contains() method works fine but I 
	get this exception:
	
	Exception in thread "main" java.lang.NullPointerException
	at IntegerTreeNode.getMax(IntegerTreeNode.java:110)
	at IntegerTreeNode.getMax(IntegerTreeNode.java:111)
	at IntegerTreeNode.getMax(IntegerTreeNode.java:111)
	at IntegerTreeNode.main(IntegerTreeNode.java:37)
*/			
		}
	}

	/**
	* method to return the minimum values stored in the tree.
	* @return returns the value integer
	*/	
	public int getMin()
	{
		if(left==null)
		{
			return left.value;
		}
		else
		{
			this.left=left.left;
			this.right=left.right;
			return this.getMin(); //recursive??
		}
	}
}