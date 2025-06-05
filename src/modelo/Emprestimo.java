package modelo;

import repositorio.BDBiblioteca;

public class Emprestimo {
	private String idEmprestimo;
	private String livroIsbn;
	private String usuarioCpf;
	private String dataEmprestimo;
	private String dataEstimadaDevolucao;
	private String dataDevolucao;
	private String status;

	private static int contador = 0; // Atributo para gerar o Id do Empréstimo

	public Emprestimo(String isbn, String cpf, String dataEmprestimo, String dataEstimadaDevolucao) {
		contador++;
		this.idEmprestimo = getIdEmprestimo();
		this.livroIsbn = isbn;
		this.usuarioCpf = cpf;
		this.dataEmprestimo = dataEmprestimo;
		this.dataEstimadaDevolucao = dataEstimadaDevolucao;
		this.dataDevolucao = "-";
		this.status = "Emprestado";
	}

	public String getIdEmprestimo() {
		return Integer.toString(contador);
	}

	public String getLivroIsbn() {
		return livroIsbn;
	}

	public String getUsuario() {
		return usuarioCpf;
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
		String relatorio = "\nId: " + this.idEmprestimo;
		relatorio += "\nISBN: " + this.livroIsbn;
		relatorio += "\nTitulo: " + BDBiblioteca.getLivros().get(livroIsbn).getTitulo();
		relatorio += "\nUsuario: " + BDBiblioteca.getUsuario().get(usuarioCpf).getNome();
		relatorio += "\nData de empréstimo: " + this.dataEmprestimo;
		relatorio += "\nData de estimada de devolução: " + this.dataEstimadaDevolucao;
		relatorio += "\nData de devolução: " + this.dataDevolucao;
		relatorio += "\nStatus: " + this.status;
		return relatorio;
	}
}
