import static org.junit.Assert.*;

import org.junit.Test;

// Tester för pengar
public class Pengatest {


	// Test att hämta pengar
	@Test
	public void addTest() {
		Pengar p = new Pengar(2500);
		Pengar q = new Pengar(5053);
		p.add(q.getPengar());
		assertEquals(7553, p.getPengar());
	}
	
	// testar att multiplicera
	@Test
	public void multiplyTest(){
		Pengar p = new Pengar(2500);
		p.multiply(31.235432);
		assertEquals(78089, p.getPengar());
	}
// Testar att skriva ut belopp
	@Test
	public void printTest(){
		Pengar p = new Pengar(1234);
		assertEquals("12,34", p.print());
	}
}
