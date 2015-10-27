
public class RabattTreForTva extends Rabatt{

	public Pengar berakna(Produkt produkt) {
		Pengar rabatt = new Pengar(produkt.getPris().getPengar());
		rabatt.multiply((produkt.getMangd()/3));
		return rabatt;
	}
	
}
