//cd desktop/JavaCoding/JavaExercises
/* Day 3, Ex3 - Your Change Please
Write a program that reads the total cost of a purchase and an 
amount of money that is paid to buy it. Your program should output 
the correct change specifying the amount of notes (50, 20, 10, 5) 
and coins (2, 1, 0.50, 0.20, 0.10, 0.05, 0.02, 0.01) needed.
*/
public class YrChangePls //Day3 ex3
{
	public static void main(String args[])
	{
//		System.out.println("Enter cost(£), e.g. 200.43");	
//		String input=System.console().readLine();
//		double cost=Double.parseDouble(input);
		double cost=200.34;
//		System.out.println("Enter amount paid, e.g. 300.00");	
//		input=System.console().readLine();
//		double paid=Double.parseDouble(input);
		double paid=300;
		if(paid<cost)
		{
			System.out.println("you must pay more");
			System.exit(0);
		}		
		double change=(paid-cost)*100;
		System.out.println("change is: "+change);
		if(change==0)
		{
			System.out.println("no change");
			System.exit(0);
		}
		long notesChange=Math.round(change/100);
		// got this from Sokratis
		long coinsChange=Math.round(change%100);
		System.out.println("long notesChange: "+notesChange);		
		System.out.println("long coinsChange: "+coinsChange);		
	}
/* The 'notes' array stores the change in the following order:
First the notes: £50[0],£20[1],£10[2],£5[3]. 
The 'coins' array stores the change in the following order:
Then the coins: £2[0],£1[1],50p[2],20p[3],10p[4],5p[5],2p[6],1p[7] */
/*		long[] notes=new long[4];
		long[] coins=new long[8];	

		notes[0]=notesChange/50; 
		notesChange%=50;
		notes[1]=notesChange/20;
		notesChange%=20;
		notes[2]=notesChange/10; 
		notesChange%=10;
		notes[3]=notesChange/5;
		notesChange%=5;			  		
		coins[0]=notesChange/2;
		notesChange%=2;
		coins[1]=notesChange/1;
		notesChange%=1;
		coins[2]=coinsChange/50;
		coinsChange%=50;
		coins[3]=coinsChange/20;
		coinsChange%=20;
		coins[4]=coinsChange/10;
		coinsChange%=10;
		coins[5]=coinsChange/5;
		coinsChange%=5;
		coins[6]=coinsChange/2;
		coinsChange%=2;
		coins[7]=coinsChange/1;
		coinsChange%=1;
		
		int i=0;
		while(i<notes.length)
		{
			if(notes[i]>0)
			{
				printNotes(i,notes);	
			}
			else
			{
				i++;
			}
		}
		int j=0;
		while(j<coins.length)
		{
			if(coins[j]>0)
			{
				printCoins(j,coins);	
			}
			else
			{
				j++;
			}
		}
	}
	public static void printNotes(int i,long[] notes)
	{
		switch(i)
		{
			case 0:System.out.println("50: "+notes[i]);break;
			case 1:System.out.println("20: "+notes[i]);break;
			case 2:System.out.println("10: "+notes[i]);break;
			case 3:System.out.println("5: "+notes[i]);break;				
			default:System.out.println("no notes");break;
		}
	}
	public static void printCoins(int j,long[] coins)
	{
		switch(j)
		{
			case 0:System.out.println("50: "+coins[j]);break;
			case 1:System.out.println("20: "+coins[j]);break;
			case 2:System.out.println("10: "+coins[j]);break;
			case 3:System.out.println("5: "+coins[j]);break;				
			case 4:System.out.println("50: "+coins[j]);break;
			case 5:System.out.println("20: "+coins[j]);break;
			case 6:System.out.println("10: "+coins[j]);break;
			case 7:System.out.println("5: "+coins[j]);break;
			default:System.out.println("no coins");break;				
		}
	}*/	
}