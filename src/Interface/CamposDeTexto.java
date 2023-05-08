package Interface;

import java.awt.Font;

import javax.swing.JTextField;

public class CamposDeTexto extends JTextField {
	private static final long serialVersionUID = 1L;
	
	//public CamposDeTexto(int x, int y, int comp, int alt) {
	//	setFont(new Font("Tahoma", Font.PLAIN, 10));
	//	setBounds(x, y, comp, alt);
	//}
	
	public CamposDeTexto(String nome, int x, int y, int comp, int alt) {
		super(nome);
		setFont(new Font("Tahoma", Font.PLAIN, 10));
		setBounds(x, y, comp, alt);
	}

	/*public void adicionarFormatoData(JFrame jf) {
		try {
			MaskFormatter mascara = new MaskFormatter("##/##/#### ##:##");
			JFormattedTextField campo = new JFormattedTextField(mascara);
			campo.setBounds(130, 205, 90, 25);
			campo.addFocusListener(new OuvinteDeFoco(campo));
			jf.add(campo);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}*/
}