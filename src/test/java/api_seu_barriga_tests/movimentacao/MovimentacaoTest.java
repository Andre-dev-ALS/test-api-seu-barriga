package api_seu_barriga_tests.movimentacao;

import org.junit.Before;
import org.junit.Test;

import api_seu_barriga_tests.login.LoginLogic;

public class MovimentacaoTest {
	MovimentacaoLogic movimentacao;
	LoginLogic login;

	@Before
	public void fazerLogin() {

		login = new LoginLogic();
		login.fazerLogin();
	}

	@Test
	public void id_0006DeveInserirUmaMovimentacaoComSucesso() {
		movimentacao = new MovimentacaoLogic();
		movimentacao.fazerMovimentacao();
	}
}
