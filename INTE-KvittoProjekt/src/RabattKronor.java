
public class RabattKronor extends Rabatt {
	
	private int rabatt;
	
	public RabattKronor(int rabatt){
		this.rabatt = rabatt;
	}
	
	public Pengar berakna(Produkt produkt){
		Pengar p = new Pengar(rabatt);
		p.multiply(produkt.getMangd());
		return p;
	}
	
}
