package br.dev.vitormiguel.tarefas.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.vitormiguel.tarefas.factory.FileFactory;
import br.dev.vitormiguel.tarefas.model.Tarefas;

public class TarefasDAOa {

	private Tarefas tarefas;
	
	public TarefasDAOa() {}
	
	public TarefasDAOa(Tarefas tarefas) {
	this.tarefas = tarefas;
}
	
	public void gravar() {
		try {
			FileFactory ff = new FileFactory();
			ff.getBufferedWriterTarefas().write(tarefas.toString());
			ff.getBufferedWriterTarefas().flush();
			
			
		} catch (IOException erro) {
			
			erro.printStackTrace();
		}
	}
	
	public List<Tarefas> listar() {
		
		List<Tarefas> tarefas = new ArrayList<Tarefas>();
		
		
		try {
			FileFactory ff = new FileFactory();
			BufferedReader br = ff.getBufferedReaderTarefas();
			
			String linha = "";
			
			
			br.readLine();
			
			while (linha != null) {
				// extraíndo uma linha do arquivo
				linha = br.readLine();
				
				// Criando um vetor
				if (linha != null) {
					
				
				String tarefaStr[] = linha.split(",");
				
				// Criando um objeto tarefa
				Tarefas tarefa = new Tarefas();
				tarefa.setTitulo(tarefaStr[0]);
				tarefa.setDescricao(tarefaStr[1]);
				tarefa.setDataInicial(tarefaStr[2]);
				tarefa.setPrazo(Double.parseDouble(tarefaStr[3]));
				tarefa.setDataConclusao(tarefaStr[4]);
				
				
				tarefas.add(tarefa);
				}
				
			}
			
			return tarefas;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}

