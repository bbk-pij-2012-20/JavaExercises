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

//singly linked circular list with inner Node class 
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
		System.out.print("\nList after adding one node only: ");	
		c.print();
		c.delete(node0);	
		System.out.print("\n..then deleting that one node: ");
		c.print();

		c.add(node1);
		c.add(node2);
		System.out.print("\nList after adding two nodes to empty list: ");
		c.delete(node2);
		System.out.print("\n..then deleting node2: ");
		c.print();
		
		c.add(node3);
		c.add(node4);
		c.add(node5);	
		c.add(node6);
		System.out.print("\nList after adding nodes 3-6: ");		
		c.print();
		System.out.println();
					
	}

	public void add(Node node) {
	
		if (root == null) {
		
			root = node;
			node.next = root;
		
		} else {
		
			root.add(root, node);
			
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
				
					return root.delete(root, node);
			
				} else {
				
					return false;
				
				}
				
			}
		
		}
			
	}
	
	
	public void print() {
	
		if (root == null) {
		
			System.out.println("List is empty");
		
		} else {
			
			root.print(root);
	
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

		public void add(Node root, Node node) {
		
			if (next == root) {
			
				next = node;
				node.next = root;
				
			} else {

				next.add(root, node);

			}

		}
		
		public boolean delete(Node root, Node node) {
		
			if (next.info == node.info) {
				
				next = next.next;
				return true;

			} else {
			
				if (next == root) {
				
					return false;
				
				} else {
				
					return delete(root, node);
				
				}
			
			}
		
		}
		
		public void print(Node root) {
		
			System.out.println("\'" + info + " : " + n + "\'");
		
			if (next != root) {
			
				next.print(root);
			
			}
			
		}

	}

}

