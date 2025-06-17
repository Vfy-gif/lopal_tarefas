package br.dev.vitormiguel.tarefas.model;

import br.dev.vitormiguel.tarefas.utils.Utils;

public class Tarefas {

	private String titulo;
	private String descricao;
	private String dataInicial;
	private String prazo;
	private String dataConclusao;
	private String codigo;
	private Status status;
	private String[] responsavel;
	
	public Tarefas(String titulo) {
		this.titulo = titulo;
		this.codigo = Utils.gerarUUID8();
	}
	
	public Tarefas() {
		this.codigo = Utils.gerarUUID8();
	}
	
	public Tarefas(String prazo, String titulo) {
		
		this.prazo = prazo;
		this.titulo = titulo;
		this.codigo = Utils.gerarUUID8();
		
	}
	
	public Tarefas(String prazo, String titulo, String descricao) {
		this.prazo = prazo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.codigo = Utils.gerarUUID8();
	}
	
	public Tarefas(String titulo,String descricao, String dataInicial, String prazo , String dataConclusao) {
		
		
		this.prazo = prazo;
		this.dataInicial = dataInicial;
		this.dataConclusao = dataInicial;
		this.titulo = titulo;
		this.descricao = descricao;
		this.codigo = Utils.gerarUUID8();
		
		
	}

	
	public Tarefas(String titulo,String descricao, String dataInicial, String prazo , String dataConclusao, Status status) {
		
		
		this.prazo = prazo;
		this.dataInicial = dataInicial;
		this.dataConclusao = dataInicial;
		this.titulo = titulo;
		this.descricao = descricao;
		this.codigo = Utils.gerarUUID8();
		this.status = status;
		
	}
	


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getPrazo() {
		return prazo;
	}

	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}

	public String getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(String dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String[] getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String[] responsavel) {
		this.responsavel = responsavel;
	}

	public String toString() {
		String tarefa = titulo + "," + descricao + "," + dataInicial + "," + prazo + "," + dataConclusao + "," + status + "," + responsavel + "\n";
		return tarefa;
	}
	
}
