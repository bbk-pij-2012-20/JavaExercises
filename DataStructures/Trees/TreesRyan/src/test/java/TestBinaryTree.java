import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TestBinaryTree {
	
	private BinaryTree bt;
	
	@Before
	public void setUp() {
		bt = new BinaryTree();
	}
	
	/*
	*   null ->  [8]
	*           /   \
	*         null  null
	*/
	@Test
	public void testShouldAddNodeToTree() {
		bt.add(8);		
		assertEquals("8 L[] R[]",bt.toString());
	}

	/*
	*    [8]           [8]
	*   /   \    ->   /   \
	* null null     [5]  null
	*/
	@Test
	public void testShouldAddNodeToLeftChild() {
		bt.add(8);
		bt.add(5);
		assertEquals("8 L[5 L[] R[]] R[]",bt.toString());
	}
	
	/*
	*    [8]           [8]
	*   /   \    ->   /   \
	* null null    null   [10]
	*/
	@Test
	public void testShouldAddNodeRightToChild() {
		bt.add(8);
		bt.add(10);
		assertEquals("8 L[] R[10 L[] R[]]",bt.toString());
	}
	
	@Test
	public void shouldKnowIfTreeContainsANumber() {
	    int expected = 8;
	    assertThat(false, is(equalTo(bt.contains(expected))));
		bt.add(expected);
		assertThat(true, is(equalTo(bt.contains(expected))));
	}
	
}