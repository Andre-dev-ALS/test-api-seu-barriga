package api_seu_barriga_tests.login;

import static io.restassured.RestAssured.given;

import me.wcaquino.seubarriga.core.BaseTest;

public class LoginLogic {
	private LoginModel dadosAcesso;
	private String token;

	public LoginLogic() {
		BaseTest.setup();
		dadosAcesso = new LoginModel("emailparatestesautomacao@gmail.com", "automacaoteste");
	}

	public void validarMenssagemUsuarioNaoAutorizado() {
		given().when().get("/contas").then().statusCode(401);
	}

	public void fazerLogin() {
		token = given().body(dadosAcesso).when().post("/signin").then().statusCode(200).extract().path("token");

	}

	public String getToken() {
		return token;
	}

}
