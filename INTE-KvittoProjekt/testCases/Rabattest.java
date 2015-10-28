import static org.junit.Assert.*;
import org.junit.Test;

// Tester f�r rabatt
public class Rabattest {

	
	private Kund k;
	private Produkt p;
	private Produkt q;
	
	private int kundNr;
	private String forNamn;
	private String efterNamn;
	private String telefonNummer;
	private String adress;
	private Rabatt rabattTypKund;
	
	// Instansierar en kund
	public void setUpKund(){
		kundNr = 123;
		forNamn = "Johan";
		efterNamn = "Svensson";
		telefonNummer = "070 253 25 34";
		adress = "Stenv�gen 4";
		rabattTypKund = new RabattProcent(0.1);
		
		k = new Kund(kundNr, forNamn, efterNamn, telefonNummer, adress, rabattTypKund);
	}
	
	private int produktNr;
	private String produktNamn;
	private String produktTyp;
	private Pengar pris;
	private int mangd;
	private Rabatt rabattTypProdukt;
	
	
	// Instansierar en kund med rabatt
	@Test
	public void testKundRabatt(){
		setUpKund();
		
		assertEquals(1000, k.getRabattTyp().berakna(new Pengar(10000)).getPengar());
	}
	
	// testar tre f�r tv� rabatt
	@Test
	public void testTreForTva(){
		produktNr = 1;
		produktNamn = "Gurka";
		produktTyp = "Gr�nsak";
		pris = new Pengar(550);
		mangd = 6;
		rabattTypProdukt = new RabattTreForTva();
		
		p = new Produkt(produktNr, produktNamn, produktTyp, pris, mangd, rabattTypProdukt);
		
		Pengar kalk = p.getRabattTyp().berakna(p);
		
		assertEquals(1100, kalk.getPengar());
	}
	
	// Testar rabatt med kronor
	@Test
	public void testRabattKronor(){
		produktNr = 1;
		produktNamn = "Gurka";
		produktTyp = "Gr�nsak";
		pris = new Pengar(550);
		mangd = 1;
		rabattTypProdukt = new RabattKronor(200);
		
		p = new Produkt(produktNr, produktNamn, produktTyp, pris, mangd, rabattTypProdukt);
		
		Pengar kalk = p.getRabattTyp().berakna(p);
		
		assertEquals((200*mangd), kalk.getPengar());
	}
	
	@Test //Testar n�gra ekvivalensklasspartitioner
	public void testTreForTvaLoop(){
		produktNr = 1;
		produktNamn = "Gurka";
		produktTyp = "Gr�nsak";
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
