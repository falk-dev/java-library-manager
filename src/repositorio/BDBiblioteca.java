package repositorio;
import java.util.HashMap;
// import modelo.Emprestimo;
// import modelo.Usuario;
import modelo.Livro;

public class BDBiblioteca {
  private static HashMap<String, Livro> livros = new HashMap<String, Livro>();

  // Método para obter todos os livros cadastrados
  // no sistema.
  public static HashMap<String, Livro> getLivros() {
    return livros;
  }

  // Adicionando ao HashMap estático usando o ISBN
  // como identificador, caso esse código já esteja
  // cadastrado, não será possível cadastrar
  // novamente, retornando 'false' como resposta.
  // Mas se não houver cadastro, efetuará o cadastro
  // e retornará 'true' como resposta.
  public static boolean addLivro(Livro l) {
    if (livros.containsKey(l.getIsbn())) return false;
    livros.put(l.getIsbn(), l);
    return true;
  }
}
