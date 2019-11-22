package sistema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import caixas.CaixaCircular;
import caixas.CaixaDecorativa;
import caixas.CaixaPentagonal;
import caixas.CaixaRetangular;

public class Controlador {

	private Map<String, CaixaDecorativa> mapaCaixas;

	public Controlador() {
		this.mapaCaixas = new HashMap<String, CaixaDecorativa>();
	}

	private void verificaMedida(int medida) {
		if (medida < 0) {
			throw new IllegalArgumentException("Valor de medida invalido.");
		}
	}

	private void existeCaixa(String descCaixa) {
		if (this.mapaCaixas.containsKey(descCaixa)) {
			throw new IllegalArgumentException("Ja existe uma caixa cadastrada com esta descricao.");
		}
	}

	private void naoExisteCaixa(String descCaixa) {
		if (!this.mapaCaixas.containsKey(descCaixa)) {
			throw new IllegalArgumentException("Nao existe caixa cadastrada com esta descricao.");
		}
	}

	public void cadastraCaixaPentagonal(String descUnica, String personalizacao, int lado) {
		CaixaPentagonal caixa = new CaixaPentagonal(descUnica, personalizacao, lado);
		existeCaixa(descUnica);
		verificaMedida(lado);
		this.mapaCaixas.put(descUnica, caixa);
	}

	public void cadastraCaixaRetangular(String descUnica, String personalizacao, int lado1, int lado2) {
		CaixaRetangular caixa = new CaixaRetangular(descUnica, personalizacao, lado1, lado2);
		existeCaixa(descUnica);
		verificaMedida(lado1);
		verificaMedida(lado2);
		this.mapaCaixas.put(descUnica, caixa);
	}

	public void cadastraCaixaCircular(String descUnica, String personalizacao, int raio) {
		CaixaCircular caixa = new CaixaCircular(descUnica, personalizacao, raio);
		existeCaixa(descUnica);
		verificaMedida(raio);
		this.mapaCaixas.put(descUnica, caixa);
	}

	public void modificar(String descCaixa, String novaPersonalizacao) {
		naoExisteCaixa(descCaixa);
		this.mapaCaixas.get(descCaixa).setPersonalizacao(novaPersonalizacao);
	}

	public boolean remover(String descUnica) {
		if (!this.mapaCaixas.containsKey(descUnica)) {
			return false;
		}
		this.mapaCaixas.remove(descUnica);
		return true;
	}

	public boolean contem(String personalizacao, String formato) {
		List<CaixaDecorativa> listaCaixas = new ArrayList<>(this.mapaCaixas.values());
		for (CaixaDecorativa caixa : listaCaixas) {
			if (caixa.getPersonalizacao().equals(personalizacao) && caixa.getFormato().equals(formato)) {
				return true;
			}
		}
		return false;
	}

	public List<String> pesquisa(String personalizacao) {
		List<String> saida = new ArrayList<>();
		for (String chave : this.mapaCaixas.keySet()) {
			if (this.mapaCaixas.get(chave).getPersonalizacao().equals(personalizacao)) {
				saida.add(chave);
			}
		}
		Collections.sort(saida);
		return saida;
	}

	public int calcularRendimentos() {
		int saida = 0;
		List<CaixaDecorativa> listaCaixas = new ArrayList<>(this.mapaCaixas.values());
		for (CaixaDecorativa caixa : listaCaixas) {
			saida += caixa.getPreco();
		}
		return saida;
	}

	public String exibeCaixa(String descCaixa) {
		naoExisteCaixa(descCaixa);
		return this.mapaCaixas.get(descCaixa).toString();
	}

}
