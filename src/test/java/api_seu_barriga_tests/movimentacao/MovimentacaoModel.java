package api_seu_barriga_tests.movimentacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

class MovimentacaoModel {
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private static List<MovimentacaoModel> listaMovimentacoes = new ArrayList<MovimentacaoModel>();
	private int id;
	private String descricao;
	private String envolvido;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String observacao;
	private String tipo;
	private String data_transacao;
	private String data_pagamento;
	private float valor;
	private boolean status;
	private int conta_id;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private int usuario_id;
	private int transferencia_id;
	private int parcelamento_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEnvolvido() {
		return envolvido;
	}

	public void setEnvolvido(String envolvido) {
		this.envolvido = envolvido;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getData_transacao() {
		return data_transacao;
	}

	public void setData_transacao(String data_transacao) {
		this.data_transacao = data_transacao;
	}

	public String getData_pagamento() {
		return data_pagamento;
	}

	public void setData_pagamento(String data_pagamento) {
		this.data_pagamento = data_pagamento;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getConta_id() {
		return conta_id;
	}

	public void setConta_id(int conta_id) {
		this.conta_id = conta_id;
	}

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

	public int getTransferencia_id() {
		return transferencia_id;
	}

	public void setTransferencia_id(int transferencia_id) {
		this.transferencia_id = transferencia_id;
	}

	public int getParcelamento_id() {
		return parcelamento_id;
	}

	public void setParcelamento_id(int parcelamento_id) {
		this.parcelamento_id = parcelamento_id;
	}

	public static List<MovimentacaoModel> getListaContas() {
		return listaMovimentacoes;
	}

	public static void setListaContas(MovimentacaoModel[] listaContas) {
		MovimentacaoModel.listaMovimentacoes = Arrays.asList(listaContas);
	}

}
