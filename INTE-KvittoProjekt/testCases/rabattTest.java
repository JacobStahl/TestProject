import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class rabattTest {

	
	private Kund k;
	private Produkt p;
	private Produkt q;
	
	private int kundNr;
	private String forNamn;
	private String efterNamn;
	private String telefonNummer;
	private String adress;
	private int rabattTypKund;
	
	
	public void setUpKund(){
		kundNr = 123;
		forNamn = "Johan";
		efterNamn = "Svensson";
		telefonNummer = "070 253 25 34";
		adress = "Stenvägen 4";
		rabattTypKund = 0;
		
		k = new Kund(kundNr, forNamn, efterNamn, telefonNummer, adress, rabattTypKund);
	}
	
	private int produktNr;
	private String produktNamn;
	private String produktTyp;
	private double pris;
	private int mangd;
	private int rabattTypProdukt;
	private double rabattKronor;
	
	
	@Test
	public void testKundRabatt(){
		Rabatt rabatt = new Rabatt();
		setUpKund();
		
		assertEquals(10, rabatt.beraknaKundRabatt(k, 100), 0f);
	}
	
	@Test
	public void testTreForTva(){
		produktNr = 1;
		produktNamn = "Gurka";
		produktTyp = "Grönsak";
		pris = 5.5f;
		mangd = 6;
		rabattTypProdukt = 0;
		rabattKronor = 0;
		
		p = new Produkt(produktNr, produktNamn, produktTyp, pris, mangd, rabattTypProdukt, rabattKronor);
		Rabatt rabatt = new Rabatt();
		
		double kalk = rabatt.beraknaProduktRabatt(p);
		
		assertEquals(11f, kalk, 0f);
	}
	
	@Test
	public void testRabattKronor(){
		produktNr = 1;
		produktNamn = "Gurka";
		produktTyp = "Grönsak";
		pris = 5.5f;
		mangd = 1;
		rabattTypProdukt = 1;
		rabattKronor = 3.2f;
		
		p = new Produkt(produktNr, produktNamn, produktTyp, pris, mangd, rabattTypProdukt, rabattKronor);
		Rabatt rabatt = new Rabatt();
		
		double kalk = rabatt.beraknaProduktRabatt(p);
		
		assertEquals((3.2f*mangd), kalk, 0f);
	}
	
	@Test //Testar några ekvivalensklasspartitioner
	public void testTreForTvaLoop(){
		produktNr = 1;
		produktNamn = "Gurka";
		produktTyp = "Grönsak";
		pris = 5.5f;
		mangd = 0;
		rabattTypProdukt = 0;
		rabattKronor = 0;
		
		q = new Produkt(produktNr, produktNamn, produktTyp, pris, mangd, rabattTypProdukt, rabattKronor);
		Rabatt rabatt = new Rabatt();
		
		for(int i = 0;i<13;i++){
			double kalk = rabatt.beraknaProduktRabatt(q);
			assertEquals((q.getMangd()/3)*5.5f, kalk, 0f);
			q.setMangd(q.getMangd()+3);
		}
	}
	
}
