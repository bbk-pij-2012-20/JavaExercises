//cd desktop/JavaCoding/JavaExNoGIT/d6Ex_noGIT
/*Day 6 Ex3 - Creating matrices*/
public class Matrix
{
	private int[][] mat2D;
	private int row;
	private int column;
	
	public static void main(String args[])
	{
		Matrix m=new Matrix(3,4);
//		m.printIt();
		m.setRow(2,"1,2,3,4");
		m.setColumn(1,"10,20,30");
//		m.printIt();
		String mat2DStr=m.toString();
		System.out.println("toString()= "+mat2DStr);
//		m.prettyPrint();
	}
	public Matrix(int row,int column)
	{
		this.row=row;
		this.column=column;
		mat2D=new int[row][column];
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<column;j++)
			{
				mat2D[i][j]=1;
			}
		}
	}
	public void printIt()
	{
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<column;j++)
			{
				System.out.print(mat2D[i][j]+" ");
			}
			System.out.print('\n');
		}	
	}
	public void setElement(int row,int column,int numb)
	{
		if(row>this.row||column>this.column)
		{
			System.out.println("invalid");
			return;
		}
		else
		{
			mat2D[row][column]=numb;
		}
	}

	public void setRow(int r,String s)
	{
		if(r>=this.row||r<0)
		{
			System.out.println("row number is invalid");
			return;
		}
		String[] str=s.split(",");
		if(str.length>mat2D[r].length)
		{
			System.out.println("yr string needs more columns");
			return;			
		}
		for(int i=0;i<str.length;i++)
		{
			mat2D[r][i]=Integer.parseInt(str[i]);
		}
	}
	public void setColumn(int c,String s)
	{
		if(c>=this.column||c<0)
		{
			System.out.println("column is invalid");
			return;
		}
		String[] str=s.split(",");
		if(str.length>mat2D.length)
		{
			System.out.println("yr string needs more rows");
			return;
		}
		for(int i=0;i<str.length;i++)
		{
			mat2D[i][c]=Integer.parseInt(str[i]);
		}
	}
	public String toString()
	{
		String aryStr="[";
		for(int i=0;i<mat2D.length;i++)
		{
			for(int j=0;j<mat2D[i].length;j++)
			{
				aryStr+=mat2D[i][j]+",";
			}
			aryStr+=";";
		}
		return aryStr+="]";
	}
	
	public void prettyPrint()
	{
		for(int i=0;i<mat2D.length;i++)
		{
			for(int j=0;j<mat2D[i].length;j++)
			{
				System.out.print(mat2D[i][j]+"\t");
			}
			System.out.println("\n");
		}
	}
}