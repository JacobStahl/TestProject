
public class Produkt {
	
	private int produktNr;
	private String produktNamn;
	private String produktTyp;
	private float pris;
	private int rabattTyp;
	private float rabattKronor;
	
	
	public Produkt(int produktNr, String produktNamn, String produktTyp, float pris){
		
		this.produktNr = produktNr;
		this.produktNamn = produktNamn;
		this.produktTyp = produktTyp;
		this.pris = pris;
		
	}
	
public Produkt(int produktNr, String produktNamn, String produktTyp, float pris, int rabattTyp, float rabattKronor){
		
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
	
	public void setPris(float pris)
	{
		this.pris = pris;
	}
	
	public float getPris()
	{
		return pris;
	}
	
	public int getRabattTyp(){
		return rabattTyp;
	}
	
	public float getRabattKronor(){
		return rabattKronor;
	}
}
