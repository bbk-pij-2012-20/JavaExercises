// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/08_GENERICS_PARAMETRICPOLYMORPHISM/Generics_Ex4_Sorted
// Exercise 11.4: Intro to parametric polymorphism (aka Generics).
/*
Modify the doubly-linked list that you have created in past weeks to make it generic,
i.e. to allow it to have values of its elements of any type.
*/

//This is the Doubly-linked list (from Ex 7.5), AFTER editting to generic format.

public class GenericSortedDoublyLinkedList<T extends Comparable<T>> extends GenericDoublyLinkedList<T> {

	@Override
	public void addNode(GenericNode<T> newOne) {

		if (root == null) {

				root = newOne;

		} else {

			if (root.name.compareTo(newOne.name) > 0) {

				root.setPrevious(newOne);
				newOne.setNext(root);
				root = newOne;

			} else {

				root.addNode(newOne);

			}

		}

	}

}

class GenericSortedNode<T extends Comparable<T>> extends GenericNode<T> {

	public GenericSortedNode(int number, T name){

		super(number, name);

	}

	@Override
	public void addNode(GenericNode<T> newNode) {

		if (nextNode == null) {

			nextNode = newNode;
			newNode.previousNode = this;

		} else {

			if (nextNode.name.compareTo(newNode.name) > 0) {

				nextNode.setPrevious(newNode);
				newNode.setNext(nextNode);
				newNode.setPrevious(this);
				nextNode = newNode;

			} else {

				nextNode.addNode(newNode);

			}

		}

	}

}
