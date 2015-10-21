
public class Rabatt {

	private int rabattTyp;
	
	public double beraknaProduktRabatt(Produkt produkt, int mangd){
		
		this.rabattTyp = produkt.getRabattTyp();
		
		switch (rabattTyp) {
		case 0:
			return treForTva(produkt, mangd);
		case 1:
			return rabattKronor(produkt, mangd);
		default:
			return 0f;
		}
	}
	
	private double treForTva(Produkt produkt, int mangd){
		int kalk;
		kalk = mangd / 3;
		return kalk * produkt.getPris();
	}
	
	private double rabattKronor(Produkt produkt, int mangd){
		return produkt.getRabattKronor() * mangd;
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
