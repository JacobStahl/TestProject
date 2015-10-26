import static org.junit.Assert.*;

import org.junit.Test;


public class pengaTest {


	
	@Test
	public void addTest() {
		Pengar p = new Pengar(2500);
		Pengar q = new Pengar(5053);
		p.add(q.getPengar());
		assertEquals(7553, p.getPengar());
	}
	
	@Test
	public void multiplyTest(){
		Pengar p = new Pengar(2500);
		p.multiply(31.235432);
		assertEquals(78089, p.getPengar());
	}

	@Test
	public void printTest(){
		Pengar p = new Pengar(1234);
		assertEquals("12,34", p.print());
	}
}
