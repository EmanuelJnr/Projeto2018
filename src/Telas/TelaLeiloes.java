package Telas;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Logica.CentralDeInformacoes;
import Logica.Leilao;
import Logica.Persistencia;

public class TelaLeiloes extends TelaPadrao{
	private static final long serialVersionUID = 1L;
	private JTable tabela;
	private DefaultTableModel modelo;
	private JButton darLance;
	private JButton voltar;
	private JButton detalhar;
	private JLabel leiloes;
	
	Persistencia pe = new Persistencia();
	CentralDeInformacoes central = pe.recuperarCentral("Central.xml");
	
	public TelaLeiloes() {
		super("Leilões ");
		adicionarLabel();
		adicionarBotao();
		adicionarTabela();
		repaint();
		setVisible(true);
	}
	private void adicionarTabela() {
		modelo = new DefaultTableModel();
		tabela = new JTable(modelo);

		modelo.addColumn("Nome");
		modelo.addColumn("Valor final");
		modelo.addColumn("Objeto");
		modelo.addColumn("Data de fim");

		for (Leilao leilao : central.getLeiloesCadastrados()) {
			Object[] linha = new Object[4];
			linha[0] = leilao.getNome();
			linha[1] = leilao.getValor();
			linha[2]= leilao.getDescricao();
			linha[3] = leilao.getDataTermino().toString();
			modelo.addRow(linha);
			repaint();
		}

		JScrollPane painel = new JScrollPane(tabela);
		painel.setBounds(90, 95, 400, 210);
		add(painel);
	}

	private void adicionarBotao() {
		darLance = new JButton("Contactar");
		darLance.setBounds(30, 305, 90, 30);
		add(darLance);

		detalhar = new JButton("Detalhar leilão");
		detalhar.setBounds(240,305,120,30);
		add(detalhar);
		detalhar.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaDetalharLeilao();
			}
		});

		voltar = new JButton("Voltar");
		voltar.setBounds(490, 305, 90, 30);
		add(voltar);
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaPerfil("Perfil");
			}
		});
	}
	private void adicionarLabel() {
		leiloes = new JLabel("LEILÕES");
		leiloes.setBounds(230, 70, 170, 30);
		leiloes.setFont(new Font("Arial", Font.BOLD, 16));
		add(leiloes);
	}
}