// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/06_DATA_STRUCTURES/LinkedLists/Queue/QueueInterface
// Exercise 8.1-8.2 (Introduction to Interfaces and their implementation (using data structures))
/*
Use the interface PersonQueue that represents a queue of people waiting at the supermarket and then implement
it. You can use the definition and the implementations of StringStack as a guide. You can reuse any version of
class Person from past days. For example, depending on your implementation, you may want to use a version of
Person with or without internal pointers.

8.1. Then create a class Supermarket that has two methods: addPerson(Person) and servePerson(). These
methods must call the appropriate methods of PersonQueue.

8.2. Implement the interface PersonQueue in a different way. Then check that it works exactly the same without
changing either the interface or your class Supermarket.

(8.3. Get a queue implementation from one of your colleagues. Use it and check that it works exactly the same without
changing either the interface or your class Supermarket.)
*/
//implementation with singly-linked list
public class PersonQueueImpl implements PersonQueue {

	private Person front = null;
	private Person back = null;
	
	@Override
	public void insert(Person person) {
	
		if (front == null) {
		
			front = back = person;
		
		} else {
		
			back.next = person;
			back = back.next;
		
		}
	
	}
	
	@Override
	public Person retrieve() {
	
		Person served = null;
		
		try {
	
			if (front == null) {
		
				throw new NullPointerException("queue is empty: ");
			
			} else {
			
				served = front;
				front = front.next;
			
			}
			
		} catch (NullPointerException e) {
		
			System.out.print(e.getMessage());
		
		}
	
		return served;
	
	}
	
	@Override
	public String toString() {
	
		if (front == null) {
		
			return "List is empty";
		
		} 
		
		Person current = front;
		String personQueue = "";
		
		while (current != back) {
		
			personQueue += current.toString() + " ";
			current = current.next;
		
		}
		
		return personQueue += back.toString();
		
	}

	/**
	*	Inner Person class
	*/
	protected class Person {

		private String name = "";
		private Person next;
	
		protected Person(String name) {
	
			this.name = name;
	
		}

		@Override
		public String toString() {
		
			return name;
	
		}

	}
	
}