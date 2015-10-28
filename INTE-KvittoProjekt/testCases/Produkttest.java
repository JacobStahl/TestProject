import static org.junit.Assert.*;
import org.junit.Test;

public class Produkttest {
	
private Produkt p;
	
	private int produktNr;
	private String produktNamn;
	private String produktTyp;
	private Pengar pris;
	private int mangd;
	
	
	public void setUp(){
		produktNr = 123;
		produktNamn = "Mjölk";
		produktTyp = "Mejeri";
		pris = new Pengar(1200);
		mangd = 1;
		
		p = new Produkt(produktNr, produktNamn, produktTyp, pris, mangd);
	}

	@Test
	public void checkIfProduktIsNull() {
		setUp();
		assertNotNull(p);
	}
	
	@Test
	public void checkGetMethods(){
		setUp();
		assertEquals(produktNr, p.getProduktNr());
		assertEquals(produktNamn, p.getProduktNamn());
		assertEquals(produktTyp, p.getProduktTyp());
		assertEquals(pris.getPengar(), p.getPris().getPengar());
	
	}
	
	@Test
	public void checkSetMethods(){
		setUp();
		produktNr = 1441;
		produktNamn = "Skinka";
		produktTyp = "Chark";
		pris = new Pengar(5400);
		
		p.setProduktNr(produktNr);
		p.setProduktNamn(produktNamn);
		p.setProduktTyp(produktTyp);
		p.setPris(pris);
		
		
		assertEquals(produktNr, p.getProduktNr());
		assertEquals(produktNamn, p.getProduktNamn());
		assertEquals(produktTyp, p.getProduktTyp());
		assertEquals(pris.getPengar(), p.getPris().getPengar());
		
	}

}
