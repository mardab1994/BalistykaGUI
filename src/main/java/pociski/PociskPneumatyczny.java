package pociski;
import modeleG.G1;

public class PociskPneumatyczny extends PociskBazowy implements G1{
	

	/**Konstruktor klasy <code>PociskPneumatyczny</code>
	 * @param aMasa masa pocisku [g] 
	 * @param aVo prêdkoœæ pocz¹tkowa pocisku [m/s]*/
	public PociskPneumatyczny(double aMasa, double aVo) {
		super(aMasa/1000, aVo);
	}
	
	
	@Override
	public void pokaz() {
		System.out.println("Pokazuje pneumatyczny");
	}
	
}
