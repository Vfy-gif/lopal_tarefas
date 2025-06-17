package br.dev.vitormiguel.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.vitormiguel.tarefas.dao.FuncionarioDAO;
import br.dev.vitormiguel.tarefas.dao.TarefasDAO;
import br.dev.vitormiguel.tarefas.model.Funcionario;
import br.dev.vitormiguel.tarefas.model.Status;
import br.dev.vitormiguel.tarefas.model.Tarefas;

public class FrameCadastroDeTarefas {

	private JLabel labelTitulo;
	private JTextField txtTitulo;
	private JLabel labelDescricao;
	private JTextField txtDescricao;
	private JLabel labelDataInicial;
	private JTextField txtDataIncial;
	private JLabel labelDataDeConclusao;
	private JTextField txtDataDeConclusao;
	private JLabel labelPrazo;
	private JTextField txtPrazo;
	private JLabel labelStatus;
	private JComboBox<Status> cmbStatus;
	private JLabel labelResponsavel;
	private JComboBox<String> cmbResponsavel;
	private JButton btnSalvar;
	private JButton btnSair;
	
	public FrameCadastroDeTarefas(JDialog dialog) {
		criarTela(dialog);
	}
	
	
	public void criarTela(JDialog dialog) {
		JDialog tela = new JDialog(dialog, true);		
		tela.setTitle("Cadastro de Tarefas");
		tela.setSize(400, 600);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(dialog);
		
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
		
		labelPrazo = new JLabel("Prazo:");
		labelPrazo.setBounds(10, 205, 150, 30);
		txtPrazo = new JTextField();
		txtPrazo.setBounds(10, 235, 365, 30);
		
		labelDataDeConclusao = new JLabel("Data conclusão:");
		labelDataDeConclusao.setBounds(10, 265, 150, 30);
		txtDataDeConclusao = new JTextField();
		txtDataDeConclusao.setBounds(10, 295, 365, 30);
		
		labelStatus = new JLabel("Status:");
		labelStatus.setBounds(10, 325, 150, 30);
		JComboBox<Status> cmbStatus = new JComboBox<>(Status.values());
		cmbStatus.setBounds(10, 355, 150, 30);
		
		labelResponsavel = new JLabel("Responsável:");
		labelResponsavel.setBounds(10, 385, 150, 30);
		
		cmbResponsavel = new JComboBox<>(new FuncionarioDAO().getNomesFuncionarios());
		cmbResponsavel.setBounds(10, 415, 150, 30);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 465, 175, 40);
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(200, 465, 175, 40);
		
		Container painel = tela.getContentPane();
		painel.add(labelTitulo);
		painel.add(txtTitulo);
		painel.add(labelDescricao);
		painel.add(txtDescricao);
		painel.add(labelDataInicial);
		painel.add(txtDataIncial);
		painel.add(labelPrazo);
		painel.add(txtPrazo);
		painel.add(labelDataDeConclusao);
		painel.add(txtDataDeConclusao);
		painel.add(labelStatus);
		painel.add(cmbStatus);
		painel.add(labelResponsavel);
		painel.add(cmbResponsavel);
		painel.add(btnSalvar);
		painel.add(btnSair);
		
		
		tela.setVisible(true);
		
		
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Confirmação",
						JOptionPane.YES_NO_OPTION);
				if (resposta == 0) {
					tela.dispose();

				}
			}
		});
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				double i = 0;
				Tarefas t = new Tarefas(txtTitulo.getText(), txtDescricao.getText(), txtDataIncial.getText(), txtPrazo.getText(), txtDataDeConclusao.getText());
				carregarDados();
				limparFormulario();
				
			}
		});}
		
		private void carregarDados() {
			TarefasDAO dao = new TarefasDAO();
			List<Tarefas> tarefas = dao.listar();
			
			Object[][] dados = new Object[tarefas.size()][3];
			
			int i = 0;
			for (Tarefas t : tarefas) {
				dados[i][0] = t.getTitulo();
				dados[i][1] = t.getDescricao();
				dados[i][2] = t.getDataInicial();
				dados[i][3] = t.getPrazo();
				dados[i][4] = t.getDataConclusao();
				dados[i][5] = t.getStatus();
				i++;
			}
		
		
		
		
		
	}
		private void limparFormulario() {
			txtTitulo.setText(null);
			txtDescricao.setText(null);
			txtDataIncial.setText(null);
			txtPrazo.setText(null);
			txtDataDeConclusao.setText(null);
			cmbResponsavel.setSelectedIndex(0);
			cmbStatus.setSelectedIndex(0);
			txtTitulo.requestFocus();
		}

	
	
}
