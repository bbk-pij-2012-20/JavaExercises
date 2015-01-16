// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/06_DATA_STRUCTURES/LinkedLists/Queue/QueueInterface
// Exercise 8.4.2 (Introduction to Interfaces and different implementations with data structures)
/*
Use the interface PersonQueue that represents a queue of people waiting at the supermarket and then implement
it. You can use the definition and the implementations of StringStack as a guide. You can reuse any version of
class Person from past days. For example, depending on your implementation, you may want to use a version of
Person with or without internal pointers. 
...
8.4.2 Implement the interface queue in a way that the next person retrieved is always 
a person over 65, if there are any in the queue; if not, it must be a person over 18, 
if there are any in the queue. Inside each age category, the behaviour of the queue is 
typical FIFO: first in, first out.

These two queues are examples of priority queues, and are not strictly FIFO: 
old people will always come out of the queue before younger people, even if the youngsters 
came to the queue first. Priority queues are more difficult to implement, but they are also 
important in computing. For example, your hard disk uses a priority queue to decide where 
to move next: if the disk’s head is at position 555 and the queue of requests is 
4, 99, 234, 500, 101, 43, 881, 77, your disk may decide to move to position 500 to reduce 
movement, time, and energy consumption.
*/

public class PriorityQueueImpl2 implements PersonQueue {

	private Person front = null;
	private Person back = null;
	private boolean noOver18sInQueue = true;
	
	/**
	*	Unlike PriorityQueueImpl, PriorityQueueImpl2's insert() method does not order the 
	*	Persons by age. (This makes writing retrieve() method's implementation a bit more
	*	interesting to do as an exercise.)
	*/
	@Override
	public void insert(Person person) {
	
		if (front == null) {
		
			front = back = person;
		
		} else {
		
			back.next = person;
			back = back.next;
		
		}
		
		if (person.age >= 18) {
		
			noOver18sInQueue = false;
		
		}
	
	}
	
	@Override
	public Person retrieve() {
	
		Person toBeServed = null;
		boolean finished = false;
		
		try {

			if (front == null) {

				throw new NullPointerException("Queue is empty: ");

			} 
			
			if (noOver18sInQueue) {
				
				finished = true;
				System.out.println("No over 18s in queue");

			} else if (front == back) {

				toBeServed = front;
				finished = true;	
				front = back = null;

			}

			int ageLimit64 = 64;
			int ageLimit17 = 17;
			Person oldestOver64 = new Person("null", ageLimit64);
			Person oldestOver17 = new Person("null", ageLimit17);
			Person priorToOldestOver64 = null;
			Person priorToOldestOver17 = null;
			Person current = front;
						
			while (!finished && current.next != null) {
								
				if (front.age > oldestOver64.age) {
				
					oldestOver64 = front;
					
				} else if (front.age > oldestOver17.age) {
				
					oldestOver17 = front;
					
				}
					
				if (current.next.age > oldestOver64.age) {
	
					oldestOver64 = current.next;
					priorToOldestOver64 = current;

					if (current.next == back) {
					
						back = priorToOldestOver64;
					
					}					

				} else if (current.next.age > oldestOver17.age) {
	
					oldestOver17 = current.next;
					priorToOldestOver17 = current;
					
					if (current.next == back) {
					
						back = priorToOldestOver17;
					
					}
					
				}
				
				current = current.next;

			}
			
			if (oldestOver64 == front) {
			
				front = front.next;
				
			} else if (oldestOver17 == front) {
			
				front = front.next;
			
			}

			try {
	
				if (oldestOver64.name == "null" && oldestOver17.name == "null") {
				
					throw new NullPointerException("Bug: there are no over 18s in queue, but this should have been caught earlier by the boolean member variable \'noOver18sQueue\'");

				} else if (oldestOver64.name != "null") {

					toBeServed = oldestOver64;
			
					if (priorToOldestOver64 != null) {
				
						priorToOldestOver64.next = oldestOver64.next;

					}
				
				} else if (oldestOver17.name != "null") {
			
					toBeServed = oldestOver17;
			
					if (priorToOldestOver17 != null) {
				
						priorToOldestOver17.next = oldestOver17.next;

					}

				} 
			
			} catch (NullPointerException e) {
		
				System.out.print(e.getMessage());
		
			}
			
		} catch (NullPointerException e) {
		
			System.out.print(e.getMessage());
		
		}
	
		return toBeServed;
	
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

		protected Person(int age) {
	
			this.age = age;
	
		}

		@Override
		public String toString() {
		
			return name + ":" + age;
	
		}

	}
	
}