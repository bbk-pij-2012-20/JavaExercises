import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
//import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TDServer extends UnicastRemoteObject implements TDService {

	public TDServer() throws RemoteException {}
	
	@Override
 	public String getTimeDate() throws RemoteException {
		
		Calendar date = Calendar.getInstance();
		return ""+date.getTime();
		
	}

}

//java -Djava.security.policy=TDSecurity.txt TDLauncher