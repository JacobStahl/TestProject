
public class Produkt {
	
	private int produktNr;
	private String produktNamn;
	private String produktTyp;
	private double pris;
	private int rabattTyp;
	private double rabattKronor;
	private int mangd;
	
	
	public Produkt(int produktNr, String produktNamn, String produktTyp, double pris, int mangd){
		
		this.produktNr = produktNr;
		this.produktNamn = produktNamn;
		this.produktTyp = produktTyp;
		this.pris = pris;
		this.mangd = mangd;
		
	}
	
public Produkt(int produktNr, String produktNamn, String produktTyp, double pris, int mangd, int rabattTyp, double rabattKronor){
		
		this.produktNr = produktNr;
		this.produktNamn = produktNamn;
		this.produktTyp = produktTyp;
		this.pris = pris;
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
	
	public void setPris(double pris)
	{
		this.pris = pris;
	}
	
	public double getPris()
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
}
