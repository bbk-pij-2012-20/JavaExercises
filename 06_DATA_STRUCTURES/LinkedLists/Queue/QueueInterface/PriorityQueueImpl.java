// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/06_DATA_STRUCTURES/LinkedLists/Queue/QueueInterface
// Exercise 8.4.1 (Introduction to Interfaces and different implementations with data structures)
/*
Use the interface PersonQueue that represents a queue of people waiting at the supermarket and then implement
it. You can use the definition and the implementations of StringStack as a guide. You can reuse any version of
class Person from past days. For example, depending on your implementation, you may want to use a version of
Person with or without internal pointers. 
...
8.4.1. Implement the interface queue in a way that the person at the end 
(i.e. the person that is retrieved next time the method retrieve() is called) 
is always the oldest person.
*/
public class PriorityQueueImpl implements PersonQueue {

	private Person front = null;
	private Person back = null;
	
	/**
	*	Insert() method's implementation inserts Persons in the queue by age.
	*	(Thus, retrieve() method just stays the same as before).
	*/
	@Override
	public void insert(Person person) {
		
		Person person_ = person;
		boolean inserted = false;
		Person current = front;
			
		while (!inserted) {
				
			if (front == null) {
		
				front = back = person;
				inserted = true;
					
			}
				
			if (front.age < person.age) {
			
				person_.next = front;
				front = person; 	
				inserted = true;
				
			} else if (front == back) {
				
				front.next = person;
				back = person;
				inserted = true;
					
			} else if (current.next.age < person.age) {
	
				person.next = current.next;
				current.next = person;
				inserted = true;
				
			} else if (current.next == back) {
					
				back.next = person;
				back = person;
				inserted = true;
					
			} else {
				
				current = current.next;
					
			}

		}

	}
	
	/**
	*	Needs to do nothing special, as insert() method does all the work in terms
	*	of ordering the Persons by age.	
	*/
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
		private int age = 0;
		private Person next;
	
		protected Person(String name, int age) {
	
			this.name = name;
			this.age = age;
	
		}

		@Override
		public String toString() {
		
			return name + ":" + age;
	
		}

	}
	
}