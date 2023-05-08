package Telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Interface.CamposDeTexto;
import Interface.JButtons;
import Interface.Labels;
import Ouvintes.OuvinteCancelar;

public class TelaRecuperacaoSenha extends TelaPadrao {
	private static final long serialVersionUID = 1L;

	public TelaRecuperacaoSenha() {
		super("Recuperar Senha");
		adicionarLabel();
		adicionarTextFields();
		adicionarBotao();
		setVisible(true);
	}

	private void adicionarLabel() {
		Labels lbEmail = new Labels("Email", 180, 100, 100, 30);
		add(lbEmail);

		Labels lb = new Labels("OU", 280, 150, 80, 30);
		add(lb);

		Labels lbCPF = new Labels("CPF", 180, 190, 100, 30);
		add(lbCPF);
	}

	private void adicionarTextFields() {
		CamposDeTexto tfEmail = new CamposDeTexto(" Digite o email", 220, 105, 150, 25);
		add(tfEmail);
		
		CamposDeTexto tfCPF = new CamposDeTexto(" Digite o CPF", 220, 195, 150, 25);
		add(tfCPF);
	}
	
	private void adicionarBotao() {		
		JButtons btCancelar = new JButtons("Cancelar", 150, 270, 100, 30);
		add(btCancelar);
		OuvinteCancelar ouvinte = new OuvinteCancelar(this, "Tela de Login");
		btCancelar.addActionListener(ouvinte);
		
		JButtons btEnviar = new JButtons("Enviar", 300, 270, 100, 30);
		add(btEnviar);
		btEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Um link de redefinição de senha foi enviado para o email cadastrado!"
					+ "\nPor favor, verifique seu email e tente novamente!");
			}
		});
	}
}