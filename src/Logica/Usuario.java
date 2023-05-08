package Logica;

public class Usuario {
	private String login;
	private String senha;
	private String emailSeguranca;
	private String nome;
	private String endereco;
	private String cidade;
	private String estado;
	
	public Usuario(String login, String senha, String emailSeguranca, String nome, String endereco, String cidade, String estado) {
		setLogin(login);
		setSenha(senha);
		setEmailSeguranca(emailSeguranca);
		setNome(nome);
		setEndereco(endereco);
		setCidade(cidade);
		setEstado(estado);
	}
	public Usuario() {
	}
	public boolean equals(Usuario u) {
		if(u.getLogin().equals(login))
			return true;
		return false;
	}
	public String getInformacoesU() {
		return "Usuário: "+nome+", email: "+emailSeguranca+", endereço: "+endereco+", cidade: "+cidade+", estado: "+estado;
	}
	public String getEmailSeguranca() {
		return emailSeguranca;
	}
	public void setEmailSeguranca(String emailSeguranca) {
		this.emailSeguranca = emailSeguranca;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}