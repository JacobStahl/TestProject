import static org.junit.Assert.*;

import org.junit.Test;

// Test som vi k�r f�r att testa profilern
public class Profilertest {
	
	@Test
	public void test(){
		int i = 1;
		int pris = 2;
		Kvitto kvitto = new Kvitto(1);
		
		while (i < 50000){
			Produkt produkt = new Produkt(2, "Gurka", "Gr�nsak", pris, 1);
			kvitto.addProdukt(produkt);
			assertEquals(i * pris, kvitto.getPris().getPengar());
			i++;
		}
		
	}
	
}
