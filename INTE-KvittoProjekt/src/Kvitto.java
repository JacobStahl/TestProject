import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;


public class Kvitto {
	
	private Pengar totalPris = new Pengar(0000);
	private Date datum = new Date();
	private int kvittoNummer;
	private ArrayList<Produkt> produkter;
	private Kund kund;
	
	public Kvitto(int kvittoNummer){
		this.kvittoNummer = kvittoNummer;
		produkter = new ArrayList<Produkt>();
	}
	
	public Kvitto(int kvittoNummer, Kund kund){
		this.kvittoNummer = kvittoNummer;
		produkter = new ArrayList<Produkt>();
		this.kund = kund;
	}
	
	public int beraknaRabatt(Produkt produkt){
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
	
	private Pengar getTotalPris(){
		totalPris.setPengar(0000);
		for(Produkt produkt : produkter){
			totalPris.add(produkt.getPris().getPengar() * produkt.getMangd());
		}
		return totalPris;
	}
	
	public String print(){
		String utskrift = "";
		Pengar totalRabatt = new Pengar(0);
		
		utskrift += "Foo Bar" + "\n";
		utskrift += "\n";
		utskrift += "Kvittonummer: " + kvittoNummer + "\n";
		utskrift += "\n";
		
		for(Produkt produkt : produkter){
			int rabatt = 0;
			rabatt = beraknaRabatt(produkt);
			totalRabatt.add(rabatt);
			if(rabatt != 0){
				utskrift += produkt + "\n";
				utskrift += "	Rabatt: -" + df.format(rabatt) + "\n";
				
			}else{
				utskrift += produkt + "\n";
			}
		}
		
		utskrift += "\n";
		utskrift += "Totalt kr: " + df.format((getTotalPris()-totalRabatt)) + "\n";
		if(totalRabatt != 0){
			utskrift += "Rabatt: " + df.format(totalRabatt) + "\n";
			utskrift += "Totalt före rabatt: " + df.format(getTotalPris()) + "\n";
		}
		utskrift += "\n";
		
		if(kund != null)
			utskrift += "Kundnummer: " + kund.getKundNr() + "\n";
		
		utskrift += "Välkommen åter!" + "\n";
		
		return utskrift;
	}
	
}
