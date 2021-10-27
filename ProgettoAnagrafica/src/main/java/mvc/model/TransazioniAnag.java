package mvc.model;

import java.util.ArrayList;


public interface TransazioniAnag {
	public void Inserimento(Anagrafica a);

	public Anagrafica Ricerca(String matricola);

	public ArrayList<Anagrafica> Visualizzazione();

	public void Modifica(Anagrafica a);

	public void Cancellazione(String matricola);
}
