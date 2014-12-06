// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/startingToEncapsulate
// Exercise 4.6 (Learning the basics. Starting to encapsulate into methods).
/*
Write a program in which you create and use a class called Point, with two fields of 
type double (e.g. x, y) and the following methods:

distanceTo(Point): calculates the distance to another point.
distanceToOrigin(): calculates the distance to the origin. Implement it by calling the 
first method.
moveTo(double x, double y): changes the coordinates of this point to be the given 
parameters x and y.
moveTo(Point): changes the coordinates of this point to move where the given point is.
clone(): returns a copy of the current point with the same coordinates.
opposite(): returns a copy of the current point with the coordinates multiplied by −1.

Two methods in a class can have the same name (identifier) as long as their parameters 
are different. This is called method overloading and we will see more of that in the future.
*/

public class MorePoints {

	public static void main(String[] args) {
	
		Point p1 = new Point(1,2);
		Point p2 = new Point(3,4);
		p1.distanceTo(p2);
		p1.distanceToOrigin();
		p1.moveTo(4, 5);
		p1.moveTo(p2);
		p1.clone();
		p1.opposite();
	
	}

}

class Point {

	private double x, y;

	public Point(double x, double y) {
	
		setX(x);
		setY(y);
	
	}
	
	public Point() {} // providing and empty constructor for clone
	
	public double getX() {
	
		return x;
	
	}

	public double getY() {
	
		return y;
	
	}
	
	public void setX(double x) {
	
		this.x = x;
	
	}

	public void setY(double y) {
	
		this.y = y;
	
	}

	//Pythagoras
	public double distanceTo(Point point) {
	
		double deltaX = distanceBetween(x, point.getX());
		double deltaY = distanceBetween(y, point.getY());
		return Math.sqrt(deltaX * deltaX + deltaY * deltaY); 
		
	}

	private double distanceBetween(double thisXY, double otherXY) {
	
		return Math.abs(thisXY - otherXY);
	
	}

	public double distanceToOrigin() {
	
		return distanceTo(new Point(0,0));
	
	}
	
	public void moveTo(Point point) {
	
		moveTo(point.getX(), point.getY());
	
	}

	public void moveTo(double x, double y) {
	
		setX(x);
		setY(y);
	
	}
	
	public Point clone() {
	
/*		Point copy = new Point(); 
		copy = this; // I think doing it this way just generates a second pointer to the same object.
		return copy;*/
		return new Point(this.x, this.y);
	
	}
	
	public Point opposite() {
	
		Point opposite = clone();
		double x = opposite.getX();
		double y = opposite.getY();
		opposite.moveTo(-1 * x, -1 * y);
		return opposite;
		
	}

}