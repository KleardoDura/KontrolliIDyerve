package kontrolliIDyerve;
import java.sql.DriverManager;
import java.sql.Statement;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;

public class MenaxhimiIDyerve extends UnicastRemoteObject implements MenaxhimiIDyerveInterface {
	public MenaxhimiIDyerve() throws RemoteException{
		super(); // Handling all exception
	}
	public void menu() {
		new Menu();
	}
	/* Ketu do te ishte funksioni main nese nuk do te kishim klasat Client dhe Server
	 * public static void main(String[] args)  {
		new Menu();	}*/
}
