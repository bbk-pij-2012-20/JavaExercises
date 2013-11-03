/*
This is the code copied from exercise 3 exactly. 
In addition, a method for calculating the list length
iteratively vs recursively. 
*/

public class Day7Ex4 // "Queue length"
{
	private Patient patientListStart=null;
	
	public static void main(String[] args)
	{
		Day7Ex4 hosMan=new Day7Ex4();

		int listSize=hosMan.getSize();

		hosMan.initList(new Patient("Jill",105,"dementia"));
		System.out.println("\nAfter adding 1st patient. List of patients is:");
		hosMan.printPatient();

		hosMan.addMorePatientsToList();
		System.out.println("\nAfter adding 10 more patients. List of patients is:");
		hosMan.printPatient();
		listSize=hosMan.getSize();
		System.out.println("\nCurrent size of list is "+listSize);
		
		hosMan.deletePatient(new Patient("Jack",157,"Asperger's Syndrome"));
		hosMan.deletePatient(new Patient("Mack",227,"Manic Depression"));
		hosMan.deletePatient(new Patient("Jim",307,"Tourette's Syndrome"));	
		System.out.println("\nAfter deleting 3 patients. List of patients is:");
		hosMan.printPatient();
		listSize=hosMan.getSize();
		System.out.println("\nNow's it's "+listSize+" patients long.");
	}
// Here is the one of two methods which together calculate 
// the list size (as per Day7 exercise#4).
	public int getSize()
	{
		if(patientListStart==null)
		{
			System.out.println("The list is empty");
			return 0;
		}
		else
		{
			return patientListStart.getListSize();
		}
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

// Here is the method for calculating list size (as per
// exercise 4).
	public int getListSize()
	{
		int size=1;
		while(this.nextPatient!=null)
		{
			this=nextPatient;
			size++;
		}
		return size;
	}
	
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