//import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.rmi.RemoteException;
import java.rmi.Remote;

public interface TDService extends Remote {
	
	String getTimeDate() throws RemoteException;		

}