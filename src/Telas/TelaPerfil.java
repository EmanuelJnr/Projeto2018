package Telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

public class TelaPerfil extends TelaPadrao{
	private static final long serialVersionUID = 1L;
	JButton leiloes ;
	JButton sair;
	JButton leiloesAtivos;
	JButton cadastrarLeilao;
	JLabel sexoSelecionado;
	JLabel nome ;
	JLabel sexo ;
	JLabel email ;
	JLabel foto ;
	
	public TelaPerfil(String titulo) {
		super(titulo);
		adicionarJlabel();
		adicionarBotao();
		setVisible(true);
		repaint();
	}

	private void adicionarBotao() {
		leiloes = new JButton("Leilões");
		leiloes.setBounds(50, 280, 100, 30);
		add(leiloes);
		leiloes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaLeiloes();
			}
		});
		
		leiloesAtivos = new JButton("Leilões Ativos");
		leiloesAtivos.setBounds(170, 280, 130, 30);
		add(leiloesAtivos);
		leiloesAtivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaLeiloesAtivos();
			}
		});
		
		cadastrarLeilao = new JButton("Cadastrar Leilão");
		cadastrarLeilao.setBounds(310, 280, 130, 30);
		add(cadastrarLeilao);
		cadastrarLeilao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaCadastroDeLeilao("");
			}
		});
		
		sair = new JButton("Sair");
		sair.setBounds(470, 280, 100, 30);
		add(sair);
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaInicial();
			}
		});
	}
	
	private void adicionarJlabel() {
		nome = new JLabel("Nome: ");
		nome.setBounds(140, 90, 80, 30);
		add(nome);

		JLabel nomeDaPessoa = new JLabel("Joana");
		nomeDaPessoa.setFont(new Font("Arial", Font.PLAIN, 12));
		nomeDaPessoa.setBounds(180, 90, 100, 30);
		add(nomeDaPessoa);
		
		email = new JLabel("Email: ");
		email.setBounds(140, 120, 80, 30);
		add(email);
		
		JLabel emailUsuario = new JLabel("email@email.com");
		emailUsuario.setFont(new Font("Arial", Font.PLAIN, 12));
		emailUsuario.setBounds(180, 120, 200, 30);
		add(emailUsuario);
		
		repaint();
	}
}