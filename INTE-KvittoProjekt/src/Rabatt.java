
public class Rabatter {

	private String rabattTyp;
	private int rabattProcent;
	private int rabattMultipel; 
	
	
	public Rabatter(String rabattTyp, int rabattProcent, int rabattMultipel)
	{
		this.rabattTyp = rabattTyp;
		this.rabattProcent = rabattProcent;
		this.rabattMultipel = rabattMultipel;
	}
	
	public void setrabattTyp(String rabattTyp)
	{
		this.rabattTyp = rabattTyp;		
	}
	
	public String getrabattTyp()
	{
		return rabattTyp;
	}
	
	public void setrabattProcent(int rabattProcent)
	{
		this.rabattProcent = rabattProcent;		
	}
	
	public int getrabattProcent()
	{
		return rabattProcent;
	}
	
	public void setrabattMultipel(int rabattMultipel)
	{
		this.rabattMultipel = rabattMultipel;		
	}

	
	public int getrabattMultipel()
	{
		return rabattMultipel;
	}
	
	
	
	
	
	
}
