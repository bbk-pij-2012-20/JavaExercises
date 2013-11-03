public class Day1Ex6 // Division
{
//dividing a "dividend" by a "divisor" to give a "quotient" and "remainder"
	public static void main(String[] args)
	{
		System.out.println("input 2 numbers, the dividend followed by the divisor:");
		int dvdnd=Integer.parseInt(System.console().readLine());	
		int dvsr=Integer.parseInt(System.console().readLine());
		boolean frctn=false;
		
		if(dvdnd<dvsr)
		{
			System.out.println(dvdnd+" divided by "+dvsr+" is the fraction: "+dvdnd+"/"+dvsr);
			frctn=true;
		}
		
		int qtnt=0;
		int rmndr=dvdnd;
		while(!frctn) 
		{
			if(rmndr>dvsr)
			{
				qtnt++;
				rmndr-=dvsr;
			}
			else
			{
				System.out.println(dvdnd+" divided by "+dvsr+" is "+qtnt+", remainder "+rmndr);		
				break;
			}
		}
	}
}