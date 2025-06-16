package br.dev.vitormiguel.tarefas.model;

import br.dev.vitormiguel.tarefas.utils.Utils;

public class Tarefas {

	private String titulo;
	private String descricao;
	private String dataInicial;
	private int prazo;
	private String dataConclusao;
	private String codigo;
	
	public Tarefas(String titulo) {
		this.titulo = titulo;
		this.codigo = Utils.gerarUUID8();
	}
	
	public Tarefas() {
		this.codigo = Utils.gerarUUID8();
	}
	
	public Tarefas(int prazo, String titulo) {
		
		this.prazo = prazo;
		this.titulo = titulo;
		this.codigo = Utils.gerarUUID8();
		
	}
	
	public Tarefas(int prazo, String titulo, String descricao) {
		this.prazo = prazo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.codigo = Utils.gerarUUID8();
	}
	
	public Tarefas(int prazo, String titulo, String descricao, String dataInicial, String dataConclusao) {
		
		this.prazo = prazo;
		this.dataInicial = dataInicial;
		this.dataConclusao = dataInicial + (prazo - 1);
		this.titulo = titulo;
		this.descricao = descricao;
		this.codigo = Utils.gerarUUID8();
		
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

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
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
	
	
}
