package modelo;
// import java.util.HashMap;
// import modelo.Emprestimo;

public class Livro {
	private String titulo;
	private String autor;
	private String isbn;
	private String ano;
	private String editora;
	private int quantidade;
	// private HashMap<String, Emprestimo> emprestimos;
	
	// Metodo construtor de Livro caso a insercao seja com autoria nao identificada.
	public Livro(String titulo, String isbn, String editora, String ano, int quantidade) {
		this.titulo = titulo;
		this.autor = "Autor desconhecido";
		this.isbn = isbn;
		this.ano = ano;
		this.editora = editora;
		this.quantidade = quantidade;
	}

	// Metodo construtor de Livro caso a insercao seja com autoria reconhecida.
	public Livro(String titulo, String autor, String isbn, String editora, String ano, int quantidade) {
		this(titulo, isbn, editora, ano, quantidade);
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getAno() {
		return ano;
	}

	public String getEditora() {
		return editora;
	}

	public int getQuantidade() {
		return quantidade;
	}

	@Override
	public String toString() {
		String relatorio = "\nTitulo: " + this.titulo;
		relatorio += "\nAutor: " + this.autor;
		relatorio += "\nISBN: " + this.isbn;
		relatorio += "\nEditora: " + this.editora;
		relatorio += "\nAno de lancamento: " + this.ano;
		return relatorio;
	}
}
