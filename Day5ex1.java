public class Day5ex1
{
	public static void main(String[] args)
	{
		Day5ex1 d5=new Day5ex1();
		d5.printNumbers(6);
		System.out.println();
	}
	public static void printNumbers(int n) 
	{ 
		if(n<=0) 
		{
			return; 
		}
		System.out.print(n+" "); 
		printNumbers(n-2); 
		printNumbers(n-3); 
		System.out.print(n+" ");
	}
}
//Task: work out ("on paper") what the output will be.
/* Here is my working:

pN(6)
print "6"
pN(4)-------pN(4)
.			print "4"
.			pN(2)-------pN(2)
.			.			print "2"
.			.			pN(0)-------return, so nxt line runs
.			.			pN(-1)------return, so nxt line runs
.			.			print "2"
.			.			----------
.			pN(1)-------pN(1)		
.			.			print "1"
.			.			pN(-1)-------return, so nxt line runs
.			.			pN(-2)-------return, so nxt line runs
.			.			print "1"	
.			print "4"	----------
.			----------		
pN(3)-------pN(3)			
.			print "3"	
.			pN(1)-------pN(1)
.			.			print "1"
.			.			pN(-1)-------return, so nxt line runs
.			.			pN(-2)-------return, so nxt line runs
.			.			print "1"
.			.			----------			
.			pN(0)-------return, so nxt line runs
.			print "3"
.			----------
print "6"
----------
based on the above script: 6 4 2 2 1 1 4 3 1 1 3 6
actual result (copy,paste):6 4 2 2 1 1 4 3 1 1 3 6 
*/
