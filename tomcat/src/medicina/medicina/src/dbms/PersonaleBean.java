package dbms;

import java.util.ArrayList;

public class PersonaleBean {
	//Definizione dei campi del Bean (variabili private: accessibili solo tramite i metodi get e set)
	private String nome;
	private String cognome;
	private String inizio;
	private ArrayList<String> specializzazioni;
	private int diagnosi;
	
	//Definizione del costruttore del Bean
    public PersonaleBean() {
		nome = ""; 
		cognome = "";
		inizio = "";
		specializzazioni = new ArrayList<String>();
		diagnosi = 0;
    }
    
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

	public String getInizio() {
		return inizio;
	}

	public void setInizio(String inizio) {
		this.inizio = inizio;
	}

	public ArrayList<String> getSpecializzazioni() {
		return specializzazioni;
	}

	public void setSpecializzazioni(ArrayList<String> specializzazioni) {
		this.specializzazioni = specializzazioni;
	}

	public int getDiagnosi() {
		return diagnosi;
	}

	public void setDiagnosi(int diagnosi) {
		this.diagnosi = diagnosi;
	}

}