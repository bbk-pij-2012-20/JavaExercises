//cd desktop/JavaCoding/JavaExercises

public class ArrayToList
{
	
	public static void main(String args[]) throws Exception
	{
		int[] intArray={1,2,4,5,6,7,8,9,3,5,7,8,12,34,2,4,45,23};	
		List list=ListUtilities.ArayToList(intArray);
	}
}
class ListUtilities
{
	public static List ArayToList(int[] intAry)
	{
		List list=new List();
		for(int i:intAry)
		{
			System.out.println(i);
			list.insert(i);
		}
		return list;
	}
}
class List
{
	private Node first=null;
	
	public void insert(int n)
	{
		Node nod=new Node(n);
		nod.next=first;  
//Why does 'nod.getNext()=first' cause compiler error 'unexpected type'? 
		first=nod;
	}
}
class Node
{
	private int n;
	public Node next;
	
	public Node getNext()//I'd written this to accomodate a private visibility on Node next
	{
		return next;
	}
	public Node(int n)
	{
		this.n=n;
		next=null;
	}
}