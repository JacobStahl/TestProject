import static org.junit.Assert.*;

import org.junit.Test;


public class kvittoTest {
	
	private Kvitto kvitto;

	private Produkt produkt;
	
	private int produktNr;
	private String produktNamn;
	private String produktTyp;
	private double pris;
	
	public void setUpProdukt(){
		produktNr = 123;
		produktNamn = "Mjölk";
		produktTyp = "Mejeri";
		pris = 12;
		
		produkt = new Produkt(produktNr, produktNamn, produktTyp, pris);
	}
	
	@Test
	public void checkAddProdukt() {
		kvitto = new Kvitto(1);
		setUpProdukt();
		
		kvitto.addProdukt(produkt);
		assertEquals(1, kvitto.getProdukter().size());
	}
	
	@Test
	public void checkRemoveProdukt(){
		kvitto = new Kvitto(1);
		setUpProdukt();
		kvitto.addProdukt(produkt);
		kvitto.removeProdukt(produkt);
		assertEquals(0, kvitto.getProdukter().size());
		
	}

}
