// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/06_DATA_STRUCTURES/LinkedLists/UsingNestedClass
// (related to Exercise 7.3)

/*
Static nested class is instantiated Node is instantiated as a static member of the 
enclosing class. 
(Notice the delete method in the enclosing class has access to the private member 'info' 
of the static nested class.)
*/

public class ListStaticNested {

	private static Node root = null;
	
	public static void main(String args[]) {

		ListStaticNested.Node node0 = new ListStaticNested.Node("root", 000);
		ListStaticNested.Node node1 = new ListStaticNested.Node("node1", 100);
		ListStaticNested.Node node2 = new ListStaticNested.Node("node2", 200);
		ListStaticNested.Node node3 = new ListStaticNested.Node("node3", 300);
		ListStaticNested.Node node4 = new ListStaticNested.Node("node4", 400);
		ListStaticNested.Node node5 = new ListStaticNested.Node("node5", 500);
		
		ListStaticNested nodeManager = new ListStaticNested();
		nodeManager.add(node0);		
		nodeManager.add(node1);
		nodeManager.add(node2);
		nodeManager.add(node3);
		nodeManager.add(node4);
		nodeManager.add(node5);	
		nodeManager.print();
		boolean deleted = nodeManager.delete(node3);
		System.out.printf("\nnode3 was %ssuccessfully deleted\n", deleted? "" : "not ");
		nodeManager.print();
										
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
	
		System.out.println();
		
		if (root == null) {
		
			System.out.println("nothing to print, list is empty");
		
		} else {
		
			root.print();
		
		}
	
	}
	
	private static class Node {
		
		private int n = 0;
		private String info = "";
		private Node next = null;
		
		private Node(String info, int n) {
		
			this.n = n;
			this.info = info;
		
		}
		
		private void add(Node node) {
		
			if (next != null) {
			
				next.add(node);
			
			} else {
			
				next = node;
			
			}
		
		}
		
		private boolean delete(Node node) {
		
			if (next == null) {
			
				return false;
			
			} else {
			
				if (next.info == node.info) {
				
					next = next.next;
					return true;
					
				} else {
				
					return next.delete(node);
				
				}
			
			}
		
		}
		
		private void print() {
		
			System.out.println(info + " : " + n);
			
			if (next != null) {
			
				next.print();
			
			}
		
		}
		
	}

}