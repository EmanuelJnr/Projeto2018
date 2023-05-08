package Telas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Interface.CamposDeTexto;
import Interface.JButtons;
import Interface.Labels;
import Logica.CentralDeInformacoes;
import Logica.Persistencia;
import Ouvintes.OuvinteCancelar;
import Ouvintes.OuvinteEntrar;

public class TelaDeLogin extends TelaPadrao {
	private static final long serialVersionUID = 1L;
	Persistencia pe = new Persistencia();
	CentralDeInformacoes central = pe.recuperarCentral("Central.xml");

	public TelaDeLogin() {
		super("Tela de Login");
		adicionarLabels();
		adicionarTextField();
		adicionarBotoes();
		setVisible(true);
	}
	private void adicionarLabels() {
		Labels lbEmail = new Labels("Email", 150, 80, 100, 50);
		add(lbEmail);

		Labels lbSenha = new Labels("Senha", 150, 125, 100, 50);
		add(lbSenha);

		Labels recuperar = new Labels("Esqueci senha", 250, 245, 92, 25);
		add(recuperar);
		recuperar.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				recuperar.setForeground(Color.BLACK);;
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				recuperar.setForeground(Color.RED);;
				recuperar.setCursor(cursor);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				new TelaRecuperacaoSenha();
			}
		});
		{
		}
	}
	private void adicionarBotoes() {
		JButtons btEntrar = new JButtons("Entrar", 195, 200, 80, 25);
		add(btEntrar);

		JButtons btCancelar = new JButtons("Cancelar", 305, 200, 90, 25);
		add(btCancelar);

		OuvinteEntrar ouvinteEntrar = new OuvinteEntrar(this, "Tela de Login");
		btEntrar.addActionListener(ouvinteEntrar);
		
		OuvinteCancelar ouvinteCancelar = new OuvinteCancelar(this, "Tela de Login");
		btCancelar.addActionListener(ouvinteCancelar);
	}
	public void adicionarTextField() {
		CamposDeTexto tfEmail = new CamposDeTexto(" Digite aqui", 195, 95, 200, 25);
		add(tfEmail);

		CamposDeTexto tfSenha = new CamposDeTexto(" Digite aqui", 195, 140, 200, 25);
		add(tfSenha);
	}
}