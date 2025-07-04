package repositorio;

import java.util.HashMap;

import modelo.Emprestimo;
import modelo.Livro;
import modelo.Usuario;

public class BDBiblioteca {
  private static HashMap<String, Livro> livros = new HashMap<String, Livro>();
  private static HashMap<String, Emprestimo> emprestimos = new HashMap<String, Emprestimo>();
  private static HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();

  // Método que retorna todos os livros cadastrados no banco como um mapa
  // (ISBN -> Livro).
  public static HashMap<String, Livro> getLivros() {
    return livros;
  }

  // Método que retorna todos os empréstimos cadastrados no banco como um mapa
  // (ID -> Emprestimo).
  public static HashMap<String, Emprestimo> getEmprestimos() {
    return emprestimos;
  }

  // Método que retorna todos os usuários cadastrados no banco como um mapa
  // (CPF -> Usuario).
  public static HashMap<String, Usuario> getUsuario() {
    return usuarios;
  }

  // Adiciona um livro ao HashMap usando o ISBN como identificador.
  // Se o ISBN já estiver cadastrado, o método retorna 'false'.
  // Caso contrário, o livro é cadastrado e o método retorna 'true'.
  public static boolean addLivro(Livro l) {
    if (livros.containsKey(l.getIsbn()))
      return false;
    livros.put(l.getIsbn(), l);
    return true;
  }

  // Método para adicionar um empréstimo.
  public static boolean addEmprestimo(Emprestimo e) {
    getLivros().get(e.getLivroIsbn()).diminuirQuantidade();
    emprestimos.put(e.getIdEmprestimo(), e);
    return true;
  }

  // Método responsável por registrar a devolução de um livro.
  // Retorna 'true' se a devolução for registrada com sucesso.
  // Caso contrário, retorna 'false'.
  public static boolean addDevolucao(String id, String dataDevolucao) {
    if (getEmprestimos().containsKey(id)) {
      Emprestimo e = getEmprestimos().get(id);
      livros.get(e.getLivroIsbn()).adicionarQuantidade();
      e.setStatus("Devolvido");
      e.setDataDevolucao(dataDevolucao);
      return true;
    }
    return false;
  }

  // Remove um livro do banco de dados, se ele não estiver emprestado.
  public static boolean removeLivro(String isbn) {
    for (Emprestimo e : getEmprestimos().values()) {
      if (e.getLivroIsbn().equals(isbn) && e.getStatus().equals("Emprestado")) {
        return false;
      }
    }
    if (livros.containsKey(isbn)) {
      livros.remove(isbn);
      return true;
    }
    return false;
  }

  // rubens -- daqui para baixo
  public static boolean addUsuario(Usuario u) {
    if (usuarios.containsKey(u.getCpf()))
      return false;
    usuarios.put(u.getCpf(), u);
    return true;
  }

  public static Usuario getUsuario(String cpf) {
    return usuarios.get(cpf); // Retorna o objeto Usuario se existir, senão null
  }

  public static void removerUsuario(String cpf) {
    usuarios.remove(cpf);
  }
}
