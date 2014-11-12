// cd desktop/JavaCoding/JavaExNoGIT/d19Ex_noGIT
import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.io.Serializable; 

public class EchoLauncher {
	public static void main(String args[]) {
		EchoLauncher el=new EchoLauncher();
		el.launch();
	}
	private void launch() {
	// 1. If there is no security manager, start one: 
		if (System.getSecurityManager()==null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		try {
	// 2. Create the registry if there isn't one already
			LocateRegistry.createRegistry(1099);
			System.out.println("Log: The server has created a registry");
	// 3. Create the server object
			EchoServer server=new EchoServer();
			System.out.println("Log: The server object is created");
	// 4. Register (bind) the server object on the registy. 
	// The registry may be on a different machine.
			String registryHost="//localhost/";
			String serviceName="echo";
			Naming.rebind(registryHost+serviceName,server);
			System.out.println("Log: The server has bound the service " +serviceName + " at the registry");
		} catch(MalformedURLException ex) {
			ex.printStackTrace();
		} catch(RemoteException ex) {
			ex.printStackTrace();
		}
	}
}