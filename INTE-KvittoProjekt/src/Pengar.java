
public class Pengar {
	private int kronor;
	private int oren;
	private int varde;
	
	public Pengar(int varde){
		this.varde = varde;
		konvertera();
	}
	
	public int getPengar(){
		return varde;
	}
	
	public String print(){
		if(oren < 10)
			return kronor + "," + "0" + oren;
		
		return kronor + "," + oren;
	}
	
	public void add(int varde){
		this.varde += varde;
		konvertera();
	}
	
	public void set(int varde){
		this.varde = varde;
		konvertera();
	}
	
	public void multiply(double d){
		varde = (int) Math.round(varde * d);
		konvertera();
	}
	
	private void konvertera(){
		kronor = varde / 100;
		oren = varde % 100;
	}
	
	public void setPengar(int varde){
		this.varde = varde;
		konvertera();
	}
	
}
	

