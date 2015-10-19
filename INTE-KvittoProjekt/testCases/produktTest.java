import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class produktTest {
	
private Produkt p;
	
	int produktNr;
	String produktNamn;
	String produktTyp;
	float pris;
	
	
	public void setUp(){
		produktNr = 123;
		produktNamn = "Mjölk";
		produktTyp = "Mejeri";
		pris = 12;
		
		
		p = new Produkt(produktNr, produktNamn, produktTyp, pris);
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
		assertEquals(pris, p.getPris(), 0f);
	
	}
	
	@Test
	public void checkSetMethods(){
		setUp();
		produktNr = 1441;
		produktNamn = "Skinka";
		produktTyp = "Chark";
		pris = 54;
		
		p.setProduktNr(produktNr);
		p.setProduktNamn(produktNamn);
		p.setProduktTyp(produktTyp);
		p.setPris(pris);
		
		
		assertEquals(produktNr, p.getProduktNr());
		assertEquals(produktNamn, p.getProduktNamn());
		assertEquals(produktTyp, p.getProduktTyp());
		assertEquals(pris, p.getPris(), 0f);
		
	}

}
