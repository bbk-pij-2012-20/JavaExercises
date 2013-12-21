//cd desktop/JavaCoding/JavaExercises
public class Supermarket2
{
	private PersonQueue2Impl pqi=new PersonQueue2Impl();
	
	public void add(Person person)
	{
		pqi.insert(person);
	}
	public void serve()
	{
		Person served=null;
		try
		{
			served=pqi.retrieve();
		}
		catch (NullPointerException ex) 
		{
			System.out.println("nothing doing up here:"+ex.getMessage());
			return;
		}
		catch (Exception ex)
		{
			System.out.println("nothing doing down here:"+ex.getMessage());
			return;
		}
		System.out.println(served.getName()+" has been seen to.");
	}
	
	public static void main(String args[])
	{
		Supermarket2 sm=new Supermarket2();
		sm.add(new Person("bob"));
		sm.add(new Person("bob2"));
		sm.add(new Person("bob3"));
		sm.add(new Person("bob4"));
		sm.add(new Person("bob5"));
		sm.add(new Person("bob6"));
		sm.serve();
		sm.serve();
		sm.serve();
		sm.serve();
	}
}
interface PersonQueue2 
{ 
	/**
	* Adds another person to the queue.
	*/
	void insert(Person person);

	/**
	* Removes a person from the queue. 
	*/
	Person retrieve() throws Exception;
}
class PersonQueue2Impl implements PersonQueue2
{
	private Person front;
	private Person back;

	public PersonQueue2Impl()
	{
		front=back=null;
	}
	public void insert(Person person)
	{
		if(back!=null)
		{
			back.setNext(person);
		}
		else
		{
			front=person;
		}
		back=person;
	}
	public Person retrieve() throws Exception 
	{
		Person personAtFront=front;
		if(front!=null)
		{
			front=front.getNext();
		}
		if(front==null)
		{
			back=null;
		}
		if(personAtFront==null)
		{
			throw new NullPointerException("queue is empty");
		}
		return personAtFront;
	}
}
class Person
{
	private String name;
	private Person nextPerson;
	
	public String getName()
	{
		return name;
	}
	public void setNext(Person person)
	{
		nextPerson=person;
	}
	public Person getNext()
	{
		return nextPerson;
	}
	public Person(String name)
	{
		this.name=name;
		nextPerson=null;
	}
}