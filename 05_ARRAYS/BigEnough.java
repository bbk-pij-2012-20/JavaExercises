// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/05_ARRAYS
// Exercise 6.7 (Arrays. 3D Array and also first use of enums as well).
/*
Write a small program that asks for the names and IDs of all employees in a small company, 
and stores them in an array of integers and an array of Strings. 
(You will need to create a Java class to hold the arrays, and to access them).
This is similar to the example from the notes, but you do not know the number of employees in advance. 
Read the names and IDs of employees until the user enters an empty name (i.e. length 0) or an ID equal to 0.
Once you have finished reading employee data, go through the employee list and print the names and IDs of
those employees whose ID is even or their names start with “S”.
(Hint: As you do not know how many employees you need in advance, you will need a growing array. 
Create a small array, if it gets full create an array twice as big, copy all data to the new array, and discard the old array,
etc).
*/

import java.util.Arrays;

public class BigEnough {

	private EmployeeRecords records = null;
	private boolean terminated = false;
	
	public static void main(String[] args) {

		BigEnough be = new BigEnough();
		String name = "";
		int id = 0;
		be.takeInputs();
		be.showOutput();
			
	}
	
   /**
 	*	Constructor initialises employee records.
 	*/	
	public BigEnough() {
	
		records = new EmployeeRecords(); 
	
	}

   /**
 	*	Takes input names and ids. Only adds them to list 
 	*	if the name input is not empty and id input is not 0.
 	*/		
	public void takeInputs() {
	
		String input = "";
		
		do {
			
			System.out.println("Input employee name");
			String name = System.console().readLine();
			String idStr = "";
			
			if (name.length() == 0) {

				break;
			
			}

			do {
			
				System.out.println("Input employee id");
				idStr = System.console().readLine();
			
			} while (!isValid(idStr));

			int id = Integer.parseInt(idStr);
			
			if (id == 0) {

				break;
					
			}
				
			records.addEmployee(name, id);

		} while (!terminated);

	}
	
   /**
 	*	Checks that input for id is a number.
 	*
 	*	@param input				id user input
 	*	@return 					true if input is a number
 	*/		
	public boolean isValid(String input) {
	
		boolean validInput = false;
		
		try {
		
			Integer.parseInt(input);
			validInput = true;
			
		} catch (NumberFormatException e) {
		
			System.out.println("Error - please enter an number (0 to end):");
			validInput = false;
		
		}
		
		return validInput;
		
	}
	
   /**
 	*	Prints out the list of employees.
 	*/	
	public void showOutput() {
	
		System.out.println("Employees with names starting with S and/or with even Id numbers:");
		System.out.println(toString(getS_NameOrEvenId()));
	
	}
	
   /**
 	*	Renders the result output of names and ids.
 	*
 	*	@param resultArray			the result array to output
 	*	@return 					the result array rendered to output to console.
 	*/		
	public String toString(String[] resultArray) {
	
		if (resultArray.length == 1) {
		
			return "[" + resultArray[0] + "]";
		
		} else if (resultArray.length == 2) {
			
			return "[" + resultArray[0] + ", " + resultArray[1] + "]";
		
		}

		return resultArray[0] + ", " + toString(Arrays.copyOfRange(resultArray, 1, resultArray.length - 1)); 
	
	}

   /**
 	*	Renders the result output of names and ids.
 	*
 	*	@return 					the result array rendered to output to console.
 	*/			
	public String[] getS_NameOrEvenId() {
	
		int initialSize = 10;
		String[] nameId = new String[initialSize];
		int j = -1;
		int i = 0;
		
		while (i < records.getRecordSize() && records.getNameAt(i) != null) {
		
			String nameAt_i = records.getNameAt(i).toUpperCase();
			int idAt_i = records.getIdAt(i);
		
			if (nameAt_i.charAt(0) == 'S' || idAt_i % 2 == 0) {

				nameId[++j] = records.getNameAt(i) + "_" + records.getIdAt(i);

			}
			
			i++;
			
		}

		return nameId;
	
	}
	
}

/**
 *	Holds the employee names and employee ids.
 *	Will double the storage container when full.
 */
class EmployeeRecords {

	private final int RECORD_INITIAL_SIZE = 10;
	private String[] employeeNames = null;
	private int[] employeeIds = null;

   /**
 	*	Constructor initialises the two containers for employee names and employee ids
 	*/
	public EmployeeRecords() {
	
		employeeNames = new String[RECORD_INITIAL_SIZE];
		employeeIds = new int[RECORD_INITIAL_SIZE];
	
	}
	
   /**
 	*	Called from BigEnough class to add new employee name and id to end of their respective 
 	*	containers. 
 	*
 	*	@param name			employee name
	*	@param name			employee id number
	*	@return 			true when employee name and id have been added to their respective containers.
 	*/	
	public boolean addEmployee(String name, int id) {
	
		int i = 0;
		boolean added = false;
		
		if (employeeNames[employeeNames.length - 1] != null) {
		
			doubleSize();
		
		}
		
		while (!added) {
	
			if (employeeNames[i] == null) {
			
				employeeNames[i] = name;
				employeeIds[i] = id;
				added = true;
							
			} else {
			
				i++;
			
			}
			
		}
		
		return added;
		
	}

   /**
 	*	Called from addEmployee(name, id).
 	*/		
	public void doubleSize() {
	
		String[] tempNames = employeeNames;
		int[] tempIds = employeeIds;
		int newArraySize = 2 * employeeNames.length;
		employeeNames = new String[newArraySize];
		employeeIds = new int[newArraySize];
		employeeNames = tempNames;
		employeeIds = tempIds;

	}

   /**
 	*	Gets length of records. Called from BigEnough.
 	*/
	public int getRecordSize() {
	
		return employeeNames.length;
	
	}
	
  /**
 	*	Gets an employee name at specified position. Called from BigEnough.
 	*
 	*	@param position			position of employee name in container 
 	*	@return					employee name at specified position 	
 	*/
	public String getNameAt(int position) {
	
		return employeeNames[position];
	
	}

   /**
 	*	Gets an employee's id at specified position. Called from BigEnough.
 	*
 	*	@param position			position of id in container 
 	*	@return					id number at specified position 	
 	*/
	public int getIdAt(int position) {
	
		return employeeIds[position];
	
	}
		
}