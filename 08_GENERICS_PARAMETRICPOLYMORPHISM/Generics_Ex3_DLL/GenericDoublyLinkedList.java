// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/08_GENERICS_PARAMETRICPOLYMORPHISM/Generics_Ex3_DLL
// Exercise 11.3: Intro to parametric polymorphism (aka Generics).
/*
Modify the doubly-linked list that you have created in past weeks to make it generic,
i.e. to allow it to have values of its elements of any type.
*/

//This is the Doubly-linked list (from Ex 7.5), AFTER editting to generic format.
public class GenericDoublyLinkedList<T> {

	private GenericNode<T> root;

	public void addNode(GenericNode<T> newOne) {

		if (root == null) {

			root = newOne;

		} else {

			root.addNode(newOne);

		}

	}

	public boolean deleteNode(GenericNode<T> node) {

		if (root == null) {

			return false;

		} else {

			if (root.getName().equals(node.getName())) {

				root = root.getNext();
				root.setPrevious(null);
				return true;

			} else {

				return root.deleteNode(node);

			}

		}

	}

	public void displayNodes() {

		if (root != null) {

			root.displayF();

		}

	}

}

class GenericNode<T> {

	private int number;
	private T name;
	private GenericNode<T> previousNode;
	private GenericNode<T> nextNode;

	public GenericNode(int number, T name){

		this.number  = number;
		this.name = name;
		previousNode = null;
		nextNode = null;

	}

	public void addNode(GenericNode<T> newNode) {

		if (nextNode == null) {

			nextNode = newNode;
			newNode.previousNode = this;

		} else {

			nextNode.addNode(newNode);

		}

	}

	public boolean deleteNode(GenericNode<T> node) {

		if (nextNode == null) {

			return false;

		} else {

			if (nextNode.name.equals(node.name)) {

				nextNode = nextNode.nextNode;

				if (nextNode != null) {

					nextNode.previousNode = this;

				}

				return true;

			} else {

				return nextNode.deleteNode(node);

			}

		}

	}

	public void displayF() {

		System.out.println("forwards: " + number + ", " + name);

		if (nextNode != null) {

			nextNode.displayF();

		} else {

			displayB();

		}

	}


	public void displayB() {

		System.out.println("backwards: " + number + ", " + name);

		if (previousNode != null) {

			previousNode.displayB();

		}

	}


	public T getName() {

		return name;

	}


	public GenericNode<T> getNext() {

		return nextNode;

	}


	public GenericNode<T> getPrevious() {

		return previousNode;

	}


	public void setNext(GenericNode<T> node) {

		nextNode = node;

	}


	public void setPrevious(GenericNode<T> node) {

		previousNode = node;

	}

}
