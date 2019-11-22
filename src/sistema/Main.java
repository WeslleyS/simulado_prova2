package sistema;

public class Main {

	private static Facade f;

	public static void main(String[] args) {
		f = new Facade();

		f.cadastraCaixaCircular("CC1", "cor verde", 2);
		f.cadastraCaixaPentagonal("CP1", "cor vermelha", 1);
		f.cadastraCaixaRetangular("CR1", "cor vermelha", 3, 5);
		System.out.println("===============================================");
		System.out.println("Rendimentos: " + f.calcularRendimentos() + "centavos.");
		f.modificar("CC1", "cor vermelha");
		if (f.contem("cor vermelha", "circular")) {
			System.out.println("Contem caixa circular com cor vermelha.");
		}
		System.out.println("===============================================");
		for (String desc : f.pesquisa("cor vermelha")) {
			System.out.println(desc);
		}
		System.out.println("===============================================");
		System.out.println("Exibindo caixas:");
		System.out.println(f.exibeCaixa("CC1"));
		System.out.println(f.exibeCaixa("CP1"));
		System.out.println(f.exibeCaixa("CR1"));
	}

}
