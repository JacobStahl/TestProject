

public class Produkt {
	
	private int produktNr;
	private String produktNamn;
	private String produktTyp;
	private Pengar pris;
	private int rabattTyp;
	private double rabattKronor;
	private int mangd;
	
	
	public Produkt(int produktNr, String produktNamn, String produktTyp, Pengar pris, int mangd){
		
		this.produktNr = produktNr;
		this.produktNamn = produktNamn;
		this.produktTyp = produktTyp;
		this.pris = pris;
		this.mangd = mangd;
		
	}
	
public Produkt(int produktNr, String produktNamn, String produktTyp, Pengar pris, int mangd, int rabattTyp, double rabattKronor){
		
		this.produktNr = produktNr;
		this.produktNamn = produktNamn;
		this.produktTyp = produktTyp;
		this.pris = pris;
		this.mangd = mangd;
		this.rabattTyp = rabattTyp;
		this.rabattKronor = rabattKronor;
		
	}

public Produkt(int produktNr, String produktNamn, String produktTyp, int pris, int mangd){
	
	this.produktNr = produktNr;
	this.produktNamn = produktNamn;
	this.produktTyp = produktTyp;
	this.pris = new Pengar(pris);
	this.mangd = mangd;
	
}

public Produkt(int produktNr, String produktNamn, String produktTyp, int pris, int mangd, int rabattTyp, double rabattKronor){
	
	this.produktNr = produktNr;
	this.produktNamn = produktNamn;
	this.produktTyp = produktTyp;
	this.pris = new Pengar(pris);
	this.mangd = mangd;
	this.rabattTyp = rabattTyp;
	this.rabattKronor = rabattKronor;
	
}
	
	public void setProduktNr(int produktNr)
	{
		this.produktNr = produktNr;		
	}
	
	public int getProduktNr()
	{
		return produktNr;
	}
	
	public void setProduktNamn(String produktNamn)
	{
		this.produktNamn = produktNamn;
	}
	
	public String getProduktNamn()
	{
		return produktNamn;
	}
	
	public void setProduktTyp(String produktTyp)
	{
		this.produktTyp = produktTyp;
	}
	
	public String getProduktTyp()
	{
		return produktTyp;
	}
	
	public void setPris(Pengar pris)
	{
		this.pris = pris;
	}
	
	public Pengar getPris()
	{
		return pris;
	}
	
	public int getRabattTyp(){
		return rabattTyp;
	}
	
	public void setRabattTyp(int rabattTyp){
		this.rabattTyp = rabattTyp;
	}
	
	public double getRabattKronor(){
		return rabattKronor;
	}
	
	public void setRabattKronor(int rabattKronor){
		this.rabattKronor = rabattKronor;
	}
	
	public void setMangd(int mangd){
		this.mangd = mangd;
	}
	
	public int getMangd(){
		return mangd;
	}
	
	public String toString(){
		return mangd + " * " + produktNamn + " " + pris.print();
	}
}
