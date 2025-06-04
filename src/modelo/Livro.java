package modelo;

public class Livro {
	private String titulo;
	private String autor;
	private String isbn;
	private String ano;
	private String editora;
	private int quantidade;
	
	// Construtor da classe Livro para casos em que a autoria não é identificada.
	public Livro(String titulo, String isbn, String editora, String ano, int quantidade) {
		this.titulo = titulo;
		this.autor = "Autor desconhecido";
		this.isbn = isbn;
		this.ano = ano;
		this.editora = editora;
		this.quantidade = quantidade;
	}

	// Construtor da classe Livro para casos em que a autoria é identificada.
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

	public int setQuantidade(int quantidade) {
		return quantidade;
	}

	public void adicionarQuantidade() {
		this.quantidade++;
	}

	public void diminuirQuantidade() {
		this.quantidade--;
	}

	@Override
	public String toString() {
		String relatorio = "\nTitulo: " + this.titulo;
		relatorio += "\nAutor: " + this.autor;
		relatorio += "\nISBN: " + this.isbn;
		relatorio += "\nEditora: " + this.editora;
		relatorio += "\nAno de lancamento: " + this.ano;
		relatorio += "\nQuantidade de exemplares disponiveis: " + this.quantidade;
		return relatorio;
	}
}
