public class MyPokerTest
{
	private static int[] ranks={0,0,0,0,2,0,2,0,0,0,0,0,0};
	private static int[] suits={0,5,0,0};
	
	public static void main(String[] args)
	{
		System.out.printf("straight flush is %s\n",straightFlush()?"true":"false"); 
		System.out.printf("straight is %s\n",straight()?"true":"false"); 
		System.out.printf("flush is %s\n",flush()?"true":"false"); 
		System.out.printf("full house is %s\n",fullHouse()?"true":"false"); 
		System.out.printf("poker is %s\n",poker()?"true":"false"); 
		System.out.printf("two pairs is %s\n",twoPairs()?"true":"false"); 
		System.out.printf("threeOfKind is %s\n",threeOfKind()?"true":"false"); 
		System.out.printf("pair is %s\n",pair()?"true":"false"); 
	}

	// all cards r same suit & ranks r consecutive.
	public static boolean straightFlush() 
	{
		return flush()&&straight(); 
	}

	// all 5 card's ranks r consecutive, (not same suit, otherwise Straight Flush)
	public static boolean straight()
	{
		int i=0;
		int j=0;
		boolean result=false;

		while(!result&&j<6)
		{						
			if(ranks[i]>1)
			{
				break;
			}
			else 
			{
				if(ranks[i]==1)
				{
					j++;
					if(j==5)
					{
						result=true;
					}
					else
					{
						i++;
					}
				}
				else if(ranks[i]==0)
				{
					if(j==0)
					{
						i++;
					}
					else 
					{
						break;
					}
				}
			}
		}
		return result;
	}
	
	// all cards r same suit, (not consecutive, otherwise Straight Flush)
	public static boolean flush()
	{
		int i=0;
		boolean result=false;
		
		while(!result)
		{
			if(suits[i]==5)
			{
				result=true;
			}
			else if(suits[i]!=0)
			{
				break;
			}
			else
			{				
				i++;
			}
		}
		return result; 
	}	

	// 3 have same rank + 2 have same rank
	public static boolean fullHouse() 
	{
		int i=0;
		boolean result=false;
		int cardRankCount=0;
		
		while(!result)
		{
			cardRankCount+=ranks[i];
			
			if(pair()==false||ranks[i]==1)
			{
				break;
			}
			else if(cardRankCount==5)
  			{
  				result=true;
  			}
  			else if(cardRankCount==4)
  			{
  				break;
  			}
  			else
  			{
  				i++;
  			}
		}
		return result;		
	}
	
	//4 of 5 cards have same rank.
	public static boolean poker()
	{
		int i=0;
		boolean result=false;
		int cardRankCount=0;
		
		while(!result)
		{
			cardRankCount+=ranks[i];
			
			if(ranks[i]>=4)
			{
				result=true;
			}
			else if(cardRankCount>1)
			{
				break;
			}
			else
			{
				i++;
			}
		}
		return result;
	}

	//	{0,0,0,1,2,0,2,0,0,0,0,0,0}	
	// at least 2 pairs of same rank.
//I don't understand why this keeps giving me ArrayIndexOutOfBoundsException!!!!!
/*	public static boolean twoPairs()
	{
		int i=0;
		boolean result=false;	
		int cardRankCount=0;
		while(!result)
		{
			cardRankCount+=ranks[i];
			
			if(pair()==false)
			{
				break;
			}
			else if(ranks[i]==3||ranks[i]==5)
			{
				break;
			}
			else if(ranks[i]==4||cardRankCount==4)
			{
				result=true;
			}
			else if(ranks[i]==1)
			{
				if((cardRankCount%2)==0)
				{
					break;
				}
				else if(cardRankCount==5)
				{
					result=true;
				}
				else
				{
					i++;
					continue;
				}
			}
			else
			{
				i++;
			}	
		}	
		return result;
	}
*/
	// 2 distinct pairs of ranks
	public static boolean twoPairs()
	{
		int i=0;
		boolean result=false;	
		int cardRankCount=0;

		while(!result)
		{
			cardRankCount+=ranks[i];
			if(pair()==false||ranks[i]>2)
			{
				break;
			}
			else if(cardRankCount==2&&ranks[i]!=2)
			{
				break;
			}
			else if(ranks[i]==2)
			{
				if(cardRankCount==4||cardRankCount==5)
				{
					result=true;
				}
				else
				{
					i++;
					continue;
				}
			}
			else
			{
				i++;
			}	
		}	
		return result;
	}
	
	//at least 3 cards have same rank
	public static boolean threeOfKind()
	{				
		int i=0;
		boolean result=false;
		int cardRankCount=0;
		
		while(!result)
		{
			cardRankCount+=ranks[i];
			
			if(ranks[i]>=3)
			{
				result=true;
			}
			else if(cardRankCount>2)
			{
				break;
			}
			else
			{
				i++;
			}
		}
		return result;
	}
	
	//at least 2 cards have same rank
	public static boolean pair()
	{				
		int i=0;
		boolean result=false;
		int cardRankCount=0;
		
		while(!result)
		{
			cardRankCount+=ranks[i];
			
			if(ranks[i]>=2)
			{
				result=true;
			}
			else if(cardRankCount>3)
			{
				break;
			}
			else
			{
				i++;
			}
		}
		return result;
	}
}