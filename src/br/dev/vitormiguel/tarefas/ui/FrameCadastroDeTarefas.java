package br.dev.vitormiguel.tarefas.ui;

import java.awt.Container;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.dev.vitormiguel.tarefas.model.Status;

public class FrameCadastroDeTarefas {

	private JLabel labelTitulo;
	private JTextField txtTitulo;
	private JLabel labelDescricao;
	private JTextField txtDescricao;
	private JLabel labelDataInicial;
	private JTextField txtDataIncial;
	private JLabel labelDataDeConclusao;
	private JTextField txtDataDeConclusao;
	private JLabel labelprazo;
	private JTextField txtprazo;
	private JLabel labelStatus;
	private JComboBox cmbStatus;
	private JLabel labelResponsavel;
	private JComboBox cmbResponsavel;
	
	public FrameCadastroDeTarefas(JDialog frame) {
		criarTela(frame);
	}
	
	
	public void criarTela(JDialog frame) {
		JDialog tela = new JDialog();		
		tela.setTitle("Cadastro de Tarefas");
		tela.setSize(400, 600);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		labelTitulo = new JLabel("Título:");
		labelTitulo.setBounds(10, 10, 200, 30);
		txtTitulo = new JTextField();
		txtTitulo.setBounds(10, 40, 365, 30);
		
		labelDescricao = new JLabel("Descrição:");
		labelDescricao.setBounds(10, 75, 200, 30);
		txtDescricao = new JTextField();
		txtDescricao.setBounds(10, 105, 365, 30);
		
		labelDataInicial = new JLabel("Data Inicial:");
		labelDataInicial.setBounds(10, 140, 200, 30);
		txtDataIncial = new JTextField();
		txtDataIncial.setBounds(10, 170, 365, 30);
		
		labelprazo = new JLabel("Prazo:");
		labelprazo.setBounds(10, 205, 150, 30);
		txtprazo = new JTextField();
		txtprazo.setBounds(10, 235, 365, 30);
		
		labelDataDeConclusao = new JLabel("Data conclusão:");
		labelDataDeConclusao.setBounds(10, 265, 150, 30);
		txtDataDeConclusao = new JTextField();
		txtDataDeConclusao.setBounds(10, 295, 365, 30);
		
		labelStatus = new JLabel("Status:");
		labelStatus.setBounds(10, 325, 150, 30);
		JComboBox<Status> cmbstatus = new JComboBox<Status>();
		cmbstatus.setBounds(10, 355, 150, 30);
		
		
		
		Container painel = tela.getContentPane();
		painel.add(labelTitulo);
		painel.add(txtTitulo);
		painel.add(labelDescricao);
		painel.add(txtDescricao);
		painel.add(labelDataInicial);
		painel.add(txtDataIncial);
		painel.add(labelprazo);
		painel.add(txtprazo);
		painel.add(labelDataDeConclusao);
		painel.add(txtDataDeConclusao);
		painel.add(labelStatus);
		
		
		tela.setVisible(true);
		
	}
	
	
	
}
