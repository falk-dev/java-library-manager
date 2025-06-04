package servico;

// Importação de classes do sistema
import modelo.Emprestimo;

import modelo.Livro;
import modelo.Usuario;
import repositorio.BDBiblioteca;

public class Servico {
  private Livro l;
  private Emprestimo e;
  private Usuario u;

// Método responsável pelo cadastro de livros sem autor identificado
  public String cadastrarLivro(String titulo, String isbn, String editora, String ano, int quantidade) {
    l = new Livro(titulo, isbn, editora, ano, quantidade);
    if(BDBiblioteca.addLivro(l)) {
      return "Livro cadastrado com sucesso!";
    }
    return "Erro! Este livro ja foi cadastrado anteriormente!";
  }

  // Método responsável pelo cadastro de livros com autor identificado
  public String cadastrarLivro(String titulo, String autor, String isbn, String editora, String ano, int quantidade) {
    l = new Livro(titulo, autor, isbn, editora, ano, quantidade);
    if(BDBiblioteca.addLivro(l)) {
      return "Livro cadastrado com sucesso!";
    }
    return "Erro! Este livro ja foi cadastrado anteriormente!";
  }

  // Se a remoção for bem sucedida, retorna uma mensagem de sucesso.
  // Caso contrário, retorna uma mensagem de erro.
  public String removerLivro(String isbn) {
    if(BDBiblioteca.removeLivro(isbn)) {
      return "Livro removido com sucesso.";
    }
    
    return "Erro! Não é possível remover o livro, está emprestado ou não existe no sistema.";
  }

  // Gera um relatório com todos os livros cadastrados.
  // Usa foreach para percorrer os valores do mapa de livros da BDBiblioteca.
  // As chaves (ISBNs) são ignoradas porque os dados completos estão nos valores.
  public String getRelatorioLivros() {
    String lista = "";
    for(Livro l : BDBiblioteca.getLivros().values()) {
      lista += l.toString();
			lista += "\n=============================\n";
    }
    return lista;
  }

  // Método que consulta um livro pelo identificador ISBN.
  // Retorna o relatório do livro se encontrado. Caso contrário, exibe uma mensagem de erro.
  public String getLivroISBN(String isbn) {
    if (BDBiblioteca.getLivros().containsKey(isbn)) {
      return BDBiblioteca.getLivros().get(isbn).toString();
    }
    return "Erro! Este livro nao esta cadastrado no sistema.";
  }

  // Método que busca no mapa os livros em que o autor corresponde ao nome fornecido.
  public String getLivrosAutor(String autor) {
    String lista = "";
    for (Livro l : BDBiblioteca.getLivros().values()) {
      if (l.getAutor().equals(autor)) {
        lista += l.toString();
        lista += "\n=============================\n";
      }
    }
    if (lista.equals("")) {
      return "Erro! Este autor não está cadastrado no sistema.";
    }

    return lista;
  }

  // Método para realizar um empréstimo de livro.
  // Cria um novo objeto do tipo Emprestimo e verifica se o empréstimo foi bem sucedido.
  // Caso retorne 'true', o livro foi emprestado com sucesso. Caso contrário, ele não está disponível.
  public String realizarEmprestimo(String isbn, String cpf, String dataEmprestimo, String dataEstimadaDevolucao) {
    e = new Emprestimo(isbn, cpf, dataEmprestimo, dataEstimadaDevolucao);
    if(BDBiblioteca.addEmprestimo(e)) {
      if (BDBiblioteca.getLivros().get(isbn).getQuantidade() > 1) {
        BDBiblioteca.getLivros().get(isbn).diminuirQuantidade();
      }
      return "Emprestimo realizado com sucesso.";
    }
    return "Erro! O livro que voce escolheu nao esta disponivel para emprestimo.";
  }

  // Realiza a devolução de um livro com base no empréstimo, ISBN e datas fornecidas.
  public String realizarDevolucao(String isbn, String cpf, String dataEmprestimo, String dataDevolucao) {
    if(BDBiblioteca.addDevolucao(isbn, dataEmprestimo, dataDevolucao)) {
      return "Devolução realizada com sucesso.";
    }
    return "Erro! O empréstimo não consta no sistema.";
  } 

  // Retorna uma string listando todos os empréstimos cujo status é "Emprestado".
  public String getRealatorioLivrosEmprestados() {
    String lista = "";
    for (Emprestimo e : BDBiblioteca.getEmprestimos().values()) {
      if (e.getStatus().equals("Emprestado")) {
        lista += e.toString();
        lista += "\n=============================\n";
      }
    }
    return lista;
  }

  // Retorna uma string com a lista de livros disponíveis, 
  // incluindo apenas os exemplares com mais de uma unidade disponível.
  public String getRelatorioLivrosDisponiveis() {
    String lista = "";
    for (Livro l : BDBiblioteca.getLivros().values()) {
      if (l.getQuantidade() > 1) {
        lista += l.toString();
        lista += "\n=============================\n";
      }
    }
    return lista;
  }

  // Gera um relatório com todos os empréstimos cadastrados.
  // Usa foreach para percorrer os valores do mapa de empréstimos da BDBiblioteca.
  // As chaves (ISBNs) são ignoradas porque os dados completos estão nos valores.
  public String getRelatorioEmprestimos() {
    String lista = "";
    for(Emprestimo e : BDBiblioteca.getEmprestimos().values()) {
      lista += e.toString();
			lista += "\n=============================\n";
    }
    return lista;
  }
  
  
//Usuario - Rubens
  
  public String cadastrarUsuario(String nome, String cpf, String email, String telefone) {
	 u = new Usuario(nome, cpf, email, telefone);
	 if(BDBiblioteca.addUsuario(u)) {
		 return "Usuario cadastrado.";
	 }
	 return "Erro no cadastro.";
  }

  public String cadastrarUsuario(String nome, String cpf, String email) {
    u = new Usuario(nome, cpf, email);
    if(BDBiblioteca.addUsuario(u)) {
      return "Usuario cadastrado.";
    }
    return "Erro no cadastro.";
   }
  
  public String consultarUsuario(String cpf) {
	    if (BDBiblioteca.getUsuario(cpf) != null) {
	        return "Usuário encontrado.";
	    }
	    return "Usuário não encontrado.";
	}

  //nao consigui pensar em um jeito para resolve isso aqui.
  public String listarUsuario() {
	  String listaRela = "";
	  for(Usuario u: BDBiblioteca.getUsuario().values()) {
		  listaRela += u.toString();
		  listaRela += "";
	  }
	  return listaRela;
  }
  
  public String removerUsuario(String cpf) {
	  if(BDBiblioteca.getUsuario(cpf) != null){
		  BDBiblioteca.removerUsuario(cpf);
		 return "Usuario removido."; 
	  }
	  return "Não e possivel remover Usuario.";
}
}
