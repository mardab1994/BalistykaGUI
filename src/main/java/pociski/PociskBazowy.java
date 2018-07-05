package pociski;

import modeleG.G;

public abstract class PociskBazowy implements G{
	
	private static int nextId=1;
	/**Indywidualny identyfikator pocisku*/		private int id;
	
	/**Masa pocisku [kg]*/						private double masa;
	/**Prêdkoœæ pocz¹tkowa pocisku [m/s]*/		private double Vo;
	/**Pocz¹tkowa energia kinetyczna pocisku*/	protected double EKo; 

	
	{
		this.id=nextId;
		nextId++;
	}
	
	/**Konstruktor abstrakcyjnej klasy <code>PociskBazowy</code> 
	 * @param aMasa Masa pocisku [kg]
	 * @param aVo Prêdkoœæ pocz¹tkowa pocisku [m/s]
	 * */
	public PociskBazowy(double aMasa, double aVo) {
		this.masa=aMasa;
		this.Vo=aVo;
		this.EKo=(masa*Vo*Vo)/2;
	}
	

	public abstract void pokaz();

	/**Geter <code>getEKo</code> daj¹cy dostêp do pocz¹tkowej energii kinetycznej pocisku*/
	public double getEKo() {
		return EKo;
	}

	/**Geter <code>getVo</code> daj¹cy dostêp do pocz¹tkowej prêdkoœci pocisku*/
	public double getVo() {
		return Vo;
	}

	/**Geter <code>getMasa</code> daj¹cy dostêp do masy pocisku*/
	public double getMasa() {
		return masa;
	}

	/**Seter <code>setMasa</code> pozwalaj¹cy ustaliæ masê pocisku*/
	public void setMasa(double aMasa) {
		this.masa=aMasa;
	}
			
}
