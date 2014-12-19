//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/DataStructures/LinkedLists/DoublyLinkedList
// Exercise 11.5 (Introduction to Data Structures. Linked Lists)
/*
A doubly-linked list is a dynamic list in which each element is connected to two other 
elements instead of just one - the one before and the one after it. 

In this exercise, you must create a doubly-linked list using the “hospital and patients” 
example as a starting point.

1. Create the doubly-linked list and add several elements to it (around 10 is fine).
2. Traverse it forwards and backwards printing out the content of each element.
3. Delete a couple of elements from the list.
4. Traverse it forwards and backwards printing out the content of each element.
5. Add a new element to the list. Try to delete an element that is NOT in the list.
6. Traverse it forwards and backwards printing out the content of each element.

Hint: First you need to add a new field to Patient for the pointer going “backwards”. 
Then you need to modify the add and delete methods to make sure you do not have loose 
pointers.
*/
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

	public String getName() {
	
		return name;
	
	}
	
	public Node(int number,String name) {
	
		this.number = number;
		this.name = name;
		previousNode = null;//Note that this is not necessary.
		nextNode = null;// And neither is this. 
	
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