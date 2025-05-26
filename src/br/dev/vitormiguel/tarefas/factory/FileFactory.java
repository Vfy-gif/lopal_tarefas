package br.dev.vitormiguel.tarefas.factory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileFactory {

	private String arquivo = "C:\\Users\\25132565\\ProjetoTarefas\\funcionarios.csv";
	
	private FileWriter fw;
	private BufferedWriter bw;
	
	public FileFactory() throws IOException {
		fw = new FileWriter(arquivo, true);
		bw = new BufferedWriter(fw);
	}
	
	public BufferedWriter getBufferedWriter() {
		return bw;
	}
	
}
