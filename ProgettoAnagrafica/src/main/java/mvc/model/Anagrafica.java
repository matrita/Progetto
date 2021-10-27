package mvc.model;

import java.io.Serializable;

public class Anagrafica implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String cognome;
	private String matricola;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	@Override
	public String toString() {
		return "Anagrafica [nome=" + nome + ", cognome=" + cognome + ", matricola=" + matricola + "]";
	}

}