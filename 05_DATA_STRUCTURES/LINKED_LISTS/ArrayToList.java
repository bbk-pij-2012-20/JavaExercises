//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/06_DATA_STRUCTURES/LinkedLists
//Exercise 7.9 (Introduction to data structures & pointers)
/*
Create a static method that takes an array of integers and returns a linked list of 
integers in the same order as the original array. You can put this method in a class 
called ListUtilities so that you can easily use it for the following exercises.

Initialising an array with 15-20 elements is very easy with curly-brackets-notation, 
so it is common to create an array and then convert it into a dynamic structure 
automatically.
*/
public class ArrayToList {

	public static void main(String args[]) throws Exception {
	
		int[] intArray = {1, 2, 4, 5, 6, 7, 8, 9, 3, 5, 7, 8, 12, 34, 2, 4, 45, 23};        
		List list = ListUtilities.ArayToList(intArray);
    
    }

}

class ListUtilities {

	public static List ArayToList(int[] intAry) {
	
		List list = new List();
		
		for (int i : intAry) {
		
			System.out.println(i);
			list.insert(i);
		
		}
		
		return list;
	}

}

class List {

	private Node first = null;
        
	public void insert(int n) {
	
		Node nod = new Node(n);
		nod.next = first;
//Why does 'nod.getNext()=first' cause compiler error 'unexpected type'?
		first = nod;
	}
	
}

class Node {

	private int n;
	public Node next;
        
	public Node getNext() {
		
		return next;
	
	}
	
	public Node(int n) {
	
		this.n = n;
		next = null;
	
	}

}