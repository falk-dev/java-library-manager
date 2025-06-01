package modelo;
import modelo.Livro;
import modelo.Usuario;

public class Emprestimo {
	private Livro livro;
	private Usuario usuario;
	private String dataEmprestimo;
	private String dataDevolucao;
	
	public Emprestimo(Livro livro, Usuario usuario, String dataEmprestimo, String dataDevolucao) {
		this.livro = livro;
		this.usuario = usuario;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
	}
}
