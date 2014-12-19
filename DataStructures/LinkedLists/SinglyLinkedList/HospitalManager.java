//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/DataStructures/LinkedLists
//Exercise 7.3 (Introduction to data structures & pointers)

/*
	Create a linked list following the “hospital and patients” example of the notes:
	1. Create the linked list and add several elements to it (around 10 is fine).
	2. Go through the list printing out the content of each element.
	3. Delete a couple of elements from the list.
	4. Print the elements in the list again. Check that the deleted elements have been deleted. Check that you can
	delete the first element too.
	Hint: Note that you cannot delete the first element from inside the list because you need to update the pointer
	patientListStart. To add or delete the first element of a list, you must do it from outside the list.
*/

// NB: Patient class is written here, below HospitalManager class. 
public class HospitalManager {

	private Patient patientListStart = null;
	
	public static void main(String[] args) {
	
		HospitalManager hm = new HospitalManager();

		admit(new Patient("Jack", 157, "Asperger's Syndrome"));
		admit(new Patient("Mack", 227, "Manic Depression"));
		admit(new Patient("Jim", 307, "Tourette's Syndrome"));
		admit(new Patient("John", 47, "Syphilitic Psychosis"));
		admit(new Patient("Jane", 717, "Schizophrenia"));
		admit(new Patient("Jackie", 51, "Asperger's Syndrome"));
		admit(new Patient("Mackie", 43, "Manic Depression"));
		admit(new Patient("Jimie", 56, "Tourette's Syndrome"));
		admit(new Patient("Johnny", 23, "Syphilitic Psychosis"));
		admit(new Patient("Janette", 2, "Schizophrenia"));		
		
		System.out.println("\nAfter admitting 10 patients. List of patients is: ");
		hm.printPatientList();
		
		hm.discharge(new Patient("Jack", 157, "Asperger's Syndrome"));
		hm.discharge(new Patient("Mack", 227, "Manic Depression"));
		hm.discharge(new Patient("Jim", 307, "Tourette's Syndrome"));	

		System.out.println("\nAfter deleting 3 patients. List of patients is: ");
		hm.printPatientList();

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
	
}

/* 
	So, my understanding of a linked list is that it consists of two classes, a node and 
	a node manager. The node class defines a linked list by the fact that every node object
	will have a pointer to the next node in the list.

	The node manager holds a reference to one, very important node, called the root. 

	What makes this data structure a "dynamic" one is that it contains the behaviour of 
	shrinking and growing within itself, i.e. the methods are included in the classes and 
	therefore these are the intrinsic 'properties' of the objects. 

	There must be at least two methods (which can be recursive). 
	These are admit() and discharge(). In this 'Hospital' example, the node is the patient 
	and the node manager is 'HospitalManager'
*/
