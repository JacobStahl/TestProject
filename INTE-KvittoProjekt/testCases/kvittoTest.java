import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;


public class kvittoTest {
	
	private Kvitto kvitto;

	private Produkt produkt;
	
	private int produktNr;
	private String produktNamn;
	private String produktTyp;
	private double pris;
	private int mangd;
	
	public void setUpProdukt(){
		produktNr = 123;
		produktNamn = "Mjölk";
		produktTyp = "Mejeri";
		pris = 12;
		mangd = 1;
		
		produkt = new Produkt(produktNr, produktNamn, produktTyp, pris, mangd);
	}
	
	public void setUpKvitto(){
		kvitto = new Kvitto(1);
		setUpProdukt();
		kvitto.addProdukt(produkt);
	}
	
	@Test
	public void checkAddProdukt() {
		setUpKvitto();
		assertEquals(1, kvitto.getProdukter().size());
	}
	
	@Test
	public void checkRemoveProdukt(){
		setUpKvitto();
		kvitto.removeProdukt(produkt);
		assertEquals(0, kvitto.getProdukter().size());
		
	}
	
	@Test
	public void checkDate(){
		setUpKvitto();
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		assertEquals(format.format(new Date()), format.format(kvitto.getDate()));
	}
	
	@Test
	public void checkProdukt(){
		setUpKvitto();
		Produkt produkt2 = new Produkt(125, "Gurka", "Grönsak", 15, 1);
		ArrayList<Produkt> list = kvitto.getProdukter();
		assertTrue(list.contains(produkt));
		assertFalse(list.contains(produkt2));
	}
	
	@Test
	public void checkTotalPris(){
		setUpKvitto();
		double pris2 = 15;
		Produkt produkt2 = new Produkt(125, "Gurka", "Grönsak", pris2, 1);
		kvitto.addProdukt(produkt2);
		
		assertEquals(pris + pris2, kvitto.getTotalPris(), 0.0);
	}
	
	@Test
	public void testRabatt(){
		setUpKvitto();
		produkt.setRabattTyp(0);
		produkt.setMangd(3);
		
		assertEquals(produkt.getPris(), kvitto.beraknaRabatt(produkt), 0.0);
	}
}
