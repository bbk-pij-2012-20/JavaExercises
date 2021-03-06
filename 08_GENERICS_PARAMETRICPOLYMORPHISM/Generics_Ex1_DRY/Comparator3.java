// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/08_GENERICS_PARAMETRICPOLYMORPHISM
// Exercise 11.1: Introduction to type-casting and parametric polymorphism (aka Generics).

/*
Look at the following code. Is there anything you can do to make this code better?
Hint: you may need to convert between types (e.g. casting).

Here is a 3nd solution, which is essentially the same as Comparator2 but shows that
you can position the generic syntax (T extends Comparable<T>>) with a generic method
rather than having to place it at the class name, as shown for Comparator2.
*/

public class Comparator3 {

	public <T extends Comparable<T>> T getMax(T number1, T number2) {

		if (number1.getClass().equals(String.class)) {

			String num1 = (String) number1;
			String num2 = (String) number2;

			if (Double.parseDouble(num1) > Double.parseDouble(num2)) {

				return number1;

			} else {

				return number2;

			}

		} else {

			if (number1.compareTo(number2) > 0) {

				return number1;

			} else {

				return number2;

			}

//		}

	}

	public static void main(String[] args) {

		Comparator3 comp3 = new Comparator3();
		String n1Str = "323";//lexicographical ordering doesn't correspond to numerical ordering
		String n2Str = "34";

		Double n1Dou = 3.5;
		Double n2Dou = 4.0;

		Integer n1Int = 123;
		Integer n2Int = 321;

		System.out.println("(doubles) max of: " + n1Dou + " and " + n2Dou + " = " + comp3.getMax(n1Dou, n2Dou));
		System.out.println("(Strings) max of: " + n1Str + " and " + n2Str + " = " + comp3.getMax(n1Str, n2Str));
		System.out.println("(integers) max of: " + n1Int + " and " + n2Int + " = " + comp3.getMax(n1Int, n2Int));

	}

}
