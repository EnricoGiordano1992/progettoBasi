package bean;

// Generated 14-lug-2014 18.07.36 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * DiagnosiId generated by hbm2java
 */
public class DiagnosiId implements java.io.Serializable {

	private String idPaziente;
	private Date data;
	private String idCartella;

	public DiagnosiId() {
	}

	public DiagnosiId(String idPaziente, Date data, String idCartella) {
		this.idPaziente = idPaziente;
		this.data = data;
		this.idCartella = idCartella;
	}

	public String getIdPaziente() {
		return this.idPaziente;
	}

	public void setIdPaziente(String idPaziente) {
		this.idPaziente = idPaziente;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getIdCartella() {
		return this.idCartella;
	}

	public void setIdCartella(String idCartella) {
		this.idCartella = idCartella;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DiagnosiId))
			return false;
		DiagnosiId castOther = (DiagnosiId) other;

		return ((this.getIdPaziente() == castOther.getIdPaziente()) || (this
				.getIdPaziente() != null && castOther.getIdPaziente() != null && this
				.getIdPaziente().equals(castOther.getIdPaziente())))
				&& ((this.getData() == castOther.getData()) || (this.getData() != null
						&& castOther.getData() != null && this.getData()
						.equals(castOther.getData())))
				&& ((this.getIdCartella() == castOther.getIdCartella()) || (this
						.getIdCartella() != null
						&& castOther.getIdCartella() != null && this
						.getIdCartella().equals(castOther.getIdCartella())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getIdPaziente() == null ? 0 : this.getIdPaziente()
						.hashCode());
		result = 37 * result
				+ (getData() == null ? 0 : this.getData().hashCode());
		result = 37
				* result
				+ (getIdCartella() == null ? 0 : this.getIdCartella()
						.hashCode());
		return result;
	}

}
