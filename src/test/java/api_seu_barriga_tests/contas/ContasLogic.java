package api_seu_barriga_tests.contas;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import api_seu_barriga_tests.login.LoginLogic;
import me.wcaquino.seubarriga.core.BaseTest;

public class ContasLogic {
	private ContasModel nomeDaConta;

	private LoginLogic login;

	public ContasLogic() {
		BaseTest.setup();
		login = new LoginLogic();
	}

	public void adicionarNovaConta() {
		login.fazerLogin();
		nomeDaConta = new ContasModel("contaAdicionada");
		given().header("Authorization", "JWT " + login.getToken()).body(nomeDaConta).when().post("/contas").then().log()
				.all().statusCode(201);
	}

	public void alterarNomeDaConta() {
		login = new LoginLogic();
		login.fazerLogin();

		nomeDaConta = new ContasModel("contaAlterada");
		given().header("Authorization", "JWT " + login.getToken()).body(nomeDaConta).when().put("/contas/1871552")
				.then().statusCode(200).body("nome", is("contaAlterada"));

	}

}
