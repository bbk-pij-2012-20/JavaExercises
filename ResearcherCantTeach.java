/* cd desktop/JavaCoding/JavaExNoTGIT/d10Ex_noGIT
Purpose of exercise is to find the problem with the following code:
Compilation error: Constructor Teacher in class Teacher cannot be 
applied to given types;
class Lecturer extends Teacher
^
  required: String
  found: no arguments
  reason: actual and formal argument lists differ in length

This is because upon instantiation of a subclass, its constructor(s) 
automatically call the constructor of the superclass. In this case
the constructor of the subclass, Lecturer has no constructor which passes
a String argument to the superclass's constructor. And vice versa, the 
superclass has no zero argument constructors which can match up with the
default empty constructor of the subclass.    
*/
public class ResearcherCantTeach//Day10Ex6
{
	public static void main(String args[])
	{
		Lecturer l=new Lecturer();
		l.getName();
		l.teach("walking");
		l.doResearch("The theory of being great");
	}
}
class Teacher 
{
	private String name;
	public Teacher(String name) 
	{
		this.name=name; 
	}
//	public Teacher(){} //compilation is resolved either by adding this line.
	public String getName()
	{
		return name;
	}
	public void teach(String lessonName)
	{
		System.out.println("Teaching lesson: "+lessonName);
	}
} 
/**
* A lecturer has both teaching and research responsibilities.
*/
class Lecturer extends Teacher
{
// Or, the compilation is resolved by adding this constructor.
	public Lecturer()
	{
		super("Jose");
	}
	
	public void doResearch(String topic)
	{
		System.out.println("Doing research on: "+topic);
	}
}