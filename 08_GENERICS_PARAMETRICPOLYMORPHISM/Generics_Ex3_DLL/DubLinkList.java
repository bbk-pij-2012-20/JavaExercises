// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/08_GENERICS_PARAMETRICPOLYMORPHISM/Generics_Ex3
// Exercise 11.3: Intro to parametric polymorphism (aka Generics).
/*
Modify the doubly-linked list that you have created in past weeks to make it generic,
i.e. to allow it to have values of its elements of any type.
*/

//This is the Doubly-linked list (from Ex 7.5), to show BEFORE editting to generic format.
public class DubLinkList {

	private Node root = null;

	public static void main(String args[]) {

		DubLinkList dll = new DubLinkList();
		dll.addNode(new Node(20, "Node20"));
		dll.addNode(new Node(40, "Node40"));
		dll.addNode(new Node(50, "Node 50"));
		dll.displayNodes();
		dll.deleteNode(new Node(40, "Node40"));
		dll.displayNodes();

	}

	public void addNode(Node newOne) {

		if (root == null) {

			root = newOne;

		} else {

			root.addNode(newOne);

		}

	}

	public boolean deleteNode(Node node) {

		if (root == null) {

			return false;

		} else {

			if (root.getName().equals(node.getName())) {

				root = root.nextNode;
				root.previousNode = null;
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

class Node {

	private int number;
	private String name;
	public Node previousNode;
	public Node nextNode;

	public Node(int number, String name) {

		this.number = number;
		this.name = name;
		previousNode = null;//Note that this is not necessary.
		nextNode = null;// And neither is this.

	}

	public String getName() {

		return name;

	}

	public void addNode(Node newNode) {

		if (nextNode == null) {

			nextNode = newNode;
			newNode.previousNode = this;

		} else {

			nextNode.addNode(newNode);

		}

	}

	public boolean deleteNode(Node node) {

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

		System.out.println("forwards:" +name);

		if (nextNode != null) {

			nextNode.displayF();

		} else {

			displayB();

		}

	}

	public void displayB() {

		System.out.println("backwards:" +name);

		if (previousNode != null) {

			previousNode.displayB();

		}

	}

}
