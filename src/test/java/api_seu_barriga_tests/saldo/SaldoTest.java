package api_seu_barriga_tests.saldo;

import org.junit.Before;
import org.junit.Test;

import api_seu_barriga_tests.login.LoginLogic;

public class SaldoTest {
	private LoginLogic login;
	private SaldoLogic saldo;

	@Before
	public void fazerLogin() {
		login = new LoginLogic();
		login.fazerLogin();
		saldo = new SaldoLogic();
	}

	@Test
	public void id_0009DeveValidarSaldo() {
		saldo.validarSaldo();
	}
}
