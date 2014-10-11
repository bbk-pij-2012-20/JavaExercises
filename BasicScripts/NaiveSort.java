// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/BasicScripts
// Exercise 1.7 (learning the basics)

// Write program that reads 3 nums & prints them in order, from lowest to highest.

public class NaiveSort {

	public static void main(String[] args) {
	
		System.out.println("input 3 numbers");
		int hi = Integer.parseInt(System.console().readLine());
		int mid = Integer.parseInt(System.console().readLine());
		int lo = Integer.parseInt(System.console().readLine());
		int temp;

		if (hi < mid) {

			temp = mid;
			mid = hi;
			hi = temp;			
		
		}

		if (hi < lo) {
		
			temp = lo;
			lo = hi;
			hi = temp;			
		
		}

		if (mid < lo) {
		
			temp = lo;
			lo = mid;
			mid = temp;
		
		}

 		System.out.printf("From hi to low: %d,%d,%d\n",hi,mid,lo);

	}	
}

/* Understanding how to arrive at the optimal order of comparisons. 3 is the minimum number of comparisons: 
  ___
 |   |
hi  mid lo
      ___
     |   |  
hi  mid lo
  _______
 |       |
hi  mid lo

			hi | mid | lo
if start:	3     4     5

1) hi/mid:  4     3     5	(swapped)
2) mid/lo:	4     5     3	(swapped)
3) hi/lo:	4     5     3	(no change)
4) hi/mid:  5	  4     3 --> NEEDED TO RE-COMPARE hi/mid

---------------------------------------------------
  ___
 |   |
hi  mid lo
  _______
 |       |
hi  mid lo
      ___
     |   |  
hi  mid lo

			hi | mid | lo
same start:	3     4     5

1) hi/mid:  4     3     5	(swapped)
2) hi/lo:	5     3     4	(swapped)
3) mid/lo:	5     4     3  --> DONE IN 3 COMPARISONS
---------------------------------------------------
  _______
 |       |
hi  mid lo
      ___
     |   |
hi  mid lo
  ___
 |   |  
hi  mid lo

			hi | mid | lo
if start:	3     5     4

1) hi/lo:   4     5     3 (swapped)
2) mid/lo:	4     5     3 (no change)
3) hi/mid:	5     4     3 --> DONE IN 3 COMPARISONS
---------------------------------------------------

So it looks like the only order that isn't optimal is one in which the 
long the immediate neighbours (top/mid and mid/low) are compared before
the distal values (top/low).

*/