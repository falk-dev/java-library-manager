package modelo;

public class Emprestimo {
	private Livro livro;
	private Usuario usuario;
	private String dataEmprestimo;
	private String dataEstimadaDevolucao;
	private String dataDevolucao;
	private String status;
	
	public Emprestimo(Livro livro, Usuario usuario, String dataEmprestimo, String dataEstimadaDevolucao) {
		this.livro = livro;
		this.usuario = usuario;
		this.dataEmprestimo = dataEmprestimo;
		this.dataEstimadaDevolucao = dataEstimadaDevolucao;
		this.dataDevolucao = "-";
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

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		String relatorio = "\nISBN: " + this.livro.getIsbn();
		relatorio += "\nTitulo: " + this.livro;
		relatorio += "\nUsuario: " + this.usuario;
		relatorio += "\nData de empréstimo: " + this.dataEmprestimo;
		relatorio += "\nData de estimada de devolução: " + this.dataEstimadaDevolucao;
		relatorio += "\nData de devolução: " + this.dataDevolucao;
		relatorio += "\nStatus: " + this.status;
		return relatorio;
	}
}
