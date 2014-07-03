package dbms;

import java.util.ArrayList;

public class CartellaBean {

	private String codice;
	private String data;
	private String dataDimissione;
	private String motivo;
	private String prognosi;
	private ArrayList<String> terapie_id_cartella;
	private ArrayList<String> terapie_inizio;
	private ArrayList<String> terapie_fine;
	private ArrayList<String> terapie_frequenza;
	private ArrayList<String> terapie_dosi;
	private ArrayList<String> terapie_farmaco;
	private ArrayList<String> diagnosi_id_paziente;
	private ArrayList<String> diagnosi_data;
	private ArrayList<String> diagnosi_icd10;
	private ArrayList<String> diagnosi_patologia;
	private ArrayList<String> diagnosi_id_medico;
	private String medicoNome;
	private String medicoCognome;

	//Definizione del costruttore del Bean
    public CartellaBean() {
		codice = "";
		data = "";
		dataDimissione = "";
		motivo = "";
		prognosi = "";
		terapie_id_cartella = new ArrayList<String>();
		terapie_inizio = new ArrayList<String>();
		terapie_fine = new ArrayList<String>();
		terapie_frequenza = new ArrayList<String>();
		terapie_dosi = new ArrayList<String>();
		terapie_farmaco = new ArrayList<String>();
		diagnosi_id_paziente = new ArrayList<String>();
		diagnosi_data = new ArrayList<String>();
		diagnosi_icd10 = new ArrayList<String>();
		diagnosi_patologia = new ArrayList<String>();
		diagnosi_id_medico = new ArrayList<String>();
		medicoNome = "";
		medicoCognome = "";
    }

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDataDimissione() {
		return dataDimissione;
	}

	public void setDataDimissione(String dataDimissione) {
		this.dataDimissione = dataDimissione;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getPrognosi() {
		return prognosi;
	}

	public void setPrognosi(String prognosi) {
		this.prognosi = prognosi;
	}

	public ArrayList<String> getTerapie_id_cartella() {
		return terapie_id_cartella;
	}

	public void setTerapie_id_cartella(ArrayList<String> terapie_id_cartella) {
		this.terapie_id_cartella = terapie_id_cartella;
	}

	public ArrayList<String> getTerapie_inizio() {
		return terapie_inizio;
	}

	public void setTerapie_inizio(ArrayList<String> terapie_inizio) {
		this.terapie_inizio = terapie_inizio;
	}

	public ArrayList<String> getTerapie_fine() {
		return terapie_fine;
	}

	public void setTerapie_fine(ArrayList<String> terapie_fine) {
		this.terapie_fine = terapie_fine;
	}

	public ArrayList<String> getTerapie_frequenza() {
		return terapie_frequenza;
	}

	public void setTerapie_frequenza(ArrayList<String> terapie_frequenza) {
		this.terapie_frequenza = terapie_frequenza;
	}

	public ArrayList<String> getTerapie_dosi() {
		return terapie_dosi;
	}

	public void setTerapie_dosi(ArrayList<String> terapie_dosi) {
		this.terapie_dosi = terapie_dosi;
	}

	public ArrayList<String> getTerapie_farmaco() {
		return terapie_farmaco;
	}

	public void setTerapie_farmaco(ArrayList<String> terapie_farmaco) {
		this.terapie_farmaco = terapie_farmaco;
	}

	public ArrayList<String> getDiagnosi_id_paziente() {
		return diagnosi_id_paziente;
	}

	public void setDiagnosi_id_paziente(ArrayList<String> diagnosi_id_paziente) {
		this.diagnosi_id_paziente = diagnosi_id_paziente;
	}

	public ArrayList<String> getDiagnosi_data() {
		return diagnosi_data;
	}

	public void setDiagnosi_data(ArrayList<String> diagnosi_data) {
		this.diagnosi_data = diagnosi_data;
	}

	public ArrayList<String> getDiagnosi_icd10() {
		return diagnosi_icd10;
	}

	public void setDiagnosi_icd10(ArrayList<String> diagnosi_icd10) {
		this.diagnosi_icd10 = diagnosi_icd10;
	}

	public ArrayList<String> getDiagnosi_patologia() {
		return diagnosi_patologia;
	}

	public void setDiagnosi_patologia(ArrayList<String> diagnosi_patologia) {
		this.diagnosi_patologia = diagnosi_patologia;
	}

	public ArrayList<String> getDiagnosi_id_medico() {
		return diagnosi_id_medico;
	}

	public void setDiagnosi_id_medico(ArrayList<String> diagnosi_id_medico) {
		this.diagnosi_id_medico = diagnosi_id_medico;
	}

	public String getMedicoNome() {
		return medicoNome;
	}

	public void setMedicoNome(String medicoNome) {
		this.medicoNome = medicoNome;
	}

	public String getMedicoCognome() {
		return medicoCognome;
	}

	public void setMedicoCognome(String medicoCognome) {
		this.medicoCognome = medicoCognome;
	}
    
}
