package api_seu_barriga_tests.movimentacao;

import org.junit.Before;
import org.junit.Test;

import api_seu_barriga_tests.login.LoginLogic;

public class MovimentacaoTest {
	private MovimentacaoLogic movimentacao;
	private LoginLogic login;

	@Before
	public void fazerLogin() {

		login = new LoginLogic();
		login.fazerLogin();
		movimentacao = new MovimentacaoLogic();
	}

	@Test
	public void id_0006DeveInserirUmaMovimentacaoComSucesso() {

		movimentacao.fazerMovimentacao();
	}

	@Test
	public void id_0007DeveValidarCamposObrigatoriosDaMovimentacao() {
		movimentacao.validarCamposObrigatoriosDaMovimentacao();
	}
}
