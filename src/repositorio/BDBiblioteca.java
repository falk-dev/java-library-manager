package repositorio;
import java.util.HashMap;

import modelo.Emprestimo;
// import modelo.Usuario;
import modelo.Livro;

public class BDBiblioteca {
  private static HashMap<String, Livro> livros = new HashMap<String, Livro>();
  private static HashMap<String, Emprestimo> emprestimos = new HashMap<String, Emprestimo>();

  // Metodo para obter todos os livros cadastrados
  // no banco
  public static HashMap<String, Livro> getLivros() {
    return livros;
  }

  // Metodo para obter todos os empréstimos realizados 
  // cadastrados no banco
  public static HashMap<String, Emprestimo> getEmprestimos() {
    return emprestimos;
  }

  // Adicionando ao HashMap usando o ISBN como
  // identificador, caso esse codigo ja esteja
  // cadastrado, nao sera possivel cadastrar
  // novamente, retornando 'false' como resposta.
  // Mas se nao houver cadastro, sera feito o cadastro
  // e ira retornar 'true' como resposta.
  public static boolean addLivro(Livro l) {
    if (livros.containsKey(l.getIsbn())) return false;
    livros.put(l.getIsbn(), l);
    return true;
  }

  public static boolean addEmprestimo(Emprestimo e) {
    if (e.getLivro().getQuantidade() > 1) {
      emprestimos.put(e.getId(), e);
      return true;
    }
    return false;
  }
}
