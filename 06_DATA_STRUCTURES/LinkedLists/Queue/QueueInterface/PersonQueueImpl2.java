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
// implemented here as an array

import java.util.Arrays;

public class PersonQueueImpl2 implements PersonQueue {

	private static final int START_SIZE = 4;
	private static final int FRONT = 0;
	private int increasedSize, lastIndexInArray, back;
	public Person[] pQueue = new Person[START_SIZE];
	
	public PersonQueueImpl2() {
	
		increasedSize = START_SIZE;
		lastIndexInArray = increasedSize - 1;
		back = FRONT;
	
	}
	
	@Override
	public void insert(Person person) {

		if (pQueue[lastIndexInArray] != null) {

			increaseArraySize();	
			
		}

		if (pQueue[back] == null) {
		
			pQueue[back] = person;

		} else {
			
			back += 1;
			pQueue[back] = person;

		}

	}
	
	/**
	*	Increases Queue array by 'size'
	*/
	private void increaseArraySize() {

		increasedSize += START_SIZE; 
		pQueue = Arrays.copyOf(pQueue, increasedSize);
				
	}
	
	@Override
	public Person retrieve() {
	
		Person served = null;
		
		try {
	
			if (pQueue[FRONT] == null) {
		
				throw new NullPointerException("queue is empty: ");
			
			} else {
			
				served = pQueue[FRONT];

				updateQueueHavingServedPersonAtFront();
		
			}
			
		} catch (NullPointerException e) {
		
			System.out.print(e.getMessage());
		
		}
	
		return served;
	
	}
	
	/**
	*	Updates Queue by moving all Persons in Queue 'forward' by one position (to lower index in the array).
	*/
	private void updateQueueHavingServedPersonAtFront() {
	
		int currentIndex = FRONT;

		while (currentIndex <= back) {

			if (currentIndex == lastIndexInArray) {

				pQueue[lastIndexInArray] = null;

			} else  {

				pQueue[currentIndex] = pQueue[currentIndex + 1];

			}

			currentIndex++;

		}
		
		back = currentIndex - 1;
	
	}
	
	@Override
	public String toString() {

		if (pQueue[FRONT] == null) {
		
			return "List is empty";
		
		} 
		
		int current = FRONT;
		String personQueue = "";
		
		while (current <= back) {
		
			personQueue += pQueue[current].toString() + " ";
			current++;
		
		}
		
		return personQueue;
		
	}

	/**
	*	Inner Person class
	*/
	protected class Person {

		private String name = "";
	
		protected Person(String name) {
	
			this.name = name;
	
		}
		
		@Override
		public String toString() {
		
			return name;
	
		}
		
	}
	
}