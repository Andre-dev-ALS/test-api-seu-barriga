package api_seu_barriga_tests.movimentacao;

import static io.restassured.RestAssured.given;

import api_seu_barriga_tests.login.LoginLogic;
import me.wcaquino.seubarriga.core.BaseTest;

public class MovimentacaoLogic {
	private LoginLogic login;
	private MovimentacaoModel movimentacao;

	public MovimentacaoLogic() {
		BaseTest.setup();
		login = new LoginLogic();
		movimentacao = new MovimentacaoModel();
	}

	public void fazerMovimentacao() {
		// movimentacao.setUsuario_id(40758);
		movimentacao.setConta_id(1879507);
		movimentacao.setDescricao("descrição da movimentação");
		movimentacao.setEnvolvido("envolvido na movimentação");
		movimentacao.setTipo("REC");
		movimentacao.setData_transacao("01/01/2000");
		movimentacao.setData_pagamento("10/05/2010");
		movimentacao.setValor(100f);
		movimentacao.setStatus(true);
		given().header("Authorization", "JWT " + login.getToken()).body(movimentacao).log().all().when()
				.post("/transacoes").then().statusCode(200);
	}
}
