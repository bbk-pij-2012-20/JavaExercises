//cd desktop/JavaCoding/JavaExercises
/* Day4 Ex 4 - Binary and decimal
Create a program in which you define the following methods:
binary2decimal(String): takes from the user a binary number 
(with digits 0 and 1) and returns the corresponding number 
in decimal (base-10, with digits between 0 and 9). Hint: in 
the same way that you know that 35 = 3 · 101 + 5 · 100, you 
can find that 100011 = 1 · 25 + 1 · 21 + 1 · 20.
decimal2binary(int): the opposite of the previous one: takes 
a decimal number and returns the corresponding binary number. 
Hint: instead of multiplying by 2, you will need to divide 
by two this time.
The program must offer a menu to the user with two options. 
The first one takes a binary number from the user and returns 
the corresponding decimal number. The second one does the 
opposite: takes a decimal number and returns a binary number. 
The program should use the methods defined.
*/
public class BinaryDecimal
{
	public static void main(String args[])
	{
		BinaryDecimal bd=new BinaryDecimal();
		String binary="1101";
		System.out.println(binary+" converted to decimal: "+bd.binary2decimal(binary));
//		1101. decInt=(1x(1))+(0x(2))+1x(2x2)+1x(2x2x2)=1+4+8=13 Hence result should be 13.0 
	}
	public double binary2decimal(String binary)
	{
		double decInt=0;
		int binInt=0;
		for(int i=binary.length()-1;i>=0;i--)
		{
			binInt=Integer.parseInt(binary.substring(i,i+1));
			decInt+=binInt*Math.pow(2,(binary.length()-1)-i);
		}
		return decInt;
	}
}