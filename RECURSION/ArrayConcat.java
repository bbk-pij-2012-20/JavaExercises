// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/recursion
// (Recursion)
/* method that takes array of strings and concatenates them recursively */

public class ArrayConcat {

	public static void main(String[] args) {

		ArrayConcat ac = new ArrayConcat();
		String[] arrStr = {"ab","Cd", "ef", "gh"};
		//System.out.println("result is: " + ac.concatenate(arrStr, 0));
		System.out.println("result is: " + ac.concatenate(arrStr));
	
	}

/*
	public String concatenate(String[] testArr, int index) {

		if (testArr.length - 1 == index) {

			return testArr[index];

		} else {

			return testArr[index] + concatenate(testArr, index + 1);

		}

	}

}
*/

	public String concatenate(String[] aryStrs) {

		if (aryStrs.length == 1) {
		
			return aryStrs[0];
		
		} else {
		
			String[] newAryStrs = new String[aryStrs.length - 1];
			
			for (int i = 0; i < newAryStrs.length; i++) {
			
				newAryStrs[i] = aryStrs[i];
			
			}
		
			return concatenate(newAryStrs) + aryStrs[aryStrs.length - 1];
		
		}
		
	}

}