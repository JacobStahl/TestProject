import static org.junit.Assert.*;

import org.junit.Test;


public class kundTest {

	@Test
	public void checkIfNull() {
		int kundNr = 123;
		String forNamn = "Johan";
		String efterNamn = "Svensson";
		String telefonNummer = "070 253 25 34";
		String adress = "Stenvägen 4";
		
		Kund k = new Kund(kundNr, forNamn, efterNamn, telefonNummer, adress);
		
		assertNotNull(k);
	}
	
	@Test
	public void checkConstructorInput(){
		int kundNr = 123;
		String forNamn = "Johan";
		String efterNamn = "Svensson";
		String telefonNummer = "070 253 25 34";
		String adress = "Stenvägen 4";
		
		Kund k = new Kund(kundNr, forNamn, efterNamn, telefonNummer, adress);
		
		assertEquals(kundNr, k.getKundNr());
		assertEquals(forNamn, k.getForNamn());
		assertEquals(efterNamn, k.getEfterNamn());
		assertEquals(telefonNummer, k.getTelefonNummer());
		assertEquals(adress, k.getAdress());
	}

}
