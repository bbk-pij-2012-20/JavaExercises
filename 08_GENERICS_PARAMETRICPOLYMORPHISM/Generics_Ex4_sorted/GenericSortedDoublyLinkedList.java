// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/08_GENERICS_PARAMETRICPOLYMORPHISM/Generics_Ex4_Sorted
// Exercise 11.3: Intro to parametric polymorphism (aka Generics).
/*
Modify the doubly-linked list that you have created in past weeks to make it generic,
i.e. to allow it to have values of its elements of any type.
*/

//This is the Doubly-linked list (from Ex 7.5), AFTER editting to generic format.
import Generics_Ex3_DLL.GenericDoublyLinkedList;
import Generics_Ex3_DLL.GenericNode;

public class GenericSortedDoublyLinkedList<T> extends GenericDoublyLinkedList<T> {

	@Override
	public void addNode(GenericNode<T> newOne) {

		if (root == null) {

			root = newOne;

		} else {

			root.addNode(newOne);

		}

	}

	@Override
	public boolean deleteNode(GenericNode<T> node) {

		return super.deleteNode(node);

	}

	@Override
	public void displayNodes() {

		super.displayNodes();

	}

}

class GenericSortedNode<T extends Comparable<T>> extends GenericNode<T> {

	private int number;
	private T name;
	private GenericNode<T> previousNode;
	private GenericNode<T> nextNode;

	public GenericNode(int number, T name){}

	@Override
	public void addNode(GenericNode<T> newNode) {

		if (nextNode == null) {

			nextNode = newNode;
			newNode.previousNode = this;

		} else {

			nextNode.addNode(newNode);

		}

	}

	@Override
	public boolean deleteNode(GenericNode<T> node) {

		return super.deleteNode(node);

	}

	@Override
	public void displayF() {

		super.displayF();

	}

	@Override
	public void displayB() {

		super.displayB();

	}

	@Override
	public T getName() {

		return super.getName();

	}

	@Override
	public GenericNode<T> getNext() {

		return super.getNext();

	}

	@Override
	public GenericNode<T> getPrevious() {

		return super.getPrevious();

	}

	@Override
	public void setNext(GenericNode<T> node) {

		super.setNext(node);

	}

	@Override
	public void setPrevious(GenericNode<T> node) {

		super.setPrevious(node);

	}

}
