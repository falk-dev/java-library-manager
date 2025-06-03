package modelo;

public class Usuario {
	
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	
	//fiz um construtor para fazer o usuario ser  criado com essas caracteristicas
	public Usuario(String nome, String cpf, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}
	public Usuario(String nome, String cpf, String email, String telefone) {
		// pesquisei e this() e bem usado para deixa o code limpo e sem repeticao
		// entao meio que so to chamando oque ja esta liberado ne?
		this(nome, cpf, email);
		this.telefone = telefone;
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
	
	public String getTelefone() {
		return telefone;
	}
	// aqui eu coloquei com a necessidade de modificação
	// talvez precise disso... to em duvida ainda nessa questão
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	// realmente isso nao precisaria mychelle, mais e se a pessoa por acasso
	// colocou o cpf errado. como iriramos fazer para troca esse cpf no proprio sistema?
	
	/*public void setCpf(String cpf) {
		this.cpf = cpf;
	}*/
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setTelefone() {
		this.telefone = telefone;
	}
	
	//isso aqui é uma anotação que indica ao compilador que
	//o método que está sendo declarado é uma sobrescrita de um método 
	//da classe pai (superclasse).
	@Override
	public String toString(){
		String relatorioUser = "\nNome: "+ this.nome;
		relatorioUser = "\nCpf: "+ this.cpf;
		relatorioUser = "\nEmail: "+ this.email;
		relatorioUser = "\nTelefone: "+ this.telefone;
		return relatorioUser;
		// tentei colocar no padrao desejado.
	}
}
