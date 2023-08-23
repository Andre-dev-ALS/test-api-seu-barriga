package api_seu_barriga_tests.contas;

import org.junit.Test;

public class ContasTest {
	private ContasLogic conta;

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
