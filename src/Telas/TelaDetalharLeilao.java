package Telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class TelaDetalharLeilao extends TelaPadrao{
	private static final long serialVersionUID = 1L;
	private JButton voltar;
	private JLabel nome;
	private JLabel nomeC;
	private JLabel tempo;
	private JLabel precoF;
	private JLabel objtL;
	
	public TelaDetalharLeilao() {
		super("Informações sobre o leilão");
		adicionarLabel();
		adicionarBotao();
		setVisible(true);
		repaint();
	}
	private void adicionarBotao() {
		voltar = new JButton("Voltar");
		voltar.setBounds(300, 300, 80, 30);
		add(voltar);
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaLeiloes();
			}			
		});
	}
	private void adicionarLabel() {
		nome = new JLabel("Nome:");
		nome.setBounds(30, 80, 80, 30);
		add(nome);
		
		nomeC = new JLabel("Nome do comprador:");
		nomeC.setBounds(30,110,120,30);
		add(nomeC);
		
		tempo = new JLabel("Tempo Do leilão");
		tempo.setBounds(30, 140, 110, 30);
		add(tempo);
		
		objtL = new JLabel("Objeto leiloado:");
		objtL.setBounds(30,170,120,30);
		add(objtL);
		
		precoF = new JLabel("Preço final:");
		precoF.setBounds(30, 200, 110, 30);
		add(precoF);
	}
}