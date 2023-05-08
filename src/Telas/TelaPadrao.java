package Telas;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Interface.CriarImagem;
import Logica.ConfiguradorResolucao;

public abstract class TelaPadrao extends JFrame {
	static final long serialVersionUID = 1L;
	public static final String[] resolucao = ConfiguradorResolucao.configurador().split("x");

	public TelaPadrao(String nome) {
		super(nome);
		setSize(Integer.parseInt(resolucao[0]), Integer.parseInt(resolucao[1]));
		setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		addImage();
	}

	private void addImage() {
		JLabel jl = new JLabel(new CriarImagem().getImagens("IconePadrao.png"));
		jl.setBounds(0, 10, 600, 60);
		add(jl);
	}
}