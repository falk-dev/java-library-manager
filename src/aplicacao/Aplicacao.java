package aplicacao;
import java.util.Scanner;
import servico.Servico;

public class Aplicacao{
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Servico s = new Servico();
		byte op;
	
		do {
			String resposta = "";
			Aplicacao.printMenu();
			System.out.println("\nDigite a opção desejada: ");
			op = Byte.parseByte(teclado.nextLine());

			switch (op) {
				case 1:
					System.out.println("\n========= CADASTRO DE LIVRO =========\n");
					System.out.println("Nome da obra: ");
					String titulo = teclado.nextLine();
					System.out.println("ISBN: ");
					String isbn = teclado.nextLine();
					System.out.println("Ano de publicação: ");
					String ano = teclado.nextLine();
					System.out.println("Editora: ");
					String editora = teclado.nextLine();
					System.out.println("Quantidade de exemplares: ");
					int quantidade = teclado.nextInt();
					teclado.nextLine(); // Limpando o buffer pois a entrada anterior eh um inteiro
					System.out.println("Autor identificado? [S/N]: ");
					char resp = teclado.nextLine().charAt(0);
					if (resp == 'S' || resp == 's') {
						System.out.println("Nome do autor: ");
						String autor = teclado.nextLine();
						System.out.println();
						resposta = s.cadastrarLivro(titulo, autor, isbn, editora, ano, quantidade);
					} else {
						resposta = s.cadastrarLivro(titulo, isbn, editora, ano, quantidade);
					}
					break;
				case 2:
					System.out.println("\n========= CONSULTA POR ISBN =========\n");
					System.out.println("Informe o ISBN: ");
					isbn = teclado.nextLine();
					resposta = s.getLivroISBN(isbn);
					break;
				case 3:
					System.out.println("\n========= CONSULTA POR AUTOR =========\n");
					System.out.println("Informe o Autor: ");
					String autor = teclado.nextLine();
					resposta = s.getLivrosAutor(autor);
					break;
				case 4:
					System.out.println("\n========= RELATORIO DE LIVROS =========\n");
					resposta = s.getRelatorioLivros();
					break;
				case 5:
					System.out.println("\n========= REMOVER LIVRO =========\n");
					System.out.println("Informe o ISBN: ");
					isbn = teclado.nextLine();
					resposta = s.removerLivro(isbn);
					break;
				case 6:
					System.out.println("\n========= EMPRÉSTIMO DE LIVRO =========\n");
					System.out.println("ISBN da obra: ");
					isbn = teclado.nextLine();
					System.out.println("CPF do usuário: ");
					String cpf = teclado.nextLine();
					System.out.println("Data de Emprestimo: ");
					String dataEmprestimo = teclado.nextLine();
					System.out.println("Data estimada de devolução: ");
					String dataEstimadaDevolucao = teclado.nextLine();
					resposta = s.realizarEmprestimo(isbn, cpf, dataEmprestimo, dataEstimadaDevolucao);
					break;
				case 7:
					System.out.println("\n========= DEVOLUÇÃO DE LIVRO =========\n");
					System.out.println("ISBN da obra: ");
					isbn = teclado.nextLine();
					System.out.println("CPF do usuário: ");
					cpf = teclado.nextLine();
					System.out.println("Data de Emprestimo: ");
					dataEmprestimo = teclado.nextLine();
					System.out.println("Data estimada de devolução: ");
					String dataDevolucao = teclado.nextLine();
					resposta = s.realizarDevolucao(isbn, cpf, dataEmprestimo, dataDevolucao);
					break;
				case 8:
					System.out.println("\n========= LIVROS EMPRESTADOS =========\n");
					resposta = s.getRealatorioLivrosEmprestados();
					break;
				case 9:
					System.out.println("\n========= LIVROS DISPONÍVEIS =========\n");
					resposta = s.getRelatorioLivrosDisponiveis();
					break;
				case 10:
					System.out.println("\n========= RELATÓRIO DE EMPRESTIMOS =========\n");
					resposta = s.getRelatorioEmprestimos();
					break;
				case 0:
					System.out.println("Programa encerrado");
					break;
				default:
				System.out.println("Digite uma opção válida.");
					break;
			}
			System.out.println("\n" + resposta);

			// Chamando a limpeza de console
			System.out.println("\nPressione Enter para limpar o console...");
      teclado.nextLine();
			clearConsole();
		} while (op != 0);
		
		teclado.close();
	}

	public static void printMenu() {
		String menu = "\n1 - Cadastrar Livro";
		menu += "\n2 - Consultar livro por ISBN";
		menu += "\n3 - Consultar livro por autor";
		menu += "\n4 - Listar todos os livros";
		menu += "\n5 - Remover livro";
		menu += "\n6 - Realizar empréstimo de um livro";
		menu += "\n7 - Registrar devolução de um livro";
		menu += "\n8 - Consultar livros emprestados";
		menu += "\n9 - Consultar livros disponíveis";
		menu += "\n10 - Listar histórico de empréstimos de livros";
		menu += "\n0 - Sair do programa";
		System.out.println(menu);
	}

	// Para fazer a limpeza do console
	public static void clearConsole() {
    try {
        if (System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        }
    } catch (Exception e) {
        System.out.println("Erro ao limpar o console.");
    }
	}

}
