package bean;

// Generated 14-lug-2014 18.07.36 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Diagnosi generated by hbm2java
 */
public class Diagnosi implements java.io.Serializable {

	private DiagnosiId id;
	private CartellaClinica cartellaClinica;
	private Paziente paziente;
	private Medico medico;
	private String icd10;
	private String patologia;
	private Set confermes = new HashSet(0);
	private Set contraddizionis = new HashSet(0);

	public Diagnosi() {
	}

	public Diagnosi(DiagnosiId id, CartellaClinica cartellaClinica,
			Paziente paziente, String icd10, String patologia) {
		this.id = id;
		this.cartellaClinica = cartellaClinica;
		this.paziente = paziente;
		this.icd10 = icd10;
		this.patologia = patologia;
	}

	public Diagnosi(DiagnosiId id, CartellaClinica cartellaClinica,
			Paziente paziente, Medico medico, String icd10, String patologia,
			Set confermes, Set contraddizionis) {
		this.id = id;
		this.cartellaClinica = cartellaClinica;
		this.paziente = paziente;
		this.medico = medico;
		this.icd10 = icd10;
		this.patologia = patologia;
		this.confermes = confermes;
		this.contraddizionis = contraddizionis;
	}

	public DiagnosiId getId() {
		return this.id;
	}

	public void setId(DiagnosiId id) {
		this.id = id;
	}

	public CartellaClinica getCartellaClinica() {
		return this.cartellaClinica;
	}

	public void setCartellaClinica(CartellaClinica cartellaClinica) {
		this.cartellaClinica = cartellaClinica;
	}

	public Paziente getPaziente() {
		return this.paziente;
	}

	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}

	public Medico getMedico() {
		return this.medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public String getIcd10() {
		return this.icd10;
	}

	public void setIcd10(String icd10) {
		this.icd10 = icd10;
	}

	public String getPatologia() {
		return this.patologia;
	}

	public void setPatologia(String patologia) {
		this.patologia = patologia;
	}

	public Set getConfermes() {
		return this.confermes;
	}

	public void setConfermes(Set confermes) {
		this.confermes = confermes;
	}

	public Set getContraddizionis() {
		return this.contraddizionis;
	}

	public void setContraddizionis(Set contraddizionis) {
		this.contraddizionis = contraddizionis;
	}

}
