//cd desktop/JavaCoding/JavaExercises
/*Day 3 Ex15 - Overlaps
Write a program that reads the coordinates of four point points, 
the former two defining one rectangle and the latter two defining 
another one. The program must read the coordinates of a fifth 
point and say whether the point is inside both rectangles, inside 
one of them only, or out of both. */
public class Overlaps
{
	public static void main(String args[])
	{
		//rectangle 1
		System.out.println("Enter x and then y coordinates of a point for 1st rectangle");
		String input=System.console().readLine();
		int p1_x=Integer.parseInt(input);
		input=System.console().readLine();
		int p1_y=Integer.parseInt(input);
		Point p1=new Point(p1_x,p1_y);		
		System.out.println("Enter x and then y coordinates of another point for 1st rectangle");
		input=System.console().readLine();
		int p2_x=Integer.parseInt(input);
		input=System.console().readLine();
		int p2_y=Integer.parseInt(input);
		Point p2=new Point(p2_x,p2_y);
		Rectangle r1=new Rectangle(p1,p2);		
		//rectangle 2
		System.out.println("Enter x and then y coordinates of a point for 2nd rectangle");
		input=System.console().readLine();
		int p3_x=Integer.parseInt(input);
		input=System.console().readLine();
		int p3_y=Integer.parseInt(input);
		Point p3=new Point(p3_x,p3_y);		
		System.out.println("Enter x and then y coordinates of another point for 2nd rectangle");
		input=System.console().readLine();
		int p4_x=Integer.parseInt(input);
		input=System.console().readLine();
		int p4_y=Integer.parseInt(input);
		Point p4=new Point(p4_x,p4_y);		
		Rectangle r2=new Rectangle(p3,p4);			
		//random point
		System.out.println("Enter x and then y coordinates of a random point");
		input=System.console().readLine();
		int p5_x=Integer.parseInt(input);
		input=System.console().readLine();
		int p5_y=Integer.parseInt(input);
		Point p5=new Point(p5_x,p5_y);
		boolean inRecOne=r1.inRec(r1,p5);
		boolean inRecTwo=r2.inRec(r2,p5);
		if(inRecOne&&inRecTwo==true)
		{
			System.out.println("The point is within both rectangles");
		}
		else
		{
			System.out.printf("The point is %swithin 1st rectangle",inRecOne?"":"not ");
			System.out.printf("The point is %swithin 2nd rectangle",inRecTwo?"":" not");
		}
	}
}
class Rectangle
{
	private Point pA;
	private Point pB;
	public Rectangle(Point pA,Point pB)
	{
		this.pA=pA;
		this.pA=pB;
	}
	public Rectangle(){}
	public boolean inRec(Rectangle rect,Point randP)
	{
		boolean withinX=withinAbsc(rect.pA.getx(),rect.pA.getx(),randP.getx());
		boolean withinY=withinOrdin(rect.pA.gety(),rect.pB.gety(),randP.gety());
		return withinX&&withinY;
	}
	public boolean withinAbsc(int p1x,int p2x,int rPx)
	{
		boolean result=false;
		if(p1x>p2x)
		{
			result=(rPx>p2x&&rPx<p1x);
		}
		else
		{
			result=(rPx<p2x&&rPx>p1x);
		}
		return result;
	}
	public boolean withinOrdin(int p1y,int p2y,int rPy)
	{
		boolean result=false;
		if(p1y>p2y)
		{
			result=(rPy>p2y&&rPy<p1y);
		}
		else
		{
			result=(rPy<p2y&&rPy>p1y);
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