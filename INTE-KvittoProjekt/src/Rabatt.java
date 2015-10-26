
public class Rabatt {
	
	public int berakna(Produkt produkt){
		return 0;
	}
	
	public int berakna(Pengar totalPris){
		return 0;
	}
	
	
	/*
	private int rabattTyp;
	
	public int beraknaProduktRabatt(Produkt produkt){
		
		this.rabattTyp = produkt.getRabattTyp();
		
		switch (rabattTyp) {
		case 1:
			return treForTva(produkt);
		case 2:
			return rabattKronor(produkt);
		default:
			return 0;
		}
	}
	
	private int treForTva(Produkt produkt){
		int kalk;
		kalk = produkt.getMangd() / 3;
		return kalk * produkt.getPris().getPengar();
	}
	
	private int rabattKronor(Produkt produkt){
		return produkt.getRabattKronor() * produkt.getMangd();
	}
	
	public int beraknaKundRabatt(Kund kund, Pengar totalPris){
		
		this.rabattTyp = kund.getRabattTyp();
		
		switch (rabattTyp){
		case 0:
			return tioProcentRabatt(totalPris);
		default:
			return 0;
		}
	}
	
	private int tioProcentRabatt(Pengar totalPris){
		Pengar rabatt = new Pengar(totalPris.getPengar());
		rabatt.multiply(0.1);
		return rabatt.getPengar();
	}
	*/
}
