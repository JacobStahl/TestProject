import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

// Testar alla kvittometoder
public class Kvittotest {
	
	private Kvitto kvitto;

	private Produkt produkt;
	
	private int produktNr;
	private String produktNamn;
	private String produktTyp;
	private Pengar pris;
	private int mangd;
	private Rabatt rabattTyp;
	
	// S�tter upp en produkt
	public void setUpProdukt(){
		produktNr = 123;
		produktNamn = "Mj�lk";
		produktTyp = "Mejeri";
		pris = new Pengar(1200);
		mangd = 1;
		rabattTyp = new RabattTreForTva();
		
		produkt = new Produkt(produktNr, produktNamn, produktTyp, pris, mangd, rabattTyp);
	}
	// s�tter upp ett kvitto
	public void setUpKvitto(){
		kvitto = new Kvitto(1);
		setUpProdukt();
		kvitto.addProdukt(produkt);
	}
	
	// Testar att l�gga till en produkt
	@Test
	public void checkAddProdukt() {
		setUpKvitto();
		assertEquals(1, kvitto.getProdukter().size());
	}
	
	// Testar att ta bort en produkt
	@Test
	public void checkRemoveProdukt(){
		setUpKvitto();
		kvitto.removeProdukt(produkt);
		assertEquals(0, kvitto.getProdukter().size());
		
	}
	
	// Kontrollerar datumet
	@Test
	public void checkDate(){
		setUpKvitto();
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		assertEquals(format.format(new Date()), format.format(kvitto.getDate()));
	}
	
	// kontrollerar produkten
	@Test
	public void checkProdukt(){
		setUpKvitto();
		Produkt produkt2 = new Produkt(125, "Gurka", "Gr�nsak", 15, 1);
		ArrayList<Produkt> list = kvitto.getProdukter();
		assertTrue(list.contains(produkt));
		assertFalse(list.contains(produkt2));
	}
	
	// kontrollerar totalpris
	@Test
	public void checkTotalPris(){
		setUpKvitto();
		int pris2 = 1500;
		Produkt produkt2 = new Produkt(125, "Gurka", "Gr�nsak", pris2, 1);
		kvitto.addProdukt(produkt2);
		
		assertEquals(pris.getPengar() + pris2, kvitto.getTotalPris().getPengar());
	}
	
	// testar rabatten 3f�r2
	@Test
	public void testRabatt(){
		setUpKvitto();
		produkt.setRabattTyp(new RabattTreForTva());
		produkt.setMangd(3);
		
		assertEquals(produkt.getPris().getPengar(), produkt.getRabattTyp().berakna(produkt).getPengar());
	}
	
	// testar printmetoden
	@Test
	public void testPrint(){
		setUpKvitto();
		
		Produkt produkt2 = new Produkt(2, "Gurka", "Gr�nsak", 5, 6, new RabattTreForTva());
		kvitto.addProdukt(produkt2);
		assertNotNull(kvitto.print());
		System.out.println(kvitto.print());
	}
	
	// Testar printa kvitto med kund
	@Test
	public void testPrintWithKund(){
		Kund kund = new Kund(1, "Stefan", "Svensson", "070 253 12 35", "Stenv�gen 4");
		kvitto = new Kvitto(2, kund);
		setUpProdukt();
		kvitto.addProdukt(produkt);
		
		Produkt produkt2 = new Produkt(2, "Gurka", "Gr�nsak", 515, 6, new RabattTreForTva());
		kvitto.addProdukt(produkt2);
		assertNotNull(kvitto.print());
		System.out.println(kvitto.print());
	}
	
	// kollar totala rabatten
	@Test
	public void testGetTotalRabatt(){
		setUpKvitto();
		Produkt produkt2 = new Produkt(2, "Gurka", "Gr�nsak", 515, 6, new RabattTreForTva());
		kvitto.addProdukt(produkt2);
		
		Produkt produkt3 = new Produkt(2, "Tomat", "Gr�nsak", 300, 3);
		kvitto.addProdukt(produkt3);
		
		assertEquals(1030, kvitto.getTotalRabatt().getPengar());
	}
	
	// Testar att ha tv� rabatter
	@Test
	public void testTvaRabatter(){
		Kund kund = new Kund(1, "Stefan", "Svensson", "070 253 12 35", "Stenv�gen 4", new RabattProcent(0.1));
		kvitto = new Kvitto(3, kund);
		Produkt produkt3 = new Produkt(1, "Juice", "Dryck", 1000, 1);
		kvitto.addProdukt(produkt3);
		
		Produkt produkt2 = new Produkt(2, "Gurka", "Gr�nsak", 1000, 6, new RabattTreForTva());
		kvitto.addProdukt(produkt2);
		assertNotNull(kvitto.print());
		System.out.println(kvitto.print());
		assertEquals(2500, kvitto.getTotalRabatt().getPengar());
		assertEquals(7000, kvitto.getTotalPris().getPengar());
		
	}
	
	// test utan rabatt
	@Test
	public void testIngenRabatt(){
		Kund kund = new Kund(1, "Stefan", "Svensson", "070 253 12 35", "Stenv�gen 4");
		kvitto = new Kvitto(3, kund);
		Produkt produkt3 = new Produkt(1, "Juice", "Dryck", 1000, 1);
		kvitto.addProdukt(produkt3);
		
		Produkt produkt2 = new Produkt(2, "Gurka", "Gr�nsak", 1000, 6);
		kvitto.addProdukt(produkt2);
		assertNotNull(kvitto.print());
		System.out.println(kvitto.print());
		assertEquals(7000, kvitto.getTotalPris().getPengar());
		assertEquals(0, kvitto.getTotalRabatt().getPengar());
		
	}
	
	// test med rabatt p� specifik produkt
	@Test
	public void testProduktRabatt(){
		Kund kund = new Kund(1, "Stefan", "Svensson", "070 253 12 35", "Stenv�gen 4");
		kvitto = new Kvitto(3, kund);
		Produkt produkt3 = new Produkt(1, "Juice", "Dryck", 1000, 1);
		kvitto.addProdukt(produkt3);
		
		Produkt produkt2 = new Produkt(2, "Gurka", "Gr�nsak", 1000, 6, new RabattTreForTva());
		kvitto.addProdukt(produkt2);
		assertEquals(2000, kvitto.getTotalRabatt().getPengar());
		assertEquals(7000, kvitto.getTotalPris().getPengar());
	}
	
	// test som hanterar kundrabatt
	@Test
	public void testKundRabatt(){
		Kund kund = new Kund(1, "Stefan", "Svensson", "070 253 12 35", "Stenv�gen 4", new RabattProcent(0.1));
		kvitto = new Kvitto(4, kund);
		Produkt produkt3 = new Produkt(1, "Juice", "Dryck", 1000, 1);
		kvitto.addProdukt(produkt3);
		
		Produkt produkt2 = new Produkt(2, "Gurka", "Gr�nsak", 1000, 6);
		kvitto.addProdukt(produkt2);
		assertEquals(700, kvitto.getTotalRabatt().getPengar());
		assertEquals(7000, kvitto.getTotalPris().getPengar());
	}
}