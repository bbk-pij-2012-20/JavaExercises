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

public class Supermarket {

	private PersonQueue pq = new PersonQueueImpl();
		
	public static void main(String[] args) {
	
		PersonQueueImpl pqi = new PersonQueueImpl();
		PersonQueueImpl.Person p1 = pqi.new Person("John");
		PersonQueueImpl.Person p2 = pqi.new Person("James");
		PersonQueueImpl.Person p3 = pqi.new Person("Jill");
		PersonQueueImpl.Person p4 = pqi.new Person("Jane");
		Supermarket s = new Supermarket();
		s.addPerson(p1);
		s.addPerson(p2);
		s.addPerson(p3);
		s.addPerson(p4);
		System.out.println("Whole queue: " + pqi.toString());
		System.out.println(s.servePerson());
		System.out.println(s.servePerson());
		System.out.println(s.servePerson());
		System.out.println(s.servePerson());
		System.out.println(s.servePerson());
			
	}
	
	public PersonQueueImpl.Person servePerson() {
	
		return pq.retrieve();		
	
	}
	
	public void addPerson(PersonQueueImpl.Person person) {
	
		pq.insert(person);
	
	}
	
}