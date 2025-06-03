package servico;

// Importação de pacotes
import modelo.Emprestimo;
import modelo.Livro;
import modelo.Usuario;
import repositorio.BDBiblioteca;

public class Servico {
  private Livro l;
  private Emprestimo e;

  // Metodo de cadastrar livro quando nao houver autoria identificada
  public String cadastrarLivro(String titulo, String isbn, String editora, String ano, int quantidade) {
    l = new Livro(titulo, isbn, editora, ano, quantidade);
    if(BDBiblioteca.addLivro(l)) {
      return "Livro cadastrado com sucesso!";
    }
    return "Este livro ja foi cadastrado anteriormente!";
  }

  // Metodo de cadastrar livro quando houver autoria identificada
  public String cadastrarLivro(String titulo, String autor, String isbn, String editora, String ano, int quantidade) {
    l = new Livro(titulo, autor, isbn, editora, ano, quantidade);
    if(BDBiblioteca.addLivro(l)) {
      return "Livro cadastrado com sucesso!";
    }
    return "Este livro ja foi cadastrado anteriormente!";
  }

  // Validacoes a ponderar para serem implementadas neste metodo:
  // - Eh possivel remover livros mesmo que o livro esteja emprestado?
  // - Eh possivel remover livros mesmo que o livro ainda tenha exemplares na biblioteca?
  public void removerLivro() {
  }

  // Metodo que mostra o relatorio de todos os livros cadastrados.
  // A forma usada para percorrer eh o foreach, a primeira parte da
  // estrutura comunicando que os elementos sao do tipo Livro, e serao
  // apelidados de 'l'. Dai a segunda parte comunica que o metodo a 
  // ser acessado 'getLivros()' esta na classe BDBiblioteca, e estou
  // percorrendo os valores do mapa, que constam todas as informacoes:
  // Titulo, autor, ISBN, ano de lancamento e editora. Neste caso, nao eh
  // interessante percorrer as chaves, pois retornaria apenas o numero do
  // ISBN, que foi definido como o identificador (chave) de cada livro.
  public String getRelatorioLivros() {
    String lista = "";
    for(Livro l : BDBiblioteca.getLivros().values()) {
      lista += l.toString();
			lista += "\n=============================\n";
    }
    return lista;
  }

  // Metodo que consulta o livro atraves do identificador ISBN.
  // Caso encontre o ISBN do livro no banco, entao retorna o relatorio,
  // caso nao encontre, retorna uma mensagem de erro.
  public String getLivroISBN(String isbn) {
    if (BDBiblioteca.getLivros().containsKey(isbn)) {
      return BDBiblioteca.getLivros().get(isbn).toString();
    }
    return "Este livro nao esta cadastrado no sistema.";
  }

  public String realizarEmprestimo(Livro livro, Usuario usuario, String dataEmprestimo, String dataEstimadaDevolucao) {
    e = new Emprestimo(livro, usuario, dataEmprestimo, dataEstimadaDevolucao);
    if(BDBiblioteca.addEmprestimo(e)) {
      return "Emprestimo realizado com sucesso.";
    }
    return "O livro que voce escolheu nao esta disponivel para emprestimo.";
  }
}
