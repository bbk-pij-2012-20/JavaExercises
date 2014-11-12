//cd desktop/JavaCoding/JavaExNoGIT/d6Ex_noGIT
/*Day6 Ex2 - Copying arrays
Create a new Java class called ArrayCopier with a method called copy 
that takes two arrays of integers as param- eters. The method should 
copy the elements of the first array (you can call it src, from “source”) 
to the second one (dst, from “destination”) as much as possible.
If the second array is smaller, then only those elements that fit will 
be copied. If the second array is larger, it will be filled with zeroes.
Write a program that creates an object of this class and uses this method 
to copy some arrays in all three cases: 
• Both arrays are of the same size.
• The source array is longer.
• The source array is shorter.
*/
public class ArrayCopier
{
	public static void main(String args[])
	{
		ArrayCopier ac=new ArrayCopier();
		int[] src1={1,2,3,4};
		int[] dst1=new int[7];//src is smaller
		int[] src2={12,14,16,18};
		int[] dst2=new int[4];//same size
		int[] src3={100,200,300,400,500,600};
		int[] dst3=new int[3];//src is bigger
		ac.copy(src1,dst1);
		for(int i=0;i<dst1.length;i++)
		{
			System.out.println("dst - when src is smaller: "+dst1[i]);
		}
		ac.copy(src2,dst2);
		for(int i=0;i<dst2.length;i++)
		{
			System.out.println("dst - when src is same size: "+dst2[i]);
		}
		ac.copy(src3,dst3);
		for(int i=0;i<dst3.length;i++)
		{
			System.out.println("dst - when src is bigger: "+dst3[i]);
		}
	}
	public void copy(int[] src,int[] dst)
	{
		if(dst.length>src.length)
		{
			for(int i=0;i<src.length;i++)
			{
				dst[i]=src[i];
			}
			for(int i=src.length;i<dst.length;i++)
			{
				dst[i]=0;;
			}
		}
		else
		{
			for(int i=0;i<dst.length;i++)
			{
				dst[i]=src[i];
			}
		}
	}
}