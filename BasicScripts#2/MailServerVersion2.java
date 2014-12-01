// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/BasicScripts#2
// Exercise 3.16 (Learning the basics. Beginning to encapsulate in methods outside main method)

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

public class MailServerVersion2 {

	public static void main(String[] args) {
	
		MailServerVersion2 ms = new MailServerVersion2();
		
		System.out.println("start by entering sender, then recipient address");
		boolean validRCPTAddress = false;
		boolean validFROMAddress = false;
		String from = "";
		String rcpt = "";
				
		while (!validRCPTAddress) {
		
			while (!validFROMAddress) {
			
				System.out.print("MAIL FROM: ");
				from = System.console().readLine();
				validFROMAddress = ms.isValid(from);
		
				if (validFROMAddress) {
				
					continue;	
				
				} else {
		
					System.out.println("Invalid FROM address");
	
				}
			
			} 
			
			System.out.println("OK");
			System.out.print("RCPT FROM: ");
			rcpt = System.console().readLine();
			validRCPTAddress = ms.isValid(rcpt);
		
			if (validRCPTAddress) {
			
				continue;
						
			} else {
			
				System.out.println("Invalid RCPT address");			
						
			}
		
		}
		
		
		System.out.print("Input subject of email: ");
		String subject = System.console().readLine();		
		System.out.print("write email message: \n");
		ms.readEmail(from, rcpt, subject);
	
	}	
	
	public boolean isValid(String s) {
		
		return hasOneAndOnlyOneAtSymbol(s) && s.charAt(0) != '@' && s.charAt(s.length()-1) != '@';
	
	}
	
	public boolean hasOneAndOnlyOneAtSymbol(String s) {
	
		int oneAt = 0;
		int i = 0;
	
		while (i < s.length() && oneAt < 2) {
		
			if (s.charAt(i) == '@') {
			 	
			 	oneAt++;
			
			}
			
			i++;
			
		}
		
		return oneAt == 1;
	
	}
	
	public void readEmail(String from, String rcpt, String subject) {
	
		int i = 0;
		StringBuilder email = new StringBuilder();
		boolean writingEmail = true;
		String newLineOfEmail = "";		
		
		while (writingEmail) {
		
			newLineOfEmail = System.console().readLine();
			email.append(newLineOfEmail);
						
			if (newLineOfEmail.trim().length() == 1) {
		
				if (newLineOfEmail.charAt(0) == '.') {
				
					System.out.println("terminated");
					writingEmail = false;
								
				}
						
			}
			
			if (newLineOfEmail.contains("QUIT")) {
			
				System.out.println("terminated");
				writingEmail = false;

			}

			email.append("\n");
		
		}

		System.out.println("\n----------------------\nSender: " + from + "\nRecipient: " + rcpt + "\nSubject: " + subject + "\n----------------------\n" + email);

	}

}