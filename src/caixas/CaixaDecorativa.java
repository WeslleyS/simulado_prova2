package caixas;

public abstract class CaixaDecorativa {

	protected String descUnica;

	protected String personalizacao;

	public CaixaDecorativa(String descUnica, String personalizacao) {
		this.descUnica = descUnica;
		this.personalizacao = personalizacao;
	}

	public void setPersonalizacao(String novaPersonalizacao) {
		this.personalizacao = novaPersonalizacao;
	}

	public String getPersonalizacao() {
		return personalizacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descUnica == null) ? 0 : descUnica.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CaixaDecorativa other = (CaixaDecorativa) obj;
		if (descUnica == null) {
			if (other.descUnica != null)
				return false;
		} else if (!descUnica.equals(other.descUnica))
			return false;
		return true;
	}

	public abstract String getFormato();

	public abstract int getPreco();

}
