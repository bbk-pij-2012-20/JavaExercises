// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/BasicScripts#2
// Exercise 3.13 (Learning the basics. Beginning to encapsulate in classes & methods)
/*
   Write a program that reads the X and Y coordinates of two points and 
   then outputs the area of a rectangle where both points are opposite 
   corners. Use the following class to store the data for the points:
   class Rectangle { Point upLeft; Point downRight; } Your program should 
   calculate (and write on the screen) the perimeter and area of the rectangle.
*/

public class Rectang {

	public static void main(String[] args) {
	
		Rectangle rectangle1 = new Rectangle(new Point(0,0), new Point(10,10));
		System.out.println("\nRectangle with 'upLeft' corner at: " + rectangle1.getUpLeft().getX() + ", " + rectangle1.getUpLeft().getY());
		System.out.println("Rectangle with 'downRight' corner at: " + rectangle1.getDownRight().getX() + ", " + rectangle1.getDownRight().getY());
		Rectang r = new Rectang();
		int[] areaAndPerim = r.calcPerimeterAndArea(rectangle1);
		System.out.printf("Area = %s, Perimeter = %s \n", areaAndPerim[0], areaAndPerim[1]);
		
	}
	
	
	private int[] calcSides(Point upLeft, Point downRight) {

		int[] sides = {Math.abs(upLeft.getX() - downRight.getX()), Math.abs(upLeft.getY() - downRight.getY())};
		return sides;
		
	}

	// returns array with area at zero-index, perimeter at index = 1
	public int[] calcPerimeterAndArea(Rectangle rectangle) {
	
		int[] sides = calcSides(rectangle.getUpLeft(), rectangle.getDownRight());
		int[] result = {sides[0] * sides[1], 2 * sides[0] + 2 * sides[1]};
		return result;
		
	}

}

class Rectangle  {

	private Point upLeft;
	private Point downRight;
	
	public Rectangle(Point upLeft, Point downRight) {
	
		this.upLeft = upLeft;
		this.downRight = downRight;
	
	}
	
	public Point getUpLeft() {
	
		return upLeft;
		
	}

	public Point getDownRight() {
	
		return downRight;
		
	}

}

class Point {
	
	private int x;
	private int y;

	public Point(int x, int y) {
	
		this.x = x;
		this.y = y;
	
	}
	
	public int getX() {
	
		return x;
		
	}

	public int getY() {
	
		return y;
		
	}

}