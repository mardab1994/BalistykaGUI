package pociski;

import modeleG.G;

public abstract class PociskBazowy implements G{
	
	private static int nextId=1;
	/**Indywidualny identyfikator pocisku*/		private int id;
	
	/**Masa pocisku [kg]*/						private double masa;
	/**Pr�dko�� pocz�tkowa pocisku [m/s]*/		private double Vo;
	/**Pocz�tkowa energia kinetyczna pocisku*/	protected double EKo; 

	
	{
		this.id=nextId;
		nextId++;
	}
	
	/**Konstruktor abstrakcyjnej klasy <code>PociskBazowy</code> 
	 * @param aMasa Masa pocisku [kg]
	 * @param aVo Pr�dko�� pocz�tkowa pocisku [m/s]
	 * */
	public PociskBazowy(double aMasa, double aVo) {
		this.masa=aMasa;
		this.Vo=aVo;
		this.EKo=(masa*Vo*Vo)/2;
	}
	

	public abstract void pokaz();

	/**Geter <code>getEKo</code> daj�cy dost�p do pocz�tkowej energii kinetycznej pocisku*/
	public double getEKo() {
		return EKo;
	}

	/**Geter <code>getVo</code> daj�cy dost�p do pocz�tkowej pr�dko�ci pocisku*/
	public double getVo() {
		return Vo;
	}

	/**Geter <code>getMasa</code> daj�cy dost�p do masy pocisku*/
	public double getMasa() {
		return masa;
	}

	/**Seter <code>setMasa</code> pozwalaj�cy ustali� mas� pocisku*/
	public void setMasa(double aMasa) {
		this.masa=aMasa;
	}
			
}
