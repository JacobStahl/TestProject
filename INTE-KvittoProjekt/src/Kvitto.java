import java.util.ArrayList;
import java.util.Date;

public class Kvitto {

	private Pengar totalPris = new Pengar(0);
	private Pengar totalRabatt = new Pengar(0);
	private Pengar pris = new Pengar(0);
	private Date datum = new Date();
	private int kvittoNummer;
	private ArrayList<Produkt> produkter;
	private Kund kund;

	public Kvitto(int kvittoNummer) {
		this.kvittoNummer = kvittoNummer;
		produkter = new ArrayList<Produkt>();
	}

	public Kvitto(int kvittoNummer, Kund kund) {
		this.kvittoNummer = kvittoNummer;
		produkter = new ArrayList<Produkt>();
		this.kund = kund;
	}

	private Pengar beraknaTotalPris() {
		totalPris.setPengar(0);
		for (Produkt produkt : produkter) {
			totalPris.add(produkt.getPris().getPengar() * produkt.getMangd());
		}
		return totalPris;
	}

	private Pengar beraknaRabatt(Produkt produkt) {
		if (produkt.getRabattTyp() != null) {
			return produkt.getRabattTyp().berakna(produkt);
		} else {
			return new Pengar(0);
		}
	}

	private Pengar beraknaTotalRabatt() {
		totalRabatt.set(0);
		for (Produkt produkt : produkter) {
			totalRabatt.add(beraknaRabatt(produkt).getPengar());
		}
		if (kund != null) {
			if (kund.getRabattTyp()!=null) {
				beraknaTotalPris();
				Pengar nyRabatt = new Pengar(0);
				nyRabatt.add(totalPris.getPengar()-totalRabatt.getPengar());
				totalRabatt.add(kund.getRabattTyp().berakna(nyRabatt).getPengar());
			}
		}
		return totalRabatt;
	}

	private Pengar beraknaPris() {
		beraknaTotalPris();
		beraknaTotalRabatt();
		pris.set(0);
		pris.add(totalPris.getPengar());
		pris.add(-totalRabatt.getPengar());
		return pris;
	}

	public void addProdukt(Produkt produkt) {
		produkter.add(produkt);
	}

	public void removeProdukt(Produkt produkt) {
		produkter.remove(produkt);
	}

	public ArrayList<Produkt> getProdukter() {
		ArrayList<Produkt> returLista = new ArrayList<Produkt>(produkter);
		return returLista;
	}

	public Date getDate() {
		return datum;
	}

	public Pengar getPris() {
		return beraknaPris();
	}

	public Pengar getTotalPris() {
		return beraknaTotalPris();
	}

	public Pengar getTotalRabatt() {
		return beraknaTotalRabatt();
	}

	public String print() {
		String utskrift = "";
		beraknaTotalPris();
		beraknaTotalRabatt();

		utskrift += "Foo Bar" + "\n";
		utskrift += "\n";
		utskrift += "Kvittonummer: " + kvittoNummer + "\n";
		utskrift += "\n";

		for (Produkt produkt : produkter) {
			Pengar rabatt = new Pengar(0);
			rabatt = beraknaRabatt(produkt);
			if (rabatt.getPengar() != 0) {
				utskrift += produkt + "\n";
				utskrift += "	Rabatt: -" + rabatt.print() + "\n";
			} else {
				utskrift += produkt + "\n";
			}
		}

		utskrift += "\n";
		if (kund != null) {
			if (kund.getRabattTyp()!=null)
		utskrift += "Kundrabatt: " + kund.getRabattTyp().berakna(new Pengar(100)).getPengar() + "%\n";
		}
		utskrift += "Totalt kr: " + getPris().print() + "\n";
		if (totalRabatt.getPengar() != 0) {
			utskrift += "Rabatt: " + totalRabatt.print() + "\n";
			utskrift += "Totalt innan rabatt: " + totalPris.print() + "\n";
		}
		utskrift += "\n";

		if (kund != null)
			utskrift += "Kundnummer: " + kund.getKundNr() + "\n";

		utskrift += "Välkommen åter!" + "\n";

		return utskrift;
	}
}
