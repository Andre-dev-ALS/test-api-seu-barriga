package api_seu_barriga_tests.contas;

import org.junit.Before;
import org.junit.Test;

import api_seu_barriga_tests.login.LoginLogic;

public class ContasTest {
	private ContasLogic conta;
	private LoginLogic login;

	@Before
	public void fazerLogin() {
		login = new LoginLogic();
		login.fazerLogin();
	}

	@Test
	public void id_0003DeveAdicionarUmaContaComSucesso() {
		conta = new ContasLogic();
		conta.adicionarNovaConta();
	}

	@Test
	public void id_0004DeveAlterarNomeDaConta() {
		conta = new ContasLogic();
		conta.alterarNomeDaConta();
	}

	@Test
	public void id_0005DeveValidarMenssagemDeErroDeCadastroDeConta() {
		conta = new ContasLogic();
		conta.validarMenssagemDeErro();
	}

}
