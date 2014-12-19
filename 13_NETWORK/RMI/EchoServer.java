// cd desktop/JavaCoding/JavaExNoGIT/d19Ex_noGIT
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.Serializable; //??

public class EchoServer extends UnicastRemoteObject implements EchoService 
{
	public EchoServer() throws RemoteException
	{ 
		// nothing to initialise for this server
	}
	@Override
	public String echo(String s)
	{	
		// This println is not necessary, but helps verifying whether 
		// the server has received the call or not on the remote machine 
		System.out.println("Replied to some client saying ’"+s+"’"); 
		return s;
	}
}

//java -Djava.security.policy=EchoSecurity.txt EchoLauncher