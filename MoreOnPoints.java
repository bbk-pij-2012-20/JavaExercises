//cd desktop/JavaCoding/JavaExercises
/*Day 4 Ex6 - More on points
Write a program in which you create and use a class called Point, 
with two fields of type double (e.g. x, y) and the following methods:
distanceTo(Point): calculates the distance to another point.
distanceToOrigin(): calculates the distance to the origin. 
Implement it by calling the first method. 
moveTo(double x, double y): changes the coordinates of this point to 
be the given parameters x and y. 
moveTo(Point): changes the coordinates of this point to move where 
the given point is.
4
clone(): returns a copy of the current point with the same coordinates.
opposite(): returns a copy of the current point with the coordinates 
multiplied by −1.
Two methods in a class can have the same name (identifier) as long as 
their parameters are different. This is called METHOD OVERLOADING.*/
public class MoreOnPoints
{
	public static void main(String args[])
	{
		Point p1=new Point(1,2);
		Point p2=new Point(3,4);
		p1.distanceTo(p2);
		p1.distanceToOrigin();
		p1.moveTo(4,5);
		p1.moveTo(p2);
		p1.clone();
		p1.opposite();
	}
}
class Point
{
	public double x;
	public double y;
	public Point(double x,double y)
	{
		this.x=x;
		this.y=y;
	}
	public Point(){}
	public double distanceTo(Point anotherPoint)
	{
		double xDist=Math.abs(this.x-anotherPoint.x);
		double yDist=Math.abs(this.y-anotherPoint.y);
		return Math.sqrt(xDist*xDist+yDist*yDist);
	}
	public double distanceToOrigin()
	{
		Point point0=new Point(0,0);
		return distanceTo(point0);
	}
	public Point clone()
	{
		return new Point(this.x,this.y);
	}
	public Point opposite()
	{
		Point oppClone=this.clone();
		oppClone.x=oppClone.x*-1;
		oppClone.y=oppClone.y*-1;
		return oppClone;
	}
	public void moveTo(Point point) //overloading (same name, diff parameters)
	{
		moveTo(point.x,point.y);
	}	
	public void moveTo(double x,double y)//overloading (same name, diff parameters)
	{
		new Point(x,y);
	}
}