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
	private Pengar pris;
	private int mangd;
	
	public void setUpProdukt(){
		produktNr = 123;
		produktNamn = "Mjölk";
		produktTyp = "Mejeri";
		pris = new Pengar(1200);
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
		int pris2 = 1500;
		Produkt produkt2 = new Produkt(125, "Gurka", "Grönsak", pris2, 1);
		kvitto.addProdukt(produkt2);
		
		assertEquals(pris.getPengar() + pris2, kvitto.getTotalPris().getPengar());
	}
	
	@Test
	public void testRabatt(){
		setUpKvitto();
		produkt.setRabattTyp(1);
		produkt.setMangd(3);
		
		assertEquals(produkt.getPris().getPengar(), kvitto.beraknaRabatt(produkt));
	}
	
	@Test
	public void testPrint(){
		setUpKvitto();
		
		Produkt produkt2 = new Produkt(2, "Gurka", "Grönsak", 5, 6, 1, 0.0);
		kvitto.addProdukt(produkt2);
		assertNotNull(kvitto.print());
		System.out.println(kvitto.print());
	}
	
	@Test
	public void testPrintWithKund(){
		Kund kund = new Kund(1, "Stefan", "Svensson", "070 253 12 35", "Stenvägen 4");
		kvitto = new Kvitto(1, kund);
		setUpProdukt();
		kvitto.addProdukt(produkt);
		
		Produkt produkt2 = new Produkt(2, "Gurka", "Grönsak", 515, 6, 1, 0.0);
		kvitto.addProdukt(produkt2);
		assertNotNull(kvitto.print());
		System.out.println(kvitto.print());
	}
}
