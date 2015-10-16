
public class Produkt {
	
	private int produktNr;
	private String produktNamn;
	private String produktTyp;
	private int pris;
	
	
	public Produkt(int produktNr, String produktNamn, String produktTyp, int pris){
		
		this.produktNr = produktNr;
		this.produktNamn = produktNamn;
		this.produktTyp = produktTyp;
		this.pris = pris;
		
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
	
	public void setPris(int pris)
	{
		this.pris = pris;
	}
	
	public int getPris()
	{
		return pris;
	}
	
}
