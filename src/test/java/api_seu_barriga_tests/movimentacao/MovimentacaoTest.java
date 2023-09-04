package api_seu_barriga_tests.movimentacao;

import org.junit.Before;
import org.junit.Test;

import api_seu_barriga_tests.contas.ContasLogic;
import api_seu_barriga_tests.login.LoginLogic;

public class MovimentacaoTest {
	private MovimentacaoLogic movimentacao;
	private LoginLogic login;
	private ContasLogic contas;

	@Before
	public void fazerLogin() {
		login = new LoginLogic();
		login.fazerLogin();
		contas = new ContasLogic();
		contas.listarContas();
		movimentacao = new MovimentacaoLogic();
		movimentacao.listarMovimentacoes();
	}

	@Test
	public void id_0006DeveInserirUmaMovimentacaoComSucesso() {
		movimentacao.fazerMovimentacao();
	}

	@Test
	public void id_0007DeveValidarCamposObrigatoriosDaMovimentacao() {
		movimentacao.validarCamposObrigatoriosDaMovimentacao();
	}

	@Test
	public void id_0008NaoDeveFazerMovimentacaoFutura() {
		movimentacao.validarMenssagemDeErroNaMovimentacaoFutura();
	}

	@Test
	public void id_0010DevoDeletarUmaMovimentacaoComSucesso() {
		movimentacao.deletarMovimentacao();
	}
}
