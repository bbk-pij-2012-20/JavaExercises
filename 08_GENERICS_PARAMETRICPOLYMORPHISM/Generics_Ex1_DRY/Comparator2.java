// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/08_GENERICS_PARAMETRICPOLYMORPHISM
// Exercise 11.1: Introduction to type-casting and parametric polymorphism (aka Generics).

/*
Look at the following code. Is there anything you can do to make this code better?
Hint: you may need to convert between types (e.g. casting).

Here is my 2nd solution showing type-casting at run-time (using generics).
*/

public class Comparator2<T extends Comparable<T>> {

	public T getMax(T number1, T number2) {

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

		}

	}

	public static void main(String[] args) {

		Comparator2<String> compStr = new Comparator2<>();
		String n1Str = "323";//lexicographical ordering doesn't correspond to numerical ordering
		String n2Str = "34";

		Comparator2<Double> compDou = new Comparator2<>();
		Double n1Dou = 3.5;
		Double n2Dou = 4.0;

		Comparator2<Integer> compInt = new Comparator2<>();
		Integer n1Int = 123;
		Integer n2Int = 321;

		System.out.println("(doubles) max of: " + n1Dou + " and " + n2Dou + " = " + compDou.getMax(n1Dou, n2Dou));
		System.out.println("(Strings) max of: " + n1Str + " and " + n2Str + " = " + compStr.getMax(n1Str, n2Str));
		System.out.println("(integers) max of: " + n1Int + " and " + n2Int + " = " + compInt.getMax(n1Int, n2Int));

	}

}
