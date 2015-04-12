// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/08_GENERICS_PARAMETRICPOLYMORPHISM/Generics_Ex3
// Exercise 11.3: Intro to parametric polymorphism (aka Generics).
/*
Modify the doubly-linked list that you have created in past weeks to make it generic,
i.e. to allow it to have values of its elements of any type. Use the TDD methodology
(interface, test, production code, repeat. . . ). Once you have it ready, create a class
Company that keeps two linked lists, one with the names of the employees and one with
their National Insurance Number.
*/

public class GenericDLLPSVM {

	public static void main(String[] args) {

		GenericDoublyLinkedList<String> stringList = new GenericDoublyLinkedList<>();
		GenericNode<String> stringRootNode = new GenericNode<>(0,"root");
		GenericNode<String> stringNode2 = new GenericNode<>(1,"nodeStr2");
		GenericNode<String> stringNode3 = new GenericNode<>(2,"nodeStr3");
		stringList.addNode(stringRootNode);
		stringList.addNode(stringNode2);
		stringList.addNode(stringNode3);
		stringList.deleteNode(stringNode2);
		stringList.displayNodes();

		GenericDoublyLinkedList<Integer> numberList = new GenericDoublyLinkedList<>();
		GenericNode<Integer> integerRootNode = new GenericNode<>(0,0);
		GenericNode<Integer> integerNode2 = new GenericNode<>(1,2);
		GenericNode<Integer> integerNode3 = new GenericNode<>(2,3);

		numberList.addNode(integerRootNode);
		numberList.addNode(integerNode2);
		numberList.addNode(integerNode3);
		numberList.deleteNode(integerNode2);

		numberList.displayNodes();

	}

}
