package caixas;

public class CaixaPentagonal extends CaixaDecorativa {

	private int lado;

	private String formato;

	public CaixaPentagonal(String descUnica, String personalizacao, int lado) {
		super(descUnica, personalizacao);
		this.lado = lado;
		this.formato = "pentagonal";
	}

	private double areaDaTampa() {
		return 1.72048 * Math.pow(this.lado, 2);
	}

	public int getPreco() {
		return (int) (10 * areaDaTampa());
	}

	public String getFormato() {
		return formato;
	}

	@Override
	public String toString() {
		return "Caixa com " + this.personalizacao + " custa " + getPreco() + " centavos. Formato " + this.formato + ".";
	}

}
