package dbms;

public class PrimarioBean {
	//Definizione dei campi del Bean (variabili private: accessibili solo tramite i metodi get e set)
	private int id;
	private String nome;
	private String cognome;
	private String primario;
	private String psw;
	private String inizio_attivita;
	private int countDiagnosi;
	
	//Definizione del costruttore del Bean
    public PrimarioBean() {
		id = 0;
		nome = ""; 
		cognome = "";
		primario = "";
		psw = "";
		inizio_attivita = "";
		countDiagnosi = 0;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPrimario() {
		return primario;
	}

	public void setPrimario(String primario) {
		this.primario = primario;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String getInizio_attivita() {
		return inizio_attivita;
	}

	public void setInizio_attivita(String inizio_attivita) {
		this.inizio_attivita = inizio_attivita;
	}

	public int getCount() {
		return countDiagnosi;
	}

	public void setCount(int countDiagnosi) {
		this.countDiagnosi = countDiagnosi;
	}

    
}
