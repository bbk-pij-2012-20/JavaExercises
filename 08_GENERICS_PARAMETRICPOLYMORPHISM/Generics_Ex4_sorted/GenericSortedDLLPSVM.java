// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/08_GENERICS_PARAMETRICPOLYMORPHISM/Generics_Ex3_DLL
// Exercise 11.3: Intro to parametric polymorphism (aka Generics).
/*
Modify the doubly-linked list that you have created in past weeks to make it generic,
i.e. to allow it to have values of its elements of any type.
*/
import Generics_Ex3_DLL.GenericDoublyLinkedList;
import Generics_Ex3_DLL.GenericNode;

public class GenericSortedDLLPSVM {

	public static void main(String[] args) {

		GenericDoublyLinkedList<String> stringList = new GenericSortedDoublyLinkedList<>();
		GenericNode<String> stringRootNode = new GenericSortedNode<>(0,"root");
		GenericNode<String> stringNode2 = new GenericSortedNode<>(1,"nodeStr5");
		GenericNode<String> stringNode3 = new GenericSortedNode<>(2,"nodeStr2");
		stringList.addNode(stringRootNode);
		stringList.addNode(stringNode2);
		stringList.addNode(stringNode3);
		stringList.deleteNode(stringNode2);
		stringList.displayNodes();

		GenericDoublyLinkedList<Integer> numberList = new GenericSortedDoublyLinkedList<>();
		GenericNode<Integer> integerRootNode = new GenericSortedNode<>(0,0);
		GenericNode<Integer> integerNode2 = new GenericSortedNode<>(1,5);
		GenericNode<Integer> integerNode3 = new GenericSortedNode<>(2,2);

		numberList.addNode(integerRootNode);
		numberList.addNode(integerNode2);
		numberList.addNode(integerNode3);
		numberList.deleteNode(integerNode2);

		numberList.displayNodes();

	}

}
