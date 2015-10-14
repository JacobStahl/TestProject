import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class kundTest {
	
	private Kund k;
	
	int kundNr;
	String forNamn;
	String efterNamn;
	String telefonNummer;
	String adress;
	
	@Before
	public void setUp(){
		kundNr = 123;
		forNamn = "Johan";
		efterNamn = "Svensson";
		telefonNummer = "070 253 25 34";
		adress = "Stenvägen 4";
		
		k = new Kund(kundNr, forNamn, efterNamn, telefonNummer, adress);
	}
	
	@Test
	public void checkIfNull() {
		assertNotNull(k);
	}
	
	@Test
	public void checkGetMethods(){
		assertEquals(kundNr, k.getKundNr());
		assertEquals(forNamn, k.getForNamn());
		assertEquals(efterNamn, k.getEfterNamn());
		assertEquals(telefonNummer, k.getTelefonNummer());
		assertEquals(adress, k.getAdress());
	}
	
	@Test
	public void checkSetMethods(){
		kundNr = 234;
		forNamn = "Stefan";
		efterNamn = "Andersson";
		telefonNummer = "070 503 27 13";
		adress = "Trävägen 6";
		
		k.setKundNr(kundNr);
		k.setForNamn(forNamn);
		k.setEfterNamn(efterNamn);
		k.setTelefonNummer(telefonNummer);
		k.setAdress(adress);
		
		assertEquals(kundNr, k.getKundNr());
		assertEquals(forNamn, k.getForNamn());
		assertEquals(efterNamn, k.getEfterNamn());
		assertEquals(telefonNummer, k.getTelefonNummer());
		assertEquals(adress, k.getAdress());
	}

}
