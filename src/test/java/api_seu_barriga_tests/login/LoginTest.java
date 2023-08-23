package api_seu_barriga_tests.login;

import org.junit.Test;

public class LoginTest {
	private LoginLogic login;

	@Test
	public void id_0001NaoDeveAcessarApiSemToken() {
		login = new LoginLogic();
		login.validarMenssagemUsuarioNaoAutorizado();
	}

	@Test
	public void id_0002DevoAcessarApiComSucesso() {
		login = new LoginLogic();
		login.fazerLogin();
	}
}
