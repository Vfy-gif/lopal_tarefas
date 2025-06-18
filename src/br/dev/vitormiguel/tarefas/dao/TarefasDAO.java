package br.dev.vitormiguel.tarefas.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import br.dev.vitormiguel.tarefas.factory.FileFactory;
import br.dev.vitormiguel.tarefas.model.Status;
import br.dev.vitormiguel.tarefas.model.Tarefas;

public class TarefasDAO {

	private Tarefas tarefas;

	public TarefasDAO() {
	}

	public TarefasDAO(Tarefas tarefas) {
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
			BufferedReader br1 = ff.getBufferedReaderFuncionario();

			String linha = "";
			String linha1 = "";

			br.readLine();
			br1.readLine();

			while (linha != null) {
				// extraíndo uma linha do arquivo
				linha = br.readLine();
				linha1 = br1.readLine();

				// Criando um vetor
				if (linha != null && linha1 != null) {

					String tarefaStr[] = linha.split(",");
					String tarefaTstr[] = linha.split(",");

					// Criando um objeto tarefa
					Tarefas tarefa = new Tarefas();
					tarefa.setTitulo(tarefaStr[0]);
					tarefa.setDescricao(tarefaStr[1]);
					tarefa.setDataInicial(tarefaStr[2]);
					tarefa.setPrazo(tarefaStr[3]);
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
