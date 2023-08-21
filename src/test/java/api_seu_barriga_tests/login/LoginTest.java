package api_seu_barriga_tests.login;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import me.wcaquino.seubarriga.core.BaseTest;

public class LoginTest extends BaseTest {

	@Test
	public void naoDeveAcessarApiSemToken() {
		given().when().get("/contas").then().statusCode(401);
	}

}
