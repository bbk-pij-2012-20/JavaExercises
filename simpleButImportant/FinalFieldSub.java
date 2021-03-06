// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises

public class FinalFieldSub extends FinalField {

	public static void main(String[] args) {
	
		FinalFieldSub ffs = new FinalFieldSub();
/*	notes:

	If FinalFieldSub did not extend FinalField, you would have to create
	an instance of FinalField in order to access finalNumber:		
		FinalField ff = new FinalField();

*/
		System.out.println("final number: " + ffs.finalNumber);
//		ffs.finalNumber *= 10;  // this would be allowed if finalNumber were not final.
		System.out.println("attempting to change final number: " + (10 * ffs.finalNumber));		
/* 

	It doesn't mean that 10 * ffs is not allowed though. This doesn't actually 
	change the value of int finalNumber. 
	It just means that the product can't then be assigned to finalNumber. 

*/

	}

}

class FinalField {

	protected final int finalNumber = 10;

/*	notes:

	If the int finalNumber were static, you would not need to create
	an instance of ffs to access finalNumber.

*/

}