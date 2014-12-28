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

/*
I've made a similar singly linked circular list, as first attempt (CircularLinkList.java)
but this time I've used an inner Node class. So there's no need to pass the root node as 
an argument to the Node class, the inner class can already see the enclosing class's 
private members.
*/

public class CircLList {

	private Node root = null;
	
	public static void main(String[] args) {
	
		CircLList c = new CircLList();
		CircLList.Node node0 = c.new Node("cNode0",0);
		CircLList.Node node1 = c.new Node("cNode1",1);
		CircLList.Node node2 = c.new Node("cNode2",2);
		CircLList.Node node3 = c.new Node("cNode3",3);
		CircLList.Node node4 = c.new Node("cNode4",4);
		CircLList.Node node5 = c.new Node("cNode5",5);
		CircLList.Node node6 = c.new Node("cNode6",6);
		
		c.add(node0);
		System.out.print("\nList after adding one node only:\n");	
		c.print();
		System.out.printf("The deletion of \'%s\' has %sbeen achieved.", node0.info, c.delete(node0)? "" : "not ");	
		System.out.print("\n..after deleting that one node, the remaining list contains:\n");
		c.print();

		c.add(node1);
		c.add(node2);
		System.out.print("\nList after adding two nodes to empty list:\n");
		c.print();
		System.out.printf("The deletion of \'%s\' has %sbeen achieved.", node2.info, c.delete(node2)? "" : "not ");
		System.out.print("\n..after deleting cNode2, the remaining list contains:\n");
		c.print();
		
		c.add(node3);
		c.add(node4);
		c.add(node5);	
		c.add(node6);
		System.out.print("\nList after adding nodes 3-6: ");		
		c.print();
		
		c.delete(node2);
		System.out.print("\n..trying to delete the already deleted node2..\n");
		System.out.printf("The deletion of \'%s\' has %sbeen achieved.", node2.info, c.delete(node2)? "" : "not ");
		System.out.print("\n..after deleting cNode2, the remaining list contains:\n");
		c.print();
		System.out.println();
					
	}

	public void add(Node node) {
	
		if (root == null) {
		
			root = node;
			node.next = root;
		
		} else {
		
			root.add(node);
			
		}
	
	}
	
	public boolean delete(Node node) {
	
		if (root == null) {
		
			return false;
		
		} else {
		
			if (root.info == node.info) {
			
				if (root.next == root) {
			
					root = null;
				
				} else {
				
					root.next = root.next.next;
				
				}	
					
				return true;
					
			} else {
			
				if (root.next != root) {
				
					return root.delete(node);
			
				} else {
				
					return false;
				
				}
				
			}
		
		}
			
	}
	
	
	public void print() {
	
		if (root == null) {
		
			System.out.println("empty");
		
		} else {
			
			root.print();
	
		}
		
	}
	
	//inner class
	private class Node  {

		private Node next = null;
		private String info = "";
		private int n = 0;
		
		private Node(String info, int n) {
		
			this.info = info;
			this.n = n;
		
		}

		public void add(Node node) {
		
			if (next == root) {
			
				next = node;
				node.next = root;
				
			} else {

				next.add(node);

			}

		}
		
		public boolean delete(Node node) {
		
			if (next.info == node.info) {
				
				next = next.next;
				return true;

			} else {
			
				if (next == root) {
				
					return false;
				
				} else {
				
					return next.delete(node);
				
				}
			
			}
		
		}
		
		public void print() {
		
			System.out.println("\'" + info + " : " + n + "\'");
		
			if (next != root) {
			
				next.print();
			
			}
			
		}

	}

}

