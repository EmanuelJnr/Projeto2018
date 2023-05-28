package Telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Interface.CamposDeTexto;
import Interface.CriarImagem;
import Logica.CentralDeInformacoes;
import Logica.Leilao;
import Logica.Persistencia;
import Logica.Usuario;
import Ouvintes.OuvinteDeFoco;

public class TelaCadastroDeLeilao extends TelaPadrao{
	Persistencia pe = new Persistencia();
	CentralDeInformacoes central = pe.recuperarCentral("Central.xml");
	
	private static final long serialVersionUID = 1L;
	private JTextField nome;
	private JTextField descricao;
	private JTextField preco;
	private JFormattedTextField tempoInicio;
	private JFormattedTextField tempoFim;
	
	public TelaCadastroDeLeilao(String titulo) {
		super("Cadastro de Leilão");
		adicionarLabel();
		adicionarBotoes();
		adicionarCampoDeTexto();
		adicionarCampoFormatado();
		setVisible(true);
	}
	private void adicionarCampoDeTexto() {
		nome = new CamposDeTexto(" Nome do produto", 190, 120, 200, 30);
		nome.addFocusListener(new OuvinteDeFoco(nome));
		add(nome);

		descricao = new CamposDeTexto(" Digite a descrição", 190, 153, 200, 30);
		descricao.addFocusListener(new Ouvintes.OuvinteDeFoco(descricao));
		add(descricao);
		
		preco = new CamposDeTexto(" Digite o preço", 190, 185, 168, 30);
		preco.addFocusListener(new Ouvintes.OuvinteDeFoco(preco));
		add(preco);
	}
	public void adicionarCampoFormatado(){
		try{
			MaskFormatter mascara1 = new MaskFormatter("##/##/#### ##:##");
			tempoInicio = new JFormattedTextField(mascara1);
			tempoInicio.setBounds(190, 218, 100, 30);
			add(tempoInicio);
			MaskFormatter mascara2 = new MaskFormatter("##/##/#### ##:##");
			tempoFim = new JFormattedTextField(mascara2);
			tempoFim.setBounds(190, 250, 100, 30);
			add(tempoFim);
		}
		catch(ParseException e){
			e.printStackTrace();
		}
	}
	private void adicionarBotoes() {
		JButton  cancelar = new JButton("Cancelar",new CriarImagem().getImagens("cancel.png"));
		cancelar.setBounds(330, 285, 126, 30);
		add(cancelar);
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaPerfil("Perfil");
			}
		});
		JButton iniciarLeilao = new JButton("Iniciar Leilão",new CriarImagem().getImagens("accept.png"));
		iniciarLeilao.setBounds(90, 285, 126, 30);
		add(iniciarLeilao);
		iniciarLeilao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome1 = nome.getText();
				String descricao1 = descricao.getText();
				float preco1 = Float.parseFloat(preco.getText());
				
				String tempoI1 = tempoInicio.getText();
				System.out.println(tempoI1);
				DateTimeFormatter dataIf = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy HH:mm").toFormatter();
				LocalDateTime datai = LocalDateTime.parse(tempoI1, dataIf);
				String tempoF1 = tempoFim.getText();
				DateTimeFormatter dataFf = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy HH:mm").toFormatter();
				LocalDateTime dataf = LocalDateTime.parse(tempoF1, dataFf);
				
				Usuario u = new Usuario();//na verdade deve listar todos os leilões desse usuário!!!
				
				central.adicionarLeilao(new Leilao(nome1, descricao1, preco1, datai, dataf, u));
				
				pe.salvarCentral(central, "Central.xml");
				JOptionPane.showMessageDialog(null, "Leilãoo cadastrado com sucesso !!");
			}
		});
	}
	private void adicionarLabel() {
		JLabel subTitulo = new JLabel("CADASTRO DE LEILÃO");
		subTitulo.setBounds(180, 80, 230, 30);
		subTitulo.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		add(subTitulo);

		JLabel preenchimento = new JLabel();
		preenchimento.setBounds(433, 130, 100, 100);
		preenchimento.setBackground(Color.DARK_GRAY);
		add(preenchimento);

		JLabel nome = new JLabel("Nome do produto:");
		nome.setBounds(80, 120, 45, 40);
		add(nome);

		JLabel objeto = new JLabel("Descrição:");
		objeto.setBounds(80, 153, 80, 30);
		add(objeto);

		JLabel precoInicial = new JLabel("Preço:");
		precoInicial.setBounds(80, 185, 80, 30);
		add(precoInicial);

		JLabel tempoInicial = new JLabel("Tempo inicial:");
		tempoInicial.setBounds(80, 218, 100, 30);
		add(tempoInicial);
		
		JLabel tempoFinal = new JLabel("Tempo final:");
		tempoFinal.setBounds(80, 250, 100, 30);
		add(tempoFinal);
	}
}