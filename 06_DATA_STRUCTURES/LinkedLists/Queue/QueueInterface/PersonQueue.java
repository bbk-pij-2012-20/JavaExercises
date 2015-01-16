// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/06_DATA_STRUCTURES/LinkedLists/Queue/QueueInterface
// Exercise 8.1 (Introduction to Interfaces and their implementation (using data structures))
/*
Use the interface PersonQueue that represents a queue of people waiting at the supermarket and then implement
it. You can use the definition and the implementations of StringStack as a guide. You can reuse any version of
class Person from past days. For example, depending on your implementation, you may want to use a version of
Person with or without internal pointers.
Then create a class Supermarket that has two methods: addPerson(Person) and servePerson(). These
methods must call the appropriate methods of PersonQueue.
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
