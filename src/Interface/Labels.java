package Interface;

import java.awt.Font;

import javax.swing.JLabel;

public class Labels extends JLabel {
	private static final long serialVersionUID = 1L;

	public Labels(String nome, int x, int y, int comp, int alt) {
		super(nome);
		setFont(new Font("Tahoma", Font.BOLD, 12 ));
		setBounds(x, y, comp, alt);
	}
}