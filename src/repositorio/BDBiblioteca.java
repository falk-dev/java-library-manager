package repositorio;
import java.util.HashMap;

import modelo.Emprestimo;
import modelo.Livro;
import modelo.Usuario;

public class BDBiblioteca {
  private static HashMap<String, Livro> livros = new HashMap<String, Livro>();
  private static HashMap<String, Emprestimo> emprestimos = new HashMap<String, Emprestimo>();
  private static HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();

  // Método que retorna todos os livros cadastrados no banco como um mapa (ISBN -> Livro).
  public static HashMap<String, Livro> getLivros() {
    return livros;
  }

  // Método que retorna todos os empréstimos cadastrados no banco como um mapa (ISBN -> Empréstimo).
  public static HashMap<String, Emprestimo> getEmprestimos() {
    return emprestimos;
  }
  
  public static HashMap<String, Usuario> getUsuario(){
	  return usuarios;
  }

  // Adiciona um livro ao HashMap usando o ISBN como identificador.
  // Se o ISBN já estiver cadastrado, o método retorna false.
  // Caso contrário, o livro é cadastrado e o método retorna true.
  public static boolean addLivro(Livro l) {
    if (livros.containsKey(l.getIsbn())) return false;
    livros.put(l.getIsbn(), l);
    return true;
  }

  // Método para adicionar um empréstimo, usando o ISBN do livro como identificador.
  // Verifica se há mais de um exemplar disponível. Se houver, adiciona o empréstimo ao HashMap, diminui a quantidade em 1 e retorna 'true'.
  // Caso contrário, não realiza o empréstimo e retorna 'false'.
  public static boolean addEmprestimo(Emprestimo e) {
    if (e.getLivro().getQuantidade() > 1) {
      emprestimos.put(e.getLivro().getIsbn(), e);
      e.getLivro().setQuantidade(e.getLivro().getQuantidade() - 1);
      return true;
    }
    return false;
  }

  // Método responsável por registrar a devolução de um livro.
  // Verifica se o ISBN e a data do empréstimo informados correspondem
  // ao empréstimo em questão. Caso positivo, atualiza o status para
  // "Devolvido" e define a data da devolução. Retorna 'true' se a
  // devolução for registrada com sucesso, e 'false' caso contrário.
  public static boolean addDevolucao(Emprestimo e, String isbn, String dataEmprestimo, String dataDevolucao) {
    if(e.getLivro().getIsbn().equals(isbn) && e.getDataEmprestimo().equals(dataEmprestimo)) {
      e.setStatus("Devolvido");
      e.setDataDevolucao(dataDevolucao);
      return true;
    }
    return false;
  }
  
  // rubens -- daqui para baixo
  public static boolean addUsuario(Usuario u) {
	  if(usuarios.containsKey(u.getCpf())) {
		  return false;
	  }
	  usuarios.put(u.getCpf(), u);
	  return true;
  }
  public static Usuario getUsuario(String cpf) {
	    return usuarios.get(cpf); // Retorna o objeto Usuario se existir, senão null
	}
  
  // analisei outros codigos e acho que poderia remove usuario desse jeito
  public static void removerUsuario(String cpf) {
	  usuarios.remove(cpf);
  }
  
  
}
