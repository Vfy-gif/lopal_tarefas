package br.dev.vitormiguel.tarefas.dao;

import java.io.IOException;

import br.dev.vitormiguel.tarefas.factory.FileFactory;
import br.dev.vitormiguel.tarefas.model.Funcionario;

public class FuncionarioDAO {

	private Funcionario funcionario;
	
	public FuncionarioDAO() {}
	
	public FuncionarioDAO(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public void gravar() {
		try {
			FileFactory ff = new FileFactory();
			ff.getBufferedWriter().write(funcionario.toString());
			ff.getBufferedWriter().flush();
			
			
		} catch (IOException erro) {
			
			erro.printStackTrace();
		}
	}
	
}
