package dbms;

import java.util.ArrayList;

public class CartellaBean {

	private String codice;
	private String data;
	private String dataDimissione;
	private String motivo;
	private String prognosi;
	private String terapie_id_cartella;
	private String terapie_inizio;
	private String terapie_fine;
	private String terapie_frequenza;
	private String terapie_dosi;
	private String terapie_farmaco;
	private String diagnosi_id_paziente;
	private String diagnosi_data;
	private String diagnosi_icd10;
	private String diagnosi_patologia;
	private String diagnosi_id_medico;
	private String medicoNome;
	private String medicoCognome;

	//Definizione del costruttore del Bean
    public CartellaBean() {
		codice = "";
		data = "";
		dataDimissione = "";
		motivo = "";
		prognosi = "";
		terapie_id_cartella = "";
		terapie_inizio = "";
		terapie_fine = "";
		terapie_frequenza = "";
		terapie_dosi = "";
		terapie_farmaco = "";
		diagnosi_id_paziente = "";
		diagnosi_data = "";
		diagnosi_icd10 = "";
		diagnosi_patologia = "";
		diagnosi_id_medico = "";
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

	public String getTerapie_id_cartella() {
		return terapie_id_cartella;
	}

	public void setTerapie_id_cartella(String terapie_id_cartella) {
		this.terapie_id_cartella = terapie_id_cartella;
	}

	public String getTerapie_inizio() {
		return terapie_inizio;
	}

	public void setTerapie_inizio(String terapie_inizio) {
		this.terapie_inizio = terapie_inizio;
	}

	public String getTerapie_fine() {
		return terapie_fine;
	}

	public void setTerapie_fine(String terapie_fine) {
		this.terapie_fine = terapie_fine;
	}

	public String getTerapie_frequenza() {
		return terapie_frequenza;
	}

	public void setTerapie_frequenza(String terapie_frequenza) {
		this.terapie_frequenza = terapie_frequenza;
	}

	public String getTerapie_dosi() {
		return terapie_dosi;
	}

	public void setTerapie_dosi(String terapie_dosi) {
		this.terapie_dosi = terapie_dosi;
	}

	public String getTerapie_farmaco() {
		return terapie_farmaco;
	}

	public void setTerapie_farmaco(String terapie_farmaco) {
		this.terapie_farmaco = terapie_farmaco;
	}

	public String getDiagnosi_id_paziente() {
		return diagnosi_id_paziente;
	}

	public void setDiagnosi_id_paziente(String diagnosi_id_paziente) {
		this.diagnosi_id_paziente = diagnosi_id_paziente;
	}

	public String getDiagnosi_data() {
		return diagnosi_data;
	}

	public void setDiagnosi_data(String diagnosi_data) {
		this.diagnosi_data = diagnosi_data;
	}

	public String getDiagnosi_icd10() {
		return diagnosi_icd10;
	}

	public void setDiagnosi_icd10(String diagnosi_icd10) {
		this.diagnosi_icd10 = diagnosi_icd10;
	}

	public String getDiagnosi_patologia() {
		return diagnosi_patologia;
	}

	public void setDiagnosi_patologia(String diagnosi_patologia) {
		this.diagnosi_patologia = diagnosi_patologia;
	}

	public String getDiagnosi_id_medico() {
		return diagnosi_id_medico;
	}

	public void setDiagnosi_id_medico(String diagnosi_id_medico) {
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
