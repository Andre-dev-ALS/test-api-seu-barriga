package api_seu_barriga_tests.saldo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaldoModel {
	private List<SaldoModel> listaSaldos = new ArrayList<SaldoModel>();
	private int conta_id;
	private String conta;
	private float saldo;

	public int getConta_id() {
		return conta_id;
	}

	public void setConta_id(int conta_id) {
		this.conta_id = conta_id;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public List<SaldoModel> getListaSaldos() {
		return listaSaldos;
	}

	public void setListaSaldos(SaldoModel[] listaSaldos) {
		this.listaSaldos = Arrays.asList(listaSaldos);
	}

}
