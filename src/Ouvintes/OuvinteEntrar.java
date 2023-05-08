package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Telas.TelaPerfil;

public class OuvinteEntrar implements ActionListener{
	private JFrame janela;

	public OuvinteEntrar(JFrame janela, String nomeTela) {
		this.janela = janela;
	}
	public void actionPerformed(ActionEvent evento) {
		new TelaPerfil("Tela de Perfil");
		this.janela.dispose();
	}
}