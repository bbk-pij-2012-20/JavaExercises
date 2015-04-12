// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/08_GENERICS_PARAMETRICPOLYMORPHISM/Generics_Ex4_DLL
// Exercise 11.4: Intro to parametric polymorphism (aka Generics).
/*
Modify the doubly-linked list that you have created in past weeks to make it generic,
i.e. to allow it to have values of its elements of any type.
*/

public class GenericSortedDLLPSVM {

	public static void main(String[] args) {

		System.out.println("\ntype passed is String:-----");
		GenericDoublyLinkedList<String> stringList = new GenericSortedDoublyLinkedList<>();
		GenericNode<String> stringRootNode = new GenericSortedNode<>(0,"aarooty");
		GenericNode<String> stringNode2 = new GenericSortedNode<>(1,"ghi");
		GenericNode<String> stringNode3 = new GenericSortedNode<>(2,"def");
		GenericNode<String> stringNode4 = new GenericSortedNode<>(3,"abc");
		stringList.addNode(stringRootNode);
		stringList.addNode(stringNode2);
		stringList.addNode(stringNode3);
		stringList.addNode(stringNode4);
		stringList.deleteNode(stringNode2);
		stringList.displayNodes();

		System.out.println("\ntype passed is Integer:-----");
		GenericDoublyLinkedList<Integer> numberList = new GenericSortedDoublyLinkedList<>();
		GenericNode<Integer> integerRootNode = new GenericSortedNode<>(0,1);
		GenericNode<Integer> integerNode2 = new GenericSortedNode<>(1,5);
		GenericNode<Integer> integerNode3 = new GenericSortedNode<>(2,3);
		GenericNode<Integer> integerNode4 = new GenericSortedNode<>(3,2);
		numberList.addNode(integerRootNode);
		numberList.addNode(integerNode2);
		numberList.addNode(integerNode3);
		numberList.addNode(integerNode4);
		numberList.deleteNode(integerNode3);
		numberList.displayNodes();

	}

}
