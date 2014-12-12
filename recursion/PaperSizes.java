// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/recursion
// Exercise 5.3 (Recursion, recursion vs iteration). Difficulty level: high

/* 
A Din-A0 sheet of paper is 841mm × 1189mm (its surface is one square meter). 
Successive measurements of paper are defined recursively as “half” or “double” the 
preceding size. Therefore, a Din-A1 sheet of paper is half of Din-A0, or 594mm × 841mm; 
while a Din-A00 is double of Din-A0, or 1189mm× 1682mm. 

Create a method that takes a String parameter representing a size 
(e.g. ”A4”, “A00000”) and prints on screen the size of the corresponding sheet of paper. 
For simplicity, you can ignore rounding errors when calculating smaller sizes.

Hint: note that two consecutive sizes always share one side and only the other one is 
multiplied or divided by two, e.g. the short side of Din-A2 is as long as the long side 
of Din-A3, while the long side of Din-A2 is twice as long as the short side of Din-A3.

A00 : 1189 mm  x 1682 mm
A0 :  841  mm  x 1189 mm
A1 :  594  mm  x 841  mm
A2 :  420  mm  x 594  mm

*/

public class PaperSizes {

		private final String A0 = "841x1189";
		private int x = 841; // A0
		private int y = 1189;// A0
		private String paperSize = "";
		
		public static void main(String[] args) {
	
			PaperSizes ps = new PaperSizes();

//											x	   y
			String paperSize = "A5";
			ps.calculate(paperSize);	// 148	x 210
			ps.print(paperSize);
			paperSize = "A4";
			ps.calculate(paperSize);	// 210	x 297
			ps.print(paperSize);
			paperSize = "A3";
			ps.calculate(paperSize);	// 297	x 420
			ps.print(paperSize);
			paperSize = "A2";
			ps.calculate(paperSize);	// 420	x 594
			ps.print(paperSize);
			paperSize = "A1";
			ps.calculate(paperSize);	// 594	x 841
			ps.print(paperSize);
			paperSize = "A0";
			ps.calculate(paperSize);	// 841	x 1189 - fixed (the rest are calculated) 
			ps.print(paperSize);
			paperSize = "A00";
			ps.calculate(paperSize);	// 1189	x 1682
			ps.print(paperSize);
			paperSize = "A000";
			ps.calculate(paperSize);	// 1682	x 2378
			ps.print(paperSize);
			paperSize = "A0000";
			ps.calculate(paperSize);	// 2378	x 3364
			ps.print(paperSize);
			paperSize = "A00000";
			ps.calculate(paperSize);	// 3364	x 4756
			ps.print(paperSize);
				
	}
	
	public void calculate(String paperSize) {
	
		if (!isValidInput(paperSize)) {

			System.out.println("That's not a legitimate input for paper size");
	
		} else {
		
			calc(paperSize.substring(1), x, y);
		
		}
		
	}
	
	public void calc(String paperSize, int x, int y) {
	
		if (paperSize.equals("0")) {
		
			this.paperSize = "" + x + " x " + y;
			return;
		
		}
		
		if (Integer.parseInt(paperSize.substring(0,1)) > 0) {
		
			paperSize = "" + (Integer.parseInt(paperSize.substring(0,1)) - 1);
			calc(paperSize, y / 2, x); 
		
		} else if (Integer.parseInt(paperSize.substring(0,1)) == 0) {
		
			calc(paperSize.substring(0,paperSize.length() - 1), y, x * 2);
		
		}

		
	}
	
	//to reduce code repetition
	public void print(String paperSize) {
		
		System.out.println("dimensions for paper size: " + paperSize + " = " + this.paperSize);
	
	}
	
	//input validation
	public boolean isValidInput(String paperSize) {
	
		boolean validInput = false;
		
		char firstCharacter = Character.toUpperCase(paperSize.charAt(0));
		
		if (paperSize.length() < 2 || paperSize.length() > 10 || firstCharacter != 'A') {
		
			System.out.println("That's not a legitimate input for paper size.");
			System.out.println("Must be something like A00 or A4.");
	
			if (firstCharacter == 'B') {
			
				System.out.println("B sizes are not calculated here.");
			
			}	
						
		} else {
		
			validInput = true;
			
		}
		
		return validInput;

	}
	
}