// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/06_DATA_STRUCTURES/LinkedLists/Queue/QueueInterface
// Exercise 8.1-8.4 (Introduction to Interfaces and their implementation (using data structures))
/*
Use the interface PersonQueue that represents a queue of people waiting at the supermarket and then implement
it. You can use the definition and the implementations of StringStack as a guide. You can reuse any version of
class Person from past days. For example, depending on your implementation, you may want to use a version of
Person with or without internal pointers.
Then create a class Supermarket that has two methods: addPerson(Person) and servePerson(). These
methods must call the appropriate methods of PersonQueue.

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

public interface PersonQueue {

//implemented by class PersonQueueImpl
/*
	/**
	* Adds another person to the queue.
	*
	void insert(PersonQueueImpl.Person person);

	/**
	* Removes a person from the queue.
	*
	PersonQueueImpl.Person retrieve();
*/		
/*
//implemented by class PersonQueueImpl2
	/**
	* Adds another person to the queue.
	*
	void insert(PersonQueueImpl2.Person person);

	/**
	* Removes a person from the queue.
	*
	PersonQueueImpl2.Person retrieve();
*/
/*
//implemented by class PriorityQueueImpl
	/**
	* Adds another person to the queue.
	*
	void insert(PriorityQueueImpl.Person person);

	/**
	* Removes a person from the queue.
	*
	PriorityQueueImpl.Person retrieve();
*/

//implemented by class PriorityQueueImpl2
	/**
	* Adds another person to the queue.
	*/
	void insert(PriorityQueueImpl2.Person person);

	/**
	* Removes a person from the queue.
	*/
	PriorityQueueImpl2.Person retrieve();

}
