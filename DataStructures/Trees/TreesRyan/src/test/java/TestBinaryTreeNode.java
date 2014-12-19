// cd ~/Desktop/JavaCoding/day9Ryan/src/test/java

import org.junit.*;
import static org.junit.Assert.*;

public class TestBinaryTreeNode {

	private BinaryTreeNode btn;
	
	@Before
	public void setUp() {
		btn = new BinaryTreeNode(3);
	}
	
	@Test
	public void testShouldGiveValueToNode() {
		assertEquals("3 L[] R[]",btn.toString());
	}

	@Test
	public void testShouldGiveLeftPointer() {
		btn.setLeft(new BinaryTreeNode(2));
		assertEquals("2 L[] R[]",btn.getLeft().toString());
	}
	
	@Test
	public void testShouldGiveRightPointer() {
		btn.setRight(new BinaryTreeNode(5));
		assertEquals("5 L[] R[]",btn.getRight().toString());
	}
}