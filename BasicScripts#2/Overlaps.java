// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/BasicScripts#2
// Exercise 3.15 (Learning the basics. Beginning to encapsulate in classes & methods)
/*
   Write a program that reads the coordinates of four point points, the former two defining one rectangle and the
   latter two defining another one. The program must read the coordinates of a fifth point and say whether the point
   is inside both rectangles, inside one of them only, or out of both.
*/

public class Overlaps {

	public static void main(String[] args) {
	
		Overlaps ol = new Overlaps();
		Point[] fourRectanglePoints = {new Point(0,0), new Point(2,2), new Point(1,1), new Point(3,3)};
		Point[] points = {new Point(0,0), new Point(1,2), new Point(2,2), new Point(3,3)};
		
		for (int i = 0; i < points.length; i++) {
		
//if in both then true at zero-index, else true/false in rectangle1 at index=1 and/or true/false in rectangle2 at index=2.
			boolean[] overlap = overlapping(fourRectanglePoints, points[i]);
			System.out.printf(? ");
		
		}		
		
	}

	public boolean[] overlapping(Point[] fourRectanglePoints, Point point) {
	
		boolean []  (withinAbscissa(fourRectanglePoints[0], fourRectanglePoints[1], point.getX())
				&& isWithinOrdinate(fourRectanglePoints[0], fourRectanglePoints[1], point.getY())); 
	
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




