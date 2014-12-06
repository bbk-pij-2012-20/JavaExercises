//	cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/DataStructures/LinkedLists
//	Implementing a linked list using a static nested class for the Node.

//	STILL HAS PLENTY COMPILATION ERRORS !! 


public class ListStaticNested {

	private ListStaticNested.Node root = null;
	
	public static void main(String args[]) {

		ListStaticNested lsn = new ListStaticNested();
		ListStaticNested.Node lsnN1 = new ListStaticNested.Node(123, "node");
		lsn.add(lsnN1);
		lsn.print();
		ListStaticNested.Node lsnN2 = new ListStaticNested.Node(234, "node2");
		lsn.add(lsnN1);
		lsn.print();
		lsn.delete(lsnN2);
		lsn.print();
	
	}
	
	public void add(Node node) {
		
		if (root == null) {
			
			root = node;
			
		} else {
			
			if (root.nextNode == null) {
				
				nextNode = node;
	
			} else {
			
				add(nextNode);
			
			}
		
		}
	
	}
		
	public boolean delete(Node node) {
	
		if (root == null) {
				
			return false;
			
		} else {
				
			if (nextNode.info.equals(node.info)) {
				
				nextNode = nextNode.nextNode;
				return true;
				
			} else {
					
				return nextNode.delete(node);
				
			}
			
		}
	
	}
	
	public void print() {
		
		if (root == null) {
			
			System.out.println("empty");
				
		} else {
			
			System.out.print(info);
				
			if (nextNode != null) {
				
				print();
					
			} else {
				
				System.out.println("\n");
				
			}	

		}
		
	}
	
	static class Node {
	
		int number;
		String info;
		Node nextNode;
	
		public Node(int number, String info) {
		
			this.number = number;
			this.info = info;
			nextNode = null;
		
		}
		
		public String getInfo() {
		
			return info;
		
		}

	}

}