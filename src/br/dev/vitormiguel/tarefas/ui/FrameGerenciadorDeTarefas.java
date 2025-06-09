package br.dev.vitormiguel.tarefas.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FrameGerenciadorDeTarefas {

	private JButton btnFuncionario;
	private JButton btnTarefas;
	
	public void criarTela() {
		
		JFrame tela = new JFrame();
		Dimension tamanho = new Dimension();
		tamanho.setSize(470, 150);
		tela.setSize(tamanho);
		tela.setTitle("Gerenciador de Tarefas");
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		tela.setResizable(false);
		
		
		btnFuncionario = new JButton("Funcionário");
		btnFuncionario.setBounds(20, 20, 200, 40);
		
		btnFuncionario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameFuncionarioList(tela);
				tela.setVisible(false);
			}
		});
		
		btnTarefas = new JButton("Tarefas");
		btnTarefas.setBounds(235, 20, 200, 40);
		
		btnTarefas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameListaDeTarefas(tela);
				
			}
		});
		
		Container painel = tela.getContentPane();
		painel.add(btnFuncionario);
		painel.add(btnTarefas);
		
		tela.setVisible(true);
		
		
		
	}
	
}
