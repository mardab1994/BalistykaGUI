package symulacjaLotu;

import pociski.PociskBazowy;

/**Klasa <code>symulacja</code> przeprowadza symulacj� wystrza�u i lotu wybranego pocisku w okre�lonym modelu balistycznym G.
 * @param Pocisk pocisk poddany symulacj
 * @param Alfa K�t wystrza�u pocisku */
public class symulacja {
	
	/**Przy�pieszenie ziemskie*/private final double g=9.81;

	/**K�t wystrza�u pocisku*/	private double alfa;
	/**Czas lotu pocisku [s]*/	private double czasSymulacji;
	/**Zasi�g pocisku [m]*/		private double zasieg;

	/**Aktualna pr�dko�� pocisku [m]
	 * aktualizaowana po pokonaniu ka�dego metra*/			private double V; 
	/**Aktualna pr�dko�� pocisku [m/s] w kierunku osi X*/	private double Vx; 
	/**Aktualna pr�dko�� pocisku [m/s] w kierunku osi Y*/	private double Vy; 
	/**Aktualna energia kinetyczna pocisku*/				private double EK;	 

	/**Aktualne po�o�enie pocisku na osi X [m]*/			private double X;
	/**Aktualne po�o�enie pocisku na osi Y [m]*/			private double Y;
	
	/**Pocisk poddany symulacji lotu*/private PociskBazowy pocisk;
	
	/**Konstruktor klasy <code>symulacja</code> 
	 * @param Pocisk pocisk poddany symulacji
	 * @param alfa k�t wystrza�u pocisku */
	public symulacja(PociskBazowy Pocisk,double Alfa) {
		this.alfa=Alfa;
		this.pocisk=Pocisk;
	}
	
	/**Metoda <code>lot</code> przeprowadza symulacj� lotu do momentu uderzenia pocisku w ziemi�.*/
	public void lot() {
		start();
		int metr=0; 				//Zmienna symuluj�ca pokonanie jednego metra przez pocisk.	
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
	
	/**Metoda <code>start</code> ustala poczatkowe warto�ci parametr�w, tj. w chwili wystrza�u.
	 * @param Vy pocz�tkowa pr�dko�� pocisku w kierunku osi Y
	 * @param Vx pocz�tkowa pr�dko�� pocisku w kierunku osi X
	 * @param EK pocz�tkowa energia kinetyczna*/
	public void start() {
		V=pocisk.getVo();
		Vx=V*Math.cos(Math.toRadians(alfa));
		Vy=V*Math.sin(Math.toRadians(alfa));
		EK=pocisk.getEKo();
	}
	
	/**Metoda <code>liczPredkosci</code> oblicza aktualne pr�dko�ci pociski w kierunku ka�dej osi na podstawie zmniejszonej energii kinetycznej pocisku.
	 * @param V  aktualna pr�dko�� pocisku 
 	 * @param Vx aktualna pr�dko�� pocisku w kierunku osi X
	 * @param Vy aktualna pr�dko�� pocisku w kierunku osi Y
	 */
	private void liczPredkosci() {
		V=Math.sqrt((2*EK)/pocisk.getMasa());
		Vx=V*Math.cos(Math.toRadians(alfa));
		Vy=V*Math.sin(Math.toRadians(alfa));
	}
}
