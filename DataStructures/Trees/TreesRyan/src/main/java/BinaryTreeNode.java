public class BinaryTreeNode {
	
	private int n;
	private BinaryTreeNode left;
	private BinaryTreeNode right;

	public int getValue() {
		return n;
	}
	
	public void setValue(int n) {
		this.n = n;
	}
	
	public BinaryTreeNode(int n) {
		setValue(n);
	}
	
	@Override
	public String toString() {
		String treeString = "" + getValue();
		if(left == null) {
			treeString += " L[]";
		} else {
			treeString += " L["+left.toString()+"]";
		}
		if(right == null) {
			treeString += " R[]";
		} else {
			treeString += " R["+right.toString()+"]";
		}
		return treeString;
	}
	
	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}
	
	public BinaryTreeNode getLeft() {
		return left;
	}
	
	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}
	
	public BinaryTreeNode getRight() {
		return right;
	}
}