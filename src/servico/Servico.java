package servico;

import java.util.HashMap;

// Importação de pacotes
// import modelo.Usuario;
import modelo.Livro;
// import modelo.Emprestimo;
// import repositorio.BDBiblioteca;

public class Servico {
  private HashMap<String, Livro> livros;

  // Função que consulta o livro através do identificador ISBN.
  // Caso encontre o ISBN do livro no sistema, então retorna o relatório,
  // caso não encontre, retorna uma mensagem de erro.
  public String consultarLivroISBN(String isbn) {
    if (this.livros.containsKey(isbn)) {
      return this.livros.get(isbn).toString();
    }
    return "Este livro não está cadastrado no sistema.";
  }

  // Funcao que lista todos os livros cadastrados no sistema, 
  // imprimindo o ISBN e o nome do livro
  public String listarLivros() {
    String lista = "Livros cadastrados no sistema: \n";
    for(String l : this.livros.keySet()) {
      lista += l + " - " + this.livros.get(l).getTitulo() + "\n";
    }
    return lista;
  }

  // Validações a ponderar para serem implementadas nesta função:
  // - Eh possivel remover livros mesmo que o livro esteja emprestado?
  // - Eh possivel remover livros mesmo que o livro ainda tenha exemplares na biblioteca?
  public void removerLivro() {
  }
}
