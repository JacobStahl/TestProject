import static org.junit.Assert.*;
import org.junit.Test;


public class rabattTest {

	
	private Kund k;
	private Produkt p;
	private Produkt q;
	
	private int kundNr;
	private String forNamn;
	private String efterNamn;
	private String telefonNummer;
	private String adress;
	private Rabatt rabattTypKund;
	
	
	public void setUpKund(){
		kundNr = 123;
		forNamn = "Johan";
		efterNamn = "Svensson";
		telefonNummer = "070 253 25 34";
		adress = "Stenvägen 4";
		rabattTypKund = new RabattProcent(0.1);
		
		k = new Kund(kundNr, forNamn, efterNamn, telefonNummer, adress, rabattTypKund);
	}
	
	private int produktNr;
	private String produktNamn;
	private String produktTyp;
	private Pengar pris;
	private int mangd;
	private Rabatt rabattTypProdukt;
	
	
	@Test
	public void testKundRabatt(){
		setUpKund();
		
		assertEquals(1000, k.getRabattTyp().berakna(new Pengar(10000)).getPengar());
	}
	
	@Test
	public void testTreForTva(){
		produktNr = 1;
		produktNamn = "Gurka";
		produktTyp = "Grönsak";
		pris = new Pengar(550);
		mangd = 6;
		rabattTypProdukt = new RabattTreForTva();
		
		p = new Produkt(produktNr, produktNamn, produktTyp, pris, mangd, rabattTypProdukt);
		
		Pengar kalk = p.getRabattTyp().berakna(p);
		
		assertEquals(1100, kalk.getPengar());
	}
	
	@Test
	public void testRabattKronor(){
		produktNr = 1;
		produktNamn = "Gurka";
		produktTyp = "Grönsak";
		pris = new Pengar(550);
		mangd = 1;
		rabattTypProdukt = new RabattKronor(200);
		
		p = new Produkt(produktNr, produktNamn, produktTyp, pris, mangd, rabattTypProdukt);
		
		Pengar kalk = p.getRabattTyp().berakna(p);
		
		assertEquals((200*mangd), kalk.getPengar());
	}
	
	@Test //Testar några ekvivalensklasspartitioner
	public void testTreForTvaLoop(){
		produktNr = 1;
		produktNamn = "Gurka";
		produktTyp = "Grönsak";
		pris = new Pengar(550);
		mangd = 0;
		rabattTypProdukt = new RabattTreForTva();
		
		q = new Produkt(produktNr, produktNamn, produktTyp, pris, mangd, rabattTypProdukt);
		
		for(int i = 0;i<10000000;i++){
			Pengar kalk = q.getRabattTyp().berakna(q);
			assertEquals((q.getMangd()/3)*550, kalk.getPengar(), 0f);
			q.setMangd(q.getMangd()+3);
		}
	}
	
	@Test
	public void testRabatt(){
		Rabatt rabatt = new Rabatt();
		assertEquals(rabatt.berakna(p).getPengar(), 0);
		assertEquals(rabatt.berakna(new Pengar(0)).getPengar(), 0);
	}
}
