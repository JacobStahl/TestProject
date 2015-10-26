
public class RabattKronor extends Rabatt {
	
	private int rabatt;
	
	public RabattKronor(int rabatt){
		this.rabatt = rabatt;
	}
	
	public int berakna(Produkt produkt){
		return rabatt * produkt.getMangd();
	}
	
}
