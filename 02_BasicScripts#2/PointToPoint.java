//	cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/BasicScripts#2
//	Exercise 3.12 (Learning the basics. Beginning to encapsulate in classes & methods)
/*

	Write a program that reads the X and Y coordinates of three points and then outputs 
	which of the three are closer.
	Use the following class to store the data for the points:
	class Point { double x; double y; }
	
*/

public class PointToPoint {

	public static void main(String[] args) {
	
		Point p1 = new Point(1, 3);
		Point p2 = new Point(4, 1);
		Point p3 = new Point(5, 10);
		PointToPoint ptp = new PointToPoint();
		ptp.findAndPrintShortest(p1, p2, p3);
			
	}
	
	public void findAndPrintShortest(Point p1, Point p2, Point p3) {
	 
		String shortest = "";
	
		if (calcDistance(p1, p2) < calcDistance(p1, p3)) {
		
			if (calcDistance(p1, p2) < calcDistance(p2, p3)) {
			
				shortest = "p1p2";
			
			} else {
			
				shortest = "p2p3";
			
			}
			
		} else {
		
			if (calcDistance(p1, p3) < calcDistance(p2, p3)) {

				shortest = "p1p3";
			
			} else {
			
				shortest = "p2p3";
				
			}
			
		}

		System.out.printf("The closest two are %s and %s. \n", shortest.substring(0, 2), shortest.substring(2, 4)); 

	}

	public double calcDistance(Point pA, Point pB) {
	
		return Math.hypot(Math.abs(pA.getX() - pB.getX()), Math.abs(pA.getY() - pB.getY()));
	
	}
	
	
}

class Point {

	private double x;
	private double y;
	
	public Point(int x, int y) {
	
		this.x = x;
		this.y = y;
	
	}
	
	public double getX() {
	
		return x;
		
	}
	
	public double getY() {
		
		return y;
		
	}
	
}