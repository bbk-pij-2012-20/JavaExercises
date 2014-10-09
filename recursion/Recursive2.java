/* This gives 'Exception in thread "main" java.lang.StackOverflowError' at runtime.

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
		//SOFError solved by placing the bottom limit before 		
		//the recursive call instead of after it.
        String result = doggyMethod(n - 3) + n + doggyMethod(n - 2); 
        return result;
    
    }
    
}