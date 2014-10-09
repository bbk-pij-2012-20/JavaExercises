//cd desktop/JavaCoding/JavaExNoGIT/d5Ex_noGIT
/* Day5,Ex2(c) - Hanoi towers
- 3 posts: A, B, C
- move between the posts, but only one at a time from 
post A to B, either directly or variety of permutations
of movement between A,B and C.
- a movement from A cannot be to the same post made 
by a preceding movement from A. 
The smallest disc can be placed on any 
post (all other discs are bigger); the biggest disc 
can only be placed on an empty post.
Create a method that calculates the number of moves 
necessary to move a set of n Hanoi disks from the 
initial post to the last post. 
*/
/* 
I really don't know how to begin thinking about this problem:
- Should I be considering poles as objects, Strings, integers, ..why?
- How about discs? 
- Or should the movement of a discs from one pole to the next be encapsulated
into an object itself. Or should movement be a method?
- Should there be conditional clauses to check for size of discs ?
i.e. if(disc1>disc2) 
Below are some examples of code for this, but they don't help me think 
how to think.
*/
/** 
* Towers of Hanoi 
* Pole are labeled 1,2,3 
* Each disk is also labeled 
* @author Lars Vogel 
**/
//The Vogel's code below is very short and comes with NO explanation at all. (what are the numbers 6, and 5,1,3?)
public class TowersOfHanoi
{
	public static void move(int n, int startPole, int endPole)
	{
		if(n==0)
		{
			return; 
		}
		int intermediatePole=6-startPole-endPole;
		move(n-1,startPole,intermediatePole); //RECURSION
		System.out.println("Move "+n+" from "+startPole+" to "+endPole);
		move(n-1,intermediatePole,endPole);
	}
	public static void main(String[] args)
	{
		move(5,1,3);
	}
} 
------------------------------------------------------------------------------
// from http://www.mathcs.emory.edu/~cheung/Courses/170/Syllabus/13/hanoi.html
public static String hanoi(int nDisks, int fromPeg, int toPeg)
{
	int helpPeg;
	String Sol1, Sol2, MyStep, mySol;   // Contains moves
	if(nDisks==1)
	{
		return fromPeg+" -> "+toPeg+"\n";
	}
	else
	{
		helpPeg=6-fromPeg-toPeg;    // Because fromPeg + helpPeg + toPeg = 6    
		Sol1=hanoi(nDisks-1,fromPeg,helpPeg);
		MyStep=fromPeg+" -> "+toPeg+"\n";
		Sol2=hanoi(nDisks-1,helpPeg,toPeg);
		mySol=Sol1+MyStep+Sol2;     // + = String concatenation !
		return mySol;;
	}
}
------------------------------------------------------------------------------
//Keith Mannock code
public class TowersOfHanoi
{
	private int totalDisks;
	private int count;
	public TowersOfHanoi(int disks)
	{
		totalDisks=disks;
		count=0;
	}
	public void solve()
	{
		moveTower(totalDisks,1,3,2);
	}
	private void moveTower(int numDisks,int start,int end,int temp)
	{
		if(numDisks==1)
		{
			moveOneDisk(start, end);
		}
		else
		{
			moveTower(numDisks-1,start,temp,end);
			moveOneDisk(start,end);
			moveTower(numDisks-1,temp,end,start);
		}
	}
	private void moveOneDisk(int start,int end)
	{
		count=count+1;
		System.out.println("Move one disk from "+start+" to "+end+" - Move "+count);
	}
	public static void main(String[] args)
	{
		TowersOfHanoi tower=new TowersOfHanoi(5);
		tower.solve();
		System.out.print("Number of moves "+tower.count);
	}
}