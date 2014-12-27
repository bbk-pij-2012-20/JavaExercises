// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/06_DATA_STRUCTURES/LinkedLists/DoublyLinkedList

public class DLList {

	private Node root = null;
	
	public static void main(String[] args) {
	
		DLList dl = new DLList();
		dl.add(new Node("root", 0));
		dl.add(new Node("node1", 111));
		dl.add(new Node("node2", 222));
		dl.add(new Node("node3", 333));
		dl.add(new Node("node4", 444));
		dl.add(new Node("node5", 555));
		dl.printForward();
		dl.printBackward();	
							
	}
	
	public void add(Node node) {
	
		if (root == null) {
		
			root = node;
			root.setPrevious(root); 
		
		} else {
		
			root.add(node);
		
		}
	
	}
	
	public boolean delete(Node node) {

		if (root == null) {
		
			return false;
		
		} else {
		
			if (root.getInfo() == node.getInfo()) {
			
				root = root.getNext();
				root.getNext().setPrevious(root);
				return true;
			
			} else {
			
				return root.delete(node);
			
			}
		
		}
	
	}
	
	public void printForward() {
	
		if (root == null) {
		
			System.out.println("nothing to print, as list is empty");
		
		} else {
		
			System.out.println("\nGoing forwards: ");		
			root.printForward();
		
		}
	
	}

	public void printBackward() {
	
		if (root == null) {
		
			System.out.println("nothing to print, list is empty");
		
		} else {
		
			System.out.println("\nGoing backwards: ");
			root.traverseToEnd();
		
		}

	}

}

class Node {

	private Node previous = null;
	private Node next = null;
	private int n = 0;
	private String info = "";
	
	public Node(String info, int n) {
	
		this.n = n;
		this.info = info;
	
	}
	
	public String getInfo() {
	
		return info;
	
	}
	
	public Node getNext() {
	
		return next;
	
	}
	
	public void setPrevious(Node node) {
	
		previous = node;
	
	}
	public void add(Node node) {
	
		if (next == null) {
		
			next = node;
			node.previous = this;
		
		} else {
		
			next.add(node);
		
		}
	
	}
	
	public boolean delete(Node node) {
	
		if (next == null) {
		
			return false;
		
		} else {
		
			if (next.info == node.info) {
			
				next = next.next;
				next.previous = this;
				return true;
			
			} else {
			
				return next.delete(node);
			
			}
		
		}
	
	}
	
	public void printForward() {
	
		System.out.println(info + " : " + n);
		
		if (next != null) {
		
			next.printForward();
		
		}
	
	}

	public void traverseToEnd() {
	
		if (next == null) {

			printBackward();

		} else {

			next.traverseToEnd();
		
		}
		
	}
	
	public void printBackward() {

		System.out.println(info + " : " + n);

		if (info.equals("root")) {

			return;

		} else {

			previous.printBackward();			

		}

	}

}