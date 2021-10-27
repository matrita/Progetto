package mvc.model;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;



@Alternative
public class TransazioniAnagVector implements TransazioniAnag {
	ArrayList<Anagrafica> anagDinamico;

	public TransazioniAnagVector() {
		this.anagDinamico = new ArrayList<Anagrafica>();
	}

	// *************INSERIMENTO******************
	public void Inserimento(Anagrafica a) {

		anagDinamico.add(a);
		

	}

	// *************RICERCA******************
	public Anagrafica Ricerca(String matricola) {

		int i;

		Anagrafica a;

		for (i = 0; i < anagDinamico.size(); i++) {

			a = (Anagrafica) anagDinamico.get(i);

			if (a.getMatricola().equals(matricola)) {
				return a;

			}
		}

		if (i == 0)

		{
			System.out.println("NON E' STATO TROVATO NESSUN UTENTE");
			return null;
		}

		return null;
	}

	// *************VISUALIZZAZIONE******************
	public ArrayList<Anagrafica> Visualizzazione() {

		for (int i = 0; i < anagDinamico.size(); i++) {

		}

		return anagDinamico;
	}

	private int RicercaPosizione(String matricola) {

		Anagrafica a;
		for (int i = 0; i < anagDinamico.size(); i++) {

			a = (Anagrafica) anagDinamico.get(i);

			if (a.getMatricola().equals(matricola)) {
				return i;
			}
		}
		return -1;
	}

	// *************MODIFICA******************
	public void Modifica(Anagrafica a) {

		int posizione = RicercaPosizione(a.getMatricola());

		if (posizione != -1)

		{

			// anagDinamico.setElementAt(anag, posizione);
			anagDinamico.set(posizione, a);
		} else {

			System.out.println("Matricola inesistente");
		}

	}

	// *************CANCELLAZIONE******************
	public void Cancellazione(String matricola) {

		int posizione = RicercaPosizione(matricola);

		if (posizione != -1)

		{

			anagDinamico.remove(posizione);

			System.out.println("L'utente è stato rimosso");

		} else {

			System.out.println("Matricola inesistente");

		}
	}

}
