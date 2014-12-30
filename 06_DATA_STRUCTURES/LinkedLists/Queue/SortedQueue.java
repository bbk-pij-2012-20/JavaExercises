// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/06_DATA_STRUCTURES/LinkedLists/Queue
// Exercise 7.10 (Introduction to data structures & pointers)
/*
Create a linked list of integers that is automatically sorted.
Every time you add an element, make sure you introduce it at the right place in the queue 
so that the queue is always sorted from lower to higher numbers.
Create the list, insert several numbers into it (around 15 is fine) and then go through 
the list printing the value of each element. Check that the elements are correctly sorted.
*/

/**
*	I will make lower-to-higher numbers go from front-to-back of queue.
*	For equal numbers, the new node will go behind (nearer back).
*	
*	implemented with a singly-linked list (as opposed to doubly-linked list)
*/
public class SortedQueue {

	private Node front = null;
	private Node back = null;
	
	public static void main(String[] args) {
	
		SortedQueue sq = new SortedQueue();
		sq.insert(5);
		sq.insert(10);
		sq.insert(12);
		sq.insert(3);
		sq.insert(11);
		sq.insert(6);	
		sq.printFrontToBack();	
		sq.retrieve();
		sq.printFrontToBack();
	
	}
	
	// inserts at front or back, otherwise calls method in Node to insert between front and back
	public void insert(int n) {
		
		if (isEmpty()) {
		
			front = back = new Node(n);
		
		} else {
		
			if (n < front.getN()) { // the new node's number is lower than front of queue, therefore it becomes new front.
			
				Node node = new Node(n);
				node.setNext(front);
				front = node;
				return;
			
			} else if (n >= back.getN()) {
			
				Node node = new Node(n);
				back.setNext(node);
				back = back.getNext();

			} else {
			
				try {
				
					front.insert(n, front);
				
				} catch (IllegalArgumentException e) {
				
					e.printStackTrace();
					System.out.println("There's a problem, the 1st insert() method should have already dealt with this");
				
				}
			
			}
			
		}
	
	}
			
	public int retrieve() {
	
		Node result = null;
		
		try {
		
			if (isEmpty()) {
		
				throw new NullPointerException("can't retrieve, empty list");
			
			}
			
			result = front;
			
			if (front == back) {
			
				front = back = null;
			
			} else {
			
				front = front.getNext();
	
			}
					
		} catch (NullPointerException e) {
		
			System.out.println(e.getMessage());
		
		}
		
		return result.getN();
	
	}
	
	public boolean isEmpty() {
	
		return back == null;
	
	}
	
	public void printFrontToBack() {
	
		if (isEmpty()) {
		
			System.out.println("list is empty");
			return;
			
		} else if (front == back) {
			
			System.out.println("Front & Back (1 in queue only): " + front); 
			return;
			
		} 	
		
		System.out.println("Front: " + front.getN());
		Node pointer = front.getNext();
		
		while (pointer != back) {
		
			System.out.println("next: " + pointer.getN()); 
			pointer = pointer.getNext();
			
		}
		
		System.out.println("Back: " + back.getN());

	}

}

class Node {

	private Node next = null;
	private int n = 0;
	
	public Node(int n) {
	
		this.n = n;
		
	}
	
	public int getN() {
	
		return n;
	
	}
	
	/*using iteration
	public void insert(int n) {
	
		Node current = this;
		
		while (current.next != null) {
		
			if (n > next.getN()) {
			
				current = current.next;
			
			}
		
		}
		
		Node node = new Node(n);
		next = node;
		
	}*/
	
	//using recursion
	public void insert(int n, Node current) throws IllegalArgumentException {
			
		Node node = null;
			
		if (n < current.next.getN()) {
				
			node = new Node(n);
			node.next = current.next;
			current.next = node;
			return;
				
		} else if (current.next == null) {
		
			throw new IllegalArgumentException();
		
		}
		
		insert(n, current.next);
	
	}
	
	public Node getNext() {
	
		return next;	
	
	}
	
	public void setNext(Node node) {
	
		next = node;
	
	}

}