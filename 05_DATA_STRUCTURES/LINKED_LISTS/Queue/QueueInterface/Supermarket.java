// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/06_DATA_STRUCTURES/LinkedLists/Queue/QueueInterface
// Exercise 8.1-8.4 (Introduction to Interfaces and their implementation (using data structures))
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

8.4.1. Implement the interface queue in a way that the person at the end 
(i.e. the person that is retrieved next time the method retrieve() is called) 
is always the oldest person.

8.4.2 Implement the interface queue in a way that the next person retrieved is always 
a person over 65, if there are any in the queue; if not, it must be a person over 18, 
if there are any in the queue. Inside each age category, the behaviour of the queue is 
typical FIFO: first in, first out.
*/

/*	PersonQueueImpl is implementation with singly-linked list, PersonQueueImpl2 is with array
*	PriorityQueueImpl & PriorityQueueImpl2 are implemented with singly-linked lists
*/
public class Supermarket {

//	private PersonQueue pq = new PersonQueueImpl();
//	private PersonQueue pq = new PersonQueueImpl2();
//	private PersonQueue pq = new PriorityQueueImpl();	
	private PersonQueue pq = new PriorityQueueImpl2();	

	public static void main(String[] args) {
/*
		PersonQueueImpl pqi1 = new PersonQueueImpl();
		PersonQueueImpl.Person p1 = pqi1.new Person("John");
		PersonQueueImpl.Person p2 = pqi1.new Person("James");
		PersonQueueImpl.Person p3 = pqi1.new Person("Jill");
		PersonQueueImpl.Person p4 = pqi1.new Person("Jane");
*/	
/*		
		PersonQueueImpl2 pqi2 = new PersonQueueImpl2();
		PersonQueueImpl2.Person p1 = pqi2.new Person("John");
		PersonQueueImpl2.Person p2 = pqi2.new Person("James");
		PersonQueueImpl2.Person p3 = pqi2.new Person("Jill");
		PersonQueueImpl2.Person p4 = pqi2.new Person("Jane");
*/
/*
		PriorityQueueImpl pqi3 = new PriorityQueueImpl();		
		PriorityQueueImpl.Person p1 = pqi3.new Person("John", 70);
		PriorityQueueImpl.Person p2 = pqi3.new Person("James", 50);
		PriorityQueueImpl.Person p3 = pqi3.new Person("Jill", 60);
		PriorityQueueImpl.Person p4 = pqi3.new Person("Jane", 40);
*/
		PriorityQueueImpl2 pqi4 = new PriorityQueueImpl2();		
		PriorityQueueImpl2.Person p1 = pqi4.new Person("John", 70);
		PriorityQueueImpl2.Person p2 = pqi4.new Person("James", 80);
		PriorityQueueImpl2.Person p3 = pqi4.new Person("Stan", 65);
		PriorityQueueImpl2.Person p4 = pqi4.new Person("Jill", 19);
		PriorityQueueImpl2.Person p5 = pqi4.new Person("Jane", 30);
		PriorityQueueImpl2.Person p6 = pqi4.new Person("Bob", 72);
		PriorityQueueImpl2.Person p7 = pqi4.new Person("Mac", 15);
		PriorityQueueImpl2.Person p8 = pqi4.new Person("Eve", 21);
		PriorityQueueImpl2.Person p9 = pqi4.new Person("Jim", 18);

		Supermarket s = new Supermarket();
		s.addPerson(p1);
		s.addPerson(p2);
		s.addPerson(p3);
		s.addPerson(p4);

		System.out.println("\nWhole queue is now: " + s.pq.toString());

		System.out.println("serving... " + s.servePerson());
		System.out.println("serving... " + s.servePerson());
		System.out.println("\nWhole queue is now: " + s.pq.toString());
		s.addPerson(p5);		
		s.addPerson(p6);
		System.out.println("...adding 2 to queue (Jane & Bob)...");
		System.out.println("\nWhole queue is now: " + s.pq.toString());		

		System.out.println("serving... " + s.servePerson());
		System.out.println("serving... " + s.servePerson());
		System.out.println("serving... " + s.servePerson());
		System.out.println("\nWhole queue is now: " + s.pq.toString());				
		
		s.addPerson(p7);
		s.addPerson(p8);		
		s.addPerson(p9);
		System.out.println("...adding 3 more to queue (Mac, Eve & Jim)...");
		System.out.println("\nWhole queue is now: " + s.pq.toString());		

		System.out.println("serving... " + s.servePerson());
		System.out.println("serving... " + s.servePerson());
		System.out.println("serving... " + s.servePerson());
		System.out.println("\nWhole queue is now: " + s.pq.toString());		

	}
/*
	public PersonQueueImpl.Person servePerson() {
	
		return pq.retrieve();		
	
	}
	
	public void addPerson(PersonQueueImpl.Person person) {
	
		pq.insert(person);
	
	}
*/	
/*
	public PersonQueueImpl2.Person servePerson() {
	
		return pq.retrieve();		
	
	}
	
	public void addPerson(PersonQueueImpl2.Person person) {

		pq.insert(person);
	
	}	
*/
/*
	public PriorityQueueImpl.Person servePerson() {
	
		return pq.retrieve();		
	
	}
	
	public void addPerson(PriorityQueueImpl.Person person) {

		pq.insert(person);
	
	}	
*/

	public PriorityQueueImpl2.Person servePerson() {
	
		return pq.retrieve();		
	
	}
	
	public void addPerson(PriorityQueueImpl2.Person person) {

		pq.insert(person);
	
	}	

}