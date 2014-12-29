// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/06_DATA_STRUCTURES/LinkedLists/Queue
// Exercise 7.7 (Introduction to data structures & pointers)
/*
A queue is a dynamic structure that implements these methods:

insert(...) inserts an element at the beginning of the queue.

retrieve(...) remove an element from the end of the queue.

size() returns the current size of the queue.

Queues are heavily used in computing: communication buffers, incoming request to web servers, read/write
requests to hard disks, etc.

Implement a queue of integers. This could represent requests to a hard drive to read from different sectors.
Implement the three methods listed above.

Then write another class that creates a queue, and makes several insert(), retrieve(), and size() calls.

Check that the values you get are consistent. The output of the program could look like this:

There are 0 requests in the queue.
Inserting request 5...
Inserting request 8...
Inserting request 12...
There are 3 requests in the queue.
Retrieving request 5... done.
Inserting request 13...
There are 3 requests in the queue.
Retrieving request 8... done.
Retrieving request 12... done.
There are 2 requests in the queue.
Retrieving request 13... done.
etc..
*/


/*
empty list:

back/front
	|	
	V	
   null
---------------------------------------------------
single-node list:

back front
 |	  |	
 V	  V	
 n o d e
---------------------------------------------------
			2 or more-node list:
back										front
 |											  |
 V											  V
node <- (next) node <- (next) node <- (next) node

*/
public class QueuesMain {

	public static void main(String[] args) {
	
		Queues q = new Queues();
		QueuesMain qm = new QueuesMain();
		
		System.out.printf("There are %d requests in the queue\n", q.size());
		qm.inserting(q, 1);
		qm.inserting(q, 2);
		System.out.printf("There are %d requests in the queue\n", q.size());
		qm.inserting(q, 3);
		qm.inserting(q, 4);
		qm.inserting(q, 5);
		System.out.printf("There are %d requests in the queue\n", q.size());
		qm.retrieving(q);	
		qm.retrieving(q);
		qm.inserting(q, 6);
		qm.inserting(q, 7);
		System.out.printf("There are %d requests in the queue\n", q.size());
		qm.retrieving(q);
			
	}
	
	//this method's just to reduce code repetition
	public void inserting(Queues q, int n) {
	
		System.out.printf("Inserting request %d..\n", n);	
		q.insert(q, n);
	
	}

	//this method's just to reduce code repetition
	public void retrieving(Queues q) {
	
		boolean retrieved  = false;
		int retrieveInt = q.retrieve();

		if (retrieveInt != -1) {
		 
		 	retrieved = true;
			
		}
		
		System.out.printf("Retrieving request %d... %sdone\n", retrieveInt, retrieved?"" : "not ");

	}

}

class Queues {

	private Queues.Node front = null; // 'end' of queue
	private Queues.Node back = null; // 'beginning' of queue
		
	//insert the element at 'back' of queue (called 'beginning' in exercise specification)
	public void insert(Queues q, int n) {
	
		Queues.Node node = q.new Node(n);
		
		if (back == null) {

			back = front = node;

		} else {

			back.next = node;
			back = back.next;

		}

	}

	//retrieve an element from 'front' of queue (called 'end' in exercise specification)	
	public int retrieve() {
	
		int result = -1; 
		
		try {
		
			if (front == null) {
		
				throw new IllegalArgumentException("nothing to retrieve - empty queue");
				
			}
			
			if (back == front) {
			
				result = front.getN();
				back = front = null;
				
			} else {
			
				result = front.getN();
				front = front.next;
			
			}
		
						
		} catch (IllegalArgumentException e) {
		
			System.out.println(e.getMessage());
			
		}
		
		return result;
	
	}


	public int size() {

		Queues.Node currentNode = front;
		int size = 0;

		while (currentNode != null) { 

			size++;
			currentNode = currentNode.next;
				
		}
		
		return size;
		
	}

	public class Node {

		private int n = 0;
		private Node next = null;
	
		public Node(int n) {
	
			this.n = n;
	
		}
		
		public int getN() {
		
			return n;
			
		}
	
	}
	
}