//cd ~/Desktop/Quizzy/RMInotesexercises/TDEx2
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
//import java.io.Serializable; 

public class TDLauncher {

	public static void main(String[] args) {
		
		TDLauncher tdl1 = new TDLauncher();
		tdl1.launch();
		
	}
	
	public void launch(){
		
		if (System.getSecurityManager() == null) {
			
			System.setSecurityManager(new RMISecurityManager());
			
		}
		
		try {
			
			LocateRegistry.createRegistry(1099);
			TDServer tdserv1 = new TDServer();
			String registryHost = "//localhost/";
			String serviceName = "Now";
			Naming.rebind(registryHost+serviceName,tdserv1);
			
		} catch (MalformedURLException e) {
		
			e.printStackTrace();
						
		} catch (RemoteException e) {
		
			e.printStackTrace();
		
		}
	}
}


//java -Djava.security.policy=TDSecurity.txt TDLauncher