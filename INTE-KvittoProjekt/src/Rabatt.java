
public class Rabatt {

	private int rabattTyp;
	
	public double beraknaProduktRabatt(Produkt produkt){
		
		this.rabattTyp = produkt.getRabattTyp();
		
		switch (rabattTyp) {
		case 0:
			return treForTva(produkt);
		case 1:
			return rabattKronor(produkt);
		default:
			return 0f;
		}
	}
	
	private double treForTva(Produkt produkt){
		int kalk;
		kalk = produkt.getMangd() / 3;
		return kalk * produkt.getPris();
	}
	
	private double rabattKronor(Produkt produkt){
		return produkt.getRabattKronor() * produkt.getMangd();
	}
	
	public double beraknaKundRabatt(Kund kund, double totalPris){
		
		this.rabattTyp = kund.getRabattTyp();
		
		switch (rabattTyp){
		case 0:
			return tioProcentRabatt(totalPris);
		default:
			return 0f;
		}
	}
	
	private double tioProcentRabatt(double totalPris){
		return totalPris * 0.1f;
	}
	
}
