package Telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import Interface.CamposDeTexto;
import Interface.JButtons;
import Interface.Labels;
import Logica.CentralDeInformacoes;
import Logica.Persistencia;
import Logica.Usuario;
import Ouvintes.OuvinteCancelar;
import Ouvintes.OuvinteDeFoco;

public class TelaDeCadastroUsuario extends TelaPadrao {
	Persistencia pe = new Persistencia();
	CentralDeInformacoes central = pe.recuperarCentral("Central.xml");
	
	private static final long serialVersionUID = 1L;
	private CamposDeTexto tfNome;
	private CamposDeTexto tfLogin;
	private CamposDeTexto tfSeguranca;
	private CamposDeTexto tfEndereco;
	private CamposDeTexto tfCidade;
	private CamposDeTexto tfEstado;
	private JPasswordField campoSenha;
	
	public TelaDeCadastroUsuario() {
		super("Cadastro de Usuário");
		adicionarLabels();
		adicionarTextFields();
		adicionarBotao();
		adicionarJPassword(this);
		setVisible(true);
	}
	private void adicionarLabels() {
		add(new Labels("Nome: *", 40, 80, 100, 30));

		add(new Labels("Login: *", 40, 110, 100, 30));
		
		add(new Labels("Senha: *", 40, 140, 100, 30));

		Labels jlSeguranca = new Labels("Email segurança", 40, 170, 150, 30);
		add(jlSeguranca);

		Labels jlEndereco = new Labels("Endereço:", 310, 113, 80, 30);
		add(jlEndereco);

		Labels jlCidade = new Labels("Cidade:", 310, 145, 80, 30);
		add(jlCidade);

		Labels jlEstado = new Labels("Estado:", 310, 175, 80, 30);
		add(jlEstado);
	}
	private void adicionarTextFields() {
		tfNome = new CamposDeTexto(" Nome completo", 95, 85, 190, 25);
		tfNome.addFocusListener(new OuvinteDeFoco(tfNome));
		add(tfNome);

		tfLogin = new CamposDeTexto(" Crie um email válido", 95, 115, 190, 25);
		tfLogin.addFocusListener(new OuvinteDeFoco(tfLogin));
		add(tfLogin);

		tfSeguranca = new CamposDeTexto(" Outro email", 150, 175, 135, 25);
		add(tfSeguranca);

		tfEndereco = new CamposDeTexto(" Endereço",380, 115, 130, 25);
		add(tfEndereco);

		tfCidade = new CamposDeTexto(" Cidade",365, 150, 145, 25);
		add(tfCidade);

		tfEstado = new CamposDeTexto(" Estado",365, 180, 145, 25);
		add(tfEstado);
	}
	private void adicionarJPassword(JFrame jf) {
		campoSenha = new JPasswordField();
		campoSenha.setBounds(100, 145, 110, 25);
		campoSenha.addFocusListener(new OuvinteDeFoco(campoSenha));
		jf.add(campoSenha);
	}
	private void adicionarBotao() {
		JButtons btSalvar = new JButtons("Salvar", 180, 300, 90, 30);
		add(btSalvar);
		OuvinteBtSalvar ouvinteSalvar = new OuvinteBtSalvar();
		btSalvar.addActionListener(ouvinteSalvar);

		JButtons btCancelar = new JButtons("Cancelar", 320, 300, 100, 30);
		add(btCancelar);

		OuvinteCancelar ouvinte = new OuvinteCancelar(this, "Tela de Cadastro");
		btCancelar.addActionListener(ouvinte);
	}
	private class OuvinteBtSalvar implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String login = tfLogin.getText();
			String senha =String.valueOf(campoSenha.getPassword());
			String nome = tfNome.getText();
			String email2 = tfSeguranca.getText();
			String endereco = tfEndereco.getText();
			String cidade = tfCidade.getText();
			String estado = tfEstado.getText();

			central.adicionarUsuario(new Usuario(login, senha, email2, nome, endereco, cidade, estado));
			
			pe.salvarCentral(central, "Central.xml");
			JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!");
		}
	}
}