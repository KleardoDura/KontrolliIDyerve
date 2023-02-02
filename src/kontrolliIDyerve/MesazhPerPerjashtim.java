package kontrolliIDyerve;

public class MesazhPerPerjashtim extends Exception{
	public String mesazhi;
	
	public MesazhPerPerjashtim (String eMesazhi) {
		mesazhi=eMesazhi;
	}
	public String getMesazh() {
		return mesazhi;
	}
}
