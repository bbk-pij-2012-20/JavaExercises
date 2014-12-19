//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/DataStructures/LinkedLists
//Exercise 7.6 (Introduction to data structures & pointers)

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