package Telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Logica.CentralDeInformacoes;
import Logica.Leilao;
import Logica.Persistencia;

public class TelaLeiloesAtivos extends TelaPadrao{
	Persistencia p = new Persistencia();
	CentralDeInformacoes cdi = p.recuperarCentral("Central.xml");

	private static final long serialVersionUID = 1L;
	private JButton darLance;
	private JButton voltar;
	private JTable tabela;
	private JLabel leiloes;
	private DefaultTableModel modelo;

	public TelaLeiloesAtivos() {
		super("Leilões Ativos ");
		adicionarLabel();
		adicionarBotao();
		adicionarTabela();
		adicionarScroll();
		setVisible(true);
	}
	private void adicionarScroll() {
		JScrollPane scrollPane=new JScrollPane(tabela);
		scrollPane.setBounds(40, 120, 500, 150);
		add(scrollPane);
	}
	private void adicionarTabela() {
		modelo = new DefaultTableModel();
		tabela = new JTable(modelo);

		modelo.addColumn("Nome");
		modelo.addColumn("Preço Atual");
		modelo.addColumn("Descrição");
		modelo.addColumn("Data de início");
		modelo.addColumn("Data de fim");
		tabela.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		for(Leilao lei : cdi.getLeiloesCadastrados()) {
			Object[] linha = new Object[5];
			linha[0] = lei.getNome();
			linha[1]= lei.getValor();
			linha[2]= lei.getDescricao();
			linha[3]= lei.getDataInicio().toString();
			linha[4]= lei.getDataTermino().toString();
			modelo.addRow(linha);
			repaint();
		}
	}
	public String pegarEmail() {
		return (String) tabela.getValueAt(tabela.getSelectedRow(),0);
	}	
	public float pegarLance() {
		return (float) tabela.getValueAt(tabela.getSelectedRow(), 0);
	}
	private Leilao l;
	private void adicionarBotao() {
		darLance = new JButton("Dar lançe");
		darLance.setBounds(30, 300, 90, 30);
		add(darLance);

		darLance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float lance = Float.parseFloat(JOptionPane.showInputDialog("Qual o seu lance??"));
				if(lance < l.getValor()) {
					JOptionPane.showMessageDialog(null, "Valor menor que o lançe mínimo!");
				}else {
					l.setValor(lance);
				}
			}
		});

		voltar = new JButton("Voltar");
		voltar.setBounds(490, 300, 80, 30);
		add(voltar);
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaPerfil("Perfil");
			}
		});
	}
	private void adicionarLabel() {
		leiloes = new JLabel("LEILÕES ATIVOS");
		leiloes.setBounds(230, 70, 170, 30);
		leiloes.setFont(new Font("Arial", Font.BOLD, 16));
		add(leiloes);
	}
}