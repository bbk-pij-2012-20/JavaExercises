public class BinaryTree {
	private BinaryTreeNode root = null;
	
	public void add(int n) {
		if(root == null) {
			root = new BinaryTreeNode(n);
		} else {
		    BinaryTreeNode node = new BinaryTreeNode(n);
			addNode(node,root);
		}		
	}
	
	public boolean contains(int n) {
		return containsNode(n,root);
	}
	
	private boolean containsNode(int n,BinaryTreeNode current) {
		if(current == null) {
			return false;
		}	
		if(n == current.getValue()) {
			return true;
		} else if(n < current.getValue()) {
			return containsNode(n,current.getLeft());
		} else {
			return containsNode(n,current.getRight());		
		}
	}
	
	private void addNode(BinaryTreeNode node,BinaryTreeNode parent) {
		if(node.getValue() < parent.getValue()) {
			if(parent.getLeft() == null) {
				parent.setLeft(node);
			} else {
				addNode(node,parent.getLeft());
			}
		} else {
			if(parent.getRight() == null) {
				parent.setRight(node);
			} else {
				addNode(node,parent.getRight());
			}
		}	
	}	
	
	@Override
	public String toString() {
		return root.toString();
	}
}