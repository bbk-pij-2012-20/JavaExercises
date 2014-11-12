//cd ~/Desktop/JavaCoding/JavaExercises
/* Day 11 Ex 1 - 'Don't Repeat Yourself'. Task is to improve the code 
given, by casting between types. 
This is my 2nd attempt at this (without first looking at my first attempt)
It turns out I produced quite different solutions ! */

public class DRY_2 { //The 1st attempt has different name: "ComparatorLess.java"
	public static void main(String[] args) {
/*2 of the getMax() methods were commented out. Now all getMax() calls
must be passed 2 strings and it will only return a string.
Casting and parsing accomodate the passing and return of doubles and integers.

While code repetition is reduced, the amount of code is increased ..!! */

		double n1 = 3.5;
		double n2 = 4.0;
		String n1str = String.valueOf(n1);
		String n2str = String.valueOf(n2);
		int n1int = (int) (n1*100); //NOTE, without the brackets around (n1*100)
		int n2int = (int) (n2*100); //java casts the variable before it is x100 !
		
		double resultDouble = Double.parseDouble(getMax(""+n1,""+n2));
		String resultString = getMax(""+n1str,""+n2str);
		int resultInt = (Integer.parseInt(getMax(""+n1int,""+n2int)))/100;	

		System.out.println("(doubles) max of: "+n1+" and "+n2+" = "+resultDouble);
		System.out.println("(Strings) max of: "+n1str+" and "+n2str+" = "+resultString);
		System.out.println("(integers) max of: "+n1int+" and "+n2int+" = "+resultInt);

	}
	public static String getMax(String number1, String number2) {
		double n1 = Double.parseDouble(number1);
		double n2 = Double.parseDouble(number2);
		if (n1 > n2) {
			return String.valueOf(number1);
		} else {
    		return String.valueOf(number2);
		}	
	}
/*
	public int getMax(int n, int m) {
		if (n > m) {
			return n;
		} else {
			return m;
		}
	}

	public double getMax(double d1, double d2) { 	
		
		if (d1 > d2) {
			return d1;
		} else {
			return d2;
		}
	}
*/
}