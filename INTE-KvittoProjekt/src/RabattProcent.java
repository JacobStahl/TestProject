
public class RabattProcent extends Rabatt{
	private double rabatt;
	
	public RabattProcent(double rabatt){
		this.rabatt = rabatt;
	}
	
	public int berakna(Pengar totalPris){
		Pengar p = new Pengar(totalPris.getPengar());
		p.multiply(rabatt);
		return p.getPengar();
	}
}
