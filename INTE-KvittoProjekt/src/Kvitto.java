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
	
	public double beraknaRabatt(Produkt produkt){
		Rabatt rabatt = new Rabatt();
		return rabatt.beraknaProduktRabatt(produkt);
	}
	
	public void addProdukt(Produkt produkt){
		produkter.add(produkt);
	}
	
	public void removeProdukt(Produkt produkt){
		produkter.remove(produkt);
	}
	
	public ArrayList<Produkt> getProdukter(){
		ArrayList<Produkt> returLista = new ArrayList<Produkt>(produkter);
		return returLista;
	}
	
	public Date getDate(){
		return datum;
	}
	
	public double getTotalPris(){
		totalPris = 0;
		for(Produkt produkt : produkter){
			totalPris += produkt.getPris() * produkt.getMangd();
		}
		return totalPris;
	}
	
}
