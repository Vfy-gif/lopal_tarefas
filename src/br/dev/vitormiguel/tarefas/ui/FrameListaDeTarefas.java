package br.dev.vitormiguel.tarefas.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrameListaDeTarefas {

	private JTable tabelaTarefas;
	private DefaultTableModel modelTarefas;
	private JScrollPane scrollTarefas;
	private JButton btnNovaTarefa;
	private JButton btnsair;
	private String[] colunas = {"CÓDIGO", "NOME", "RESPONSÁVEL"};
	
	public FrameListaDeTarefas(JFrame frame) {
		criarTela(frame);
	}
	
	public void criarTela(JFrame frame) {
		
		JDialog tela = new JDialog(frame, true);
		Dimension tamanho = new Dimension();
		tamanho.setSize(500, 420);
		tela.setSize(tamanho);
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setTitle("Lista de Tarefas");
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		tela.setResizable(false);
		
		modelTarefas = new DefaultTableModel(colunas, 5) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tabelaTarefas = new JTable(modelTarefas);
		tabelaTarefas.getTableHeader().setReorderingAllowed(false);
		scrollTarefas = new JScrollPane(tabelaTarefas);
		scrollTarefas.setBounds(10, 20, 460, 300);
		
		btnNovaTarefa = new JButton("Nova Tarefa");
		btnNovaTarefa.setBounds(10, 330, 180, 40);
		
		btnNovaTarefa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameCadastroDeTarefas novaTarefa = new FrameCadastroDeTarefas(tela);
				novaTarefa.criarTela(tela);
				
			}
		});
		
		btnsair = new JButton("Sair");
		btnsair.setBounds(200, 330, 180, 40);
		
		btnsair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			tela.dispose();
				
			}
		});
		
		
		Container painel = tela.getContentPane();
		painel.add(scrollTarefas);
		painel.add(btnNovaTarefa);
		painel.add(btnsair);
		
		tela.setVisible(true);
		
	}
	
}
