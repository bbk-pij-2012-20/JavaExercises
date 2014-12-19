// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/recursion
// Exercise 5.6 (Recursion, recursion vs iteration). Difficulty level: very high

/*
Create a method that calculates the solution to the problem of the eight Dames: 
“given a chess board, and knowing that the Dame can reach any tile horizontally, 
vertically, or diagonally, place 8 Dames on the board so that none of them can reach 
the others by doing only one move”. You can return the solution as an array of 8x8 booleans
where eight tiles are true (those with the Dames on them) and the others are false.
For extra complexity, make your method return all the possibilities in which the problem 
can be solved (this may take a long time).
*/


//I'm thinking about whether I can have a cycle of two methods that are recursive
// as a pair. i.e addDames() calls update() which calls addDames() etc.. but not sure 
// if this makes sense.

// also not sure how/whether addDames()-update() need to be able to try out every 
// permutation. But every permutation did not need to tried for towerOfHanoi.. so.. 

public class EightDames {

	private final int SIZE_OF_BOARD = 8;
	private int counter = SIZE_OF_BOARD;
	private final int STARTING_NUM_OF_DAMES = 0;
	private int dameCountDown = 8;
	private eightDamesOnBoard = false;
			
	public static void main(String[] args) {
	
		EightDames ed = new EightDames();
		boolean[][] damesAt = new boolean[SIZE_OF_BOARD][SIZE_OF_BOARD];//all false
		ed.placeDameOnUpdated(damesAt, 0, 0);
		ed.print();	
		
	}	
	
	private void addDames(boolean[][] invalidAt, int i, int j) {
	
		if (eightDamesOnBoard) {
		
			return;
			
		} else {
			
			for (int i = 0; i < invalidAt.length; i++) {
			
				for (int j = 0 ; j < invalidAt[0].length; j++) {
			
					if (invalidAt[i][j] = false) {
				
						damesAt[i][j] = true;
						addDames(update(invalidAt, i, j));
					
					}
					
				}
			
			}		
					
		}
	
	}
	
	//board has just had a dame added to position i_newDame, j_newDame,
	//it is this method's job to update the invalidAt matrix 
	private boolean[][] update(boolean[][] invalidAt, int i_newDame, int j_newDame) {
		
		if (numOfDamesOnBoard(board) == 8) {
		
			eightDamesOnBoard = true;
			return board;
			
		} 
					
		invalidAt[i_newDame][j_newDame] = true;
			
		for (int n = 0; n < SIZE_OF_BOARD; n++) {
	
			invalidAt[n][j_newDame] = true;
			invalidAt[i_newDame][n] = true;
				
		}
		
		int i = 0;
		int j = 0;
///// to complete!!!!
		while ()
		if (i_newDame - i) {
		
			
			
		}
				
		return invalidAt;	
				
	}
	
	// returns the number of dames on board, i.e. num of positions where board[][] is true
	private int numOfDamesOnBoard(boolean[][] board) {
	
		int dames = 0;
		
		for (int i = 0; i < board.length; i++) {
		
			for (int j = 0; j < board[0].length; j++) {
			
				if (board[i][j] == true) {
				
					dames++;
					
				}
				
			}
		
		}
		
		return dames;
	
	}
	



