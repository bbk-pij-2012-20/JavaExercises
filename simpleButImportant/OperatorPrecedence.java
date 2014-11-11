//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/simpleButImportant
// about operator precedence, int variables only store int values, and dividing by zero is caught.

/* 
	/, *, and % are equal
	+ and - are equal
	/, *, % take precedence over + and -
	if operator are at the same level, then precedence is given by position, with precedence given to left over right
*/ 

public class OperatorPrecedence {

	public static void main(String[] args) {
	
		int num = 5;
		System.out.println(num);		// 5
		num = num + 2;
		System.out.println(num);		// 7
		System.out.println(num / 3);	// 2
		System.out.println(7 / 3);		// 2  Reason is: Java assumes the type to be int as there is no decimal
		System.out.println(7.0 / 3);	// 2.3333333333333335
		System.out.println(7 / 3.0);	// 2.3333333333333335
		num = num / 3 * 6;
		System.out.println(num);		// 12 Reason is: 7/3 = 2.33 but int data type makes it 2, so then 2 X 6 = 12, not 14 (i.e. not 2.3 X 6)
		System.out.println(7 + 15 % 4); // 10
		num = 24 / 3 / 4;
		System.out.println(num);		// 2
		num = 24 / (num / 4);
		System.out.println(num);		// Exception in thread "main" java.lang.ArithmeticException: / by zero
	
	}

}