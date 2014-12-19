// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/DataStructures/LinkedLists/Queue
// Exercise 8.1: Data Structures (implementation of Queue interface with Linked List)

/*
Use the interface PersonQueue that represents a queue of people waiting at the 
supermarket and then implement it. You can use the definition and the implementations of 
StringStack as a guide. You can reuse any version of class Person from past days. 
For example, depending on your implementation, you may want to use a version of Person 
with or without internal pointers.

public interface PersonQueue {
	Javadoc: Adds another person to the queue.
	void insert(Person person);

	Javadoc: Removes a person from the queue.
	Person retrieve();
}

Then create a class Supermarket that has two methods: addPerson(Person) and servePerson(). 
These methods must call the appropriate methods of PersonQueue.
*/

public interface PersonQueue { 
	
	/**	
	*	Adds another person to the queue.
	*/
	public void insert(PersonQueueNode node);
	
	/**
	*	Removes a person from the queue. 
	*/
	public PersonQueueNode retrieve();

}

class PersonQueueImpl implements PersonQueue {

	private PersonQueueNode personAtFront; //pAF
	private PersonQueueNode personAtBack;  //pAB
	
	public PersonQueueImpl() {
	
		personAtBack = personAtFront = null;
	
	}

	/**
	*	Adds another person to the back of the queue.
	*/
	public void insert(PersonQueueNode node) {
	
		if (personAtFront == null) {
		
			personAtFront = personAtBack = node;
		
		} else  {
			
			personAtBack.setNext(node);
		
		}
	
	}
	
	/**
	*	Removes a person from the front of the queue. 
	*/
	public PersonQueueNode retrieve() {
	
		PersonQueueNode result;
		
		if (personAtFront == null) {
		
			System.out.println("there's no one there");
			result = null;
		
		} else {
			
			result = personAtFront;
			personAtFront = result.getNext();
		
		}
		
		return result;
	
	}
	
	public PersonQueueNode getPersonAtBack() {
	
		return personAtBack;
	
	}

}

//NODE CLASS
class PersonQueueNode {
 
	private String name;
	private int noOfBeers;
	private PersonQueueNode nextInQueue;
	
	public String getName() {
	
		return name;
	
	}
	
	public int getNoOfBeers() {
	
		return noOfBeers;
	
	}

	public PersonQueueNode(){}
	
	public PersonQueueNode(String name, int noOfBeers) {
	
		this.name = name;
		this.noOfBeers = noOfBeers;
		nextInQueue = null;
	
	}
	
	public void setNext(PersonQueueNode newAddition) {
	
		if (nextInQueue == null) {
		
			nextInQueue = newAddition;
		
		} else {
			
			nextInQueue.setNext(newAddition);
	
		}
		
	}
	
	public PersonQueueNode getNext() {
	
		if (nextInQueue.nextInQueue == null) {
		
			return this;
		
		} else {
			
			return nextInQueue.getNext();
		
		}
	
	}
	
	/**	
	*	prints out queue.
	*/
	public void displayCurrentQueue() {
	
		PersonQueueNode personAtBack2;
		PersonQueueImpl pqi3 = new PersonQueueImpl();
		personAtBack2 = pqi3.getPersonAtBack();
		System.out.println("From back to front: " + personAtBack2.getName() + " has " + personAtBack2.getNoOfBeers() + " green bottles");
		
		if (personAtBack2.nextInQueue != null) {
		
			nextInQueue.displayCurrentQueue();
		
		}

	}

}

class Supermarket {

	public static void main(String[] args) {
	
		Supermarket sup = new Supermarket();
			
		PersonQueueNode person1 = new PersonQueueNode("person1", 5);
		PersonQueueNode person2 = new PersonQueueNode("person2", 15);
		PersonQueueNode person3 = new PersonQueueNode("person3", 25);
		PersonQueueNode person4 = new PersonQueueNode("person4", 35);
		System.out.println("\nQueue before adding 4 persons");
		sup.displayQueue();

		sup.add(person1);
		sup.add(person2);
		sup.add(person3);
		sup.add(person4);
		System.out.println("\nQueue after adding 4 persons");
		sup.displayQueue();
		
		sup.servePerson();
		sup.displayQueue();
		sup.servePerson();
		sup.displayQueue();
		sup.servePerson();
		sup.displayQueue();
		sup.servePerson();
		sup.displayQueue();
	
	}
		
	public void displayQueue() {
	
		PersonQueueNode pqn = new PersonQueueNode();
		pqn.displayCurrentQueue();
	
	}
	
	/**	
	*	Adds another person to the queue.
	*/
	public void add(PersonQueueNode personNode) {
	
		PersonQueueImpl pqi2 = new PersonQueueImpl();
		pqi2.insert(personNode);
	
	}
	
	/**
	*	Removes a person from the queue. 
	*/
	public PersonQueueNode servePerson() {
	
		PersonQueueImpl pqi2 = new PersonQueueImpl();
		return pqi2.retrieve();
	
	}

}


/*	
A queue (implemented with dynamic data structure) must have two pointers personAtFront
and personAtBack (pAF & pAB). When the first node is added (hence the queue only has 1 node), both pointers are 
pointing at that one node (PQN):

	    pAF pAB
	    
		  | | 
	      V V
		
		  PQN  
-----------------------------------
When the queue has more than 1 node, pAF remains pointing to the root node, but pAB now 
points to a different node - at the back of the queue:
(PQN is PersonQueueNode. nIQ is nextInQueue pointer.)

	     pAF             pAB
	     
	 	  |               |
	      V               V
	     
	     PQN PQN PQN PQN PQN 	
		  | |  | | | | | | |
		  nIQ  nIQ nIQ nIQ nIQ--> null

Each node has an internal pointer nIQ pointing to the next node.
The node at the back of the queue is pointing to null.
*/
