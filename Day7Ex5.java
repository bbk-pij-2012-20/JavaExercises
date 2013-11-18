/*
This is the code copied from exercise 4 exactly. 
In addition, it is now doubly-linked.
*/

public class Day7Ex5 // "Doubly-linked list"
{
	private Patient patientListStart=null;
	
	public static void main(String[] args)
	{
		Day7Ex5 hm=new Day7Ex5();

		int listSize=hm.getSize();

		hm.initList(new Patient("Jill",105,"dementia"));
		System.out.println("\nAfter adding 1st patient. List of patients is:");
		hm.printPatient();

		hm.addMorePatientsToList();
		System.out.println("\nAfter adding 10 more patients. List of patients is:");
		hm.printPatient();
		listSize=hm.getSize();
		System.out.println("\nCurrent size of list is "+listSize);
		
		hm.deletePatient(new Patient("Jack",157,"Asperger's Syndrome"));
		hm.deletePatient(new Patient("Mack",227,"Manic Depression"));
		hm.deletePatient(new Patient("Jim",307,"Tourette's Syndrome"));	
		System.out.println("\nAfter deleting 3 patients. List of patients is:");
		hm.printPatient();
		listSize=hm.getSize();
		System.out.println("\nNow's it's "+listSize+" patients long.");
	}

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
	public Patient previousPatient;

//(recursive version of this method only is shown)
	public int getListSize()
	{
		if(nextPatient==null)
		{
			return 1;
		}
		else
		{
			return 1+nextPatient.getListSize(); 
		}
	}

	public Patient(String name,int age,String illness)
	{
		this.name=name;
		this.age=age;
		this.illness=illness;
		this.nextPatient=null;
	//?	this.previousPatient=null; ?
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
			newPatient.previousPatient=this;
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
			if(this.nextPatient!=null)
			{
				this.nextPatient.previousPatient=this;
			}
			return true;
		}
		else 
		{
			return this.nextPatient.deletePatient(patient);
		}
	}
	
	public void printPatients()
	{
		System.out.println("Name: "+name+", Age: "+age+", Illness: "+illness);
		if(nextPatient!=null)
		{
			nextPatient.printPatients();
		}
		else
		{
			printPatientsInReverse();  // not sure why I can call this method without an object.   
		}
	}
	public void printPatientsInReverse()
	{
		System.out.println("In REVERSE! Name: "+name+", Age: "+age+", Illness: "+illness);
		if(previousPatient!=null)
		{
			previousPatient.printPatientsInReverse();
		} 
	}
}