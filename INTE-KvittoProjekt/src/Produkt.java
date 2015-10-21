
public class Produkt {
	
	private int produktNr;
	private String produktNamn;
	private String produktTyp;
	private double pris;
	private int rabattTyp;
	private double rabattKronor;
	
	
	public Produkt(int produktNr, String produktNamn, String produktTyp, double pris){
		
		this.produktNr = produktNr;
		this.produktNamn = produktNamn;
		this.produktTyp = produktTyp;
		this.pris = pris;
		
	}
	
public Produkt(int produktNr, String produktNamn, String produktTyp, double pris, int rabattTyp, double rabattKronor){
		
		this.produktNr = produktNr;
		this.produktNamn = produktNamn;
		this.produktTyp = produktTyp;
		this.pris = pris;
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
	
	public double getRabattKronor(){
		return rabattKronor;
	}
}
