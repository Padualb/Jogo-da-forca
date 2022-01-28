//LUCAS DE PÁDUA BERGAMASCHI
// 200049429


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = 51;
		int p = 51;
		String[][] tp = new String[t][p];

		int escolhaMenu = 0;
		int escolhaTema = 0;
		int escolhaPalavra = 0;

		// PRE CARREGAMENTO DOS TEMAS

		tp[0][0] = "cidade";
		tp[1][0] = "pais";
		tp[2][0] = "estado";
		tp[3][0] = "nome";
		tp[4][0] = "animal";

		// PRE CARREGAMENTO DAS PALAVRAS
		// CIDADE
		tp[0][1] = "bsb";
		tp[0][2] = "gyn";
		tp[0][3] = "salvador";
		tp[0][4] = "guarulhos";
		tp[0][5] = "vitoria";
		tp[0][6] = "porto";
		tp[0][7] = "lisboa";
		tp[0][8] = "lima";
		tp[0][9] = "londres";
		tp[0][10] = "bergamo";
		// PAÍS
		tp[1][1] = "brasil";
		tp[1][2] = "peru";
		tp[1][3] = "inglaterra";
		tp[1][4] = "argentina";
		tp[1][5] = "italia";
		tp[1][6] = "portugal";
		tp[1][7] = "bolivia";
		tp[1][8] = "espanha";
		tp[1][9] = "escocia";
		tp[1][10] = "frança";
		// ESTADO
		tp[2][1] = "ba";
		tp[2][2] = "df";
		tp[2][3] = "rj";
		tp[2][4] = "am";
		tp[2][5] = "ac";
		tp[2][6] = "es";
		tp[2][7] = "pa";
		tp[2][8] = "pe";
		tp[2][9] = "ro";
		tp[2][10] = "ma";
		// NOME
		tp[3][1] = "barcos";
		tp[3][2] = "durval";
		tp[3][3] = "rogerio";
		tp[3][4] = "antonio";
		tp[3][5] = "arthur";
		tp[3][6] = "sofia";
		tp[3][7] = "patrick";
		tp[3][8] = "pedro";
		tp[3][9] = "rodrigo";
		tp[3][10] = "maria";
		// ANIMAL
		tp[4][1] = "formiga";
		tp[4][2] = "baleia";
		tp[4][3] = "leao";
		tp[4][4] = "lobo";
		tp[4][5] = "avestruz";
		tp[4][6] = "tigre";
		tp[4][7] = "pato";
		tp[4][8] = "ganso";
		tp[4][9] = "rato";
		tp[4][10] = "veado";

		do {

			menu();
			escolhaMenu = sc.nextInt();

			switch (escolhaMenu) {

			case 1:

				menuTemas();
				escolhaTema = sc.nextInt();

				switch (escolhaTema) {

				case 1:

					adicionaTema(tp);
					removeDuplicados(tp);
					break;

				case 2:
					listaTema(tp);
					removeTema(tp);
					break;

				case 3:

					buscaTema(tp, t);
					break;
				}

				break;

			case 2:

				menuPalavras();
				escolhaPalavra = sc.nextInt();

				switch (escolhaPalavra) {

				case 1:
					listaTema(tp);
					adicionaPalavra(tp, t);
					break;

				case 2:
					excluiPalavra(tp, t, p);
					break;

				case 3:
					buscaPalavra(tp);
					break;

				case 4:
					listaTema(tp);
					listaPalavra(tp);
					break;
				}

				break;

			case 3:
				listaTema(tp);
				jogo(tp);
				break;

			case 4:

				break;
			}

		} while (escolhaMenu != 4);

	}

	// MÉTODO QUE MOSTRA O MENU PRINCIPAL

	public static void menu() {

		System.out.println();
		System.out.println("           _____________MENU___________");
		System.out.println("          |                            |");
		System.out.println("          |      Digite um número      |");
		System.out.println("          |                            |");
		System.out.println("          |    1- Gerenciar temas      |");
		System.out.println("          |    2- Gerenciar Palavras   |");
		System.out.println("          |    3- Jogar                |");
		System.out.println("          |    4- Sair                 |");
		System.out.println("          |                            |");
		System.out.println("          |____________________________|");
	}

	// MÉTODO QUE MOSTRA O MENU DOS TEMAS

	public static void menuTemas() {

		System.out.println();
		System.out.println("           __________MENU_TEMAS________ ");
		System.out.println("          |                            |");
		System.out.println("          |      Digite um número      |");
		System.out.println("          |                            |");
		System.out.println("          |    1- Cadastrar um tema    |");
		System.out.println("          |    2- Excluir um tema      |");
		System.out.println("          |    3- Buscar por tema já   |");
		System.out.println("          |         cadastrado         |");
		System.out.println("          |                            |");
		System.out.println("          |____________________________|");

	}

	// MÉTODO QUE ADICIONA OS TEMAS A MATRIZ

	public static void adicionaTema(String[][] tp) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Quantos temas deseja cadastrar?");
		int qntTema = sc.nextInt();

		for (int i = 0; i < qntTema; i++) {

			System.out.println("Digite o nome do tema " + (i + 1) + " :");
			tp[i][0] = sc.next();
		}

	}

	// MÉTODO QUE REMOVE TEMAS DUPLICADOS

	public static void removeDuplicados(String[][] tp) {

		for (int i = 0; i < tp.length; i++) {
			for (int j = i + 1; j < tp.length; j++) {

				if (tp[i][0] != null && tp[i][0].equalsIgnoreCase(tp[j][0])) {
					tp[j][0] = null;

					System.out.println("A duplicação do tema " + tp[i][0] + " foi removida");
					break;
				}

			}
		}

	}

	// MÉTODO PARA LISTAGEM DOS TEMAS
	private static void listaTema(String[][] tp) {
		System.out.println("Temas cadastrados:");
		for (int i = 0; i < tp.length; i++) {

			if (tp[i][0] != null) {
				System.out.println("- " + tp[i][0]);

			}
		}
	}

	// MÉTODO QUE REMOVE OS TEMAS DA MATRIZ

	public static void removeTema(String[][] tp) {

		Scanner sc = new Scanner(System.in);
		String removerTema;
		boolean x = false;

		System.out.println("Qual tema deseja excluir?");
		removerTema = sc.next();

		for (int i = 0; i < tp.length; i++) {

			if (removerTema.equalsIgnoreCase(tp[i][0]) && tp[i][1] == null) {
				tp[i][0] = null;
				x = true;
				break;
			}
		}

		if (x == true) {
			System.out.println("Tema excluído com sucesso");
		} else {
			System.out.println(
					"Não foi possível excluir o tema." + " Verifique se existem palavras cadastradas nesse tema.");
		}

	}

	// MÉTODO QUE BUSCA OS TEMAS DA MATRIZ

	public static void buscaTema(String[][] tp, int t) {

		Scanner sc = new Scanner(System.in);
		String buscarTema;
		boolean cadastrado = false;

		System.out.println("Digite o tema de busca: ");
		buscarTema = sc.next();

		for (int i = 0; i < t; i++) {
			if (buscarTema.equalsIgnoreCase(tp[i][0])) {

				cadastrado = true;
				break;
			}

		}
		if (cadastrado == false) {
			System.out.println("Tema não encontrado");

		} else {
			System.out.println("Tema encontrado");
		}

	}

	// MÉTODO QUE MOSTRA O MENU DAS PALAVRAS

	public static void menuPalavras() {

		System.out.println();
		System.out.println("           ________MENU_PALAVRAS_______ ");
		System.out.println("          |                            |");
		System.out.println("          |      Digite um número      |");
		System.out.println("          |                            |");
		System.out.println("          |   1- Cadastrar uma palavra |");
		System.out.println("          |   2- Excluir uma palavra   |");
		System.out.println("          |   3- Buscar por palavra já |");
		System.out.println("          |   cadastrada               |");
		System.out.println("          |   4-Listagem               |");
		System.out.println("          |____________________________|");

	}

	// MÉTODO QUE ADICIONA PALAVRAS A MATRIZ

	private static void adicionaPalavra(String[][] tp, int t) {

		Scanner sc = new Scanner(System.in);
		String nomeTema;
		boolean x = false;
		int qntdPalavras;
		int coluna = 0;

		System.out.println("Deseja adicionar uma palavra a qual tema?");
		nomeTema = sc.next();

		for (int i = 0; i < t; i++) {
			if (nomeTema.equalsIgnoreCase(tp[i][0])) {
				x = true;
				coluna = i;
				break;

			}
		}

		if (x == false) {
			System.out.println("Tema não encontrado!");
		} else {
			System.out.println("Deseja adicionar quantas palavras ao tema " + nomeTema);
			qntdPalavras = sc.nextInt();

			for (int i = 0; i < qntdPalavras; i++) {
				System.out.println("Qual a palavra " + (i + 1) + " :");
				tp[coluna][i + 1] = sc.next();
			}

			// REMOVENDO PALAVRAS DUPLICADAS NO MESMO TEMA
			for (int i = 0; i < tp.length; i++) {
				for (int j = i + 1; j < tp.length; j++) {
					if (tp[coluna][i] != null && tp[coluna][i].equalsIgnoreCase(tp[coluna][j])) {
						tp[coluna][j] = null;
						System.out.println("A duplicação da palavra " + tp[coluna][i] + " foi removida");
						break;
					}
				}
			}
		}
	}

	// MÉTODO QUE EXCLUI PALAVRAS DA MATRIZ

	private static void excluiPalavra(String[][] tp, int t, int p) {

		Scanner sc = new Scanner(System.in);
		String removerPalavra;
		boolean x = false;

		System.out.println("Digite a palavra a ser removida: ");
		removerPalavra = sc.next();

		for (int i = 0; i < tp.length; i++) {
			for (int j = 0; j < tp.length; j++) {
				if (removerPalavra.equalsIgnoreCase(tp[i][j]) && removerPalavra != tp[i][0]) {
					tp[i][j] = null;
					x = true;
					break;
				}
			}
		}

		if (x == false) {
			System.out.println("Palavra não encontrada");
		} else {
			System.out.println("Palavra removida com sucesso");
		}
	}

	// MÉTODO QUE BUSCA PALAVRAS DA MATRIZ

	private static void buscaPalavra(String[][] tp) {

		Scanner sc = new Scanner(System.in);
		String buscarPalavra;

		boolean x = false;

		int linha = 0;

		System.out.println("Digite a palavra a ser buscada: ");
		buscarPalavra = sc.next();

		for (int i = 0; i < tp.length; i++) {
			for (int j = 1; j < tp.length; j++) {
				if (buscarPalavra.equalsIgnoreCase(tp[i][j])) {
					x = true;
					linha = i;

					break;

				}
			}
		}

		if (x == true) {
			System.out.println("Palavra já cadastrada no tema: " + tp[linha][0]);

		} else {
			System.out.println("Palavra não cadastrada");
		}

	}

	// MÉTODO QUE LISTA AS PALAVRAS DA MATRIZ
	private static void listaPalavra(String[][] tp) {

		Scanner sc = new Scanner(System.in);
		boolean x = false;
		int linha = 0;

		System.out.println("Deseja ver as palavras cadastradas em qual dos temas?");
		String tema = sc.next();

		for (int i = 0; i < tp.length; i++) {

			if (tema.equalsIgnoreCase(tp[i][0])) {
				x = true;
				linha = i;
				break;
			}
		}

		if (x == true) {
			System.out.println("Palavras cadastradas no tema " + tema + ":");
			for (int i = 1; i < tp.length; i++) {
				if (tp[linha][i] != null) {
					System.out.println("- " + tp[linha][i]);
				}
			}
		} else {
			System.out.println("Esse tema não está cadastrado");
		}
	}

	// MÉTODO DO JOGO
	private static void jogo(String[][] tp) {

		Scanner sc = new Scanner(System.in);

		String tema;
		int linha = 0;
		boolean x = false;
		String palavra = null;
		char letra;
		Random random = new Random();
		int rodada = 0;
		int erro = 0;
		boolean y = false; // VARIÁVEL P/ VERIFICAR SE O JOGADOR GANHOU
		boolean z = false; // VARIÁVEL P/ VERIFICAR SE OS ERROS
		String newGame = null;
		boolean menu = true;

		while (menu == true) {

			menu = false;
			System.out.println("Digite o tema que deseja:");
			tema = sc.next();

			for (int i = 0; i < tp.length; i++) {
				if (tema.equalsIgnoreCase(tp[i][0])) {
					linha = i;
					x = true;
					break;
				} else {
					continue;
				}
			}

			if (x == true) {

				for (int i = 0;; i++) {
					int numSorte = random.nextInt(tp.length);
					if (tp[linha][numSorte] != null && numSorte != 0) {
						palavra = tp[linha][numSorte];
						break;
					}
				}
			}

			System.out.println("Palavra escolhida!");

			char[] acertos = new char[palavra.length()];
			for (int i = 0; i < acertos.length; i++) {
				acertos[i] = 0;
			}
			rodada =0;
			y = false;
			erro = 0;
			while (y == false) {

				z = false;
				rodada++;
				System.out.println();
				System.out.println("========================");
				System.out.println("Rodada " + rodada);
				System.out.println("Digite ume letra:");
				letra = sc.next().charAt(0);

				for (int i = 0; i < palavra.length(); i++) {

					if (letra == palavra.charAt(i)) {
						System.out.println("Acertou!");
						acertos[i] = 1;
						z = true;
					}

				}
				y = true;

				for (int i = 0; i < palavra.length(); i++) {

					if (acertos[i] == 0) {
						System.out.print("_ ");
						y = false;

					} else {
						System.out.print(palavra.charAt(i));

					}

				}

				if (z == false) {
					erro++;
				}

				z = true;

				if (y == true) {
					System.out.println();
					System.out.println("========================");
					System.out.println("Parabéns, Você acertou a palavra!");
					System.out.println("Deseja jogar novamente? (s/n)");
					newGame = sc.next();
					if (newGame.equalsIgnoreCase("s")) {
						menu = true;
						y = true;
					} else {
						y = true;
					}
				}
				if (erro == 5) {
					System.out.println();
					System.out.println("========================");
					System.out.println("Você perdeu :(");
					System.out.println("Deseja jogar novamente? (s/n)");
					newGame = sc.next();
					if (newGame.equalsIgnoreCase("s")) {
						menu = true;
						y = true;
					} else {
						y = true;
					}
				}

			}
		}
	}
}