// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/DataStructures/LinkedLists
// Exercise 7.4 (Introduction to data structures & pointers)

/*
	Reuse the code of one of the dynamic list in the former exercise, 
	and add a method that calculates the length of the list. 
	Iteratively and recursively ? Try both ways and see which is 
	more natural for you. If one takes too long, try the other way.
*/

public class HospitalManagerPlusGetSize {

	private Patient patientListStart = null;
	
	public static void main(String[] args) {
	
		HospitalManagerPlusGetSize hmpgs = new HospitalManagerPlusGetSize();

		admit(new Patient("Jack",157,"Asperger's Syndrome"));
		admit(new Patient("Mack",227,"Manic Depression"));
		admit(new Patient("Jim",307,"Tourette's Syndrome"));
		admit(new Patient("John",47,"Syphilitic Psychosis"));
		admit(new Patient("Jane",717,"Schizophrenia"));
		admit(new Patient("Jackie",51,"Asperger's Syndrome"));
		admit(new Patient("Mackie",43,"Manic Depression"));
		admit(new Patient("Jimie",56,"Tourette's Syndrome"));
		admit(new Patient("Johnny",23,"Syphilitic Psychosis"));
		admit(new Patient("Janette",2,"Schizophrenia"));		
		
		System.out.println("\nAfter admitting 10 patients. List of patients is: ");
		hmpgs.printPatientList();
		System.out.println("size:" + hmpgs.getSize());
		
		hmpgs.discharge(new Patient("Jack",157,"Asperger's Syndrome"));
		hmpgs.discharge(new Patient("Mack",227,"Manic Depression"));
		hmpgs.discharge(new Patient("Jim",307,"Tourette's Syndrome"));	

		System.out.println("\nAfter deleting 3 patients. List of patients is: ");
		hmpgs.printPatientList();
		System.out.println("size:" + hmpgs.getSize());

	}
	
	public void admit(Patient patient) {
	
		if (patientListStart == null) {
		
			patientListStart = patient;
		
		} else {

			patientListStart.add(patient);

		}

	}
	
	public boolean discharge(Patient patient) {
	
		if (patientListStart == null) {
		
			return false;
		
		} else {
			
			if (patientListStart.getName().equals(patient.getName())) {
			
				patientListStart = patientListStart.nextPatient;
				return true;
			
			} else {
				
				return patientListStart.remove(patient);
		
			}
	
		}

	}
	
	public int getSize() {
	
		int size = 0;
		
		if (patientListStart == null) {
		
			size = 0;
		
		} else {
		
			return patientListStart.getSize();
		
		}
	
	}
	
	public void printPatientList() {
	
		if (patientListStart != null) {
		
			patientListStart.printPatientList();
		
		} else {
			
			System.out.println("I've no patients");
		
		}
	
	}
}

class Patient {

	private String name;
	private int age;
	private String illness;
	public Patient nextPatient;
	
	public Patient(String name, int age, String illness) {
	
		this.name = name;
		this.age = age;
		this.illness = illness;
		this.nextPatient = null;
	
	}
	
	public String getName() {
	
		return name;
	
	}
	
	public void add(Patient patient) {
	
		if (nextPatient == null) {
		
			nextPatient = patient;
		
		} else {
			
			nextPatient.add(patient);
		
		}
	
	}
	
	public boolean remove(Patient patient) {
	
		if (nextPatient == null) {
		
			return false;
		
		} else if (nextPatient.name.equals(patient.name)) {
		
			nextPatient = nextPatient.nextPatient;
			return true;
		
		} else {
			
			return nextPatient.remove(patient);
		
		}

	}	
	
	public void printPatientList() {
	
		System.out.println("Name:" + name + ", Age: " + age + ", Illness: " + illness);
		
		if (nextPatient != null) {
		
			nextPatient.printPatientList();
		
		}
	
	}

// Calculating list size iteratively:
/*	
	public int getSize() {
	
		int size = 1;
		
		while (nextPatient != null) {
		
			size++;
			nextPatient = nextPatient.nextPatient;
		
		}

		return size;
	
	}
*/

// Calculating list size recursively:

	public int getSize() {
	
		if (nextPatient == null) { 

			return 1;

		} else {
			
			return 1 + nextPatient.getSize(); 
		
		}
	
	}
	
	
/* 
	Notes (Sokratis)
	A recursive call can only deal with a small part of the problem at a time.
	For a linked list, recursion is more elegant than iteration
	but is much less preferable to iteration, the bigger the list gets. 
	For a tree, recursion is much less complicated than iteration. 
*/	

}