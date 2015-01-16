// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/05_ARRAYS
// Exercise 6.6 (Arrays. 3D Array and also first use of enums as well).
/*
Create an enumerated type Result in its own file. 
The enum must have 8 possible values: HIT, FAIL_LEFT, FAIL_RIGHT, FAIL_HIGH, FAIL_LOW, FAIL_SHORT, FAIL_LONG, OUT_OF_RANGE. 
Hint: the enum must be public.
Then create a Java class Target with the following methods:

• A constructor method Target(int) that creates a 3-D array of integers of the proposed size in all three
dimensions. All elements must be set to zero.

• A method called init() that sets all the elements in the matrix to 0 except one —selected randomly— that
will be set to 1. 

• fire(int,int,int) a method that checks whether the element determined by the indexes is 1 and returns a type Result according to the result: 

Result.HIT if the element is 1, 
Result.FAIL_LEFT if the element of value 1 is “to the left” (you must decide what left and right are in your 3-D array), etc. 
If any of the indices is too big (or negative), the method must return Result.OUT_OF_RANGE. 
Left–right information takes precedence over high–low, and this takes precendence over short–long. 
If the 1 is to the left and behind, the output should be Result.FAIL_LEFT.

Write a small program that tells the user they must hit a flying target, and then let the user try to find it by
introducing three indices. The program should use an object of class Target to know whether the user hit or not,
and provide feedback accordingly. Here is a sample out of such a program in a space 10x10x10.
Here they come! Try to bring the plane down!

Enter a coordinate X: 30
Enter a coordinate Y: 4
Enter a coordinate Z: 5
That shot is way out of range. Try harder!
Enter a coordinate X: 3
Enter a coordinate Y: 4
Enter a coordinate Z: 5
You missed! The target is to the right!
Enter a coordinate X: 5
Enter a coordinate Y: 4
Enter a coordinate Z: 1
You missed! The target is farther!
Enter a coordinate X: 5
Enter a coordinate Y: 4
Enter a coordinate Z: 5
You hit it! Well done!
Would you like to play again? y
Here they come! Try to bring the plane down!
Enter a coordinate X:
*/

import java.util.Random;

public class Target {

	private int[][][] space3D = null;
	private int size;
		
	public static void main(String[] args) {
	
		int x = 0;
		int y = 0;
		int z = 0;
		int size = 10;
		Target t = new Target(size);
		t.init();
				
		do {
			
			System.out.print("\nEnter a coordinate X: ");
			x = Integer.parseInt(System.console().readLine());
			System.out.print("Enter a coordinate Y: ");
			y = Integer.parseInt(System.console().readLine());
			System.out.print("Enter a coordinate Z: ");
			z = Integer.parseInt(System.console().readLine());

			t.showResult(t.fire(x,y,z));
				
		} while (!t.fire(x,y,z).equals(Result.HIT));
		
		System.out.println();
		
	}

	/**
	*	Constructor takes the size and initializes the 3D array, sets all values to 0
	*/
	public Target(int size) {
	
		this.size = size;
		space3D = new int[size][size][size];
		target();
		
	}
	
	/**
	*	Randomly positions the aircraft, represented with 1.
	*/
	private void showResult(Result result) {

		switch (result) {
			
			case HIT : System.out.println("You hit! Good shot old boy!"); break;
			case OUT_OF_RANGE : System.out.println("Out of range of this game (needs to be within 0-9)!"); break;
			case FAIL_LEFT : System.out.println("Too far to the left (use higher x)"); break;
			case FAIL_RIGHT : System.out.println("Too far to the right (use lower x)"); break;
			case FAIL_HIGH : System.out.println("Too high (use lower y)"); break;
			case FAIL_LOW : System.out.println("Too low (use higher y)"); break;
			case FAIL_SHORT : System.out.println("Too short (use higher z)"); break;
			default : System.out.println("Too long (use lower z)"); break;
			
		}

	}
	
   /**
	*	Initializes the 3D array and sets all values to 0.
	*/
	public void target() {
		
		for (int i = 0; i < size; i++) {
		
			for (int j = 0; j < size; j++) {
			
				for (int k = 0; k < size; k++) {
				
					space3D[i][j][k] = 0;
				
				}
				
			}
			
		}
	
	}
	
   /**
	*	Randomly positions the aircraft, represented with 1.
	*/
	public void init() {
	
		Random r = new Random();
		space3D[r.nextInt(size)][r.nextInt(size)][r.nextInt(size)] = 1;
	
	}

   /**
	*	Determines whether shot is relative to aircraft
	*
	*	@param i		left_right index
	*	@param j		high_low index
	*	@param k		long_short index
	*	@return			Result of shot, hit or missed 
	*/	
	public Result fire(int i, int j, int k) {
	
		int[] aircraftPosition = findAircraft();
		int x = aircraftPosition[0];
		int y = aircraftPosition[1];
		int z = aircraftPosition[2];
						
		if (i > size || j > size || k > size) {
		
			 return Result.OUT_OF_RANGE;
						
		} else {

			if (i < x) {

				return Result.FAIL_LEFT;
			
			} else if (i > x) {

				return Result.FAIL_RIGHT;

			} else { 
			
				if (j < y) {
			
					return Result.FAIL_LOW;
				
				} else if (j > y) {

					return Result.FAIL_HIGH;

				} else {
			
					if (k < z) {
			
						return Result.FAIL_SHORT;
				
					} else if (k > z) {

						return Result.FAIL_LONG;

					}
				
				}
				
			}
		
		}
			
		return Result.HIT;
		
	}
	
   /**
	*	Finds the left-right ("x") index, the high_low ("y") index and the long_short ("z") 
	*	index of the aircraft (where 1 lies). I could have just taken these values directly 
	*	from the member fields, but I wanted to find the aircraft by searching the 3D array, 
	*	otherwise it seems pointless to have made the 3D array at all.
	*		
	*	@return			left_right, high_low and long_short index of aircraft
	*/
	public int[] findAircraft() {
	
		int lRHLSL[] = new int[3];
		boolean found = false;
		int i = 0;
		int j = 0;
		int k = 0;
		
		while (i < size && !found) {
		
			while (j < size) {
			
				while (k < size) {
				
					if (space3D[i][j][k] == 1) {
			
						lRHLSL[0] = i;
						lRHLSL[1] = j;
						lRHLSL[2] = k;
						found = true;
						
					}
					
					k++;
					
				}
				
				k = 0;
				j++;
				
			}
			
			j = 0;
			i++;
	
		}
		
		return lRHLSL;
			
	}

}