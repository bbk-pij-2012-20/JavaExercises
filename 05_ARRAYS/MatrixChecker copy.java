//cd desktop/JavaCoding/JavaExercises

public class MatrixChecker
{
	//can this be done recursively??- I think not	
	public boolean isSymmetrical(int[] aryInt)
	{
		int i=0;
		boolean isSym=true;
		while(isSym&&i<aryInt.length/2)
		{
			if(aryInt[i]!=aryInt[(aryInt.length-1)-i])
			{
				isSym=false;
			}
			i++;
		}
		return isSym;
	}
	
	public boolean isSymmetrical(int[][] matInt)
	{
		int i=0;
		int j=i+1;
		boolean isSym=true;
		while(isSym&&i<matInt.length)
		{
			while(j<matInt.length)
			{
				if(matInt[i][j]!=matInt[j][i])
				{
					isSym=false;
				}
				j++;
			}
			i++;
		}
		return isSym;	
	}
/*	  0 1 2 3 4 5 j
	0 o d f h . .
	1 d o s g . . 
	2 f s o x . . 
	3 h g x o . .
	i
*/	
	public boolean isTriangular(int[][] matInt)
	{
		return false;
	}
}