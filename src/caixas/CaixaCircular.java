package caixas;

public class CaixaCircular extends CaixaDecorativa {

	private int raio;

	private String formato;


	public CaixaCircular(String descUnica, String personalizacao, int raio) {
		super(descUnica, personalizacao);
		this.raio = raio;
		this.formato = "circular";
	}

	public String getFormato() {
		return formato;
	}
	
	private double areaTampa() {
		return (Math.PI * Math.pow(this.raio, 2) / Math.PI);
	}

	public int getPreco() {
		return (int) (10 * areaTampa());
	}

	@Override
	public String toString() {
		return "Caixa com " + this.personalizacao + " custa " + getPreco() + " centavos. Formato " + this.formato + ".";
	}
}
