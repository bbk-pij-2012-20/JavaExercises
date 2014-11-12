// cd ~/Desktop/JavaCoding/JavaExNoGIT/d19Ex_noGIT
import java.rmi.Naming;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.Remote;
import java.rmi.NotBoundException;
import java.io.Serializable; 

public class EchoClient {
	public static void main(String args[]) {
		try {
			Remote service = Naming.lookup("//127.0.0.1:1099/echo"); 
			EchoService echoService = (EchoService) service;
//			String receivedEcho = echoService.echo("Hello!");
			System.out.println("Log: The client is going to execute the remote method");
			String receivedEcho = echoService.echo(args[0]); 
//			if you want to enter the text on the line below
			System.out.println("Log: The client has executed the remote method");
			System.out.println("echoing back from server: "+receivedEcho);
		} catch(RemoteException ex) {
			System.out.println("remote exception");
			ex.printStackTrace();
		} catch(NotBoundException ex) {
			System.out.println("not bound exception");
			ex.printStackTrace();
		} catch(Exception ex) {
			System.out.println("exception");
			ex.printStackTrace();
		}
	}
}

//In a new, 2nd terminal:

//java -Djava.security.policy=EchoSecurity.txt EchoClient 

//line below
//java -Djava.security.policy=EchoSecurity.txt EchoClient somewords