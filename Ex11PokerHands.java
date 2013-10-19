import java.util.Random;

public class Ex11PokerHands
{		
	private final int RANK=13;
	private final int SUIT=4;
	private int[] ranks=new int[RANK];
	private int[] suits=new int[SUIT];
	private final int hand=5;
						
	public static void main(String[] args)
	{
		Ex11PokerHands ph=new Ex11PokerHands();
	}
	public Ex11PokerHands()
	{
		deal();
		findBestHand();
	}
	public void deal()
	{
		int noOfCardDealt=0;
		
		while(noOfCardDealt<hand)
		{
			Random random1=new Random();
			int randomRank=random1.nextInt(13);
			ranks[randomRank]++;
			System.out.print("Card no."+(noOfCardDealt+1)+": ");

			int randomSuit=random1.nextInt(4);
			suits[randomSuit]++;
			printCard(randomRank,randomSuit);
			
			noOfCardDealt++;				

		}
	}
	public void printCard(int rankIn, int suitIn)
	{		
		String cardRank;
		String cardSuit;
		
		switch(rankIn)
		{
			case 0:cardRank="Ace";break;
			case 1:cardRank="Two";break;
			case 2:cardRank="Three";break;
			case 3:cardRank="Four";break;
			case 4:cardRank="Five";break;
			case 5:cardRank="Six";break;
			case 6:cardRank="Seven";break;
			case 7:cardRank="Eight";break;
			case 8:cardRank="Nine";break;
			case 9:cardRank="Ten";break;
			case 10:cardRank="Jack";break;
			case 11:cardRank="Queen";break;
			default:cardRank="King";break;
		}				
		switch(suitIn)
		{
			case 0:cardSuit="Diamonds";break;
			case 1:cardSuit="Hearts";break;
			case 2:cardSuit="Spades";break;
			default:cardSuit="Clubs";break;
		}	
		System.out.println(cardRank+" of "+cardSuit);
	}

	public void findBestHand()
	{
		System.out.print("Your best hand is: ");
		if(straightFlush()==true)
		{
			System.out.println("Straight Flush");
		}
		else if(poker()==true)
		{
			System.out.println("Poker");
		}
		else if(fullHouse()==true)
		{
			System.out.println("Full House");
		}
		else if(flush()==true)
		{
			System.out.println("Flush");
		}
		else if(straight()==true)
		{
			System.out.println("Straight");
		}
		else if(threeOfKind()==true)
		{
			System.out.println("three of a kind");
		}
		else if(twoPairs()==true)
		{
			System.out.println("two pairs");
		}
		else if(pair()==true)
		{
			System.out.println("pair");
		}
		else
		{
			System.out.println("nada");
		}
	}
	
	// all cards r same suit & ranks r consecutive.
	public boolean straightFlush() 
	{
		return flush()&&straight(); 
	}
	
	//4 of 5 cards have same rank.
	public boolean poker()
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
		
	// 3 have same rank + 2 have same rank
	public boolean fullHouse() 
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

	// all cards r same suit, 
	// (if 5 consecutive ranks, it is also a Straight Flush)

	public boolean flush()
	{
		int i=0;
		boolean result=false;
		
		while(!result)
		{
			if(suits[i]==5)
			{
				result=true;
				break;
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
	
	// all 5 card's ranks r consecutive, 
	// (if all 5 cards have same suit, it is also a Straight Flush)
	public boolean straight()
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
	
	//at least 3 cards have same rank
	public boolean threeOfKind()
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
		
	// 2 distinct pairs of ranks
	public boolean twoPairs()
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


	//at least 2 cards have same rank
	public boolean pair()
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