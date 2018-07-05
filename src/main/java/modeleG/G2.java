package modeleG;
/**
 * Interfejs <code>G2</code> reprezentuje model balistyczny pocisku.
 */
public interface G2 extends G {
	/**Metoda <code>liczEk</code> wylicza energiê kinetyczn¹ pocisku, zgodnie z modelem G2, po pokonaniu ka¿dego metra, pocisk traci okreœlony procent swojej energii kinetycznej.
	 * @param Ek energia kinetyczna w chwili poprzedniej
	 * @return energia kinetyczna pomniejszona o 2% (po pokoniu 1metra)
	 * */
	default double liczEk(double Ek)  {
		return (Ek-(0.02*Ek));
	}
	

}
