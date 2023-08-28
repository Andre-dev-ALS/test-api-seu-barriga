package api_seu_barriga_tests.saldo;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

import api_seu_barriga_tests.login.LoginLogic;
import me.wcaquino.seubarriga.core.BaseTest;

public class SaldoLogic {
	private LoginLogic login;
	private SaldoModel saldo;

	public SaldoLogic() {
		BaseTest.setup();
		login = new LoginLogic();
		saldo = new SaldoModel();
	}

	public void validarSaldo() {
		saldo.setListaSaldos(given().header("Authorization", "JWT " + login.getToken()).log().all().when().get("/saldo")
				.then().statusCode(200).extract().as(SaldoModel[].class));
		for (SaldoModel i : saldo.getListaSaldos()) {
			if (i.getConta_id() == 1880342) {
				Assert.assertEquals(i.getSaldo(), 6000.00f, 0);
			}
		}
	}
}
