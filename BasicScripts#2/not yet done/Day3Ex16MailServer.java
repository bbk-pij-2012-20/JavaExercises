public class Day3Ex16MailServer
{
	public static void main(String[] args)
	{
		boolean valid=false;
		
		System.out.println("Welcome to my mail server");
		System.out.println("Enter return address as follows.");
		System.out.println("MAIL FROM: <email-address>");
		System.out.print("MAIL FROM: ");
		String fromMail=System.console().readLine();
		
		if(fromMail.equalsIgnoreCase("quit"))
		{
			System.exit(0);
		}
		
		for(int i=1;i<fromMail.length()-1;i++)
		{
			if(fromMail.charAt(i)=='@')
			{
				valid=true;
			}
		}
		while(!valid)
		{
			System.out.println("invalid email address, try again");
			System.out.print("MAIL FROM: ");
			fromMail=System.console().readLine();	
			if(fromMail.equalsIgnoreCase("quit"))
			{
				System.exit(0);
			}

			for(int i=1;i<fromMail.length()-1;i++)
			{
				if(fromMail.charAt(i)=='@')		
				{
					valid=true;
				}
			}
		}
		System.out.println("OK");

		valid=false;
		System.out.println("Enter recipient address as follows.");
		System.out.println("RCPT TO: <email-address>");
		System.out.print("RCPT TO: ");
		String toMail=System.console().readLine();		
		
		if(toMail.equalsIgnoreCase("quit"))
		{
			System.exit(0);
		}

		for(int i=1;i<toMail.length()-1;i++)
		{
			if(toMail.charAt(i)=='@')
			{
				valid=true;
			}
		}
		while(!valid)
		{
			System.out.println("invalid email address, try again");
			System.out.print("RCPT TO: ");
			toMail=System.console().readLine();		
			if(toMail.equalsIgnoreCase("quit"))
			{
				System.exit(0);
			}

			for(int i=1;i<toMail.length();i++)
			{
				if(toMail.charAt(i)=='@')
				{
					valid=true;
				}
			}
		}
		System.out.println("OK");	

		System.out.println("Enter data, end with '.' ");
		System.out.println("MESSAGE: <DATA>");		
		String[] wholeMessage=new String[20];
	
		int i=1;		
		boolean stop=false;
		
		while(stop==false)
		{
			System.out.print("MESSAGE - Line "+i+": ");
			String message=System.console().readLine();
			if(message.equalsIgnoreCase("quit"))
			{
				System.exit(0);
			}

			if(message.equals("."))
			{
				stop=true;
			}
			else
			{
				wholeMessage[i]=message;
				i++;					
			}
		}						
			
		System.out.println("Sending email....\nfrom: "+fromMail+"\nto: "+toMail)	;	
		int j=1;
		while(j<wholeMessage.length)
		{
			if(wholeMessage[j]==null)
			{
				break;
			}
			else
			{
				System.out.println("line "+j+": "+wholeMessage[j]);
				j++;
			}
		}
	}
}