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
	private static final int LEFT_TO_RIGHT = 1;
	private static final int RIGHT_TO_LEFT = -1;
	
	public QuickSort() {
	
		list = new List();
	
	}
	
	public static void main(String[] args) {

		QuickSort qs = new QuickSort();
		qs.makeDLL();
		List.Node testNode1 = qs.list.new Node(1000);
		List.Node testNode2 = qs.list.new Node(10);
		qs.add(qs.list, testNode1);
		qs.add(qs.list, testNode2);
		qs.print();
		qs.list.swap(testNode1, testNode2);
		qs.print();
		
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
	
		if (list.getFirst() == null) {
		
			list.setFirst(node);
			
			if (list.length() == 1) {
			
				list.setLast(node);
			
			}
		
		} else {
		
			list.getFirst().add(node);
		
		}
	
	}
	
/*	public void sort(List list) {
	
		if (list.length() == 2) {
		
			if (list.getFirst().getN() > list.getLast().getN()) {
			
				list.swap(list.getFirst(), list.getLast());
				return;
			
			} 	
		
		} else {
	
			list.sort(list.getFirst(), list.getFirst(), list.getLast(), RIGHT_TO_LEFT);
		
		}

	}
*/	
	public void print() {
	
		if (list.getFirst() == null) {
		
			System.out.println("List is empty");
		
		} else {
		
			System.out.println();
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
	
	public List() {

		pivot = first;
			
	}
	
/*	public void sort(Node node, Node firstInPartition, Node lastInPartition, int direction) {// -1 means traversing to left, +1 to right
	
	
		if (node == firstInPartition && node == lastInPartition) {
		
			return;
		
		}
		
		
		if (direction == -1 && rightOfPartition == firstInPartition) {
		
			return;
		
		}
	
		if (direction == 1 && leftOfPartition == lastInPartition) {
		
			leftOfPartition
		
		}
		
		sort(node.getNext(), 
	
	}
*/	
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
		Node newNode1 = node1;
		Node newNode2 = node2;
		
		if (preNode1 == node2) {
				
			newNode2.setPrevious(node1);
			newNode1.setNext(node2);
			newNode2.setNext(nextNode1);
			
			if (nextNode1 != null) {
			
				nextNode1.setPrevious(newNode2);
			
			}
			
			newNode1.setPrevious(preNode2);
			
			if (preNode2 != null) {
				
				preNode2.setNext(node1);
			
			}
		
		} else if (preNode2 == node1) {
				
			newNode1.setPrevious(node2);
			newNode2.setNext(node1);
			newNode1.setNext(nextNode2);
			
			if (nextNode2 != null) {
			
				nextNode2.setPrevious(node1);
			
			}
			
			newNode2.setPrevious(preNode1);
			
			if (preNode1 != null) {
			
				preNode1.setNext(node2);
			
			}
		
		} else {

			newNode2.setPrevious(preNode1);
		
			if (preNode1 != null) {
		
				preNode1.setNext(newNode2);
		
			}
		
			newNode2.setNext(nextNode1);
		
			if (nextNode1 != null) {
		
				nextNode1.setPrevious(newNode2);
		
			}
		
			newNode1.setPrevious(preNode2);
		
			if (preNode2 != null) {
		
				preNode2.setNext(newNode1);
		
			} 
		
			newNode1.setNext(nextNode2);
		
			if (nextNode2 != null) {
			
				nextNode2.setPrevious(newNode1);
		
			}

		}
	
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
	
	public void setLast(Node node) {
	
		last = node;
	
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
				node.previous = this;
				last = node;
			
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

