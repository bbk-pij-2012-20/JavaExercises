//cd desktop/JavaCoding/JavaExercises
// Exercise 11.3 (Introduction to Generics (aka Parametric Polymorphism)

/*
Modify the doubly-linked list that you have created in past weeks to make it generic, 
i.e. to allow it to have values of its elements of any type. Use the TDD methodology 
(interface, test, production code, repeat. . . ).
Once you have it ready, create a class Company that keeps two linked lists, one with 
the names of the employees and one with their National Insurance Number
*/
public class GenericDubLinkList<T> // that's all I've done so far!!!

//I've not started to turn the rest of the code into Generic format
{
	private Node root=null;
	public static void main(String args[])
	{
		DubLinkList dll=new DubLinkList();
		dll.addNode(new Node(20,"Node20"));
		dll.addNode(new Node(40,"Node40"));
		dll.addNode(new Node(50,"Node 50"));
		dll.displayNodes();
		dll.deleteNode(new Node(40,"Node40"));
		dll.displayNodes();
	}
	public void addNode(Node newOne)
	{
		if(root==null)
		{
			root=newOne;
		}
		else
		{
			root.addNode(newOne);
		}
	}
	public boolean deleteNode(Node node)
	{
		if(root==null)
		{
			return false;
		}
		else
		{
			if(root.getName().equals(node.getName()))
			{
				root=root.nextNode;
				root.previousNode=null;
				return true;
			}
			else return root.deleteNode(node);
		}
	}
	public void displayNodes()
	{
		if(root!=null)
		{
			root.displayF();
		}
	}
}
class Node
{
	private int number;
	private String name;
	public Node previousNode;
	public Node nextNode;

	public String getName()
	{
		return name;
	}
	public Node(int number,String name)
	{
		this.number=number;
		this.name=name;
		previousNode=null;//Note that this is not necessary.
		nextNode=null;// And neither is this. 
	}
	public void addNode(Node newNode)
	{
		if(nextNode==null)
		{
			nextNode=newNode;
			newNode.previousNode=this;
		}
		else
		{
			nextNode.addNode(newNode);
		}
	} 
	public boolean deleteNode(Node node)
	{
		if(nextNode==null)
		{
			return false;
		}
		else
		{
			if(nextNode.name.equals(node.name))
			{
				nextNode=nextNode.nextNode;
			
				if(nextNode!=null)
				{
					nextNode.previousNode=this;
				}
				return true;
			}
			else
			{
				return nextNode.deleteNode(node);
			}
		}
	}
	public void displayF()
	{
		System.out.println("forwards:" +name);
		
		if(nextNode!=null)
		{
			nextNode.displayF();
		}
		else
		{
			displayB();
		}	
	}
	public void displayB()
	{
		System.out.println("backwards:" +name);
		
		if(previousNode!=null)
		{
			previousNode.displayB();
		}
	}
}