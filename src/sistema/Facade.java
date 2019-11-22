package sistema;

import java.util.List;

public class Facade {

	private Controlador c;

	public Facade() {
		this.c = new Controlador();
	}

	public void cadastraCaixaPentagonal(String descUnica, String personalizacao, int lado) {
		c.cadastraCaixaPentagonal(descUnica, personalizacao, lado);
	}

	public void cadastraCaixaRetangular(String descUnica, String personalizacao, int lado1, int lado2) {
		c.cadastraCaixaRetangular(descUnica, personalizacao, lado1, lado2);
	}

	public void cadastraCaixaCircular(String descUnica, String personalizacao, int raio) {
		c.cadastraCaixaCircular(descUnica, personalizacao, raio);
	}

	public void modificar(String descCaixa, String novaPersonalizacao) {
		c.modificar(descCaixa, novaPersonalizacao);
	}

	public boolean remover(String descUnica) {
		return c.remover(descUnica);
	}

	public boolean contem(String personalizacao, String formato) {
		return c.contem(personalizacao, formato);
	}

	public List<String> pesquisa(String personalizacao) {
		return c.pesquisa(personalizacao);
	}

	public int calcularRendimentos() {
		return c.calcularRendimentos();
	}
	
	public String exibeCaixa(String descCaixa) {
		return c.exibeCaixa(descCaixa);
	}

}
