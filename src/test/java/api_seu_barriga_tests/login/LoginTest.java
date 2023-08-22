package api_seu_barriga_tests.login;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import api_seu_barriga_tests.model.LoginModel;
import me.wcaquino.seubarriga.core.BaseTest;

public class LoginTest extends BaseTest {
	private LoginModel dadosAcesso;

	@Test
	public void id_0001NaoDeveAcessarApiSemToken() {
		given().when().get("/contas").then().statusCode(401);
	}

	@Test
	public void id_0002DevoAcessarApiComSucesso() {
		dadosAcesso = new LoginModel("emailparatestesautomacao@gmail.com", "automacaoteste");
		given().body(dadosAcesso).when().post("/signin").then().statusCode(200).log().all();
	}
}
