package sistema;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControladorTest {

	private Controlador f;

	@BeforeEach
	void testControlador() {
		f = new Controlador();
		f.cadastraCaixaPentagonal("CP1", "cor vermelha", 1);
		f.cadastraCaixaRetangular("CR1", "cor vermelha", 3, 5);
		f.cadastraCaixaCircular("CC1", "cor verde", 2);
	}

	@Test
	void testCadastraCaixaPentagonal() {
		f.cadastraCaixaPentagonal("CP2", "cor vermelha", 1);
		assertEquals("Caixa com cor vermelha custa 17 centavos. Formato pentagonal.", f.exibeCaixa("CP2"));
	}

	@Test
	void testCadastraCaixaRetangular() {
		f.cadastraCaixaRetangular("CR2", "cor vermelha", 3, 5);
		assertEquals("Caixa com cor vermelha custa 150 centavos. Formato retangular.", f.exibeCaixa("CR2"));
	}

	@Test
	void testCadastraCaixaCircular() {
		f.cadastraCaixaCircular("CC2", "cor verde", 2);
		assertEquals("Caixa com cor verde custa 40 centavos. Formato circular.", f.exibeCaixa("CC2"));
	}

	@Test
	void testModificar() {
		f.modificar("CC1", "cor vermelha");
		assertEquals("Caixa com cor vermelha custa 40 centavos. Formato circular.", f.exibeCaixa("CC1"));

	}

	@Test
	void testRemover() {
		f.remover("CC1");
		try {
			f.exibeCaixa("CC1");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Nao existe caixa cadastrada com esta descricao.", e.getMessage());
		}
	}

	@Test
	void testContem() {
		assertTrue(f.contem("cor vermelha", "retangular"));
	}

	@Test
	void testPesquisa() {
		List<String> lista = new ArrayList<>();
		lista.add("CP1");
		lista.add("CR1");
		assertEquals(lista, f.pesquisa("cor vermelha"));
	}

	@Test
	void testCalcularRendimentos() {
		assertTrue(207 == f.calcularRendimentos());
	}

	@Test
	void testExibeCaixa() {
		assertEquals("Caixa com cor verde custa 40 centavos. Formato circular.", f.exibeCaixa("CC1"));
	}

}
