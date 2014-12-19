// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/BasicScripts#2
// Exercise 3.16 (Learning the basics. All code inside main method.)

/*
Let’s implement part of a mail server. A mail server is a program that takes your 
emails and then sends them to the appropriate recipient. In this exercise, you will 
implement a simplified version of the SMTP protocol that is used to send emails over 
the Internet. When your program starts, it should provide a command prompt to the user. 
Then it must read the return address of the email using a command of the form 
“MAIL FROM: <email-address>”. The program must check that the command is properly 
written and that the email address is valid (i.e. contains one and only one “@” sign 
which is neither the first nor the last character). There is no need for the email 
address to actually exist, it only needs to be valid. If there is an error, the program 
must say so and wait for a correct return address. Once the destination is correct, the 
program must say “OK” and wait for the recipient. The recipient must be introduced by 
the user with a command of the form “RCPT FROM: <email-address>”. Once again, if the user
enters an invalid command or email address, the program must wait for a correct one.
Once the return address and recipient are correct, and only then, the user can enter 
the command “DATA”. The program reads then the body of the email, line after line, 
until the user enters a line that consists of only a dot. At that point, the email is 
ready and the program must write on the screen who is sending the email, to whom,
and what the email says. If at any point the users types “QUIT” the program must 
terminate. If the user enters any other command, or types one of these commands at the 
wrong time (e.g. RCPT before MAIL), the program must say “Invalid command” on screen. 
See a simple example below:
*/

public class MailServerVersion1 {

	public static void main(String[] args) {
	
		boolean valid = false;
		System.out.println("Welcome to my mail server");
		System.out.println("Enter return address as follows.");
		System.out.println("MAIL FROM: <email-address>");
		System.out.print("MAIL FROM: ");
		String fromMail = System.console().readLine();
		
		if (fromMail.equalsIgnoreCase("quit")) {

			System.exit(0);
		
		}
		
		for (int i = 1; i < fromMail.length() - 1; i++)	{

			if (fromMail.charAt(i) == '@') {

				valid = true;
			
			}
		
		} while (!valid) {
		
			System.out.println("invalid email address, try again");
			System.out.print("MAIL FROM: ");
			fromMail = System.console().readLine();	
			if (fromMail.equalsIgnoreCase("quit")) {
			
				System.exit(0);
			
			}

			for (int i = 1; i < fromMail.length() - 1; i++)	{
				
				if (fromMail.charAt(i) == '@')	{
			
					valid = true;
				
				}
			
			}
		
		}
		
		System.out.println("OK");
		valid = false;
		System.out.println("Enter recipient address as follows.");
		System.out.println("RCPT TO: <email-address>");
		System.out.print("RCPT TO: ");
		String toMail = System.console().readLine();		
		
		if (toMail.equalsIgnoreCase("quit")) {

			System.exit(0);

		}

		for (int i = 1; i < toMail.length() - 1; i++) {

			if (toMail.charAt(i) == '@') {
			
				valid = true;
		
			}
		
		} while (!valid) {
		
			System.out.println("invalid email address, try again");
			System.out.print("RCPT TO: ");
			toMail = System.console().readLine();		
			
			if (toMail.equalsIgnoreCase("quit")) {
				
				System.exit(0);
				
			}

			for (int i = 1; i < toMail.length(); i++) {

				if (toMail.charAt(i) == '@') {
					
					valid = true;
					
				}
			
			}
	
		}
	
		System.out.println("OK");	
		System.out.println("Enter data, end with '.' ");
		System.out.println("MESSAGE: <DATA>");		
		String[] wholeMessage = new String[20];
		int i = 1;		
		boolean stop = false;
		
		while (stop == false) {
		
			System.out.print("MESSAGE - Line "+i+": ");
			String message = System.console().readLine();
			
			if (message.equalsIgnoreCase("quit")) {

				System.exit(0);

			}

			if (message.equals(".")) {
			
				stop = true;
			
			} else {
				
				wholeMessage[i] = message;
				i++;					
			
			}
		
		}						
			
		System.out.println("Sending email....\nfrom: " + fromMail + "\nto: " + toMail);	
		int j = 1;
		
		while (j < wholeMessage.length) {
		
			if (wholeMessage[j] == null) {
			
				break;
			
			} else {
				
				System.out.println("line " + j + ": " + wholeMessage[j]);
				j++;
			
			}
	
		}
		
	}

}