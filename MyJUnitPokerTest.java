import org.junit.Assert;

//author is Sergio

public class MyJUnitPokerTest
{
	int[] ranks1, ranks2, ranks3, ranks4;
	int[] suits1, suits2, suits3, suits4;

	@Before
	public void createHands() 
	{
		ranks1 = {4,1,1,3,0,0,0,0,0,0,0,0,0};
		suits1 = {1,1,1,1};
		ranks2 = {1,1,1,3,0,0,0,0,0,0,0,0,0};
		suits2 = {1,1,1,1};
		ranks3 = {3,1,1,3,0,0,0,0,0,0,0,0,0};
		suits3 = {1,1,1,1};
		ranks4 = {1,1,1,0,0,0,0,0,0,0,0,0,0};
		suits4 = {1,1,1,1};
	}

	@After
	public void whateverHappensAfterEachTest() 
	{
	
	}

	@Test
	public void testsThreeOfAKind() {
		assertFalse(threeOfAKind(ranks1));
		assertTrue(threeOfAKind(ranks2));
		assertTrue(threeOfAKind(ranks3));
		assertFalse(threeOfAKind(ranks4));
	}

	@Test
	public void testsFourOfAKind() {
		assertFalse(threeOfAKind(ranks1));
		assertTrue(threeOfAKind(ranks2));
		assertTrue(threeOfAKind(ranks3));
		assertFalse(threeOfAKind(ranks4));
	}


	public static boolean threeOfKind(int[] ranks)
	{				
//		int[] ranks={4,1,1,3,0,0,0,0,0,0,0,0,0};
		int i=0;
		boolean result=false;
		
		while(!result)
		{
			if(ranks[i]>3)
			{
				break;
			}
			else if(ranks[i]==3)
			{
				result=true;
			}
			else
			{
				i++;
			}
		}
		return result;
	}