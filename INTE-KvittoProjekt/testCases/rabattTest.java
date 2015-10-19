import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class rabattTest {

	private Rabatter r;
	
	
	String rabattTyp;
	int rabattProcent;
    int rabattMultipel; 
    
    @Before 
    public void rabattSetUp()
    {
		rabattTyp = "Ta två betala för en";
		rabattProcent = 25;
		rabattMultipel = 100;
		
		r = new Rabatter(rabattTyp, rabattProcent, rabattMultipel);
    }
		

	
	@Test
	public void checkIfRabatterIsNull() {
		assertNotNull(r);
	}

	
	@Test
	public void checkGetMethods(){
		assertEquals(rabattTyp, r.getrabattTyp());
		assertEquals(rabattProcent, r.getrabattProcent());
		assertEquals(rabattMultipel, r.getrabattMultipel());
		
	
	}
	
	@Test
	public void checkSetMethods()
	{
		rabattTyp = "2 för 1";
		rabattProcent = 25;
		rabattMultipel = 100;
		
		
		r.setrabattTyp(rabattTyp);
		r.setrabattProcent(rabattProcent);
		r.setrabattMultipel(rabattMultipel);
		
	
		
		assertEquals(rabattTyp, r.getrabattTyp());
		assertEquals(rabattProcent, r.getrabattProcent());
		assertEquals(rabattMultipel, r.getrabattMultipel());
		
		
	}

	
}
