// cd ~/Desktop/all_pooled/computing/CODING/JavaExercises/04_RECURSION
// Exercise 5.2c (Recursion, recursion vs iteration).
/*
Hanoi towers
- 3 posts: A, B, C
- move between the posts, but only one at a time from post A to B, either directly or
variety of permutations of movement between A,B and C.
- a movement from A cannot be to the same post made by a preceding movement from A.
The smallest disc can be placed on any post (all other discs are bigger); the biggest
disc can only be placed on an empty post.

Create a method that calculates the number of moves necessary to move a set of n Hanoi
disks from the initial post to the last post.
*/
/*
//@author Lars Vogel
public class TowersOfHanoi {

	public static void move(int n, int startPole, int endPole) {

		if (n == 0) {

			return;

		}

		int intermediatePole = 6 - startPole - endPole;				// what is 6 ????
		move(n - 1, startPole, intermediatePole); //RECURSION
		System.out.println("Move " + n + " from " + startPole + " to " + endPole);
		move(n - 1, intermediatePole, endPole); // RECUSION

	}

	public static void main(String[] args) {

		move(5, 1, 3);

	}

}*/
//------------------------------------------------------------------------------
// from http://www.mathcs.emory.edu/~cheung/Courses/170/Syllabus/13/hanoi.html

// note: fromPeg is the int 1, toPeg is 3.
public class TowersOfHanoi {

	static int moveCount = 0 ;

	public static void main(String[] args) {

		System.out.println("result: \n" + hanoi(4, 1, 3));
		System.out.println("move count: " + moveCount);
	}

	public static String hanoi(int nDisks, int fromPeg, int toPeg) {

		int helpPeg;
		String Sol1, Sol2, MyStep, mySol;   // Contains moves

		if (nDisks == 1) {

			moveCount++;
			return fromPeg + " -> " + toPeg + "\n";

		} else {

			helpPeg = 6 - fromPeg - toPeg;    // Because fromPeg + helpPeg + toPeg = 6   //fromPeg 1, helpPeg 2, toPeg 3 ..?
System.out.println("TOP ----- nDisks: " + nDisks);
			Sol1 = hanoi(nDisks - 1, fromPeg, helpPeg);
System.out.println("MID ................... nDisks: " + nDisks);
			MyStep = fromPeg + " -> " + toPeg + "\n";
			moveCount++;
			Sol2 = hanoi(nDisks - 1, helpPeg, toPeg);
System.out.println("BOT ____________________________________ nDisks: " + nDisks);
			mySol = Sol1 + MyStep + Sol2;     // + = String concatenation !
			return mySol;

		}

	}

}

/*------------------------------------------------------------------------------
// @author Keith Mannock (lecturer)
public class TowersOfHanoi {

	private int totalNumOfDisksToMove;
	private int count;

	public TowersOfHanoi(int disks) {

		totalNumberOfDisksToMove = disks;
		count = 0;

	}

	public static void main(String[] args) {

		System.out.println("enter how many disks to move: ")
		TowersOfHanoi tower = new TowersOfHanoi(Integer.parseInt(System.console().readLine()));
		tower.solve();
		System.out.print("Number of moves it takes to move " + totalNumberOfDisksToMove + " from one peg to another is: " + tower.count);

	}

	public void solve() {

		int diskPosition1 = 1; // I added this to make it clear what these magic numbers are!
		int diskPosition2 = 2; // ditto
		int diskPosition3 = 3; // ditto
		moveTower(totalDisks, diskPosition1, diskPosition3, diskPosition2);

	}

	private void moveTower(int numDisks, int start, int end, int temp) {

		if (numDisks == 1) {

			moveOneDisk(start, end);

		} else {

			moveTower(numDisks - 1, start, temp, end);
			moveOneDisk(start, end);
			moveTower(numDisks - 1, temp, end, start);

		}

	}

	private void moveOneDisk(int start, int end) {

		count = count + 1;
		System.out.println("Move one disk from " + start + " to " + end + " - Move " + count);

	}

}
*/
/*------------------------------------------------------------------------------
@author YouTube tutorial. Can't find it now.
public class Recursion {

	public static void main(String[] args) {

		Recursion r = new Recursion();
		System.out.println("result: \n" + r.move(5, 'S', 'E', 'T'));

	}

	public String move(int n, char start, char end, char temp) {

		final String MOVE = "Move disk " + n + " from " + start + " to " + end + "\n";

		if (n == 1) {

			return MOVE;

		}

		String result = move(n - 1, start, temp, end);
		result += MOVE;

		result += move(n - 1, temp, end, start);
		return result;

	}

}
*/
