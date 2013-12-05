//cd desktop/JavaCoding/JavaExercises

/*Day 3 Ex12 - Distance point–to–point
Write a program that reads the X and Y coordinates of three points and then 
outputs which of the three are closer. 
Use the following class to store the data for the points: */

//code below does not account for distances being the same...
public class PointToPoint
{
	public static void main(String args[])
	{
		Point p1=new Point(1,2);
		Point p2=new Point(3,4);
		Point p3=new Point(6,7);
		double distP1_P2=p1.calcDist(p1,p2);
		double distP1_P3=p1.calcDist(p1,p3);
		double distP2_P3=p2.calcDist(p2,p3);		
		PointToPoint ptp=new PointToPoint();
		System.out.println("The closest two points are: "+ptp.getClosest(distP1_P2,distP1_P3,distP2_P3));
	}
	public String getClosest(double distP1_P2,double distP1_P3,double distP2_P3)
	{
		String closer="";
		if(distP1_P2<distP1_P3)
		{
			closer="P1_P2";
			if(distP1_P2<distP2_P3)
			{
				closer="P1_P2";
			}
			else
			{
				closer="P2_P3";
			}
		}
		else
		{
			if(distP1_P3<distP2_P3)
			{
				closer="P1_P3";
			}
			else
			{
				closer="P2_P3";
			}
		}
		return closer;
	}
}
//Is it mathematically corrected to calculate the shorter distance as a sum of the 
//distance of each ordinate, rather than the hypothenuse ?
//If we assume it is, then the code for this is shown below:
class Point 
{
	private double x=0;
	private double y=0;	
	public Point(double x,double y)
	{
		this.x=x;
		this.y=y;
	}
	public double calcDist(Point point1,Point point2)
	{
		return (Math.abs(point1.x-point2.x)+(Math.abs(point1.y-point2.y)));
	}
}