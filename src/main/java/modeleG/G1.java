package modeleG;
/**
 * Interfejs <code>G1</code> reprezentuje model balistyczny pocisku.
 */
public interface G1 extends G {
	/**Metoda <code>liczEk</code> wylicza energiê kinetyczn¹ pocisku, zgodnie z modelem G1, po pokonaniu ka¿dego metra, pocisk traci okreœlony procent swojej energii kinetycznej.
	 * @param Ek energia kinetyczna w chwili poprzedniej
	 * @return energia kinetyczna pomniejszona o 1.5% (po pokoniu 1metra)
	 * */
	default double liczEk(double Ek)  
	{
		return (Ek-(0.015*Ek));
	}
}
