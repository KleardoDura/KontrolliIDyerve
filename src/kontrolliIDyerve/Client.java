package kontrolliIDyerve;

import java.rmi.Naming;

import kontrolliIDyerve.MenaxhimiIDyerveInterface;

public class Client {

	public static void main(String[] args) throws Exception{
		//Ekzekutohet e dyta
		MenaxhimiIDyerveInterface obj=(MenaxhimiIDyerveInterface)Naming.lookup("rmi://localhost:8080/menaxhimi");
		obj.menu();
		System.out.println("Client");
	}

}
