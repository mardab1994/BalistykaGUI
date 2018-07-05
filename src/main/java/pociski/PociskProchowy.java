package pociski;

import modeleG.G2;

public class PociskProchowy extends PociskBazowy implements G2{


	public PociskProchowy(double aMasa, double aVo) {
		super(aMasa/1000, aVo);
	}
	
	@Override
	public void pokaz() {
		System.out.println("Pokazuje prochowy");
	}
}
