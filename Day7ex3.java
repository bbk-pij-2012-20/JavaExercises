/* 
The linked list consists of two classes, a node and a node
manager. 
The node defines a linked list by having an internal pointer,
i.e. pointing to another node as a member field. 

The node manager has one node which represents the root node. 

What makes this data structure a "dynamic" one is that it 
contains the behaviour of shrinking and growing itself, 
built in. So, it must have two methods (which can be recursive). 
These are add() and delete(). In this 'hospital' example, the 
node is the patient and manager is the 'hospital manager'
*/

public class Day7ex3 // aka 'HOSPITAL MANAGER' CLASS
{
	private Patient patientListStart=null;
	
	public static void main(String[] args)
	{
		Day7ex3 hosMan=new Day7ex3();
		
		hosMan.initList(new Patient("Jill",105,"dementia"));
		System.out.println("\nAfter adding 1st patient. List of patients is:");
		hosMan.printPatient();
		
		hosMan.addMorePatientsToList();
		System.out.println("\nAfter adding 10 more patients. List of patients is:");
		hosMan.printPatient();
		
		hosMan.deletePatient(new Patient("Jack",157,"Asperger's Syndrome"));
		hosMan.deletePatient(new Patient("Mack",227,"Manic Depression"));
		hosMan.deletePatient(new Patient("Jim",307,"Tourette's Syndrome"));	
		System.out.println("\nAfter deleting 3 patients. List of patients is:");
		hosMan.printPatient();
	}
	public void initList(Patient firstPatient)
	{
		if(patientListStart==null)
		{
			patientListStart=firstPatient;
		}
		else
		{
			patientListStart.addPatient(firstPatient);
		}		
	}	
	public void addMorePatientsToList()
	{
		initList(new Patient("Jack",157,"Asperger's Syndrome"));
		initList(new Patient("Mack",227,"Manic Depression"));
		initList(new Patient("Jim",307,"Tourette's Syndrome"));
		initList(new Patient("John",47,"Syphilitic Psychosis"));
		initList(new Patient("Jane",717,"Schizophrenia"));
		initList(new Patient("Jackie",51,"Asperger's Syndrome"));
		initList(new Patient("Mackie",43,"Manic Depression"));
		initList(new Patient("Jimie",56,"Tourette's Syndrome"));
		initList(new Patient("Johnny",23,"Syphilitic Psychosis"));
		initList(new Patient("Janette",2,"Schizophrenia"));		
	}
	
	public boolean deletePatient(Patient patient)
	{
		if(patientListStart==null)
		{
			return false;
		}
		else
		{
			if(patientListStart.getName().equals(patient.getName()))
			{
				patientListStart=patientListStart.nextPatient;
				return true;
			}
			else
			{
				return patientListStart.deletePatient(patient);
			}
		}
	}
	
	public void printPatient()
	{
		if(patientListStart!=null)
		{
			patientListStart.printPatients();
		}
		else
		{
			System.out.println("I've no patients");
		}
	}
}

class Patient
{
	private String name;
	private int age;
	private String illness;
	public Patient nextPatient;
	
	public Patient(String name,int age,String illness)
	{
		this.name=name;
		this.age=age;
		this.illness=illness;
		this.nextPatient=null;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void addPatient(Patient newPatient)
	{
		if(this.nextPatient==null)
		{
			this.nextPatient=newPatient;
		}
		else
		{
			this.nextPatient.addPatient(newPatient);
		}
	}
	public boolean deletePatient(Patient patient)
	{
		if(this.nextPatient==null)
		{
			return false;
		}
		else if(this.nextPatient.name.equals(patient.name))
		{
			this.nextPatient=nextPatient.nextPatient;
			return true;
		}
		else
		{
			return this.nextPatient.deletePatient(patient);
		}
	}	
	
	public void printPatients()
	{
		System.out.println("Name:"+this.name+", Age: "+this.age+", Illness: "+this.illness);
		if(nextPatient!=null)
		{
			nextPatient.printPatients();
		}
	}
}

