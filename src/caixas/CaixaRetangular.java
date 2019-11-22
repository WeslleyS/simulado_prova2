package caixas;

public class CaixaRetangular extends CaixaDecorativa {

	private int lado1;

	private int lado2;

	private String formato;

	public CaixaRetangular(String descUnica, String personalizacao, int lado1, int lado2) {
		super(descUnica, personalizacao);
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.formato = "retangular";
	}

	private double areaDaTampa() {
		return (this.lado1 * lado2);
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
