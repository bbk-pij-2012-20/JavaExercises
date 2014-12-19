// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/recursion
// Exercise 5.1c (Recursion, recursion vs iteration).

/* 
Question: Do you see anything wrong with the following code? How would you fix it?
Result: This gives 'Exception in thread "main" java.lang.StackOverflowError' at runtime.

public class Recursive2 {

	public static void main(String[] args) {
	
		Recursive2 rec2 = new Recursive2();
		rec2.doggyMethod(4);
	
	}
	
	public String doggyMethod(int n) {
	
		String result = doggyMethod(n - 3) + n + doggyMethod(n - 2); 
	
		if (n <= 0) {
		
			return ""; 
		
		}
        
        return result;
    }
}
*/
public class Recursive2 {

	public static void main(String[] args) {
	
		Recursive2 rec2 = new Recursive2();
		String stringToPrint = rec2.doggyMethod(4);
		System.out.println(stringToPrint);
	
	}
	
	public String doggyMethod(int n){
	
		if (n <= 0) {

			return ""; 

		}
		// StackOverFlowError resolved by placing the bottom limit 
		// prior to the recursive call instead of following it.
        String result = doggyMethod(n - 3) + n + doggyMethod(n - 2); 
        return result;
    
    }
    
}