//cd desktop/JavaCoding/JavaExercises

public class NodeMakerQueueLength
{
	Node root=null;
	
	public static void main(String args[])
	{
		NodeMakerQueueLength nmaq=new NodeMakerQueueLength();
		Node nod1=new Node("scooby root node");
		nmaq.addNode(nod1);
		Node nod2=new Node("batman node");
		nmaq.addNode(nod2);
//		nmaq.printList();
		nmaq.addNode(new Node("superman node"));
//		nmaq.printList();
//		nmaq.deleteNode(new Node("batman node"));
		nmaq.printList();
		System.out.println("List length: "+nmaq.getLength());
	}
	public int getLength()
	{
		if(root==null)
		{
			return 0;
		}
		else
		{
			return 1+root.getLength();
		}
	}
	public void addNode(Node brandNew)
	{
		if(root==null)//u cud write this.root but makes no difference
		{
			root=brandNew;//u cud write this.root but makes no difference
		}
		else
		{
			root.addNode(brandNew);//u cud write this.root here but makes no difference
		}
	}
	
	public boolean deleteNode(Node node)
	{
		if(root==null)//u cud write this.root here but makes no difference
		{
			return false;
		}
		else
		{	
			if(node.getName().equals(root.getName()))//u cud write this.root here but makes no difference
			{
				root=root.nextNode;//u cud write this.root here but makes no difference
				return true;
			}
			else return root.deleteNode(node);//u cud write this.root here but makes no difference
		}
	}
	public void printList()
	{
		if(root!=null)//seems u can put root, this.root or just this here.
		{
			root.printList();//if u put this instead, get StackOverFlowError
		}	//but you can put this.root instead of root.
	}
}

class Node
{
	private String name;
	public Node nextNode;
	
	public Node(String name)
	{
		this.name=name;
		nextNode=null;
	}
	//iteratively
	public int getLength()
	{
		int length=0;
		while(nextNode!=null)
		{
			length++;
			nextNode=nextNode.nextNode;
		}
		return length;	
	}
	/* recursively
	public int getLength()
	{
		if(nextNode==null)
		{
			return 0;
		}
		else
		{
			return 1+nextNode.getLength();
		}
	}*/
	public String getName()
	{
		return name;
	}
	public void addNode(Node brandNew)
	{
		if(nextNode==null)
		{
			nextNode=brandNew;
		}
		else
		{
			nextNode.addNode(brandNew);
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
				return true;
			}
			else
			{
				return nextNode.deleteNode(node);
			}
		}
	}
	
	public void printList()
	{
		System.out.println(name);
		if(nextNode!=null)
		{
			nextNode.printList();
		}
	}
}