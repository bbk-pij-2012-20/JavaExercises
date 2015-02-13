// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/05_DATA_STRUCTURES/LINKED_LISTS/UsingNestedClass
// (related to Exercise 7.3)
/*
I'm trying the linked list with an inner Node class. This is more logical in circumstances
where the node is not likely to be used by any class other than the enclosing class, here
called ListWithInnerClass.

Objects that are instances of the inner class, Node, exist within an object instance of the
enclosing (outer) class. So to make a Node object, an object of ListWithInnerClass must 1st
be instantiated.
Notice the slightly unusual syntax is the attachment of the object to the 'new' word.
*/

public class ListWithInnerClass {

	private ListWithInnerClass.Node root = null;

	public static void main(String args[]) {

		ListWithInnerClass lwic = new ListWithInnerClass();
		ListWithInnerClass.Node node0 = lwic.new Node("root", 000);
		ListWithInnerClass.Node node1 = lwic.new Node("node1", 100);
		ListWithInnerClass.Node node2 = lwic.new Node("node2", 200);
		ListWithInnerClass.Node node3 = lwic.new Node("node3", 300);
		ListWithInnerClass.Node node4 = lwic.new Node("node4", 400);
		ListWithInnerClass.Node node5 = lwic.new Node("node5", 500);
		lwic.add(node0);
		lwic.add(node1);
		lwic.add(node2);
		lwic.add(node3);
		lwic.add(node4);
		lwic.add(node5);
		lwic.print();
		lwic.delete(node3);
		System.out.println("\nafter deleting node3:");
		lwic.print();

	}

	public void add(Node node) {

		if (root == null) {

			root = node;

		} else {

			root.add(node);

		}

	}

	public boolean delete(Node node) {

		if (root == null) {

			System.out.println("Can't delete any nodes from an empty list");
			return false;

		} else {

			if (root.info == node.info) {

				root = root.next;
				return true;

			} else {

				return root.delete(node);

			}

		}

	}

	public void print() {

		if (root == null) {

			System.out.println("Nothing to print, list is empty");

		} else {

			root.print();

		}

	}

	// INNER CLASS
	private class Node {

		private String info = "";
		private int n = 0;
		private Node next = null;

		private Node(String info, int n) {

			this.info = info;
			this.n = n;

		}

		private void add(Node node) {

			if (next == null) {

				next = node;

			} else {

				next.add(node);

			}

		}

		private boolean delete(Node node) {

			if (next.info == node.info) {

				next = next.next;
				return true;

			} else {

				if (next != null) {

					return next.delete(node);

				} else {

					return false;

				}

			}

		}

		private void print() {

			System.out.println("printout: " + info + " : " + n + ",");

			if (next != null) {

				next.print();

			}

		}

	}

}
