package modelo;
import java.util.HashMap;
import modelo.Emprestimo;

public class Livro {
	private String titulo;
	private String autor;
	private String isbn;
	private String editora;
	private String ano;
	private int quantidade;
	private HashMap<String, Emprestimo> emprestimos;
	
	public Livro(String titulo, String autor, String isbn, String editora, String ano, int quantidade) {
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.editora = editora;
		this.ano = ano;
		this.quantidade = quantidade;
	}
}
