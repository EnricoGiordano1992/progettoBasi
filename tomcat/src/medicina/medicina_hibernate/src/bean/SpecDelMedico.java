package bean;

// Generated 12-lug-2014 19.15.43 by Hibernate Tools 3.4.0.CR1

/**
 * SpecDelMedico generated by hbm2java
 */
public class SpecDelMedico implements java.io.Serializable {

	private SpecDelMedicoId id;
	private Specializzazioni specializzazioni;
	private Medico medico;

	public SpecDelMedico() {
	}

	public SpecDelMedico(SpecDelMedicoId id, Specializzazioni specializzazioni,
			Medico medico) {
		this.id = id;
		this.specializzazioni = specializzazioni;
		this.medico = medico;
	}

	public SpecDelMedicoId getId() {
		return this.id;
	}

	public void setId(SpecDelMedicoId id) {
		this.id = id;
	}

	public Specializzazioni getSpecializzazioni() {
		return this.specializzazioni;
	}

	public void setSpecializzazioni(Specializzazioni specializzazioni) {
		this.specializzazioni = specializzazioni;
	}

	public Medico getMedico() {
		return this.medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

}
