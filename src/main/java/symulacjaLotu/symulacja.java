package symulacjaLotu;

import pociski.PociskBazowy;

/**Klasa <code>symulacja</code> przeprowadza symulacjê wystrza³u i lotu wybranego pocisku w okreœlonym modelu balistycznym G.
 * @param Pocisk pocisk poddany symulacj
 * @param Alfa K¹t wystrza³u pocisku */
public class symulacja {
	
	/**Przyœpieszenie ziemskie*/private final double g=9.81;

	/**K¹t wystrza³u pocisku*/	private double alfa;
	/**Czas lotu pocisku [s]*/	private double czasSymulacji;
	/**Zasiêg pocisku [m]*/		private double zasieg;

	/**Aktualna prêdkoœæ pocisku [m]
	 * aktualizaowana po pokonaniu ka¿dego metra*/			private double V; 
	/**Aktualna prêdkoœæ pocisku [m/s] w kierunku osi X*/	private double Vx; 
	/**Aktualna prêdkoœæ pocisku [m/s] w kierunku osi Y*/	private double Vy; 
	/**Aktualna energia kinetyczna pocisku*/				private double EK;	 

	/**Aktualne po³o¿enie pocisku na osi X [m]*/			private double X;
	/**Aktualne po³o¿enie pocisku na osi Y [m]*/			private double Y;
	
	/**Pocisk poddany symulacji lotu*/private PociskBazowy pocisk;
	
	/**Konstruktor klasy <code>symulacja</code> 
	 * @param Pocisk pocisk poddany symulacji
	 * @param alfa k¹t wystrza³u pocisku */
	public symulacja(PociskBazowy Pocisk,double Alfa) {
		this.alfa=Alfa;
		this.pocisk=Pocisk;
	}
	
	/**Metoda <code>lot</code> przeprowadza symulacjê lotu do momentu uderzenia pocisku w ziemiê.*/
	public void lot() {
		start();
		int metr=0; 				//Zmienna symuluj¹ca pokonanie jednego metra przez pocisk.	
		do {
			EK=pocisk.liczEk(EK);	// aktualizacja energii kinetycznej zgodnie z obranym modelem balistycznym 
			liczPredkosci();
			X=metr;
			metr++;
			Y=V*(X/Vx)-((g*X*X)/(2*Vx*Vx));
			//System.out.println("x="+X+"   y="+Y);	//wydrukowanie aktualnej pozycji pocisku (x,y)
		}while(Y>=0);
		 
	}
	public double lot(double metr) {
		EK=pocisk.liczEk(EK);	// aktualizacja energii kinetycznej zgodnie z obranym modelem balistycznym 
		liczPredkosci();
		X=metr;
		Y=V*(X/Vx)-((g*X*X)/(2*Vx*Vx));
		return Y;
	}
	
	/**Metoda <code>start</code> ustala poczatkowe wartoœci parametrów, tj. w chwili wystrza³u.
	 * @param Vy pocz¹tkowa prêdkoœæ pocisku w kierunku osi Y
	 * @param Vx pocz¹tkowa prêdkoœæ pocisku w kierunku osi X
	 * @param EK pocz¹tkowa energia kinetyczna*/
	public void start() {
		V=pocisk.getVo();
		Vx=V*Math.cos(Math.toRadians(alfa));
		Vy=V*Math.sin(Math.toRadians(alfa));
		EK=pocisk.getEKo();
	}
	
	/**Metoda <code>liczPredkosci</code> oblicza aktualne prêdkoœci pociski w kierunku ka¿dej osi na podstawie zmniejszonej energii kinetycznej pocisku.
	 * @param V  aktualna prêdkoœæ pocisku 
 	 * @param Vx aktualna prêdkoœæ pocisku w kierunku osi X
	 * @param Vy aktualna prêdkoœæ pocisku w kierunku osi Y
	 */
	private void liczPredkosci() {
		V=Math.sqrt((2*EK)/pocisk.getMasa());
		Vx=V*Math.cos(Math.toRadians(alfa));
		Vy=V*Math.sin(Math.toRadians(alfa));
	}
}
