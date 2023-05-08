package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import Telas.TelaDeLogin;
import Telas.TelaInicial;

public class OuvinteCancelar implements ActionListener {
	private JFrame janela;
	private String nomeTela;

	public OuvinteCancelar(JFrame janela, String nomeTela) {
		this.janela = janela;
		this.nomeTela = nomeTela;
	}

	public void actionPerformed(ActionEvent evento) {
		switch (nomeTela) {
		case ("Tela de Cadastro"):
			new TelaDeLogin();
			this.janela.dispose();
			break;
		case ("Tela de Login"):
			new TelaInicial();
			this.janela.dispose();
			break;
	
		}
	}
}