import static org.junit.Assert.*;
import org.junit.Test;


// Tester som hanterar kunder
public class Kundtest {
	
	private Kund k;
	
	int kundNr;
	String forNamn;
	String efterNamn;
	String telefonNummer;
	String adress;
	
	// instansierar en ny kund
	public void setUp(){
		kundNr = 123;
		forNamn = "Johan";
		efterNamn = "Svensson";
		telefonNummer = "070 253 25 34";
		adress = "Stenv�gen 4";
		
		k = new Kund(kundNr, forNamn, efterNamn, telefonNummer, adress);
	}
	
	// Kollar s� kunden inte �r null
	@Test
	public void checkIfNull() {
		setUp();
		assertNotNull(k);
	}
	// Kollar alla getmetoder
	@Test
	public void checkGetMethods(){
		setUp();
		assertEquals(kundNr, k.getKundNr());
		assertEquals(forNamn, k.getForNamn());
		assertEquals(efterNamn, k.getEfterNamn());
		assertEquals(telefonNummer, k.getTelefonNummer());
		assertEquals(adress, k.getAdress());
	}
	// Kollar alla setmetoder
	@Test
	public void checkSetMethods(){
		setUp();
		kundNr = 234;
		forNamn = "Stefan";
		efterNamn = "Andersson";
		telefonNummer = "070 503 27 13";
		adress = "Tr�v�gen 6";
		
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
