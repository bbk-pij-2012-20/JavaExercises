// cd desktop/JavaCoding/JavaExercises
/*Day3 Ex14 - Inside or outside
Write a program that reads the coordinates of the two points 
defining a rectangle and then the coordinates of a third point. 
The program must then determine whether the point falls inside 
or outside the rectangle. */

public class InsideOrOutside
{
	public static void main(String args[])
	{
		System.out.println("enter x then y coordinates of one corner");
		String input=System.console().readLine();
		int corner1_x=Integer.parseInt(input);
		input=System.console().readLine();
		int corner1_y=Integer.parseInt(input);
		Point p1=new Point(corner1_x,corner1_y);		
		
		System.out.println("enter x then y coordinates of opposite corner");
		int corner2_x=Integer.parseInt(System.console().readLine());
		int corner2_y=Integer.parseInt(System.console().readLine());
		Point p2=new Point(corner2_x,corner2_y);
		
		System.out.println("enter x then y coordinates of random point");
		int point3_x=Integer.parseInt(System.console().readLine());
		int point3_y=Integer.parseInt(System.console().readLine());
		Point p3=new Point(point3_x,point3_y);
		
		Rectangle r1=new Rectangle(p1,p2);
		boolean withinRectangle=r1.withinAbscissaBoundaries(p1.getx(),p2.getx(),p3.getx())&&r1.withinOrdinateBoundaries(p1.gety(),p2.gety(),p3.gety());
		System.out.printf("The random point is %swithin the rectangle\n",withinRectangle?"":"not ");
	}
}
class Rectangle
{
	private Point point1;
	private Point point2;
	public Rectangle(Point point1,Point point2)
	{
		this.point1=point1;
		this.point2=point2;
	}
	public boolean withinAbscissaBoundaries(int p1_x,int p2_x,int p3_x)
	{
		boolean result;
		if(p1_x<p2_x)
		{
			result=p3_x>p1_x&&p3_x<p2_x;
		}
		else
		{
			result=p3_x>p2_x&&p3_x<p1_x;
		}
		return result;
	}
	public boolean withinOrdinateBoundaries(int p1_y,int p2_y,int p3_y)
	{
		boolean result;
		if(p1_y<p2_y)
		{
			result=p3_y>p1_y&&p3_y<p2_y;
		}
		else
		{
			result=p3_y>p2_y&&p3_y<p1_y;
		}
		return result;
	}
}
class Point
{
	private int x;
	private int y;
	public Point(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public int getx()
	{
		return x;
	}
	public int gety()
	{
		return y;
	}
}