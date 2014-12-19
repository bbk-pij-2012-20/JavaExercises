// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/BasicScripts#2
// Exercise 3.14 (Learning the basics. Beginning to encapsulate in classes & methods)
/*
   Write a program that reads the coordinates of the two points defining a rectangle 
   and then the coordinates of a third point. The program must then determine whether 
   the point falls inside or outside the rectangle.
*/

public class InsideOutside {

	public static void main(String[] args) {
	
		InsideOutside io1 = new InsideOutside();
		Rectangle rectangle = new Rectangle(new Point(0,0), new Point(10,10));
		Point point = new Point(5,5);
		Point[] corners = rectangle.getCorners();
		System.out.printf("The point with coordinates %s, %s is %sside the rectangle with corners %s, %s and %s, %s \n",point.getX(), point.getY(),io1.isInRectangle(rectangle,point)? "in" : "out", corners[0].getX(), corners[0].getY(), corners[1].getX(), corners[1].getY());		
		point = new Point(10,10);
		System.out.printf("The point with coordinates %s, %s is %sside the rectangle with corners %s, %s and %s, %s \n",point.getX(), point.getY(),io1.isInRectangle(rectangle,point)? "in" : "out", corners[0].getX(), corners[0].getY(), corners[1].getX(), corners[1].getY());		
	
	}

	public boolean isInRectangle(Rectangle rectangle, Point point) {
	
		return isWithinAbscissa(rectangle.getCorners(), point.getX())
				&& isWithinOrdinate(rectangle.getCorners(), point.getY()); 
	
	}	
	
	private boolean isWithinAbscissa(Point[] corners, int x) {

		return (x > corners[0].getX() && x < corners[1].getX()) 
				|| (x < corners[0].getX() && x > corners[1].getX());

	}

	private boolean isWithinOrdinate(Point[] corners, int y) {

		return (y > corners[0].getY() && y < corners[1].getY()) 
				|| (y < corners[0].getY() && y > corners[1].getY());

	}

}

class Rectangle {

	private Point corner1;
	private Point corner2;
	
	public Rectangle(Point corner1, Point corner2) {
	
		this.corner1 = corner1;
		this.corner2 = corner2;
	
	}
	
	public Point[] getCorners() {
	
		Point[] corners = {corner1, corner2};
		return corners;
	
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




