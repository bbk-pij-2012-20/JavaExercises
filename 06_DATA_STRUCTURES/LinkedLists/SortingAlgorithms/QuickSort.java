// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/06_DATA_STRUCTURES/LinkedLists/SortingAlgorithms
// Exercise 7.13 (Using data structures & pointers to implement Sorting Algorithms). Difficulty level: very.
/*
This is a popular sorting algorithm that is very fast in most situations. Once you have finished all the other exercises,
look up in wikipedia how this method works and make your own implementation (put it in ListUtilities.quickSort(List)).
Then compare its performance with the other two methods. In order to see significant differences, you will need to
use lists of some length.
*/

/*
like bubble sort & cocktail sort, quick sort is at worst O(n^2). (n is number of elements).
However, quick sort typically acts more like an O(n log n) algorithm. 

Also known as a partition-exchange sort

Steps in quick sort:

1. randomly pick one element in a list. This is called the "pivot".
2. randomly partition the remainder of the list.
3. compare pivot with the elements and re-arrange according to their comparison with the pivot.

3.  
*/

import java.util.Random;

public class QuickSort {

	private List lowerList = null;
	private List higherList = null;
	private List list = null;
	
	public QuickSort() {
	
		list = new List();
	
	}
	
	public static void main(String[] args) {
	
		QuickSort qs = new QuickSort();
		qs.makeDLL();
	
	}
	
	public void makeDLL() {
		
		add(list, list.new Node(5));
		add(list, list.new Node(67));
		add(list, list.new Node(2));		
		add(list, list.new Node(985));
		add(list, list.new Node(36));
		add(list, list.new Node(56));
		add(list, list.new Node(1));		
		add(list, list.new Node(34));
	
	}
	
	public void add(List list, List.Node node) {
	
		List.Node firstNode = list.getFirst();
		
		
		if (firstNode.getNext() == null) {
		
			list.setFirst(node);
		
		} else {
		
			list.getFirst().add(node);
		
		}
	
	}
	
	/*public void sort(List list) {
	
		if (list.length() == 2) {
		
			if (list.getLeft().getN() > list.getRight.getN()) {
			
				list.swap(list.getLeft().getN(), list.getRight.getN());
				return;
			
			} 	
		
		}

	}*/
	
	public void print() {
	
		if (list.getFirst() == null) {
		
			System.out.println("List is empty");
		
		} else {
		
			list.print(list.getFirst());
		
		}
	
	}
	
}

class List {

	private Node first;
	private Node last;
	private Node leftOfPartition;
	private Node rightOfPartition;
	private Node pivot;
	
	public void setPivotPntr() {
	
		int i = 0;
		
		while (i < getRandomPartition()) {
		
			pivot = pivot.getNext();
			i++;
						
		}
	
	}
	// note the list not zero-indexed and I want any position except the first and last. 
	private int getRandomPartition() {
		
		try {
	
			if (length() < 2) {
			
				throw new IndexOutOfBoundsException("list is less than 3 elements, therefore can't get a random midpoint");
			
			}
		
		} catch (IndexOutOfBoundsException e){ 
		
			System.out.println(e.getMessage());
		
		}
			
		Random r = new Random();
		return r.nextInt(length() - 2) + 2;//because random.nextInt(5) gives anything from 0 to 5
		
	}
	
	public int length() {
	
		int length = 0;
		Node current = first;
		
		while (current != last) {
		
			length++;
			current = current.getNext();
			
		}
	
		return length;
	
	}
		
	public void swap(Node node1, Node node2) {
		
		Node preNode1 = node1.getPrevious();
		Node nextNode1 = node1.getNext();
		Node preNode2 = node2.getPrevious();
		Node nextNode2 = node2.getNext();		
			
		preNode2.setNext(node1);
		Node newNextNodeOfpreNode2 = preNode2.getNext();
		newNextNodeOfpreNode2.setPrevious(preNode2);
			
	}
	
	public void setFirst(Node node) {
	
		first = node;

	}
	
	public List.Node getFirst() {
	
		return first;
	
	}

	public Node getLast() {
	
		return last;
	
	}
	
	public Node getNext(Node node) {
	
		return node.getNext();
	
	}
	
	public void print(Node node) {
		
		System.out.print(node.getN() + " ");
		
		if (getNext(node) != null) {
		
			print(getNext(node));
			
		}
	
	}
		
   	protected class Node {
	
		private Node next;
		private Node previous;
		private int n;
			
		protected Node(int n) {
		
			this.n = n;
		
		}
		
		public void add(Node node) {
		
			if (next == null) {
			
				next = node;
			
			} else {
			
				next.add(node);
			
			}
		
		}
		
		public Node getNext() {
		
			return next;
		
		}
		
		public Node getPrevious() {
		
			return previous;
		
		}
		
		public void setNext(Node node) {
		
			next = node;
		
		}
		
		public void setPrevious(Node node) {
	
			previous = node;
		
		}
		
		public int getN() {
		
			return n;
		
		}
	
	}
	
}

