package br.dev.vitormiguel.tarefas.factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileFactory {

	private String arquivofuncionario = "C:\\Users\\vitor\\ProjetoTarefas\\funcionarios.csv";
	private String arquivotarefas = "C:\\Users\\vitor\\ProjetoTarefas\\tarefas.csv";

	private FileWriter fwfuncionario;
	private BufferedWriter bwfuncionario;

	private FileReader frfuncionario;
	private BufferedReader brfuncionario;

	private FileWriter fwtarefas;
	private BufferedWriter bwtarefas;

	private FileReader frtarefas;
	private BufferedReader brtarefas;

	public FileFactory() throws IOException {

		// Necessário para escrever no arquivo
		fwfuncionario = new FileWriter(arquivofuncionario, true);
		bwfuncionario = new BufferedWriter(fwfuncionario);

		// Necessário para ler o arquivo
		frfuncionario = new FileReader(arquivofuncionario);
		brfuncionario = new BufferedReader(frfuncionario);

		fwtarefas = new FileWriter(arquivotarefas, true);
		bwtarefas = new BufferedWriter(fwtarefas);

		// Necessário para ler o arquivo
		frtarefas = new FileReader(arquivotarefas);
		brtarefas = new BufferedReader(frtarefas);

	}

	public BufferedWriter getBufferedWriterFuncionario() {
		return bwfuncionario;
	}

	public BufferedReader getBufferedReaderFuncionario() {
		return brfuncionario;
	}

	public BufferedWriter getBufferedWriterTarefas() {
		return bwtarefas;
	}

	public BufferedReader getBufferedReaderTarefas() {
		return brtarefas;
	}

}
