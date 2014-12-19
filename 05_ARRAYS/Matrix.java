// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/Arrays
// Exercise 6.3 (Arrays)
/* 
Create a class Matrix that has a 2-D array of integers as a field. The class should have 
methods for:
• a constructor method Matrix(int,int) setting the size of the array as two integers 
(not necessarily the same). All elements in the matrix should be initialised to 1.
• a method setElement(int,int,int) to modify one element of the array, given its position 
(the first two integers) and the new value to be put in that position (the third integer). 
The method must check that the indices are valid before modifying the array to avoid an 
IndexOutOfBoundsException. If the indeces are invalid, the method will do nothing and the 
third argument will be ignored.
• a method setRow(int,String) that modifies one whole row of the array, given its position 
as an integer and the list of numbers as a String like “1,2,3”. The method must check 
that the index is valid and the numbers are correct (i.e. if the array has three columns, 
the String contains three numbers). If the index or the String is invalid, the method will 
do nothing.
• a method setColumn(int,String) that modifies one whole column of the array, given its 
position as an integer and the list of numbers as a String like “1,2,3”. The method must 
check that the index is valid and the numbers are correct (i.e. if the array has four 
rows, the String contains four numbers). If the index or the String is invalid, the method 
will do nothing.
• a method toString() that returns the values in the array as a String using square 
brackets, commas, and semicolons, e.g. “[1,2,3;4,5,6;3,2,1]”.
• A method prettyPrint() that prints the values of the matrix on screen in a legible 
format. Hint: you can use the special character ’\t’ (backslash-t) to mark a tabulator so 
that all numbers are placed in the same column regardless of their size. You can think of 
a tabulator character as a move-to-the-next-column command when printing on the screen.
Create a Groovy program that uses all those methods from the Matrix class: creates 
matrices, modifies its elements (one-by-one, by rows, and by columns), and prints the 
matrix on the screen.
*/
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