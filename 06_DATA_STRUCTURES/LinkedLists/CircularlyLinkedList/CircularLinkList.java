// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/06_DATA_STRUCTURES/LinkedLists/CircularlyLinkedList
// Exercise 7.6 (Introduction to data structures & pointers)
/*
A circular list is a dynamic list in which there is a beginning but there is no end: the last element is pointing back
to the first element. Circular lists can be singly- or doubly-linked. In this exercise, you must create a singly-linked
circular list using the “hospital and patients” example as a starting point.
1. Create the circular list and add several elements to it (around 10 is fine).
2. Traverse it forwards for one complete loop. While you go around the list, print out the content of each element.
How do you know that you have reached the end of the list when you never find a null pointer?
3. Delete a couple of elements from the list.
4. Traverse it again printing out the content of each element.
5. Add a new element to the list. Try to delete an element that is NOT in the list.
6. Traverse it again printing out the content of each element.
*/

public class CircularLinkList {

	private Node root = null;	

	public static void main(String args[]) {
	
		CircularLinkList cll = new CircularLinkList();
		Node firstNode = new Node("the first", 4);
		Node secondNode = new Node("the next", 6);
		Node thirdNode = new Node("the last", 8);
		cll.addNode(firstNode);
		cll.addNode(secondNode);
		cll.addNode(thirdNode);
		cll.showMeUp();
		cll.deleteNode(secondNode);
		cll.deleteNode(firstNode);
		cll.showMeUp();
	
	}
	
	public void addNode(Node n) {
	
		if (root == null) {
		
			root = n;
			n.next = root;
		
		} else {
			
			root.addNode(n, root);
		
		}
	
	}
	
	public void deleteNode(Node n) {
	
		if (root == null) {
		
			return;
		
		} else {
			
			root = root.deleteNode(n, root);
		
		}
	
	}
	
	public void showMeUp() {
	
		if (root != null) {
		
			root.showMeUp(root);
		
		}
	
	}

}

class Node {

	private String s;
	private int num;
	public Node next;
	
	public Node(String str,int nums) {
	
		s = str;
		num = nums;
		next = null;
	
	}
	
	public int getNums() {
	
		return num;
	
	}
	
	public void addNode(Node p, Node head) {
	
		if (next == head) {
		
			next = p;
			p.next = head;//or next.next=head;

		} else {

			next.addNode(p, head);

		}
	
	}
	
	public Node deleteNode(Node node, Node head) {
	
		if (num == node.num) {
		
			next.next = next;
			return next;
		
		}
		
		if (next == head) {
		
			return head;
		
		} else {
			
			return next.deleteNode(node, head);
		
		}
	
	}
	
	public void showMeUp(Node head) {
	
		System.out.println(num + ", " + s);
		
		if (next != head) {
		
			next.showMeUp(head);
		
		}

	}

}