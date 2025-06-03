package modelo;

public class Usuario {
	//garanti que o usuario tenha nome, cpf e email
	private String nome;
	private String cpf;
	private String email;
	
	//fiz um construtor para fazer o usuario ser  criado com essas caracteristicas
	public Usuario(String nome, String cpf, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}
	// aqui eu vou retorna o get nome, cpf e email para pode ve informacao
	public String getNome(){
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public String getEmail() {
		return email;
	}
	// aqui eu coloquei com a necessidade de modificação
	// talvez precise disso... to em duvida ainda nessa questão
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	//isso aqui é uma anotação que indica ao compilador que
	//o método que está sendo declarado é uma sobrescrita de um método 
	//da classe pai (superclasse).
	@Override
	public String toString(){
		String relatorio_user = "\nNome: "+ this.nome;
		relatorio_user = "\nCpf: "+ this.cpf;
		relatorio_user = "\nEmail: "+ this.email;
		return relatorio_user;
	}
	// Nao sei se vai precisa disso aqui mais vi que vc myche colocou no livro entao vou colocar
	// se puder me explica depois oque isso faz agradeço
}
