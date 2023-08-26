package api_seu_barriga_tests.contas;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import api_seu_barriga_tests.login.LoginLogic;
import me.wcaquino.seubarriga.core.BaseTest;

public class ContasLogic {
	private ContasModel conta;
	private String nomeDaConta = "contaAdicionada";
	private LoginLogic login;

	public ContasLogic() {
		BaseTest.setup();
		login = new LoginLogic();
		conta = new ContasModel();
	}

	public void adicionarNovaConta() {
		conta.setNome(nomeDaConta);
		given().header("Authorization", "JWT " + login.getToken()).body(conta).when().post("/contas").then().log().all()
				.statusCode(201);
	}

	public void alterarNomeDaConta() {
		conta.setNome("contaAlterada");
		given().header("Authorization", "JWT " + login.getToken()).body(conta).when().put("/contas/1880342").then()
				.statusCode(200).body("nome", is("contaAlterada"));
	}

	public void validarMenssagemDeErroDeCriacaoDeContaJaExistente() {
		conta.setNome(nomeDaConta);
		given().header("Authorization", "JWT " + login.getToken()).body(conta).when().post("/contas").then()
				.statusCode(400).body("error", is("Já existe uma conta com esse nome!"));
	}

	public void validarMenssagemDeErroDeExclusaoDeContaComMovimentacao() {
		given().header("Authorization", "JWT " + login.getToken()).when().delete("/contas/1880342").then()
				.statusCode(500).body("constraint", is("transacoes_conta_id_foreign"));
	}
}
