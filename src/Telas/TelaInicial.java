package Telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import Interface.CriarImagem;
import Interface.JButtons;
import Interface.Labels;

public class TelaInicial extends TelaPadrao {
	private static final long serialVersionUID = 1L;

	public TelaInicial() {
		super("Tela Inicial");
		adicionarLabels();
		adicionarBotoes();
		addImage();
		setVisible(true);
	}
	private void addImage() {
		JLabel jl = new JLabel(new CriarImagem().getImagens("icon.png"));
		jl.setBounds(60, 110, 50, 50);
		add(jl);
	}
	private void adicionarLabels() {
		add(new Labels("Já possuo conta!", 450, 80, 200, 50));

		add(new Labels("Cadastre-se já!", 450, 180, 200, 50));

		add(new Labels(" Ver Leilões ativos", 30, 70, 200, 50));
	}
	private void adicionarBotoes() {
		JButtons btCadastrar = new JButtons("Cadastrar", 450, 230, 100, 25);
		add(btCadastrar);
		
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaDeCadastroUsuario();
				;
			}
		});
		JButtons btLogin = new JButtons("Fazer Login", 450, 130, 110, 25);
		add(btLogin);

		btLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaDeLogin();
				;
			}
		});
	}
}