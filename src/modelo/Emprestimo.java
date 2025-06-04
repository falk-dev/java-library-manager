package modelo;

public class Emprestimo {
	private Livro livro;
	private Usuario usuario;
	private String dataEmprestimo;
	private String dataEstimadaDevolucao;
	private String status;
	public static int contador = 0;
	
	public Emprestimo(Livro livro, Usuario usuario, String dataEmprestimo, String dataEstimadaDevolucao) {
		this.livro = livro;
		this.usuario = usuario;
		this.dataEmprestimo = dataEmprestimo;
		this.dataEstimadaDevolucao = dataEstimadaDevolucao;
		this.status = "Emprestado";
	}

	public Livro getLivro() {
		return livro;
	}


	public void setLivro(Livro livro) {
		this.livro = livro;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public String getDataEmprestimo() {
		return dataEmprestimo;
	}


	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}


	public String getDataEstimadaDevolucao() {
		return dataEstimadaDevolucao;
	}


	public void setDataEstimadaDevolucao(String dataEstimadaDevolucao) {
		this.dataEstimadaDevolucao = dataEstimadaDevolucao;
	}

	public String getStatus() {
		return this.status;
	}


	@Override
	public String toString() {
		String relatorio = "\nTitulo: " + this.livro;
		relatorio += "\nUsuario: " + this.usuario;
		relatorio += "\nData de emprestimo: " + this.dataEmprestimo;
		relatorio += "\nData de estimada de devolucao: " + this.dataEstimadaDevolucao;
		relatorio += "\nDevolvido?: " + this.status;
		return relatorio;
	}
}
