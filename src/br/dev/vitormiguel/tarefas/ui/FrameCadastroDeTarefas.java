package br.dev.vitormiguel.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
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
	private JComboBox cmbResponsavel;
	private JButton btnSalvar;

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
		cmbStatus = new JComboBox<>(Status.values());
		cmbStatus.setBounds(10, 355, 150, 30);

		labelResponsavel = new JLabel("Responsável:");
		labelResponsavel.setBounds(10, 385, 150, 30);

		cmbResponsavel = new JComboBox<>();
		cmbResponsavel.setBounds(10, 415, 150, 30);

		FuncionarioDAO dao = new FuncionarioDAO();
		List<Funcionario> funcionario = dao.listar();

		String[][] responsaveis = new String[funcionario.size()][1];
		int i = 0;
		for (Funcionario f : funcionario) {
			responsaveis[0][0] = f.getNome();
			i++;

			cmbResponsavel.addItem(responsaveis[0][0]);

		}
		String responsavelSelecionado = (String) cmbResponsavel.getSelectedItem();

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 465, 175, 40);

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

		txtDataIncial.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				atualizarDataConclusao();
			}
		});
		txtPrazo.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				atualizarDataConclusao();
			}
		});

		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Funcionario f = new Funcionario();
				// Este condigo, pega o status selecionado
				Status statusEscolhido = (Status) cmbStatus.getSelectedItem();

				// Criando Tarefa
				Tarefas t = new Tarefas(txtTitulo.getText(), txtDescricao.getText(), txtDataIncial.getText(),
						txtPrazo.getText(), txtDataDeConclusao.getText(), statusEscolhido.name(),
						responsavelSelecionado);
				t.setResponsavel(f.getNome());
				t.getResponsavel();

				// Ler data inicial e prazo
				String dataInicialStr = txtDataIncial.getText();
				int prazoDias = Integer.parseInt(txtPrazo.getText());

				// Converter e somar prazo usando LocalDate
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate dataInicial = LocalDate.parse(dataInicialStr, formatter);
				LocalDate dataConclusao = dataInicial.plusDays(prazoDias);
				String dataConclusaoStr = dataConclusao.format(formatter);
				txtDataDeConclusao.setText(dataConclusaoStr);

				TarefasDAO dao = new TarefasDAO(t);
				dao.gravar();

				JOptionPane.showMessageDialog(tela, txtTitulo.getText() + " gravado com sucesso", "Sucesso !!!",
						JOptionPane.INFORMATION_MESSAGE);
				limparFormulario();

			}
		});

		tela.setVisible(true);

	}

	private void atualizarDataConclusao() {
		String dataInicialStr = txtDataIncial.getText().trim();
		String prazoStr = txtPrazo.getText().trim();

		try {
			if (dataInicialStr.isEmpty() || prazoStr.isEmpty())
				return;

			int prazoDias = Integer.parseInt(prazoStr);

			DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendValue(ChronoField.DAY_OF_MONTH)
					.appendLiteral('/').appendValue(ChronoField.MONTH_OF_YEAR).appendLiteral('/')
					.appendValue(ChronoField.YEAR, 4).toFormatter();

			LocalDate dataInicial = LocalDate.parse(dataInicialStr, formatter);
			LocalDate dataConclusao = dataInicial.plusDays(prazoDias);
			String dataConclusaoStr = dataConclusao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			txtDataDeConclusao.setText(dataConclusaoStr);
		} catch (Exception e) {
			txtDataDeConclusao.setText("Data inválida");
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
