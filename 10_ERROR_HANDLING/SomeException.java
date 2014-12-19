// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/ErrorHandling
// Exercise 15.2 : Introducing Error handling
/* 
Read the following code and check whether there is anything wrong with it. 
Then write some similar code and check your answer:

// Some code here 
try {
	// more code here 
	list.add(newElement); 
	// more code here
} catch (Exception ex) { 
	ex.printStackTrace();
} catch (NullPointerException ex) { 
	ex.printStackTrace();
}
It may be that the more specific exception is written after the less specific one. 
So it will be caught with Exception even though the exception thrown could be a 
NullPointerException

Indeed, when placed in the code below it that order, the JVM gives compilation error: 
exception NullPointerException has already been caught	
catch(NullPointerException ex)
^
The error is resolved by moving the more specific exception up above the 
less specific exception, as below
*/		

import java.util.List;
import java.util.ArrayList;

public class SomeException {

	public static void main(String args[]) {

		try {
			
			List<Integer> list = new ArrayList<Integer>();
			list.add(10);
			list.add(20);
			list.add(30);
			list.remove(0);
			list.remove(8); // "line 38"
		
		} catch(NullPointerException ex) {
		
			System.out.println("NullPointerException on line 21\n");
			ex.printStackTrace();
	
		} catch(Exception ex) {
	
			System.out.println("Exception on line 38\n");
			ex.printStackTrace();
	
		}
	
	}

}