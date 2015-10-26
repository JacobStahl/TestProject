
public class RabattTreForTva extends Rabatt{

	public int berakna(Produkt produkt) {
		int kalk;
		kalk = produkt.getMangd() / 3;
		return kalk * produkt.getPris().getPengar();
	}
	
}
