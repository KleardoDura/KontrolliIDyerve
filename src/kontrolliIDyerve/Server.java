package kontrolliIDyerve;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class Server {

	public static void main(String[] args) throws RemoteException {
		//Ekzekutohet e para
			Registry registry =LocateRegistry.createRegistry(8080);
			MenaxhimiIDyerve obj= new MenaxhimiIDyerve();
			registry.rebind("menaxhimi",obj); 
			System.out.println("Server started...");
	}

}
