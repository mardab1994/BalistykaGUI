package modeleG;
/**
 * Interfejs <code>G</code> reprezentuje model balistyczny pocisku.
 */
public interface G {
	/**Metoda <code>liczEk</code> wylicza energi� kinetyczn� pocisku, zgodnie z modelem G, po pokonaniu ka�dego metra, pocisk traci okre�lony procent swojej energii kinetycznej.
	 * @param Ek energia kinetyczna w chwili poprzedniej
	 * @return energia kinetyczna po pokoniu 1metra
	 * */
	default double liczEk(double Ek) 
	{
		return Ek;
	}
}
