package mvc.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.enterprise.inject.Alternative;



@Alternative
public class TransazioniAnagFile implements TransazioniAnag {

	ArrayList<Anagrafica> VettAnag;

	public TransazioniAnagFile() {
		VettAnag = new ArrayList<Anagrafica>();
	}

	public void Inserimento(Anagrafica a) {
		VettAnag.add(a);
		try {
			FileOutputStream f = new FileOutputStream("d:/elenco.dat");
			ObjectOutputStream fOUT = new ObjectOutputStream(f);

			fOUT.writeObject(VettAnag);

			fOUT.flush();
			f.close();

		} catch (Exception e) {
			System.out.println("Eccezione: " + e.getMessage());
		}
		

	};

	public Anagrafica Ricerca(String matricola) {
		System.out.println("Propcedura da implementare");

		return null;

	};

	@SuppressWarnings("unchecked")
	public ArrayList<Anagrafica> Visualizzazione() {
		ArrayList<Anagrafica> VettoreAnag = null;
		try {
			FileInputStream f = new FileInputStream("d:/elenco.dat");
			ObjectInputStream fIN = new ObjectInputStream(f);

			VettoreAnag = (ArrayList<Anagrafica>) fIN.readObject();

			f.close();
		} catch (Exception e) {
			System.out.println("Eccezione: " + e.getMessage());
		}
		return VettoreAnag;

	};

	public void Modifica(Anagrafica a) {
		System.out.println("Propcedura da implementare");

	};

	public void Cancellazione(String matricola) {
		System.out.println("Propcedura da implementare");

	};

}

