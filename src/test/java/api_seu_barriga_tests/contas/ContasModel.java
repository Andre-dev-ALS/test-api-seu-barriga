package api_seu_barriga_tests.contas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContasModel {
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private static List<ContasModel> listaContas = new ArrayList<ContasModel>();
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private int id;
	private String nome;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private boolean visivel;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private int usuario_id;

	public List<ContasModel> getListaContas() {
		return listaContas;
	}

	public void setListaSaldos(ContasModel[] listaContas) {
		ContasModel.listaContas = Arrays.asList(listaContas);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isVisivel() {
		return visivel;
	}

	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

}
