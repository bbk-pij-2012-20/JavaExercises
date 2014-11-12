// cd desktop/JavaCoding/JavaExNoGIT/d19Ex_noGIT

// localhost
// 127.0.0.1

//1st step in offering a service using RMI is to define the
// interface of the service.

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.io.Serializable;
 
/**
 * An implementation of the echo service.
 */
public interface EchoService extends Remote 
{
   /**
	* Returns the same string passed as parameter 
	* @param s a string
	* @return the same string passed as parameter 
	*/
	public String echo(String s) throws RemoteException; 
}