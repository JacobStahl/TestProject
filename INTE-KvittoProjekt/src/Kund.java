
public class Kund {
	
	private int kundNr;
	private String forNamn;
	private String efterNamn;
	private String telefonNummer;
	private String adress;
	private Rabatt rabattTyp;
	
	public Kund(int kundNr, String forNamn, String efterNamn, String telefonNummer, String adress){
		this.kundNr = kundNr;
		this.forNamn = forNamn;
		this.efterNamn = efterNamn;
		this.telefonNummer = telefonNummer;
		this.adress = adress;
		
	}
	
	public Kund(int kundNr, String forNamn, String efterNamn, String telefonNummer, String adress, Rabatt rabattTyp){
		this.kundNr = kundNr;
		this.forNamn = forNamn;
		this.efterNamn = efterNamn;
		this.telefonNummer = telefonNummer;
		this.adress = adress;
		this.rabattTyp = rabattTyp;
		
	}
	
	public int getKundNr(){
		return kundNr;
	}
	
	public void setKundNr(int kundNr){
		this.kundNr = kundNr;
	}
	
	public String getForNamn(){
		return forNamn;
	}
	
	public void setForNamn(String forNamn){
		this.forNamn = forNamn;
	}
	
	public String getEfterNamn(){
		return efterNamn;
	}
	
	public void setEfterNamn(String efterNamn){
		this.efterNamn = efterNamn;
	}
	
	public String getTelefonNummer(){
		return telefonNummer;
	}
	
	public void setTelefonNummer(String telefonNummer){
		this.telefonNummer = telefonNummer;
	}
	
	public String getAdress(){
		return adress;
	}
	
	public void setAdress(String adress){
		this.adress = adress;
	}

	public Rabatt getRabattTyp() {
		return rabattTyp;
	}
	
	
	
}
