import java.util.ArrayList;
import java.util.Date;


public class Kvitto {
	
	private double totalPris;
	private Date datum;
	private int kvittoNummer;
	private ArrayList<Produkt> produkter;
	
	public Kvitto(int kvittoNummer){
		this.datum = new Date();
		this.kvittoNummer = kvittoNummer;
		produkter = new ArrayList<Produkt>();
	}
	
}
