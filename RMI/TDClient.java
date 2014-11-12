//cd ~/Desktop/Quizzy/RMInotesexercises/TDEx2
import java.rmi.Naming;
import java.rmi.Remote;
//import java.io.Serializable;
import java.rmi.NotBoundException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class TDClient {

	public static void main(String[] args) {
		
		try {
	
			Remote r1 = Naming.lookup("//127.0.0.1:1099/Now");
			TDService tds1 = (TDService) r1;
			String now = tds1.getTimeDate();
			System.out.println("Do you want to know the date and time? (y/n)");
			String inp = System.console().readLine().trim().toLowerCase();
			
			if (inp.charAt(0) == 'y') {
				
				System.out.println("Here it is: "+now);

			} else if (inp.charAt(0) == 'n') {
			
				System.out.println("fine, suit yourself");
			
			} else {
			
				System.out.println("invalidico");
		
			}	
		
		} catch (RemoteException e) {
		
			e.printStackTrace();
		
		} catch (NotBoundException e) {
		
			e.printStackTrace();
		
		} catch (Exception e) {
		
			e.printStackTrace();
		
		}
		
	}
	
}

//java -Djava.security.policy=TDSecurity.txt TDClient 