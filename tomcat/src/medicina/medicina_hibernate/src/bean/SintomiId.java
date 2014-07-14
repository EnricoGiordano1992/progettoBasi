package bean;

// Generated 14-lug-2014 18.07.36 by Hibernate Tools 3.4.0.CR1

/**
 * SintomiId generated by hbm2java
 */
public class SintomiId implements java.io.Serializable {

	private String nome;
	private String idCartella;

	public SintomiId() {
	}

	public SintomiId(String nome, String idCartella) {
		this.nome = nome;
		this.idCartella = idCartella;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		if (!(other instanceof SintomiId))
			return false;
		SintomiId castOther = (SintomiId) other;

		return ((this.getNome() == castOther.getNome()) || (this.getNome() != null
				&& castOther.getNome() != null && this.getNome().equals(
				castOther.getNome())))
				&& ((this.getIdCartella() == castOther.getIdCartella()) || (this
						.getIdCartella() != null
						&& castOther.getIdCartella() != null && this
						.getIdCartella().equals(castOther.getIdCartella())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getNome() == null ? 0 : this.getNome().hashCode());
		result = 37
				* result
				+ (getIdCartella() == null ? 0 : this.getIdCartella()
						.hashCode());
		return result;
	}

}
