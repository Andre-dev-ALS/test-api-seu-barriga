package api_seu_barriga_tests.login;

public class LoginModel {
	private String email;
	private String senha;

	public LoginModel(String email, String senha) {
		setEmail(email);
		setSenha(senha);
		;

	}

	public String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	private void setSenha(String senha) {
		this.senha = senha;
	}

}
