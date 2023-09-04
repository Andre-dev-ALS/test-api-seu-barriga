package api_seu_barriga_tests.movimentacao;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.hamcrest.Matchers;

import api_seu_barriga_tests.contas.ContasModel;
import api_seu_barriga_tests.login.LoginLogic;
import me.wcaquino.seubarriga.core.BaseTest;

public class MovimentacaoLogic {
	private LoginLogic login;
	private MovimentacaoModel movimentacao;
	private ContasModel conta;

	public MovimentacaoLogic() {
		BaseTest.setup();
		login = new LoginLogic();
		movimentacao = new MovimentacaoModel();
		conta = new ContasModel();
	}

	public void validarMenssagemDeErroNaMovimentacaoFutura() {
		movimentacao.setConta_id(conta.getListaContas().get(0).getId());
		movimentacao.setDescricao("descrição da movimentação");
		movimentacao.setEnvolvido("envolvido na movimentação");
		movimentacao.setTipo("REC");
		String date = LocalDateTime.now().plusYears(5).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		movimentacao.setData_transacao(date);
		movimentacao.setData_pagamento("10/05/2020");
		movimentacao.setValor(6000f);
		movimentacao.setStatus(true);
		given().header("Authorization", "JWT " + login.getToken()).body(movimentacao).log().all().when()
				.post("/transacoes").then().statusCode(400);
	}

	public void validarCamposObrigatoriosDaMovimentacao() {
		given().header("Authorization", "JWT " + login.getToken()).body("{}").log().all().when().post("/transacoes")
				.then().statusCode(400).body("$", Matchers.hasSize(8)).body("msg",
						hasItems("Data da Movimentação é obrigatório", "Data do pagamento é obrigatório",
								"Descrição é obrigatório", "Interessado é obrigatório",
								"Data do pagamento é obrigatório", "Valor é obrigatório", "Valor deve ser um número",
								"Conta é obrigatório", "Situação é obrigatório"));
	}

	public void fazerMovimentacao() {
		movimentacao.setConta_id(conta.getListaContas().get(0).getId());
		movimentacao.setDescricao("descrição da movimentação");
		movimentacao.setEnvolvido("envolvido na movimentação");
		movimentacao.setTipo("REC");
		movimentacao.setData_transacao("01/01/2015");
		movimentacao.setData_pagamento("10/05/2020");
		movimentacao.setValor(6000f);
		movimentacao.setStatus(true);

		MovimentacaoModel.setListaContas(given().header("Authorization", "JWT " + login.getToken()).body(movimentacao)
				.log().all().when().post("/transacoes").then().statusCode(201).log().all().extract()
				.as(MovimentacaoModel[].class));
	}

	public void deletarMovimentacao() {
		given().header("Authorization", "JWT " + login.getToken()).when()
				.delete("/transacoes/" + MovimentacaoModel.getListaContas().get(0).getId()).then().statusCode(204);
	}

	public void listarMovimentacoes() {
		MovimentacaoModel.setListaContas(given().header("Authorization", "JWT " + login.getToken()).when()
				.get("/transacoes").then().statusCode(200).extract().as(MovimentacaoModel[].class));
	}
}
